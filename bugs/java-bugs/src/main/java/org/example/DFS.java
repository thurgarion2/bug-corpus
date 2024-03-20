package org.example;

import java.util.List;

public class DFS {
    public static void main(String[] args) {
//        Graph tree = new Graph(List.of(List.of(1, 2), List.of(3, 4), List.of(), List.of(), List.of()));
//        Graph notTree = new Graph(List.of(List.of(1), List.of(2), List.of(3, 4), List.of(0), List.of(1)));
//
//        //dfs(tree, 0);
//        dfs(notTree, 0);
    }

    public static void dfs(Graph graph, int node){
        for(int neighbor : graph.neigbhors(node)){
            dfs(graph, neighbor);
        }
    }

    static class Graph {
        int nodesNumber;
        List<List<Integer>> adjacencyList;

        public Graph(List<List<Integer>> adjacencyList){
            nodesNumber = adjacencyList.size();
            this.adjacencyList = adjacencyList;
        }

        public List<Integer> neigbhors(int node){
            if(node<0 || node>=nodesNumber)
                throw new IllegalArgumentException();
            return adjacencyList.get(node);
        }
    }
}
