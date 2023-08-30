import java.util.Scanner;

public class CountChars {
    public static void main(String [] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string:");
        str = scanner.nextLine();
        System.out.println("[Total Length] " + str.length());

        // [loop, indexing, charAt] Counting letter "z"
        int zCount = 0;
        String zStr = "z";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == zStr.charAt(0)) {
                zCount += 1;
            }
        }
        System.out.println("[Counting Z] " + zCount);

        // [character comparison, logical operators] Counting number of letters
        // There's a unicode decimal for each letter [a, z] [A, Z], direct comparison is supported
        int letterCount = 0;
        for (int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if ( c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                letterCount ++;
            }
        }
        System.out.println("[Counting Letter Logical Operators] " + letterCount);

        // [calling a static method of a library class] Counting number of letters with Character Class
        int cLetterCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)){
                cLetterCount ++;
            }
        }
        System.out.println("[Counting Letter Character Class] " + cLetterCount);

        // [logical operator] Counting vowels "aeiou"
        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowelCount ++;
            }
        }
        System.out.println("[Counting Vowel Logical Operation] " + vowelCount);

        // [calling a static method] String vowels="aeiou" and String.indexOf function
        int sVowelCount = 0;
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (vowels.indexOf(c) != -1){
                sVowelCount ++;
            }
        }
        System.out.println("[Counting Vowel String.indexOf] " + sVowelCount);

        // [building a String through concatenation] Hidden String
        String hiddenString = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' '){
                hiddenString += '*';
            }
            else{
                hiddenString += ' ';
            }
        }
        System.out.println("[Hidden String Concatenation] " + hiddenString);

        // [Building a String with StringBuilder] Hidden String
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' '){
                stringBuilder.append('*');
            }
            else{
                stringBuilder.append(' ');
            }
        }
        System.out.println("[Hidden String StringBuilder] " + stringBuilder);
    }
}