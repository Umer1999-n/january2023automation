package Day4_011623;

public class T3_VoidMethodExample {
    public static void main(String[] args) {
        //call sumoftwonumbers from reusable class
//        ReusableClass.sumOfTwoNumbers(9, 10);
        int sumOfTwoNum = ReusableClass.returnSumOfTwoNumbers(9, 10);

        int a = 9;
        int b = 10;
        System.out.println("the sum of two numbers is " + (a + b));
    }//end of main
}//end of class
