import java.util.Scanner;

public class grupos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int e = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        
        int[][] studentsTogether = new int[m][2];
        int[][] studentsNotTogether = new int[d][2];
        int[][] groups = new int[e / 3][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                studentsTogether[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < 2; j++) {
                studentsNotTogether[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < e / 3; i++) {
            for (int j = 0; j < 3; j++) {
                groups[i][j] = scanner.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {

            if (!isRestricted(groups, studentsTogether[i], true)) {
                count++;
            }
        }
        for (int i = 0; i < d; i++) {

            if (!isRestricted(groups, studentsNotTogether[i], false)) {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }

    public static boolean isRestricted(int[][] groups, int[] restriction, boolean isTogether) {

        if (isTogether) {

            int line = -1;
            for (int i = 0; i < groups.length; i++) {
                for (int j = 0; j < groups[0].length; j++) {

                    if (groups[i][j] == restriction[0]) {
                        line = i;
                        break;
                    }
                }
            }

            for (int j = 0; j < groups[0].length; j++) {

                if (restriction[1] == groups[line][j]) {
                    return true;
                }
            }
            return false;
        }
        else {

            int line = -1;
            for (int i = 0; i < groups.length; i++) {
                for (int j = 0; j < groups[0].length; j++) {

                    if (groups[i][j] == restriction[0]) {
                        line = i;
                        break;
                    }
                }
            }

            for (int j = 0; j < groups[0].length; j++) {

                if (restriction[1] == groups[line][j]) {
                    return false;
                }
            }
            return true;
        }
    }
}