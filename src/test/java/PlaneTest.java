import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaneTest {

    Plane plane;
    PlaneType planeType;

    @Before
    public void before(){
        planeType = PlaneType.BOEING747;
        plane = new Plane(planeType);
    }

    @Test
    public void canGetPlaneCapacity(){
        //Given there is a plane
        assertNotNull(plane);
        //When
        //Then you can access the plane's planeType's capacity
        assertEquals(PlaneType.BOEING747.getCapacity(), plane.getCapacity());
    }

    @Test
    public void canGetPlaneTotalWeight(){
        //Given there is a plane
        assertNotNull(plane);
        //When
        //Then you can access the plane's planeType's capacity
        assertEquals(PlaneType.BOEING747.getTotalWeight(), plane.getTotalWeight());
    }
}
