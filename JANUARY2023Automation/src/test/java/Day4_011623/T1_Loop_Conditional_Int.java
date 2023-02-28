package Day4_011623;

import java.util.ArrayList;

public class T1_Loop_Conditional_Int {
    public static void main(String[] args) {
        //declare integer array list for student grades
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add some grade to the studentGrades arrayList
        studentGrades.add(96);//index 0
        studentGrades.add(86);//index 1
        studentGrades.add(76);//index 2
        //index 3 does not exist
        //for loop to iterate through the array list
        for (int i = 0; i < studentGrades.size(); i++) {
            //|| is called the OR operator in java (one of the conditions need to be true in order for it to execute)
            //&& is called the AND operator in java (both of the conditions need to be true in order for it to be true)
            /*if (studentGrades.get(i) == 76 || studentGrades.get(i) == 96) {
                System.out.println(" the student grade is " + studentGrades.get(i) + " A or B");
            }*/
            //start conditional statement to see if grade is 86
            //print only grade 86
            if (studentGrades.get(i) == 86)
                System.out.println(" the student grade is " + studentGrades.get(i) + " Grade B ");
            //use else if to print mor than one statement
            else if (studentGrades.get(i) == 96)
                System.out.println(" the student grade is " + studentGrades.get(i) + " Grade A ");
        }//end of for  loop
    }//end of main
}//end of class
