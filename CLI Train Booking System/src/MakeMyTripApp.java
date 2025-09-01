import java.util.List;
import java.util.Scanner;

public class MakeMyTripApp {

    private final Scanner scanner = new Scanner(System.in);

    private final UserServices userServices = new UserServices();
    private final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        new MakeMyTripApp().start();
    }

    public void start(){


        // UI :
        while(true){
            System.out.println("\n********** Welcome to Make My Trip App ***********");

            if(!userServices.isLoggedIn()){
                System.out.println();
                System.out.println("1. |____REGISTER____|");
                System.out.println("2. |______LOGIN_____|");
                System.out.println("3. |_______EXIT_____|");
                System.out.println();

                System.out.print("Enter Your Choice : ");
                int choice = scanner.nextInt();

                switch (choice){

                    // case 1 : register();
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exit();
                    default -> System.out.println("Invalid Choice!!!");

                }


            }else {
                userMenu();
            }
        }
    }

    public void register(){
        System.out.println();
        System.out.print("Enter Your FullName : ");
        scanner.nextLine();
        String FullName = scanner.nextLine();
        System.out.print("Enter Your Username : ");
        String UserName = scanner.next();
        System.out.print("Enter Your Email : ");
        String Email = scanner.next();
        System.out.print("Enter Your Contact : ");
        String phone = scanner.next();
        System.out.print("Enter Your Password : ");
        String Password = scanner.next();

        userServices.registerUser(UserName ,FullName , Password ,Email , Password);

    }

    public void login(){
        System.out.print("Enter Your Username : ");
        String UserName = scanner.next();

        System.out.print("Enter Your Password : ");
        String Password = scanner.next();

        userServices.loginUser(UserName , Password);
    }

    public void exit(){
        System.out.println("Thank You For Using ---Make My Trip App---");
        System.exit(0);
    }

    private void userMenu() {

        while (userServices.isLoggedIn()) {
            System.out.println();
            System.out.println("   |------------User Menu-----------|");
            System.out.println("   ----------------------------------");
            System.out.println("1. |_________View All Trains________|");
            System.out.println("2. |__________Search Trains_________|");
            System.out.println("3. |___________Book Ticket__________|");
            System.out.println("4. |__________View My Ticket________|");
            System.out.println("5. |_______Cancel Booked Ticket_____|");
            System.out.println("6. |______________Logout____________|");
            System.out.println();
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            switch (choice){

                case 1 -> viewAllTrains();
                case 2 -> searchTrain();
                case 3 -> bookTicket();
                case 4 -> viewMyTicket();
                case 5 -> cancelYourTicket();
                case 6 -> userServices.logoutUser();
                default -> System.out.println("Invalid Choice : `");

            }
        }
    }

    private void viewAllTrains(){

        System.out.println();
        System.out.println("List of all Trains => ");
        System.out.println();
        System.out.println("TrainId  | Train Name         | Source       -> Destination  | Seats ");
        System.out.println("--------------------------------------------------------------------");

        bookingService.ListOfAllTrain();
    }

    private void searchTrain(){
        System.out.println();
        System.out.println();
        System.out.print("Enter Source Station : ");
        String source = scanner.next();
        System.out.print("Enter Destination Station : ");
        String destination = scanner.next();

        List<Train> trains = bookingService.searchTrian(source , destination);

        if (trains.isEmpty()) {
            System.out.println();
            System.out.println("====================================");
            System.out.println(" 🚆  Sorry! No Trains Found ");
            System.out.println("------------------------------------");
            System.out.println(" No trains are available from " + source + " → " + destination);
            System.out.println(" Please try with different stations.");
            System.out.println("====================================");
            return;
        }

        System.out.println();
        System.out.println("============================================");
        System.out.println("        ✅ Trains Found from " + source + " → " + destination);
        System.out.println("============================================");

        for (Train train : trains) {
            System.out.println();
            System.out.printf("%-10s | %-20s | %-5s%n", "Train ID", "Train Name", "Seats");
            System.out.println("---------------------------------------------");
            System.out.printf("%-10d | %-20s | %-5d%n",
                    train.getTrainId(),
                    train.getTrainName(),
                    train.getTotalSeats());
        }

        System.out.println();
        System.out.print("Do you want to book ticket ? (YES / NO) : "); // combine call
        String choice = scanner.next();

        if(choice.equalsIgnoreCase("YES")){
            System.out.println();
            System.out.println();
            System.out.println("============================================");
            System.out.println("          🚆 Train Booking ");
            System.out.println("============================================");
            System.out.println();

            System.out.println();
            System.out.print(" 👉 Enter Train ID to Book: ");
            int trainId = scanner.nextInt();

            System.out.print(" 🎟️  Enter number of seats to book: ");
            int seats = scanner.nextInt();


            System.out.println();
            Tickets tickets =  bookingService.bookTickets(userServices.getCurrentUser() , trainId , seats);
            if (tickets != null){
                System.out.println();
                System.out.println("Booking SuccessFull!!");
                System.out.println();
                System.out.println("--------------------------- TICKET DETAILS ---------------------------\n");
                System.out.println(tickets);
            }

        }else {
            System.out.println("Returning To User Menu....");
        }

    }

    private void bookTicket(){
        System.out.print("Enter Source Station : ");
        String source = scanner.next();
        System.out.print("Enter Destination Station : ");
        String destination = scanner.next();

        List<Train> trains = bookingService.searchTrian(source , destination);

        if (trains.isEmpty()) {
            System.out.println("====================================");
            System.out.println(" 🚆  Sorry! No Trains Found ");
            System.out.println("------------------------------------");
            System.out.println(" No trains are available from " + source + " → " + destination);
            System.out.println(" Please try with different stations.");
            System.out.println("====================================");
            return;
        }

        System.out.println();
        System.out.println("|________Available Trains_______|");
        System.out.println();
        System.out.println("TrainId  | Train Name         | Source       -> Destination  | Seats ");
        System.out.println("----------------------------------------------------------");

        for (Train train : trains){
            System.out.println(train);
        }

        System.out.println("=========================================");
        System.out.println("           🚆 Train Booking ");
        System.out.println("=========================================");

        System.out.print(" 👉 Enter Train ID to Book: ");
        int trainId = scanner.nextInt();

        System.out.print(" 🎟️  Enter number of seats to book: ");
        int seats = scanner.nextInt();


        System.out.println();
        Tickets tickets =  bookingService.bookTickets(userServices.getCurrentUser() , trainId , seats);
        if (tickets != null){
            System.out.println("Booking SuccessFull!!");
            System.out.println("--------------------------- TICKET DETAILS ---------------------------\n" );
            System.out.println(tickets);
        }

    }

    private void viewMyTicket(){
        List<Tickets> ticketByUser = bookingService.getBookingTicketByUser(userServices.getCurrentUser());
        if (ticketByUser.isEmpty()){
            System.out.println();
            System.out.println();
            System.out.println("No Ticket Booked Yet!!");
        }else {
            System.out.println();
            System.out.println("|______Your Book Ticket Details_____|");
            System.out.println();
            System.out.println("--------------------------- TICKET DETAILS ---------------------------\n" );
            for (Tickets ticket : ticketByUser ){
                System.out.println(ticket);
            }
        }
    }

    private void cancelYourTicket(){
        List<Tickets> ticketByUser = bookingService.getBookingTicketByUser(userServices.getCurrentUser());
        System.out.println();
        System.out.print(" 👉 Enter Your Ticket ID to Cancel: ");
        int ticketId = scanner.nextInt();
        bookingService.cancelTicket(ticketId , userServices.getCurrentUser());

        System.out.println();
        System.out.println();
        System.out.println("--------------------------- YOUR CANCEL TICKET ---------------------------\n" );
        for (Tickets ticket : ticketByUser ){
            System.out.println(ticket);
        }
    }

}

