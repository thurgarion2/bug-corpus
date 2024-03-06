package org.example;

import java.util.Scanner;

public class MessyCode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int grid[][] = new int[3][3];
        int player = 1;
        boolean gameFinished = false;
        boolean draw = false;
        boolean hasZero = false;

        for(int i = 0; i< 3; ++i){
            for(int j=0; j<3; ++j)
                grid[i][j] = 0;
        }

        while(!gameFinished && !draw){
            player = player==1 ? 2 :1;

            for(int i = 0; i< 3; ++i){
                for(int j=0; j<3; ++j) {
                    if(grid[i][j]==1){
                       System.out.print('O');
                    }else if(grid[i][j]==2){
                        System.out.print('X');
                    }else {
                        System.out.print('-');
                    }

                }
                System.out.println();
            }


            if(player==1){
                System.out.println("Player O play");
            }else{
                System.out.println("Player X play");
            }

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            while(x<0 || x>2 || y<0 || y>2 || grid[x][y]!=0){
              System.out.println("Illegal move try again");
              player = player%2;
              x = scanner.nextInt();
              y = scanner.nextInt();
            };

            grid[x][y] = player;

            for(int p=1; p<=2; ++p){
                for(int line = 0; line<3; ++line){
                    if(grid[line][0]==player && grid[line][1]==player && grid[line][2]==player){
                        gameFinished = true;
                    }
                }

                for(int column = 0; column<3; ++column){
                    if(grid[0][column]==player && grid[1][column]==player && grid[2][column]==player){
                        gameFinished = true;
                    }
                }

                if(grid[0][0]==player && grid[1][1] == player && grid[2][2]==player){
                    gameFinished = true;
                }

                if(grid[0][2]==player && grid[1][1] == player && grid[2][0]==player){
                    gameFinished = true;
                }
            }

            hasZero = false;
            for(int i = 0; i< 3; ++i){
                for(int j=0; j<3; ++j)
                    hasZero = hasZero || grid[i][j] == 0;
            }
            draw = !hasZero;
        }

        if(draw){
            System.out.println("The game is a draw");
        }else if(player==1){
            System.out.println("Player O has won");
        }else{
            System.out.println("Player X has won");
        }

    }
}
