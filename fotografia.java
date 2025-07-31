import java.util.ArrayList;
import java.util.Scanner;

public class fotografia {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int l = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] all = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                all[i][j] = scanner.nextInt();
            }
        }

        ArrayList<Integer> allBiggerIndex = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {

            if (all[i][0] >= a && all[i][1] >= l) {
                
                allBiggerIndex.add(i);
            }
            else if (all[i][1] >= a && all[i][0] >= l) {

                allBiggerIndex.add(i);
            }
        }
        if (allBiggerIndex.isEmpty()) {
            System.out.println(-1);
            scanner.close();
            return;
        }

        int area = a * l;
        int lessAreaIndex = 0;

        for (int i = 0; i < allBiggerIndex.size(); i++) {

            int areaIndex =  (all[allBiggerIndex.get(i)][0] 
                * all[allBiggerIndex.get(i)][1]) - area;

            int lessArea = (all[allBiggerIndex.get(lessAreaIndex)][0] 
                * all[allBiggerIndex.get(lessAreaIndex)][1]) - area;

            if (areaIndex < lessArea) {
                lessAreaIndex = i;
            }
        }

        System.out.println(lessAreaIndex + 1);

        scanner.close();
    }
}
