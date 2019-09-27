import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String departureAirport;
    private String destination;
    private String departureTime;

    public Flight(ArrayList<Passenger> passengerList, Plane plane, String flightNumber, String departureAirport, String destination, String departureTime) {

        this.passengerList = passengerList;
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

    public String getDepartureTime() {
        return departureTime;
    }
}
