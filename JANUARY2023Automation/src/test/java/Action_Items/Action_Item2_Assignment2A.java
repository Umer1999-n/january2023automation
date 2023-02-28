package Action_Items;

import java.util.ArrayList;

public class Action_Item2_Assignment2A {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");

        for (int i = 0; i < cities.size(); i++){
            System.out.println("The iteration number is now : " + i);
            System.out.println("The city is " + cities.get(i));

        }//end of for loop
    }//end of main
}//end of class
