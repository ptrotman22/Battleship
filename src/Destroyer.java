import java.util.Scanner;

public class Destroyer extends Ship{
    private static final int size = 3;
    private int hit = 0;
    private int[] location = new int[size*2];

    // Setters & Getters
    public void setHit(int hit){ this.hit = hit;}
    public int getHit(){
        return hit;
    }

    @Override
    public int Size(){
        return size;
    }

    public int[] Location(int[] startLocation, String[][] grid){
        Scanner scanner = new Scanner(System.in);

        while(!(!((startLocation[0] < 1) || (startLocation[0] > (grid.length - 1))) && !((startLocation[1] < 1) || (startLocation[1] > (grid[0].length - 1)))))
        {
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
