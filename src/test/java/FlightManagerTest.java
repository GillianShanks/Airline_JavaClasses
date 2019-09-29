import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightManagerTest {

    FlightManager flightManager;
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

        Date date = new Date(2019, 11, 17, 11, 0);

        flight = new Flight(plane, "FR3180", "EDI", "ARN", date);

        flightManager = new FlightManager(flight);
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

}
