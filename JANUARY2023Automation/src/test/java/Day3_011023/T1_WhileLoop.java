package Day3_011023;

import java.util.ArrayList;

public class T1_WhileLoop {
    public static void main(String[] args) {
        //declare an array list of countries
        ArrayList<String> countries = new ArrayList<>();
        //add values for countries
        countries.add("USA");//index 0
        countries.add("PAKISTAN");//index 1
        countries.add("INDIA");//index 2
        countries.add("BANGLADESH");// index 3

        //set the initializer first
        int i = 0;

        //define the end point in while command
        while (i < countries.size()) {
            //shortcut for print statement is lower case sout
            System.out.println("country is " + countries.get(i));
            //at the end before closing the while loop, call the incrementation
            i = i+1;//if you don't have incrementation, while loop will become infinite loop
        }//end of while
    }//end of main
}//end of class
