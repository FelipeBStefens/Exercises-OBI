import java.util.Scanner;

public class supers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        double[] bits = new double[n];
        double[] weight = new double[n];

        for (int i = 0; i < n; i++) {

            bits[i] = scanner.nextDouble();
            weight[i] = (double)scanner.nextInt();
        }

        double min = 0;
        for (int i = 0; i < n; i++) {

            double value = (1000 * bits[i]) / weight[i];
            if (min == 0) {
                min = value;
            }
            else if (min > value) {
                min = value;
            }
        }

        System.out.printf("%.2f", min);
        
        scanner.close();
    }
}
