public class Tickets {

    private int PRN;
    private UserDetails user;
    private Train train;
    private int seatBooked;

    private static int counter = 61565168;

    //constructor
    public Tickets( UserDetails user, Train train, int seatBooked) {
        this.PRN = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

    //getter and setter

    public int getPRN() {
        return PRN;
    }

    public void setPRN(int PRN) {
        this.PRN = PRN;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Tickets.counter = counter;
    }

    // pretty print
    @Override
    public String toString() {
        return String.format(
                        "PRN Number      : %-10d\n" +
                        "Train ID        : %-10d\n" +
                        "Passenger Name  : %-15s\n" +   //  added line
                        "Train Name      : %-15s\n" +
                        "Route           : %-12s -> %-12s\n" +
                        "Seats Booked    : %-5d\n" +
                        "----------------------------------------------------------------------",
                PRN, train.getTrainId(), user.getFullName(), train.getTrainName(),
                train.getTrainSource(), train.getTrainDestination(),
                seatBooked
        );
    }



}

