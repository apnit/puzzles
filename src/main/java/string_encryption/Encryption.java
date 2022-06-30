package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        StringBuilder output = new StringBuilder();
        char[] ch = str.toCharArray();
        for (int i=0; i<str.length(); i++) {
            int newCh;
            newCh = ch[i] + ch[0];
            if (i == str.length() - 1) {
                if (str.length() > 1 && ch[i] == ch[0]) {
                    output.append(ch[i]).append(ch[0]);
                } else if (newCh % 2 == 0) {
                    output.append((char) newCh);
                } else {
                    output.append(ch[i]).append(ch[0]);
                }
            } else {
                 newCh = ch[i] + ch[i+1];
                output.append((char) newCh);
            }
        }
        return output.toString();
    }

    public static String Decrypt(String str) {
        return "";
    }
}
