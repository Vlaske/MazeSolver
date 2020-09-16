package com.company;

import java.util.LinkedList;

public class MazeSolver {

    static int[][] maze = {
            {1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 2, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 1, 0, 1, 1, 1}
    };
    //0 = wall
    //1 = path
    //2 = destination

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {

        if(solveMaze(new Position(1, 1))){
            System .out.println("You won!");
        }else{
            System.out.println("No path");
        }
    }

    private static boolean solveMaze(Position position) {

        path.push(position);

        while (true){
            int y = path.peek().getY();
            int x = path.peek().getX();
            maze[y][x] = 0;

            //down
            if(isValid(y+1, x)){
                if(maze[y+1][x] == 2){
                    System.out.println("Moved down");
                    return true;
                }else if(maze[y+1][x] == 1){
                    System.out.println("Moved down");
                    path.push(new Position(y+1, x));
                    continue;
                }
            }

            //left
            if(isValid(y,x-1)){
                if(maze[y][x-1] == 2){
                    System.out.println("Moved left");
                    return true;
                }else if(maze[y][x-1] == 1){
                    System.out.println("Moved left");
                    path.push(new Position(y, x-1));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x)){
                if(maze[y-1][x] == 2){
                    System.out.println("Moved up");
                    return true;
                }else if(maze[y-1][x] == 1){
                    System.out.println("Moved up");
                    path.push(new Position(y-1, x));
                    continue;
                }
            }

            //right
            if(isValid(y,x+1)){
                if(maze[y][x+1] == 2){
                    System.out.println("Moved right");
                    return true;
                }else if(maze[y][x+1] == 1){
                    System.out.println("Moved right");
                    path.push(new Position(y, x+1));
                    continue;
                }
            }

            path.pop();
            System.out.println("Took step back");
            if(path.size() <= 0){
                return false;
            }
        }
    }

    //Checking if the spot is valid (are we getting out of bounds of maze or not)
    public  static  boolean isValid(int y, int x){
        if(y < 0 || y >= maze.length || x < 0 || x >= maze[y].length){
            return false;
        }
        return true;
    }

}
