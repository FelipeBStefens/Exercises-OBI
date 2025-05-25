import java.util.Scanner;

public class ogro {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int e = scanner.nextInt();
        if (e < 0 || e > 5) {

            scanner.close();
            throw new Exception();
        }

        int d = scanner.nextInt();
        if (d < 0 || d > 5) {

            scanner.close();
            throw new Exception();
        }
        else if (e == d) {
            scanner.close();
            throw new Exception();
        }
        else if (e > d) {
            System.out.println(e + d);
        }
        else if (e < d) {
            System.out.println(2 * (d - e));
        }
        
        scanner.close();
    }
}