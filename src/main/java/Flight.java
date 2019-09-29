import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String departureAirport;
    private String destination;
    private Date departureTime;
    private ArrayList<Integer> seatsBooked;

    public Flight(Plane plane, String flightNumber, String departureAirport, String destination, Date departureTime) {

        this.passengerList = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destination = destination;
        this.departureTime = departureTime;
        this.seatsBooked = new ArrayList<Integer>();
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public int remainingSeats() {
        return plane.getCapacity() - this.passengerList.size();
    }

    public void book(Passenger passenger) {
        if (this.remainingSeats()>0) {
            this.passengerList.add(passenger);
            passenger.setFlightBooked(this);
            int assignedSeat = this.getRandomSeat();
            passenger.setSeatBooked(assignedSeat);
            this.seatsBooked.add(assignedSeat);
        }
    }

    public ArrayList<Integer> getSeatsBooked() {
        return seatsBooked;
    }

    public int getRandomSeat() {
        int totalNumOfSeats = this.getPlane().getCapacity();
        Random random = new Random();
        int randomSeatNumber = random.nextInt(totalNumOfSeats) + 1;
        for (int seatNumber : this.seatsBooked ){
            if (seatNumber == randomSeatNumber){
                randomSeatNumber = this.getRandomSeat();
            }
        }
        return randomSeatNumber;

    }
}
