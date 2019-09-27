import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Debbie McFarlane", 1);
        passenger2 = new Passenger("Gregor Talloy", 3);
        passenger3 = new Passenger("Jeremy Kyle", 0);

        plane = new Plane(PlaneType.CONCHORD);

        flight = new Flight(plane, "FR3180", "EDI", "ARN", "1100");

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


}
