import java.util.ArrayList;
import java.util.Date;

public class Flight {

    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String departureAirport;
    private String destination;
    private Date departureTime;

    public Flight(Plane plane, String flightNumber, String departureAirport, String destination, Date departureTime) {

        this.passengerList = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destination = destination;
        this.departureTime = departureTime;
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
        }
    }
}
