import java.util.Arrays;
import java.util.Scanner;

public class estrada {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[] allStates = new int[n];

        for (int i = 0; i < n; i++) {
            allStates[i] = scanner.nextInt();
        }

        Arrays.sort(allStates);

        double min = t;
        for (int i = 0; i < allStates.length; i++) {

            double way = 0;
            if (i == 0) {
                way += (double)allStates[i];
                way += ((double)allStates[i + 1] - (double)allStates[i]) / 2;
            }
            else if (i == allStates.length - 1) {
                way += (double)t - (double)allStates[i];
                way += ((double)allStates[i] - (double)allStates[i - 1]) / 2;
            }
            else {
                way += ((double)allStates[i + 1] - (double)allStates[i]) / 2;
                way += ((double)allStates[i] - (double)allStates[i - 1]) / 2;
            }

            if (way < min) {
                min = way;
            }
        }

        System.out.printf("%.2f", min);
        scanner.close();
    }
}
