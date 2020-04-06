import main.java.Sea;

import java.util.*;

public class BattleshipDriver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //System.out.println("");

        int end = 0;// end game 1 = end, 0 = continue.
        do {
            // Creating Objects and necessary variables
            int[] location = new int[2];
            String[][] grid = new String[10][10];
            String[][] grid2 = new String[10][10];
            String[][] hitGrid = new String[10][10];
            String[][] hitGrid2 = new String[10][10];
            int size = 0;
            Sea sea = new Sea();
            // Player 1 Objects
            Carrier p1Carrier = new Carrier();
            Battleship p1Battleship = new Battleship();
            Destroyer p1Destroyer = new Destroyer();
            PatrolBoat p1PatrolBoat = new PatrolBoat();
            // Player 2 Objects
            Carrier p2Carrier = new Carrier();
            Battleship p2Battleship = new Battleship();
            Destroyer p2Destroyer = new Destroyer();
            PatrolBoat p2PatrolBoat = new PatrolBoat();
            // Game Opening
            System.out.println("Battleship Multiplayer");
            System.out.println("Enter Player 1 name: ");
            String player1 = new Scanner(System.in).nextLine(); // clear buffer for scanner.
            System.out.println("Enter Player 2 name: ");
            String player2 = new Scanner(System.in).nextLine(); // clear buffer for scanner.

            // Place Ships on Board
            sea.PrintGrid();
            System.out.println(player1 +" place your BattleShips: Carrier(5 places)");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = p1Carrier.Location(location, grid);
            size = p1Carrier.Size();
            grid = sea.Grid(true, player1, location, grid, size);

            grid = PlaceShips(player1, grid, location, p1Battleship.Size());
            grid = PlaceShips(player1, grid, location, p1Destroyer.Size());
            grid = PlaceShips(player1, grid, location, p1PatrolBoat.Size());

            sea.PrintGrid();
            grid2 = PlaceShips(player2, grid2, location, p2Carrier.Size());
            grid2 = PlaceShips(player2, grid2, location, p2Battleship.Size());
            grid2 = PlaceShips(player2, grid2, location, p2Destroyer.Size());
            grid2 = PlaceShips(player2, grid2, location, p2PatrolBoat.Size());

            System.out.println("");

            // Hit System
            hitGrid = sea.FillGrid();
            hitGrid2 = sea.FillGrid();
            boolean endHit = false;
            int win1 = 0;
            int win2 = 0;
            do {
                // Player 1 hit Game
                sea.PrintGrid(hitGrid);
                System.out.println(player1 + " find your opponents Battleships");
                System.out.println("Please choose first coordinate:");
                int input3 = new Scanner(System.in).nextInt();
                location[0] = input3;
                System.out.println("Please choose second coordinate:");
                int input4 = new Scanner(System.in).nextInt();
                location[1] = input4;
                hitGrid = sea.HitGrid(grid2, hitGrid, location);
                win1 = sea.WinCondition(hitGrid);
                if (win1 == 14){
                    System.out.println(player1 + " wins the Match");
                    endHit = true;
                    end = 1;
                    break;
                }

                System.out.println("");

                // Player 2 hit Game
                sea.PrintGrid(hitGrid2);
                System.out.println(player2 + " find your opponents Battleships");
                System.out.println("Please choose first coordinate:");
                int input5 = new Scanner(System.in).nextInt();
                location[0] = input5;
                System.out.println("Please choose second coordinate:");
                int input6 = new Scanner(System.in).nextInt();
                location[1] = input6;
                hitGrid2 = sea.HitGrid(grid, hitGrid2, location);
                win2 = sea.WinCondition(hitGrid2);
                if (win2 == 14){
                    System.out.println(player2 + " wins the Match");
                    endHit = true;
                    end = 1;
                    break;
                }

                System.out.println("");

            } while (endHit = false);

        }while(end != 1);

        System.out.println("Thank you for playing");

    }
    public static String[][] PlaceShips(String player, String[][] currentGrid, int[] location, int size){
        String[][] grid = new String[10][10];
        grid = currentGrid.clone();
        Sea sea = new Sea();
        // Player Objects
        Carrier carrier = new Carrier();
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        PatrolBoat patrolBoat = new PatrolBoat();

        String letter = "";
        String shipName = "";
        if (size == 5){
            shipName = "Carrier";
            System.out.println(player +" place your BattleShips: "+ shipName +" (" + size + ") ");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = carrier.Location(location, grid);
            size = carrier.Size();
            grid = sea.Grid(true, player, location, grid, size);
        }
        else if(size == 4){
            shipName = "Battleship";
            System.out.println(player +" place your BattleShips: "+ shipName +" (" + size + ") ");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = battleship.Location(location, grid);
            size = battleship.Size();
            grid = sea.Grid(false, player, location, grid, size);
        }
        else if(size == 3){
            shipName = "Destroyer";
            System.out.println(player +" place your BattleShips: "+ shipName +" (" + size + ") ");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = destroyer.Location(location, grid);
            size = destroyer.Size();
            grid = sea.Grid(false, player, location, grid, size);
        }
        else if(size == 2){
            shipName = "Patrol Boat";
            System.out.println(player +" place your BattleShips: "+ shipName +" (" + size + ") ");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = patrolBoat.Location(location, grid);
            size = patrolBoat.Size();
            grid = sea.Grid(false, player, location, grid, size);
        }

        // Return Grid
        return grid;

    }
}
