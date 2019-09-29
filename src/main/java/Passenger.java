public class Passenger {
    private String name;
    private int numOfBags;
    private Flight flightBooked;
    private Integer seatBooked;

    public Passenger(String name, int numOfBags){
        this.name = name;
        this.numOfBags = numOfBags;
        this.flightBooked = null;
        this.seatBooked = null;
    }

    public String getName() {
        return name;
    }

    public int getNumOfBags() {
        return numOfBags;
    }

    public Flight getFlightBooked() {
        return flightBooked;
    }

    public void setFlightBooked(Flight flightBooked) {
        this.flightBooked = flightBooked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfBags(int numOfBags) {
        this.numOfBags = numOfBags;
    }

    public Integer getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(Integer seatBooked) {
        this.seatBooked = seatBooked;
    }
}
