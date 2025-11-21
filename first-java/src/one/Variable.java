package one;
// Single line comment
/**
 * This is
 * For Better Understanding
 */
public class Variable {
    public static void main(String[] args) {

    /* This is For Better Understanding */

        // Declaration
        int a;

        String name;

        // Initialization
        a = 10;
        name = "Java";

        // Declaration and Initialization
        int age = 20;
        System.out.println(a);
        System.out.println(name);

        System.out.println(String.format("Hello, %s. You are %s year old%n",name,age));
        System.out.printf("Hello, %s. You are %s year old",name,age);
        System.out.println();
        System.out.println();

        name = "Gaurang";
        age = 26;
        String language = "Java";

        System.out.println("My name is " + name + " and my age is "+ age + " my favorite programming language is " + language);
    }
}
