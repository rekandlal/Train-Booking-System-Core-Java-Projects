
public class Train {

    private int trainId;
    private String trainName;
    private String trainSource;
    private String trainDestination;
    private int totalSeats;
    private int availableSeats;

    // constructor
    public Train(int trainId, String trainName, String trainSource, String trainDestination, int totalSeats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainSource = trainSource;
        this.trainDestination = trainDestination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;  // totalSeats == availableSeats
    }

    // getter and setter method for access and update value

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainSource() {
        return trainSource;
    }

    public void setTrainSource(String trainSource) {
        this.trainSource = trainSource;
    }

    public String getTrainDestination() {
        return trainDestination;
    }

    public void setTrainDestination(String trainDestination) {
        this.trainDestination = trainDestination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Booking Seat logic
    public boolean booking(int NoOfBookingSeats) {
        if (NoOfBookingSeats <= totalSeats) {
            totalSeats -= NoOfBookingSeats;
            return true;
        }

        return false;
    }

    // Ticket Cancellation logic
    public void cancellation(int NoOfBookingSeats) {
        totalSeats += NoOfBookingSeats;
    }

    // pretty print

    @Override
    public String toString() {
        return String.format("%-8d | %-18s | %-12s -> %-12s | %-5d",
                trainId, trainName, trainSource, trainDestination, totalSeats);
    }

}


