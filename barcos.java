import java.util.ArrayList;
import java.util.Scanner;

public class barcos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int b = scanner.nextInt();

        int[][] shipsDetails = new int[b][3];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 3; j++) {
                shipsDetails[i][j] = scanner.nextInt();
            }
        }

        int c = scanner.nextInt();

        int[][] allConsults = new int[c][2];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                allConsults[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < allConsults.length; i++) {
            System.out.println(max(shipsDetails, allConsults[i], new ArrayList<>(), -1));
        }
        scanner.close();
    }

    public static int max
        (int[][] shipsDetails, int[] consult, ArrayList<Integer> isVisited, int p) {

        if (consult[0] == consult[1]) {
            return p;
        }

        isVisited.add(consult[0]);
        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 0; i < shipsDetails.length; i++) {

            if (shipsDetails[i][0] == consult[0]) {
                if (!isInVisited(isVisited, shipsDetails[i][1])) {

                    int[] newConsult = {shipsDetails[i][1], consult[1]};
                    if (p == -1 || p > shipsDetails[i][2]) {
                        count.add((Integer)max(shipsDetails,
                            newConsult, isVisited, shipsDetails[i][2]));
                    }
                    else if (p <= shipsDetails[i][2]) {
                        count.add((Integer)max(shipsDetails,
                            newConsult, isVisited, p));
                    }
                }
            }
            else if (shipsDetails[i][1] == consult[0]) {
                if (!isInVisited(isVisited, shipsDetails[i][0])) {

                    int[] newConsult = {shipsDetails[i][0], consult[1]};
                    if (p == -1 || p > shipsDetails[i][2]) {
                        count.add((Integer)max(shipsDetails,
                            newConsult, isVisited, shipsDetails[i][2]));
                    }
                    else if (p <= shipsDetails[i][2]) {
                        count.add((Integer)max(shipsDetails,
                            newConsult, isVisited, p));
                    }
                }
            }
        }
        isVisited.remove(isVisited.size() - 1);
        return maxCount(count);
    }

    public static boolean isInVisited(ArrayList<Integer> list, int value) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }

    public static int maxCount(ArrayList<Integer> count) {

        int max = -1;
        for (int i = 0; i < count.size(); i++) {
            
            if (max < count.get(i)) {
                max = count.get(i);
            }
        }
        return max;
    }
}