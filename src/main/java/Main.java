import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    public static String calc(String input) {
        return new Calculation().start(input);
    }
}
