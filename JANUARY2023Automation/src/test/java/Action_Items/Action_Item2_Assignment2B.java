package Action_Items;

import java.util.ArrayList;

public class Action_Item2_Assignment2B {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        //add values for countries
        cities.add("Brooklyn");//index 0
        cities.add("Queens");//index 1
        cities.add("Manhattan");//index 2
        cities.add("Staten Island");//index 3


        int i = 0;

        while (i < cities.size()){
            System.out.println("cities is " + cities.get(i));
            i = i+1;
        }
    }//end of main





}//end of class
