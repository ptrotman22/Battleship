package main.java;

import java.util.Scanner;

public class Sea {
    public static String[][] Grid(boolean firstTime, String name, int[] currentLocation, String[][] currentGrid, int size){
        String[][] grid = new String[10][10];

        //Fill grid
        if(firstTime == true) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = " ~ ";
                }
            }
            grid[0][0] = " X ";

            for (int i = 1; i < grid.length; i++) {
                grid[0][i] = String.valueOf(" "+ i +" ");
                grid[i][0] = String.valueOf(" "+ i +" ");
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

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[6][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[7][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[8][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[9][i]);
        }
        System.out.println();

        return grid;
    }
    public static String[][] GridCheck(String[][] grid, int[] currentLocation, int size){
        String letter = "";
        String shipName = "";
        if (size == 5){
            letter = " c ";
            shipName = "Carrier";
        }
        else if(size == 4){
            letter = " b ";
            shipName = "Battleship";
        }
        else if(size == 3){
            letter = " d ";
            shipName = "Destroyer";
        }
        else if(size == 2){
            letter = " p ";
            shipName = "Patrol Boat";
        }

        // Move down or right
        System.out.println("Place "+ shipName +" ("+ size +" spaces) horizontally(Right) or vertically(Down) (h or v)?");
        String direction = new Scanner(System.in).nextLine();

        if (direction.equalsIgnoreCase("h")){
            boolean emptySpace = false;
            while (emptySpace == false) {
                while ((currentLocation[1] + size) > (grid.length - 1)) {
                    System.out.println("Sorry, The ship must fit on the board. Please try again");
                    System.out.println("Please choose first coordinate:");
                    int input = new Scanner(System.in).nextInt();
                    currentLocation[0] = input;
                    System.out.println("Please choose second coordinate:");
                    int input1 = new Scanner(System.in).nextInt();
                    currentLocation[1] = input1;
                }
                //Check if ship space is occupied.
                for (int i = 0; i < size; i++) {
                    if (!(grid[currentLocation[0]][currentLocation[1] + i].equalsIgnoreCase(" ~ "))) {
                        emptySpace = false;
                        System.out.println("A ship is already located there, enter another location:");
                        System.out.println("Please choose first coordinate:");
                        int input = new Scanner(System.in).nextInt();
                        currentLocation[0] = input;
                        System.out.println("Please choose second coordinate:");
                        int input1 = new Scanner(System.in).nextInt();
                        currentLocation[1] = input1;
                        break;
                    }
                    else {
                        emptySpace = true;
                    }
                }
            }
            //fill in ship on grid
            for (int i = 0; i < size; i++){
                grid[currentLocation[0]][currentLocation[1]+i] = letter;
            }
        }
        else{
            boolean emptySpace = false;
            while (emptySpace == false) {
                while ((currentLocation[1] + size) > (grid.length - 1)) {
                    System.out.println("Sorry, The ship must fit on the board. Please try again");
                    System.out.println("Please choose first coordinate:");
                    int input = new Scanner(System.in).nextInt();
                    currentLocation[0] = input;
                    System.out.println("Please choose second coordinate:");
                    int input1 = new Scanner(System.in).nextInt();
                    currentLocation[1] = input1;
                }
                //Check if ship space is occupied.
                for (int i = 0; i < size; i++) {
                    if (!grid[currentLocation[0]+i][currentLocation[1]].equalsIgnoreCase(" ~ ")) {
                        emptySpace = false;
                        System.out.println(shipName +" is already located there, enter another location:");
                        System.out.println("Please choose first coordinate:");
                        int input = new Scanner(System.in).nextInt();
                        currentLocation[0] = input;
                        System.out.println("Please choose second coordinate:");
                        int input1 = new Scanner(System.in).nextInt();
                        currentLocation[1] = input1;
                        break;
                    }
                    else {
                        emptySpace = true;
                    }
                }
            }
            for (int i = 0; i < size; i++){
                grid[currentLocation[0]+i][currentLocation[1]] = letter;
            }
        }

        return grid;
    }
    public static void PrintGrid(String[][] currentGrid){
        String[][] grid = new String[10][10];

        //Fill grid
        grid = currentGrid.clone();


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

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[6][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[7][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[8][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[9][i]);
        }
        System.out.println();

    }

    public static void PrintGrid(){
        String[][] grid = new String[10][10];

        //Fill grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = " ~ ";
            }
        }

        grid[0][0] = " X ";

        for (int i = 1; i < grid.length; i++) {
            grid[0][i] = String.valueOf(" " + i + " ");
            grid[i][0] = String.valueOf(" " + i + " ");
        }



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

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[6][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[7][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[8][i]);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[9][i]);
        }
        System.out.println();

    }

    public static String[][] FillGrid(){
        String[][] grid = new String[10][10];

        // fill Grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = " ~ ";
            }
        }
        grid[0][0] = " X ";

        for (int i = 1; i < grid.length; i++) {
            grid[0][i] = String.valueOf(" "+ i +" ");
            grid[i][0] = String.valueOf(" "+ i +" ");
        }

        return grid;
    }

    public static String[][] HitGrid(String[][] currentGrid, String[][] currentHitGrid, int[] currentLocation){
        String[][] grid = currentGrid.clone();
        String[][] hitGrid = new String[10][10];

        hitGrid = currentHitGrid.clone();

        boolean filled = true;
        boolean end = false;
        while (end = false) {
            while (filled = true) {
                if (!grid[currentLocation[0]][currentLocation[1]].equalsIgnoreCase(" ~ ")) {
                    if (hitGrid[currentLocation[0]][currentLocation[1]].equalsIgnoreCase(" h ") || hitGrid[currentLocation[0]][currentLocation[1]].equalsIgnoreCase(" m ")) {
                        System.out.println("Sorry, You already picked this spot. Please try again");
                        System.out.println("Please choose first coordinate:");
                        int input = new Scanner(System.in).nextInt();
                        currentLocation[0] = input;
                        System.out.println("Please choose second coordinate:");
                        int input1 = new Scanner(System.in).nextInt();
                        currentLocation[1] = input1;
                        break;
                    } else {
                        hitGrid[currentLocation[0]][currentLocation[1]] = " h ";
                        filled = false;
                        end = true;
                    }
                } else {
                    hitGrid[currentLocation[0]][currentLocation[1]] = " m ";
                    filled = false;
                    end = true;
                }
            }
        }

        // Print Map
        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[0][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[1][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[2][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[3][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[4][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[5][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[6][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[7][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[8][i]);
        }
        System.out.println();

        for (int i = 0; i < hitGrid.length; i++) {
            System.out.print(hitGrid[9][i]);
        }
        System.out.println();

        return hitGrid;

    }

    public static int WinCondition(String[][] currentHitGrid){
        String[][] hitGrid = currentHitGrid.clone();
        int count = 0;

        for (int i = 0; i < hitGrid.length; i++) {
            for (int j = 0; j < hitGrid[0].length; j++) {
                if (hitGrid[i][j].equalsIgnoreCase(" h ")){
                   count++;
                }
            }
        }

        return count;
    }

}
