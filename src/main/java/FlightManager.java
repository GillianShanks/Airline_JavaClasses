import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightManager {

    private Flight flight;
    private int bagWeight;
    private ArrayList<Integer> sortedSeatsBooked;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.bagWeight = 20;
        this.sortedSeatsBooked = null;
    }

    public int getBaggageWeightPerPassenger() {
        int totalWeight = flight.getPlane().getTotalWeight();
        int baggageWeight = totalWeight/2;
        return baggageWeight/this.flight.getPlane().getCapacity();
    }

    public int getBaggageWeightBooked() {
        int totalNumOfBags =0;
        for(Passenger passenger : this.flight.getPassengerList()){
            totalNumOfBags += passenger.getNumOfBags();
        }
        return this.bagWeight * totalNumOfBags;
    }

    public int getRemainingBaggageWeight() {
        int totalWeight = flight.getPlane().getTotalWeight();
        int baggageWeight = totalWeight/2;
        return baggageWeight - this.getBaggageWeightBooked();
    }

    public void setSortedSeatsBooked(ArrayList<Integer> sortedSeatsBooked) {
        this.sortedSeatsBooked = sortedSeatsBooked;
    }

    public void sortSeats(){
        ArrayList<Integer> sortedSeatList = new ArrayList<Integer>(this.flight.getSeatsBooked());
        boolean swapped = true;

        while(swapped) {
            for (int i = 0; i < sortedSeatList.size() - 1; i++) {
                swapped = false;

                if (sortedSeatList.get(i) > sortedSeatList.get(i+1)) {
                    int temp = sortedSeatList.get(i);
                    sortedSeatList.set(i, sortedSeatList.get(i+1));
                    sortedSeatList.set(i+1, temp);
                    swapped = true;
                }
            }
        }

        this.setSortedSeatsBooked(sortedSeatList);
    }

    public ArrayList<Integer> getSortedSeatsBooked() {
        this.sortSeats();
        return sortedSeatsBooked;
    }
}
