package five;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int result =10/0;
        }catch (Exception e){
            System.out.println("In catch block");
        }
        System.out.println("Done");

        int[] a = {1,2,3};
        try {
            System.out.println(a[6]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter array valid index number");
        }
    }
}
