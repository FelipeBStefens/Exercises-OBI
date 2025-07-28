import java.util.ArrayList;
import java.util.Scanner;

public class subcadeias {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String word = scanner.next();

        ArrayList<String> allPalindrome = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {

                if (word.charAt(i) == word.charAt(j)) {

                    String newWord = word.substring(i, j+ 1);

                    boolean isPalindrome = true;
                    for (int w = 0; w < newWord.length(); w++) {

                        if (newWord.charAt(w) != newWord.charAt(newWord.length() - 1 - w)) {
                            isPalindrome = false;
                        }
                    }

                    if (isPalindrome) {
                        allPalindrome.add(newWord);
                    }
                }
            }  
        }

        int count = -1;
        for (int i = 0; i < allPalindrome.size(); i++) {

            if (allPalindrome.get(i).length() > count) {
                count = allPalindrome.get(i).length();
            }
        }
        System.out.println(count);

        scanner.close();
    }
}
