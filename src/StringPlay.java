import java.util.Scanner;

public class StringPlay {

    public static void shiftN(String s, int n){
        // shifting n steps using ASCII code and module
        String newSN = "";
        for (int i = 0; i < s.length(); i++) {
            // upper case 65 90
            if (s.charAt(i) <= 'Z'){
                if (s.charAt(i) + n > 'Z'){
                    int code = 64 + ((int)s.charAt(i)+n) % 'Z';
                    newSN += (char) code;
                } else {
                    newSN += (char)(s.charAt(i) + n);
                }
            // lower case 97 122;
            } else if (s.charAt(i) >= 'a') {
                if (s.charAt(i) + n > 'z') {
                    int code = 96 + (s.charAt(i) + n) % 'z';
                    newSN += (char) code;
                } else {
                    newSN += (char)(s.charAt(i) + n);
                }
            }
        }
        System.out.println("Shift N Steps: " + newSN);
    }


    public static void replaceXY(String s){
        // replace all occurrences of 'x' with 'y'
        String newS = "";
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='x') {
                newS += 'y';
                continue;
            }
            newS += s.charAt(i);
        }
        System.out.println("Replace x to y: " + newS);
    }
    public static void main (String args[]) {

        System.out.println("enter a string:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        shiftN(s, 1);
        replaceXY(s);
        }
    }
