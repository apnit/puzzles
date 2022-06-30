package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        StringBuilder encryptedStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int firstChar = str.charAt(i);
            int nextChar;
            if (i == str.length()-1) nextChar = str.charAt(0);
            else nextChar = str.charAt(i+1);

            encryptedStr.append((char) (firstChar + nextChar));
        }
        return encryptedStr.toString();
    }

    public static String Decrypt(String str) {
        return "";
    }
}
