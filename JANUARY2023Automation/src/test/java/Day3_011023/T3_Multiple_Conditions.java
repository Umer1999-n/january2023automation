package Day3_011023;

public class T3_Multiple_Conditions {
    public static void main(String[] args) {
        //print when a+b < c or a+b > c or a+b = c

        int a = 2;
        int b = 3;
        int c = 5;

        if (a+b < c){
            System.out.println("a & b is less than c");
        }else if (a+b > c){
            System.out.println("a & b is greater than c");
        }else {
            System.out.println("a & b is equal to c");
        }//end of conditions
    }//end of main
}//end of class
