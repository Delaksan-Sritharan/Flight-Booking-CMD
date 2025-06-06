import java.util.Scanner;

public class Flight {
    private static int [][] planeSeats = null;
    private static int[] pricePerRow = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Dela Flight Booking!");
        initialiseRows();
        runMenu();

    }

    public static void initialiseRows(){
        planeSeats = new int [4][];
        planeSeats[0] = new int[18];
        planeSeats[1] = new int[20];
        planeSeats[2] = new int[20];
        planeSeats[3] = new int[18];
        pricePerRow = new int[4];
        pricePerRow[0] = 50;
        pricePerRow[1] = 80;
        pricePerRow[2] = 80;
        pricePerRow[3] = 50;
    }


    public static int getMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                --- Dela Flight Seat Booking ---
                1. View Available Seats
                2. Book a seat
                3. Exit
                """);
        System.out.print("Please select a option: ");
        int option = input.nextInt();
        return option;
    }

    public static void buyTickets(){
        Scanner input = new Scanner(System.in);
        System.out.println("Row price details");
        for (int row = 0; row <planeSeats.length;row++){
            System.out.println("Row "+(row+1)+" price is "+pricePerRow[row]);

        }
        System.out.print("Enter row number : ");
        int row = input.nextInt() - 1;
        System.out.print("Enter the seat number : ");
        int seat = input.nextInt() - 1;

        if (planeSeats[row][seat] == 0){
            planeSeats[row][seat] = 1;
            System.out.println("Purchase Succesful");
        }else {
            System.out.println("This seat is already taken");
            buyTickets();
        }
    }

    private static void showSeatingArea() {
        System.out.println("View Seating Area");
        int rows = planeSeats.length;
        for (int row = 0; row<rows;row++){
            System.out.print("Row "+(row + 1)+":");
            int seatsPerRow = planeSeats[row].length;
            for(int seat = 0; seat< seatsPerRow;seat++){
                if (planeSeats[row][seat] == 0){
                    System.out.print("[0]");
                }else {
                    System.out.print("[x]");
                }
            }System.out.println();
        }
    }


    public static void runMenu(){
        int option;
        boolean decision = true;
        while (decision){
            option = getMenu();
            switch (option){
                case 3:
                    decision = false;
                    System.out.println("Thank you for choosing us!");
                    break;
                case 2:
                    buyTickets();
                    break;
                case 1:
                    showSeatingArea();
                    break;
                default:
                    System.out.println("Option not available");
            }
        }
    }


}



