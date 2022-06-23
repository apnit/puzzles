package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
          String stri = "";

        for (int i = 0; i < str.length(); i++){
            if (i == str.length()-1){
                int x = str.charAt(0);
                int y = str.charAt(str.length()-1);
                char z = (char) (x+y);
                stri = stri+String.valueOf(z);
            }

            else {
                int x = str.charAt(i);
                int y = str.charAt(i+1);
                char z = (char) (x + y);
                stri = stri + String.valueOf(z);
            }

        }
        String s  = null;
        String x1 = null;
        String x2 = null;

        if (str.length() % 2 == 0){
             x1 = String.valueOf(str.charAt(0));
             x2 = String.valueOf(str.charAt(str.length()-1));
             s = stri.substring(0,str.length()-1);

        }
        return  s+x1+x2;
    }

    public static String Decrypt(String str) {
          StringBuilder a = new StringBuilder();
        int s = 0;
        for (int i = 0; i < str.length(); i+=2) {
            if (i == str.length()-1){
                int x = (int) str.charAt(i);
                int y = (int) str.charAt(0);
                s = s + x - y;
            }
            else{
                int z = (int) str.charAt(i+1);
                int x = (int) str.charAt(i);
                s = s + x - z;
            }
        }
        char ch = (char) ((s + str.charAt(0))/2);

        for (int i = 0; i < str.length(); i++) {
            if (ch != 0)
            {
                a.append(ch);
                ch = (char) (str.charAt(i) - ch);
            }
        }
        return a.toString();
    }
}
