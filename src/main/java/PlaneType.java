public enum PlaneType {
    BOEING747(10, 2000),
    CONCHORD(2, 1000);

    private int capacity;
    private int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
