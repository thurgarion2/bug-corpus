package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;


import javax.swing.*;
import javax.swing.text.Position;

public class BoidsExample {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Boids");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            World world = new World(400);
            frame.add(world);

            int delay = 100; // milliseconds
            Timer timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    world.update(((double)delay)/1000);
                    world.repaint();
                }
            });

            timer.start();

            frame.setVisible(true);
        });
    }

    static class Triangle extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int[] xPoints = {50, 150, 250};  // X coordinates of the triangle vertices
            int[] yPoints = {200, 50, 200};  // Y coordinates of the triangle vertices
            int numPoints = 3;  // Number of vertices

            g.setColor(Color.BLUE);
            g.fillPolygon(xPoints, yPoints, numPoints);
        }
    }

    static class Point {
        final double x;
        final double y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        public static Point massCenter(List<Point> points){
            double x=0, y=0;
            for(Point p : points){
                x+=p.x;
                y+=p.y;
            }
            return new Point(x/points.size(), y/points.size());
        }

        public Point add(Vector v){
            return new Point(x + v.dx, y + v.dy);
        }

        public boolean inRecangle(Point p1, Point p2){
            return x>=p1.x && y>=p1.y && x<=p2.x && y<=p2.y;
        }

        public Vector substract(Point p){
            return new Vector(x - p.x, y - p.y);
        }
    }

    static class Vector {
        final double dx;
        final double dy;

        public static Vector identity(){
            return new Vector(0,0);
        }

        Vector(double dx, double dy){
            this.dx = dx;
            this.dy = dy;
        }

        public Vector scale(double alpha){
            return new Vector(dx * alpha, dy * alpha);
        }

        public Vector add(Vector other){
            return new Vector(dx + other.dx, dy + other.dy);
        }

        public double norm(){
            return Math.sqrt(dx*dx+dy*dy)+0.001;
        }

        public Vector normalized(){
            return this.scale(1/this.norm());
        }

        public Vector subtract(Vector other){
            return new Vector(dx - other.dx, dy - other.dy);
        }
    }

    static class Boid extends JPanel {
        final Point position;
        final Vector speed;

        Boid(Point position, Vector speed){
            this.position = position;
            this.speed = speed;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = (int) Math.round(position.x);
            int y = (int) Math.round(position.y);
            int radius = 7;

            g.setColor(Color.RED);
            g.fillOval(x - radius,  y - radius, 2 * radius, 2 * radius);
        }

        public Boid update(Vector acceleration, double dt){
            return new Boid(position.add(speed.scale(dt)), speed.add(acceleration.scale(dt)));
        }
    }

    static class World extends JPanel{
        Random rand = new Random(0);
        final int size;
        final double radius = 50;
        final Point center;
        List<Boid> boids;

        public World(int size){
            this.size = size;
            boids = new ArrayList<>();
            center = new Point(size/2,size/2);
            init();
        }

        public void update(double dt){

            List<Boid> next = boids.stream()
                    .map(boid -> {
                        List<Point> inRadius = boids.stream()
                                .filter(b -> b.position.substract(boid.position).norm()<radius && b!=boid)
                                .map(b -> b.position)
                                .collect(Collectors.toList());

                        Vector avoidance = inRadius.stream()
                                .map(p -> {
                                    Vector diff = boid.position.substract(p);
                                    double norm = diff.norm();
                                    return diff.scale(norm*norm);
                                })
                                .reduce(Vector.identity(), Vector::add);
                        Vector cohesion = Point.massCenter(inRadius).substract(boid.position);

                        Vector containment = Vector.identity();
                        if(boid.position.inRecangle(new Point(0,0), new Point(400, 400))){
                            containment = center.substract(boid.position).normalized().scale(5);
                        }
                        return boid.update(avoidance.add(containment).add(cohesion), dt);
                    })
                    .collect(Collectors.toList());
            this.boids = next;
        }

        private void init(){
            for(int i=0; i<50; ++i){
                int x = rand.nextInt(size), y = rand.nextInt(size);
                double angle = rand.nextDouble()*2*Math.PI;
                double dx=Math.cos(angle)*10, dy=Math.sin(angle)*10;
                boids.add(new Boid(new Point(x,y), new Vector(dx,dy)));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            boids.forEach(b -> b.paintComponent(g));
        }


    }


}
