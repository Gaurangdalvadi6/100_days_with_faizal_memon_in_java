package six;

@java.lang.FunctionalInterface
interface BookAction {
    void perform();
//    void performAny();
}

@java.lang.FunctionalInterface
interface Operations {
    int add(int a,int b);
}

public class FunctionalInterface {
    public static void main(String[] args) {

//        BookAction action1 = new BookAction() {
//            @Override
//            public void perform() {
//                System.out.println("Action Performed");
//            }
//        };
//        action1.perform();

//        BookAction action2 = () -> {
//                System.out.println("Action Performed");
//        };
//        action2.perform();

        BookAction action3 = () -> System.out.println("Action Performed");;
        action3.perform();

        Operations operations = (a,b)-> {
            return a+b;
        };
        System.out.println(operations.add(2,3));
    }
}
