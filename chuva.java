import java.util.Scanner;

public class chuva {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] rain = new char[n][m];
        for (int i = 0; i < n; i++) {
            rain[i] = scanner.next().toCharArray();
        }

        int startIndex = 0;
        for (int j = 0; j < m; j++) {
            if (rain[0][j] == 'o') {
                startIndex = j;
                break;
            }
        }

        rainWay(rain, 0, startIndex);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(rain[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void rainWay(char[][] rain, int i, int j) {

        rain[i][j] = 'o';
        if (i == rain.length - 1) {
            return;
        }

        if (rain[i + 1][j] == '.') {
            rainWay(rain, i + 1, j);
        }
        if (j > 0 && rain[i][j - 1] == '.' && rain[i + 1][j] == '#') {
            rainWay(rain, i, j - 1);
        }
        if (j < rain[0].length - 1 && rain[i][j + 1] == '.' && rain[i + 1][j] == '#') {
            rainWay(rain, i, j + 1);
        }
    }
}