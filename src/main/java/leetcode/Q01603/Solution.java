class ParkingSystem {
    private int[] lots = new int[4];
    
    public ParkingSystem(int big, int medium, int small) {
        lots[1] = big;
        lots[2] = medium;
        lots[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (lots[carType] == 0) {
            return false;
        }
        
        lots[carType] -= 1;
        return lots[carType] >= 0;
    }
}
