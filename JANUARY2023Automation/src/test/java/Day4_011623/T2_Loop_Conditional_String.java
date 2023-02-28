package Day4_011623;

import java.util.ArrayList;

public class T2_Loop_Conditional_String {
    public static void main(String[] args) {
        //define an array list of fruits
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apples");
        fruits.add("Oranges");
        fruits.add("Grapes");
        fruits.add("Bananas");
        //use for loop to iterate through the fruits array list
        for(int i = 0; i < fruits.size(); i++) {
            //only print bananas to the console
            //.equals compares the content of the value
            //== compares the reference to a location of java memory
            //equalsignorecase will ignore the upper / Lower case letters
            if (fruits.get(i).equalsIgnoreCase("BANANAS")){
                System.out.println("Go Bananas");
            }
        }//
    }//end of main
}//end of class




