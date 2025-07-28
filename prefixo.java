import java.util.Scanner;

public class prefixo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String word1 = scanner.next();

        int m = scanner.nextInt();
        String word2 = scanner.next();

        int count = 0;
        for (int i = 0; i < n; i++) {
           
            if (i == m) {
                break;
            }
            else if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
            else {
                break;
            }
        }

        System.out.println(count);
        
        scanner.close();
    }
}
