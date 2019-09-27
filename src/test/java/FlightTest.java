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

    @Before
    public void before(){
        passenger1 = new Passenger("Debbie McFarlane", 1);
        passenger2 = new Passenger("Gregor Talloy", 3);

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




}
