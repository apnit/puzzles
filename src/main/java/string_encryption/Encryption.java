package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
            StringBuilder a = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            if (i == str.length()-1){
                int x = str.charAt(0);
                int y = str.charAt(str.length()-1);
                char z = (char) (x+y);
                a.append(z);
            }

            else {
                int x = str.charAt(i);
                int y = str.charAt(i+1);
                char z = (char) (x + y);
                a.append(z);
            }

        }
    
        String p;

        if (str.length() % 2 == 0){
         
             String x1 = String.valueOf(str.charAt(str.length()-1));
            String x2 = String.valueOf(str.charAt(0));
            String s = a.substring(0,str.length()-1);
            a = new StringBuilder(s + x1 + x2);

        }
        p = a.toString();
        return  p;
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
