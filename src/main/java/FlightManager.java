public class FlightManager {

    private Flight flight;
    private int bagWeight;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.bagWeight = 20;
    }

    public int getBaggageWeightPerPassenger() {
        int totalWeight = flight.getPlane().getTotalWeight();
        int baggageWeight = totalWeight/2;
        return baggageWeight/this.flight.getPlane().getCapacity();
    }

}
