import java.util.Scanner;

public class Carrier extends Ship {
    private static final int size = 5;
    private int hit = 0;
    private int[] location = new int[size*2];

    public void setHit(int hit){ this.hit = hit;}
    public int getHit(){
        return hit;
    }

    int Size(){
        return size;
    }


    int[] Location(int[] startLocation, String[][] grid){
        Scanner scanner = new Scanner(System.in);

        while((startLocation[0] < 1 || startLocation[0] > grid.length) || (startLocation[1] < 1 || startLocation[1] > grid[0].length)) {
            System.out.println("Sorry, You must choose a coordinate on the board. Please try again");
            System.out.println("Please choose first coordinate:");
            int input = new Scanner(System.in).nextInt();
            startLocation[0] = input;
            System.out.println("Please choose second coordinate:");
            int input1 = new Scanner(System.in).nextInt();
            startLocation[1] = input1;
        }

        return startLocation;
    }

}
