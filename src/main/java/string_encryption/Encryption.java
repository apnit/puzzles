package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        boolean even = str.length() % 2 == 0;
        StringBuilder out = new StringBuilder();
        for (int i=0; i < str.length(); i++) {
            if (i == str.length()-1) {
                if(even) out.append(str.charAt(i)).append(str.charAt(0));
                else out.append((char)((int) str.charAt(i) + (int) str.charAt(0)));
            }
            else out.append((char)((int) str.charAt(i) + (int) str.charAt(i+1)));
        }
        return out.toString();
    }

    public static String Decrypt(String str) {
        StringBuilder out = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < str.length(); i+=2) {
            if (i == str.length()-1) sum += (int) str.charAt(i) - (int) str.charAt(0);
            else sum += (int) str.charAt(i) - (int) str.charAt(i+1);
        }
        char first = (char) ((sum + str.charAt(0))/2);
        for (int i = 0; i < str.length(); i++) {
            if (first != 0) out.append(first);
            first = (char) (str.charAt(i) - first);
        }
        return out.toString();
    }
}
