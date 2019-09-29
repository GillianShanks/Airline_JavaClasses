import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight;
    Flight flight2;
    Plane plane;
    Plane plane2;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Debbie McFarlane", 1);
        passenger2 = new Passenger("Gregor Talloy", 3);
        passenger3 = new Passenger("Jeremy Kyle", 0);

        plane = new Plane(PlaneType.CONCHORD);
        plane2 = new Plane(PlaneType.BOEING747);

        LocalDate date = LocalDate.of(2019, 11, 17);
        LocalDateTime dateTime = date.atTime(11,0);

        Date oldFashionedDate = Date.from(dateTime.toInstant(ZoneOffset.UTC));
        long longDate = oldFashionedDate.getTime();
        Date goodDate = new Date (longDate);

        flight = new Flight(plane, "FR3180", "EDI", "ARN", goodDate);
        flight2 = new Flight(plane2, "FR3180", "EDI", "ARN", goodDate);

    }

    @Test
    public void canGetAvailableSeat_startsEmpty(){
        //Given there is a flight
        assertNotNull(flight);
        //When
        //Then the number of seats starts empty - so full capacity
        assertEquals(2, flight.remainingSeats());
    }

    @Test
    public void canBookPassenger__flightEmpty(){
        //Given there is a flight
        assertNotNull(flight);
        //AND there is a passenger
        assertNotNull(passenger1);
        //When I book the passenger on the flight
        flight.book(passenger1);
        //Then the remaining seats will be 1
        assertEquals(1, flight.remainingSeats());

    }
    @Test
    public void canBookPassenger__flightFull(){
        //Given there is a flight
        assertNotNull(flight);
        //AND there are three passengers
        assertNotNull(passenger1);
        //AND 2 are booked on the flight
        flight.book(passenger1);
        flight.book(passenger2);
        //When I book the passenger on the flight
        flight.book(passenger3);
        //Then the remaining seats will be 1
        assertEquals(0, flight.remainingSeats());

    }

    @Test
    public void canGetFlightTime(){
        assertEquals(new Date(1573988400000L), flight.getDepartureTime());
    }

    @Test
    public void canAddFlightToPassenger(){
        //Given there is a flight
        assertNotNull(flight);
        //AND there is a passenger
        assertNotNull(passenger1);
        //When I book the passenger on the flight
        flight.book(passenger1);
        //Then the passenger's flight is updated
        assertEquals(this.flight, passenger1.getFlightBooked());
    }

    @Test
    public void canGetPassengersUniqueSeatNumber(){
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
        //Then the passenger's seatNumber is updated
        assertEquals(this.flight2.getSeatsBooked().get(0), passenger1.getSeatBooked());
        assertEquals(this.flight2.getSeatsBooked().get(1), passenger2.getSeatBooked());
        assertEquals(this.flight2.getSeatsBooked().get(2), passenger3.getSeatBooked());
    }
}
