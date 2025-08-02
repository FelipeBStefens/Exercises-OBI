import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mapa {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int c = scanner.nextInt();

        char[][] map = new char[l][c];
        for (int i = 0; i < l; i++) {
            map[i] = scanner.next().toCharArray();
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'o') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }

        int[] hermionePoints = wayMatrix(map, x, y, new ArrayList<>());
        System.out.println((hermionePoints[1] + 1) + " " + (hermionePoints[0] + 1));

        scanner.close();
    }

    public static int[] wayMatrix(char[][] matrix, int x, int y, ArrayList<int[]> isVisited) {
        
        int[] actualPoints = {x, y};
        isVisited.add(actualPoints);

        if (y > 0 && matrix[y - 1][x] == 'H' && !itsVisited(x, y - 1, isVisited)) {
            return wayMatrix(matrix, x, y - 1, isVisited);
        }
        else if (y < matrix.length - 1 && matrix[y + 1][x] == 'H' && !itsVisited(x, y + 1, isVisited)) {
            return wayMatrix(matrix, x, y + 1, isVisited);
        }
        else if (x > 0 && matrix[y][x - 1] == 'H' && !itsVisited(x - 1, y, isVisited)) {
            return wayMatrix(matrix, x - 1, y, isVisited);
        }
        else if (x < matrix[0].length - 1 && matrix[y][x + 1] == 'H' && !itsVisited(x + 1, y, isVisited)) {
            return wayMatrix(matrix, x + 1, y, isVisited);
        }
        else {
            return actualPoints;
        }
    }

    public static boolean itsVisited(int x, int y, ArrayList<int[]> isVisited) {

        int[] points = {x, y};
        for (int i = 0; i < isVisited.size(); i++) {

            if (Arrays.equals(points, isVisited.get(i))) {
                return true;
            }
        }

        return false;
    }
}
