package race;

import java.util.Arrays;
import java.util.Random;

import car_stats.generated_stats;

public class race_started {
    private int carAcceleration;
    private int carBraking;
    private int startSpeed;
    private int currentSpeed;
    private int laps;
    private int position1;
    private int position2;
    private int position3;
    private int position4;
    private int[] eventSelector = new int[]{1, 2, 3, 4};
    private Random rand = new Random();
    generated_stats statgen = new generated_stats();

    public race_started(){
        startSpeed = 10;
        laps = 10;
        int lapcount = 1;

        int[] racer1 = {statgen.getCarAcc(), statgen.getCarBr(), 0, 0};
        int[] racer2 = {statgen.getCarAcc(), statgen.getCarBr(), 0, 1};
        int[] racer3 = {statgen.getCarAcc(), statgen.getCarBr(), 0, 2};
        int[] racer4 = {statgen.getCarAcc(), statgen.getCarBr(), 0, 3};

        while(laps != 0){
            System.out.println("Current Lap: " + lapcount);

            car1(racer1);
            car2(racer2);
            car3(racer3);
            car4(racer4);

            System.out.println("Checking racer positions.");
            position1 = checkPositions1(racer1, racer2, racer3, racer4);
            position2 = checkPositions2(racer1, racer2, racer3, racer4);
            position3 = checkPositions3(racer1, racer2, racer3, racer4);
            position4 = checkPositions4(racer1, racer2, racer3, racer4);

            System.out.print("Racer 1 is in position: " + position1);
            System.out.print("Racer 2 is in position: " + position2);
            System.out.print("Racer 3 is in position: " + position3);
            System.out.print("Racer 4 is in position: " + position4);

            lapcount = lapcount + 1;
            laps = laps - 1;
        }

        System.out.println("Final Position are:");
        System.out.println("Racer 1 finished in position: " + position1);
        System.out.println("Racer 2 finished in position: " + position2);
        System.out.println("Racer 3 finished in position: " + position3);
        System.out.println("Racer 4 finished in position: " + position4);
           

    }
    
    public void car1(int [] racer1){
        int carselect1 = getRandomEvent();
        carAcceleration = racer1[0];
        carBraking = racer1[1];
        if (carselect1 == 1){
            racer1[2] = eventAccel();
        } 
        else if (carselect1 == 2) {
            racer1[2] = eventBrake();
        }
        else {
            racer1[2] = eventPittstop();
        }
    }

    public void car2(int [] racer2){
        int carselect2 = getRandomEvent();
        carAcceleration = racer2[0];
        carBraking = racer2[1];
        if (carselect2 == 1){
            racer2[2] = eventAccel();
        } 
        else if (carselect2 == 2) {
            racer2[2] = eventBrake();
        }
        else {
            racer2[2] = eventPittstop();
        }
    }

    public void car3(int [] racer3){
        int carselect3 = getRandomEvent();
        carAcceleration = racer3[0];
        carBraking = racer3[1];
        if (carselect3 == 1){
            racer3[2] = eventAccel();
        } 
        else if (carselect3 == 2) {
            racer3[2] = eventBrake();
        }
        else {
            racer3[2] = eventPittstop();
        }
    }

    public void car4(int [] racer4){
        int carselect4 = getRandomEvent();
        carAcceleration = racer4[0];
        carBraking = racer4[1];
        if (carselect4 == 1){
            racer4[2] = eventAccel();
        } 
        else if (carselect4 == 2) {
            racer4[2] = eventBrake();
        }
        else {
            racer4[2] = eventPittstop();
        }
    }

    public int getRandomEvent(){
        return eventSelector[rand.nextInt(eventSelector.length)];
    }

    public int eventAccel(){
        if(currentSpeed > 0){
            currentSpeed = currentSpeed + carAcceleration;
        }
        else{
            currentSpeed = startSpeed + carAcceleration;
        }
         return currentSpeed;
    }

    public int eventBrake(){
        if(currentSpeed > 0){
            currentSpeed = currentSpeed - carBraking; 
        }
        else {
            currentSpeed = 0;
        }
         
        return currentSpeed;
    }

    public int eventPittstop(){
        currentSpeed = 0;

        return currentSpeed;
    }

    public int checkPositions1(int [] racer1, int [] racer2, int [] racer3, int [] racer4){
        int[] array1 = {racer1[2], racer2[2], racer3[2], racer4[2]};
        int i;
        int x = 0;
        int max = array1[0];
        int position = 0;
        int setposition = 0;
        for (i = 1; i < array1.length; i++)
            if (array1[i] > max){
                max = array1[i];
            }
        while (x < array1.length){
            if (array1[x] == max){
                position = x;
            }
            else{
                x ++;
            }
        }
        if(racer1[3] == position){
            setposition = racer1[3];
        }
        else if(racer2[3] == position){
            setposition = racer2[3];
        }
        else if(racer3[3] == position){
            setposition = racer3[3];
        } 
        else{
            setposition = racer4[3];
        }   
        return setposition;
    }
    
    public int checkPositions2 (int [] racer1, int [] racer2, int [] racer3, int [] racer4){
        int[] array2 = {racer1[2], racer2[2], racer3[2], racer4[2]};
        int size = array2.length;
        Arrays.sort(array2);
        int second = array2[size-2];
        int x = 0;
        int position = 0;
        while (x < array2.length){
            if (array2[x] == second){
                position = x;
            }
            else{
                x ++;
            }
        } 
        if(racer1[3] == position){
            position2 = racer1[3];
        }
        else if(racer2[3] == position){
            position2 = racer2[3];
        }
        else if(racer3[3] == position){
            position2 = racer3[3];
        } 
        else{
            position2 = racer4[3];
        }   
        return position2;
    }

    public int checkPositions3 (int [] racer1, int [] racer2, int [] racer3, int [] racer4){
        int[] array3 = {racer1[2], racer2[2], racer3[2], racer4[2]};
        int size = array3.length;
        Arrays.sort(array3);
        int second = array3[size-3];
        int x = 0;
        int position = 0;
        while (x < array3.length){
            if (array3[x] == second){
                position = x;
            }
            else{
                x ++;
            }
        } 
        if(racer1[3] == position){
            position3 = racer1[3];
        }
        else if(racer2[3] == position){
            position3 = racer2[3];
        }
        else if(racer3[3] == position){
            position3 = racer3[3];
        } 
        else{
            position3 = racer4[3];
        }   
        return position3;
    }

    public int checkPositions4 (int [] racer1, int [] racer2, int [] racer3, int [] racer4){
        int[] array4 = {racer1[2], racer2[2], racer3[2], racer4[2]};
        int i;
        int x = 0;
        int min = array4[0];
        int position = 0;
        for (i = 1; i < array4.length; i++)
            if (array4[i] < min){
                min = array4[i];
            }
        while (x < array4.length){
            if (array4[x] == min){
                position = x;
            }
            else{
                x ++;
            }
        }    
        if(racer1[3] == position){
            position1 = racer1[3];
        }
        else if(racer2[3] == position){
            position4 = racer2[3];
        }
        else if(racer3[3] == position){
            position4 = racer3[3];
        } 
        else{
            position4 = racer4[3];
        }   
        return position4;
    }


    
    public race_started(int carAcceleration, int carBraking, int startSpeed, int currentSpeed, int laps, int position1,
            int position2, int position3, int position4, int[] eventSelector, Random rand) {
        this.carAcceleration = carAcceleration;
        this.carBraking = carBraking;
        this.startSpeed = startSpeed;
        this.currentSpeed = currentSpeed;
        this.laps = laps;
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.position4 = position4;
        this.eventSelector = eventSelector;
        this.rand = rand;
    }

    public int getCarAcceleration() {
        return carAcceleration;
    }

    public void setCarAcceleration(int carAcceleration) {
        this.carAcceleration = carAcceleration;
    }

    public int getCarBraking() {
        return carBraking;
    }

    public void setCarBraking(int carBraking) {
        this.carBraking = carBraking;
    }

    public int getStartSpeed() {
        return startSpeed;
    }

    public void setStartSpeed(int startSpeed) {
        this.startSpeed = startSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
        if(this.currentSpeed > 0){
            this.currentSpeed = 0;
        }
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int[] getEventSelector() {
        return eventSelector;
    }

    public void setEventSelector(int[] eventSelector) {
        this.eventSelector = eventSelector;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

    public int getPosition3() {
        return position3;
    }

    public void setPosition3(int position3) {
        this.position3 = position3;
    }

    public int getPosition4() {
        return position4;
    }

    public void setPosition4(int position4) {
        this.position4 = position4;
    }

    


}