import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class FlightManagerTest {

    FlightManager flightManager;
    FlightManager flightManager2;
    Flight flight;
    Flight flight2;
    Plane plane;
    Plane plane2;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Passenger passenger7;
    Passenger passenger8;
    Passenger passenger9;
    Passenger passenger10;

    @Before
    public void before(){
        passenger1 = new Passenger("Debbie McFarlane", 1);
        passenger2 = new Passenger("Gregor Talloy", 3);
        passenger3 = new Passenger("Jeremy Kyle", 0);
        passenger4 = new Passenger("Jeremy Kyle", 0);
        passenger5 = new Passenger("Jeremy Kyle", 0);
        passenger6 = new Passenger("Jeremy Kyle", 0);
        passenger7 = new Passenger("Jeremy Kyle", 0);
        passenger8 = new Passenger("Jeremy Kyle", 0);
        passenger9 = new Passenger("Jeremy Kyle", 0);
        passenger10 = new Passenger("Jeremy Kyle", 0);

        plane = new Plane(PlaneType.CONCHORD);
        plane2 = new Plane(PlaneType.BOEING747);

        LocalDate date = LocalDate.of(2019, 11, 17);
        LocalDateTime dateTime = date.atTime(11,0);

        Date oldFashionedDate = Date.from(dateTime.toInstant(ZoneOffset.UTC));
        long longDate = oldFashionedDate.getTime();
        Date goodDate = new Date (longDate);

        flight = new Flight(plane, "FR3180", "EDI", "ARN", goodDate);
        flight2 = new Flight(plane2, "FR3180", "EDI", "ARN", goodDate);

        flightManager = new FlightManager(flight);
        flightManager2 = new FlightManager(flight2);
    }

    @Test
    public void canGetBaggageWeightPerPassenger(){
        //Given there is a flight
        assertNotNull(flight);
        //When
        //Then baggage weight per passenger is 250
        assertEquals(250, flightManager.getBaggageWeightPerPassenger());
    }

    @Test
    public void canGetBaggageWeightBooked_1passenger(){
        //Given there is a flight
        assertNotNull(flight);
        //When 1 passenger with 3 bags is booked
        assertNotNull(passenger2);
        this.flight.book(passenger2);
        //Then baggage weight booked is 60
        assertEquals(60, flightManager.getBaggageWeightBooked());
    }

    @Test
    public void canGetBaggageWeightBooked__2passengers(){
        //Given there is a flight
        assertNotNull(flight);
        //When 2 passenger are booked
        assertNotNull(passenger2);
        assertNotNull(passenger1);
        this.flight.book(passenger1);
        this.flight.book(passenger2);
        //Then baggage weight booked is 80
        assertEquals(80, flightManager.getBaggageWeightBooked());
    }

    @Test
    public void canGetRemainingFlightBaggageWeight(){
        //Given there is a flight
        assertNotNull(flight);
        //When 2 passenger are booked
        assertNotNull(passenger2);
        assertNotNull(passenger1);
        this.flight.book(passenger1);
        this.flight.book(passenger2);
        //Then overall weight remaining is 420
        assertEquals(420, flightManager.getRemainingBaggageWeight());
    }

    @Test
    public void canSortBookedSeatsList() {
        //Given there is a flight
        assertNotNull(flight2);
        //AND there are 3 passengers
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        assertNotNull(passenger3);
        //When I book the passengers on the flight
        flight2.book(passenger1);
        flight2.book(passenger2);
        flight2.book(passenger3);
        //Then the each seat in the list will be be in ascending order
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(0).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(1).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(1).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(2).getSeatBooked());
    }

    @Test
    public void canSortBookedSeatsList__book10() {
        //Given there is a flight
        assertNotNull(flight2);
        //AND there are 3 passengers
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        assertNotNull(passenger3);
        //When I book the passengers on the flight
        flight2.book(passenger1);
        flight2.book(passenger2);
        flight2.book(passenger3);
        flight2.book(passenger4);
        flight2.book(passenger5);
        flight2.book(passenger6);
        flight2.book(passenger7);
        flight2.book(passenger8);
        flight2.book(passenger9);
        flight2.book(passenger10);
        //Then the each seat in the list will be be in ascending order
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(0).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(1).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(1).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(2).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(2).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(3).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(3).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(4).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(4).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(5).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(5).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(6).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(6).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(7).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(7).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(8).getSeatBooked());
        assertTrue(this.flightManager2.getSortedPassengersBooked().get(8).getSeatBooked() < this.flightManager2.getSortedPassengersBooked().get(9).getSeatBooked());
    }

    @Test
    public void canFindPassengerBySeatNumber__passengerExists() {
        //Given there is a flight
        assertNotNull(flight2);
        //AND there are 3 passengers
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        assertNotNull(passenger3);
        //AND I book the passengers on the flight
        flight2.book(passenger1);
        flight2.book(passenger2);
        flight2.book(passenger3);
        //When I search for passenger by seat number
        int seatNumber = passenger2.getSeatBooked();
        //Then I get passenger2 back
        assertEquals(passenger2, flightManager2.findPassengerBySeat(flightManager2.getSortedPassengersBooked(), seatNumber));
    }

    @Test
    public void canFindPassengerBySeatNumber__passengerDoesNotExist() {
        //Given there is a flight with no passengers
        assertNotNull(flight2);
        //When I search for passenger by seat number
        int seatNumber = 1;
        //Then I get no passenger back
        assertEquals(null, flightManager2.findPassengerBySeat(flightManager2.getSortedPassengersBooked(), seatNumber));
    }
}
