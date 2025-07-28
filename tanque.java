import java.util.Scanner;

public class tanque {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int t = scanner.nextInt();

        if ((double)d / (double)c < (double)t) {
            System.out.println((double)0);
        }
        else {

            double value = (((double)d / (double)c) - (double)t) * 10;
            System.out.println((double)Math.round(value) / 10);
        }

        scanner.close();
    }
}
