package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        StringBuilder builder = new StringBuilder();
        int fN = (str.charAt(0) >= 122)?-1:1;
        for (int i = 0; i < str.length(); i++) {
            int asci = ((int)str.charAt(i))*2+fN;
            if(str.charAt(i) == 122 && fN == 1)
                asci = 122;
            else if(str.charAt(i)==98 && fN == -1)
                asci=220;
            if(str.charAt(i) == 97) {
                if(str.length() > i+1) {
                    if(str.charAt(i+1) ==97) {
                        builder.append((char)194);
                        asci =97;
                        i++;
                    }
                }else
                    asci = 194;
            }
            builder.append(((char)asci));
        }
        if(str.length()!=1 & str.charAt(0) == 'a')
            builder.append("a");
        return builder.toString();
    }

    public static String Decrypt(String str) {
        StringBuilder builder = new StringBuilder();
        int fN = (str.charAt(0) >= 243)?+1:-1;
        if(str.length()!=1 & str.charAt(str.length()-1) == 'a') {
            if(str.charAt(0)!=195)
            builder.append("a");
            str = new StringBuilder(str).deleteCharAt(str.length()-1).toString();
        }
        for (int i = 0; i < str.length(); i++) {
            int asci = (str.charAt(i)>= 123)? (int) (Math.ceil((float)(str.charAt(i)+fN) / 2f)) :str.charAt(i);
            if(str.charAt(i) == 122 && fN == -1)
                asci = 122;
            else if(str.charAt(i)==220 && fN == 1)
                asci=98;
            if(str.charAt(i) == 194) {
                if(str.length() > i+1) {
                    if(str.charAt(i+1) ==97) {
                        asci =97;
                        i++;
                    }
                }else
                    asci = 97;
            }
            builder.append(((char)asci));
        }
        return builder.toString();
    }
}
