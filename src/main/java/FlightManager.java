import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class FlightManager {

    private Flight flight;
    private int bagWeight;
    private ArrayList<Passenger> sortedPassengersBooked;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.bagWeight = 20;
        this.sortedPassengersBooked = null;
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

    public void setSortedPassengersBooked(ArrayList<Passenger> sortedPassengersBooked) {
        this.sortedPassengersBooked = sortedPassengersBooked;
    }

    public void sortPassengers(){
        ArrayList<Passenger> sortedPassengerList = new ArrayList<Passenger>(this.flight.getPassengerList());
        boolean swapped = true;

        while(swapped) {
            for (int i = 0; i < sortedPassengerList.size() - 1; i++) {
                swapped = false;

                if (sortedPassengerList.get(i).getSeatBooked() > sortedPassengerList.get(i+1).getSeatBooked()) {
                    Passenger temp = sortedPassengerList.get(i);
                    sortedPassengerList.set(i, sortedPassengerList.get(i+1));
                    sortedPassengerList.set(i+1, temp);
                    swapped = true;
                }
            }
        }

        this.setSortedPassengersBooked(sortedPassengerList);
    }

    public ArrayList<Passenger> getSortedPassengersBooked() {
        this.sortPassengers();
        return sortedPassengersBooked;
    }

//    public Passenger findPassengerBySeat(int seatNumber) {
//        this.getSortedPassengersBooked();
//        if (index >=0) {
//            return this.getSortedPassengersBooked().get(index);
//        }
//        return null;
//    }
}
