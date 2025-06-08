import java.util.Scanner;

public class irmaos {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n < 1 || n > 40) {

            scanner.close();
            throw new Exception();
        }

        int m = scanner.nextInt();
        if (m < n || m > 40) {

            scanner.close();
            throw new Exception();
        }

        System.out.println(2 * m - n);
        scanner.close();
    }
}
