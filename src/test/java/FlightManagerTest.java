import org.junit.Before;
import org.junit.Test;

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

        flight = new Flight(plane, "FR3180", "EDI", "ARN", "1100");

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
    public void canGetBaggageWeightBooked(){
        //Given there is a flight
        assertNotNull(flight);
        //When 1 passenger with 3 bags is booked
        assertNotNull(passenger2);
        this.flight.book(passenger2);
        //Then baggage weight booked is 60
        assertEquals(60, flightManager.getBaggageWeightBooked());
    }
}
