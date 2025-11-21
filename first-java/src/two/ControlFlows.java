package two;

public class ControlFlows {
    /*
==========================================================
    CONTROL FLOW IN JAVA
==========================================================

🔹 What is Control Flow?
Control flow means how your program executes statements
based on conditions or loops. Instead of running code line
by line blindly, you can tell Java:

✅ “Do this if something is true.”
🔄 “Repeat this until a condition changes.”
🔀 “Choose one path from many.”

Java gives us three main types:
1. Decision-making → if, else if, else, switch
2. Loops (Iteration) → for, while, do-while, enhanced for-each
3. Jump statements → break, continue
*/
    public static void main(String[] args) {
        // if-else
        int age = 17;
        if (age>=18) {
            System.out.println("Adult.");
        }
        else {
            System.out.println("Not Adult.");
        }

        String day = "Friday";
        switch (day){
            case "Monday"-> System.out.println("Day is Monday");
            case "TuesDay"-> System.out.println("Day is Tuesday");
            case "Wednesday"-> System.out.println("Day is Wednesday");
            case "Thursday"-> System.out.println("Day is Thursday");
            case "Friday"-> System.out.println("Day is Friday");
            case "Saturday"-> System.out.println("Day is Saturday");
            case "Sunday"-> System.out.println("Day is Sunday");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Counter "+ i);
        }

        String[] languages = {"Java",".Net","Python","Javascript"};
        // for loop
        for (int i = 0; i < languages.length; i++) {
            System.out.println(languages[i]);
        }

        // for-each loop
        for (String language: languages){
            System.out.println(language);
        }
    }
}
