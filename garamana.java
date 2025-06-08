import java.util.Scanner;

public class garamana {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        char[] firstLetter = scanner.next().toCharArray();
        if (firstLetter.length < 1 || firstLetter.length > 100) {

            scanner.close();
            throw new Exception();
        }

        char[] secondLetter = scanner.next().toCharArray();
        if (secondLetter.length != firstLetter.length) {

            scanner.close();
            throw new Exception();
        }

        boolean isTrue = true;
        for (int i = 0; i < secondLetter.length; i++) {
            if (secondLetter[i] != '*') {
                boolean isLetter = false;

                for (int j = 0; j < firstLetter.length; j++) {

                    if (secondLetter[i] == firstLetter[j]) {
                        firstLetter[j] = '_';
                        isLetter = true;
                        break;
                    }
                }

                if (!isLetter) {
                    isTrue = false;
                    break;
                }
            }
        }

        if (isTrue) {
            System.out.println("S");
        }
        else {
            System.out.println("N");
        }

        scanner.close();
    }
}
