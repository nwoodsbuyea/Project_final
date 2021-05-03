package car_stats;

public class generated_stats {
    private int carAcc;
    private int carBr;


    public generated_stats(){

        carAcc = 6 + (int) (Math.random() * 10);
        carBr = 3 + (int) (Math.random() * 5);

    }


    public generated_stats(int carAcc, int carBr) {
        this.carAcc = carAcc;
        this.carBr = carBr;
    }


    public int getCarAcc() {
        return carAcc;
    }


    public void setCarAcc(int carAcc) {
        this.carAcc = carAcc;
    }


    public int getCarBr() {
        return carBr;
    }


    public void setCarBr(int carBr) {
        this.carBr = carBr;
    }


}