import java.util.InputMismatchException;
import java.util.Scanner;

public class Flight {
    private static int [][] planeSeats = null;
    private static int[] pricePerRow = null;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("*".repeat(37));
        System.out.println("|  Welcome to Dela Flight Booking!  |");
        System.out.println("*".repeat(37));
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
        int option = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("""
                  Dela Flight Seat Booking 
            1. View Available Seats
            2. Book a seat
            3. Exit
                """);
        System.out.print("Please select a option: ");
        try{
            option = input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input! Please enter a number between 1 and 3.");
            input.nextLine();
        }
        return option;
    }

    public static void buyTickets(){
        Scanner input = new Scanner(System.in);
        System.out.println("Row price details");
        for (int row = 0; row <planeSeats.length;row++){
            System.out.println("Row "+(row+1)+" price is "+pricePerRow[row]);
        }
        int row = -1;
        int seat = -1;
        while (true) {
            try {
                System.out.print("Enter row number : ");
                 row = input.nextInt() - 1;
                if (row >= 0 && row < planeSeats.length) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a seat between 1 and " + planeSeats.length);
                }
        }catch (InputMismatchException e){
            System.out.println("Invalid input! Please enter a valid number for the row.");
            input.next();
        }
    }
        while (true){
            try {
        System.out.print("Enter the seat number : ");
         seat = input.nextInt() - 1;
        if (seat >= 0 && seat < planeSeats[row].length){
        if (planeSeats[row][seat] == 0){
            planeSeats[row][seat] = 1;
            System.out.println("Purchase Succesful");
            break;
        }else {
            System.out.println("This seat is already taken");
        }
        }else {
            System.out.println("Invalid seat number! Please enter a seat between 1 and " + planeSeats[row].length);
        }
        }catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter a valid number for the seat.");
            input.next();
        }
    }
}

    private static void showSeatingArea() {
        System.out.println("*".repeat(37));
        System.out.println("|          View Seating Area        |");
        System.out.println("*".repeat(37));
        int rows = planeSeats.length;
        for (int row = 0; row<rows;row++){
            System.out.print("Row "+(row + 1)+" : ");
            int seatsPerRow = planeSeats[row].length;
            for(int seat = 0; seat< seatsPerRow;seat++){
                if (planeSeats[row][seat] == 0){
                    System.out.print("[0]");
                }else {
                    System.out.print("[x]");
                }
            }System.out.println();
        }System.out.println("=".repeat(76));
        System.out.println("LEGEND: [O] = Seat available, [X] = Seat not available");
        System.out.println("=".repeat(76));
        System.out.println();
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



