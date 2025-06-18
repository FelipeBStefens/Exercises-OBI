import java.util.Scanner;

public class idade {

     public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        if (m < 40 || m > 110) {
          scanner.close();
          throw new Exception();
        }

        int a = scanner.nextInt();
        if (a < 1 || a >= m) {
          scanner.close();
          throw new Exception();
        }

        int b = scanner.nextInt();
        if (b < 1 || b >= m || b == a || m - a == 2 * b) {
          scanner.close();
          throw new Exception();
        }

        if (m - b > 2 * a && m - a > 2 * b) {
          System.out.println(m - b - a);
        }
        else if (2 * a > m - b && a > b) {
          System.out.println(a);
        }
        else {
          System.out.println(b);
        }
        
        scanner.close();
     }
}
