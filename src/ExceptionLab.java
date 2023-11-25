import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionLab {

    public static int doDivide(int x, int y) throws ArithmeticException, InputMismatchException{
        return x/y;
    }

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter x:");
                int x = scanner.nextInt();
                System.out.println("Please enter y:");
                int y = scanner.nextInt();
                int z = doDivide(x, y);
                System.out.println(z);
                return;
            }
            catch (ArithmeticException e){
                // print(f"{variables}") 3.8
                // String.format()
                System.out.printf("%s: Can not / by zero, try again", e);
            }
            catch (InputMismatchException e){
                System.out.printf("%s: Only Int allowed, try again", e);
            }
        }
    }

}