import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    ArrayList<Passenger> passengerList;

    @Before
    public void before(){
        passenger1 = new Passenger("Debbie McFarlane", 1);
        passenger2 = new Passenger("Gregor Talloy", 3);
        passengerList = new ArrayList<Passenger>();
        passengerList.add(passenger1);
        passengerList.add(passenger2);

        flight = new Flight(passengerList, plane, "FR3180", "GLA", "ARN", "1100");

    }




}
