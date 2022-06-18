package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length(); i++) {
                if (i == str.length() - 1) {
                    stringBuilder.append(str.charAt(i)).append(str.charAt(0));
                }else
                    stringBuilder.append((char)((int) str.charAt(i) + (int) str.charAt(i+1)));
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i == str.length() - 1) {
                    stringBuilder.append((char)((int) str.charAt(i) + (int) str.charAt(0)));
                } else
                    stringBuilder.append((char)((int) str.charAt(i) + (int) str.charAt(i+1)));
            }
        }
        return stringBuilder.toString();
    }

    public static String Decrypt(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        /*
        code
         */
        return stringBuilder.toString();
    }
}
