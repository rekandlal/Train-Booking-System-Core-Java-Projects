import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    // all info.

    private List<Train> trainList =  new ArrayList<>();

    // buy ticket list
    private List<Tickets> ticketList =  new ArrayList<>();

    // all train list
    public BookingService(){

        trainList.add(new Train(101, "Rajdhani Express", "Delhi", "Mumbai", 250));
        trainList.add(new Train(102, "Shatabdi Express", "Bhopal", "Delhi", 300));
        trainList.add(new Train(103, "Duronto Express", "Kolkata", "Delhi", 280));
        trainList.add(new Train(104, "Garib Rath", "Lucknow", "Delhi", 350));
        trainList.add(new Train(105, "Tejas Express", "Mumbai", "Goa", 200));
        trainList.add(new Train(106, "Jan Shatabdi", "Patna", "Ranchi", 180));
        trainList.add(new Train(107, "Humsafar Express", "Delhi", "Chennai", 400));
        trainList.add(new Train(108, "Vande Bharat", "Delhi", "Varanasi", 220));
        trainList.add(new Train(109, "Sampark Kranti", "Delhi", "Bangalore", 380));
        trainList.add(new Train(110, "Maharaja Express", "Delhi", "Jaipur", 150));
    }

    // date function add optional....


    // search function
    public List<Train> searchTrian(String source , String destination){

        List<Train> searchResult = new ArrayList<>();

        // get info form all trian list
        for(Train train : trainList){

            if(train.getTrainSource().equalsIgnoreCase(source) && train.getTrainDestination().equalsIgnoreCase(destination) ){
                searchResult.add(train);
            }
        }

        return searchResult;
    }

    // ticket booking logic
    public Tickets bookTickets(UserDetails user , int trainId , int seatCount){

        for(Train train : trainList ){

            if(train.getTrainId() == trainId){

                if(train.booking(seatCount)){ // seat available
                    // now create ticket
                    Tickets tickets = new Tickets(user , train , seatCount);
                    ticketList.add(tickets);
                    return tickets;

                }else{ // if seat is not available

                    System.out.println("No enough seats available " + " , remaining seat is " + train.getAvailableSeats());
                    return null;
                }

            }
        }

        System.out.println("Train ID not found");
        return null;
    }

    // get booking ticket by user == checking current user booking any ticket via comparing user full name with ticket buyer name
    public List<Tickets> getBookingTicketByUser(UserDetails user){

        List<Tickets> result = new ArrayList<>();

        for(Tickets tickets : ticketList){

            if(tickets.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                result.add(tickets);
            }
        }

        return result;
    }

    // ticket cancellation logic
    public boolean cancelTicket(int ticketID , UserDetails user){

        // traverse in ticket list via Iterator
        Iterator<Tickets> iterator = ticketList.listIterator();

        while(iterator.hasNext()){ // check karta hai ki next element available hai ya nahi.

            Tickets ticket = iterator.next() ; // next element return karta hai.
            Train train = ticket.getTrain();
            if(train.getTrainId() == ticketID &&
                    ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())) {

//                Train train = ticket.getTrain();
                train.cancellation(ticket.getSeatBooked());
                iterator.remove(); // booked ticket list me ticket removed
                System.out.println("Ticket " + train.getTrainId() + " cancelled successfully");

                return true;
            }

        }

        System.out.println("Ticket not found or does not belong to current user!");
        return false;
    }


    // list of all trian
    public void ListOfAllTrain(){
        for (Train train : trainList){
            System.out.println(train); // pretty print , we already done in Train Class
        }
    }


}
