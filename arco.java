import java.util.ArrayList;
import java.util.Scanner;

public class arco {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        ArrayList<Double> arrayDistance = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {

            count = 0;

            double distanceArrow = distance(matrix[i][0], matrix[i][1]);
            if (!arrayDistance.isEmpty()) {

                for (int j = 0; j < arrayDistance.size(); j++) {
                    if (arrayDistance.get(j) <= distanceArrow) {
                        count++;
                    }
                }
            }

            System.out.println(count);
            arrayDistance.add(distanceArrow);
        } 

        scanner.close();
    }

    public static double distance(int x, int y) {
        return Math.sqrt(Math.pow((double)x, 2) + Math.pow((double)y, 2));
    }
}
