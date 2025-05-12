package Day6;

class ParkingSystem {
    int remainingBig;
    int remainingMedium;
    int remainingSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.remainingBig = big;
        this.remainingMedium = medium;
        this.remainingSmall = small;
    }

    public boolean addCar(int carType) {
        if( carType == 1){
            if(remainingBig > 0){
                remainingBig--;
                return true;
            } else return false;
        }
        if( carType == 2){
            if(remainingMedium > 0){
                remainingMedium--;
                return true;
            } else return false;
        }
        if( carType == 3){
            if(remainingSmall > 0){
                remainingSmall--;
                return true;
            } else return false;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
