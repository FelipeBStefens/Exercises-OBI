import java.util.Scanner;

public class placas {
    
    public static char[] validLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'P', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static char[] validNumbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        String sign = scanner.next();
        char[] charSign = sign.toCharArray();

        if (charSign.length < 6 || charSign.length > 10) {

            scanner.close();
            throw new Exception();
        }
        boolean isValid = true;
        for (int i = 0; i < charSign.length; i++) {

            if (!isValidChar(charSign[i])) {
                isValid = false;
            }
        }
        if (!isValid) {

            scanner.close();
            throw new Exception();
        }

        if (charSign.length == 8 && isLetter(charSign[0]) && isLetter(charSign[1]) && isLetter(charSign[2])
            && charSign[3] == '-' && isNumber(charSign[4]) && isNumber(charSign[5]) && isNumber(charSign[6])
            && isNumber(charSign[7])) {

            System.out.println(1);
        }
        else if (charSign.length == 7 && isLetter(charSign[0]) && isLetter(charSign[1]) && isLetter(charSign[2])
            && isNumber(charSign[3]) && isLetter(charSign[4]) && isNumber(charSign[5]) && isNumber(charSign[6])) {

            System.out.println(2);
        }
        else {
            System.out.println(0);
        }
        scanner.close();
    }

    public static boolean isValidChar(char character) {

        boolean isValid = false;

        if(isLetter(character) || isNumber(character) || character == '-') {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isLetter(char character) {

        boolean isLetter = false;

        for (int  i = 0; i < validLetters.length; i++) {
            if (validLetters[i] == character) {
                isLetter = true;
            }
        }
        return isLetter;
    }

    public static boolean isNumber(char character) {

        boolean isNumber = false;

        for (int i = 0; i < validNumbers.length; i++) {
            if (validNumbers[i] == character) {
                isNumber = true;
            }
        }
        return isNumber;
    }
}