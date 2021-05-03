
package race;

import car_stats.generated_stats;
import racer_names.racer_names;

public class main_race{
    

    public static void main(String[] args) {
        //Collect player name
        System.out.println("Generating Racer Names: ");


        //Print all names
        printAllNames();
        System.out.println();

        //Generate car stats
        System.out.println("Generating Car Stats");
        generated_stats genstats = new generated_stats();
        System.out.println();
        
        //Print length of track
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("The race will consist of 10 laps.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();


        //Starting Race
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Race is now starting.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        //Print Starting Position
        race_started race = new race_started();

        


    }

    public static void printAllNames(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("List of Racers:");
        for (int i = 0; i <4; i++){
            racer_names name = new racer_names();
            System.out.println(name + " - Racer " + (i+1));
        }
        System.out.println("------------------------------------------------------------------------------");
    }

}

