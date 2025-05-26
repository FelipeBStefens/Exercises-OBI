import java.util.Scanner;

public class contas {
    
    public static void main(String[] args) throws Exception{
       Scanner scanner = new Scanner(System.in);
       
       int v = scanner.nextInt();
       if (v < 0 || v > 2000) {

        scanner.close();
        throw new Exception();
       }
       int a = scanner.nextInt();
       if (a < 0 || a > 1000) {

        scanner.close();
        throw new Exception();
       }
       int f = scanner.nextInt();
       if (f < 0 || f > 1000) {

        scanner.close();
        throw new Exception();
       }
       int p = scanner.nextInt();
       if (p < 0 || p > 1000) {

        scanner.close();
        throw new Exception();
       }

       int quantityPayments= 0;
       if (v - a >= 0 && v - f - p < 0) {
        v -= a;
        quantityPayments++;
       }
       if (v - f >= 0) {
        v -= f;
        quantityPayments++;
       }
       if (v - p >= 0) {
        quantityPayments++;
       }

       System.out.println(quantityPayments);
       scanner.close();
    }
}
