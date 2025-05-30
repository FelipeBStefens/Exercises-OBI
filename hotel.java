import java.util.Scanner;

public class hotel {
   
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int d = scanner.nextInt();
        if (d < 1 || d > 1000) {

            scanner.close();
            throw new Exception();
        }

        int a = scanner.nextInt();
        if (a < 1 || a > 1000) {

            scanner.close();
            throw new Exception();
        }

        int n = scanner.nextInt();
        if (n < 1 || n > 31) {

            scanner.close();
            throw new Exception();
        }

        if (n <= 15) {

            System.out.println((32 - n) * (d + (n - 1) * a));
        }
        else {

            System.out.println((32 - n) * (d + 14 * a));
        }
        scanner.close();
    }
}

