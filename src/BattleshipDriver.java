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
            int size = 0;
            Sea sea = new Sea();
            Carrier p1Carrier = new Carrier();
            Carrier p2Carrier = new Carrier();
            // Game Opening
            System.out.println("Battleship Multiplayer");
            System.out.println("Enter Player 1 name: ");
            String player1 = new Scanner(System.in).nextLine(); // clear buffer for scanner.
            System.out.println("Enter Player 2 name: ");
            String player2 = new Scanner(System.in).nextLine(); // clear buffer for scanner.

            // Place Ships on Board
            sea.PrintGrid();
            System.out.println("Player 1 place your BattleShips");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            location[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            location[1] = input1;

            location = p1Carrier.Location(location, grid);
            size = p1Carrier.Size();
            grid = sea.Grid(true, player1, location, grid, size);

            
        }while(end != 1);

    }
}
