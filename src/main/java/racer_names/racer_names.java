package racer_names;

import java.util.Random;

public class racer_names {
    private String fullname;

    public racer_names(){
        fullname = randomFirst() + " " + randomLast();
    }

    public String randomFirst(){
        String[] firstName = new String[] {"Tom", "Grant", "Valentin", "Lasse", "Paskal", "Knox", "Claire", "Emelia"};
        Random generat = new Random(); 
        int randomind = generat.nextInt(firstName.length);
        return firstName[randomind];
    }

    public String randomLast(){
        String[] lastName = new String[] {"Thorns", "Louis", "Ralston", "Dunn", "Hall", "Findlay", "Meyer", "Marin"};
        Random generator = new Random(); 
        int randomindex = generator.nextInt(lastName.length);
        return lastName[randomindex];
    }
 

    public racer_names(String fullname) {
        this.fullname = fullname;
    }
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return fullname;
    }
    
    
}