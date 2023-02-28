package Day2_010923;

import java.util.ArrayList;
public class T3_ForLoop_ArrayList {
    public static void main(String[] args) {
        //declare an array list of countries
        ArrayList<String> countries = new ArrayList<>();
        //add values for countries
        countries.add("USA");//index 0
        countries.add("PAKISTAN");//index 1
        countries.add("INDIA");//index 2
        countries.add("BANGLADESH");// index 3
        countries.add("CHINA");//index 4
        //call for loop to print out all countries
        //countries.size() will return 5 but our condition needs to be less than 5 or until 4
        for (int i = 0; i < countries.size(); i++){
            //print out the i value to see the iteration number
            System.out.println("The iteration number is now : " + i);
            //print out all the countries
            System.out.println("The country is " + countries.get(i));
            // this is where the i++ happens
        }//end of for loop
    }//end of main
}//end of class
