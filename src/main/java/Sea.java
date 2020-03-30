package main.java;

import java.util.Scanner;

public class Sea {
    public String[][] Grid(boolean firstTime, String name, int[] currentLocation, String[][] currentGrid, int size){
        String[][] grid = new String[10][10];

        //Fill grid
        if(firstTime == true) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = "~";
                }
            }
            grid[0][0] = "X";

            for (int i = 1; i < grid.length; i++) {
                grid[0][i] = String.valueOf(i);
                grid[i][0] = String.valueOf(i);
            }
        }else {
            grid = currentGrid.clone();
        }

        grid = GridCheck(grid, currentLocation, size);

        // Print Map
        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[0][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[1][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[2][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[3][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[4][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[5][i]);
        }
        System.out.println();

        return grid;
    }
    public String[][] GridCheck(String[][] grid, int[] currentLocation, int size){
        String letter = "";
        String shipName = "";
        if (size == 5){
            letter = "c";
            shipName = "Carrier";
        }
        else if(size == 4){
            letter = "b";
            shipName = "Battleship";
        }
        else if(size == 3){
            letter = "d";
            shipName = "Destroyer";
        }
        else if(size == 2){
            letter = "p";
            shipName = "Patrol Boat";
        }

        System.out.println("Place "+ shipName +" ("+ size +" spaces) horizontally(Right) or vertically(Down) (h or v)?");
        String direction = new Scanner(System.in).nextLine();

        if (direction.equalsIgnoreCase("h")){
            while ((currentLocation[1]+size) > (grid.length-1)){
                System.out.println("Sorry, The ship must fit on the board. Please try again");
                System.out.println("Please choose first coordinate:");
                int input = new Scanner(System.in).nextInt();
                currentLocation[0] = input;
                System.out.println("Please choose second coordinate:");
                int input1 = new Scanner(System.in).nextInt();
                currentLocation[1] = input1;
            }
            for (int i = 0; i < size; i++){
                grid[currentLocation[0]][currentLocation[1]+i] = letter;
            }
        }
        else{
            while ((currentLocation[1]+size) > (grid.length-1)){
                System.out.println("Sorry, The ship must fit on the board. Please try again");
                System.out.println("Please choose first coordinate:");
                int input = new Scanner(System.in).nextInt();
                currentLocation[0] = input;
                System.out.println("Please choose second coordinate:");
                int input1 = new Scanner(System.in).nextInt();
                currentLocation[1] = input1;
            }
            for (int i = 0; i < size; i++){
                grid[currentLocation[0]+i][currentLocation[1]] = letter;
            }
        }

        return grid;
    }
}
