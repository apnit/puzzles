package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {

        StringBuilder s = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++){
            if (i < (n-1)){
                int a = str.charAt(i);
                int b = str.charAt(i+1);
                char c = (char) (a + b);
                s.append(c);
            }
            else {
                int a = str.charAt(0);
                int b = str.charAt(n-1);
                char c = (char) (a + b);
                s.append(c);
            }
        }

        if (n % 2 == 0){
            String first = String.valueOf(str.charAt(0));
            String last = String.valueOf(str.charAt(n-1));
            String t = s.substring(0,n-1);
            s = new StringBuilder(t + last + first);
        }
        return s.toString();
    }

    public static String Decrypt(String str) {

        int n = str.length();
        if(str.charAt(n-1)<122){
            str = str + "a";
        }
        int [] a = new int[n];
        int [] b = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = str.charAt(i);
        }

        StringBuilder s = new StringBuilder();
        int t1 = 0;
        int t2 = 0;

        for (int j = 0; j < n; j++){

            if (j % 2 == 0){
                t1 += a[j];
            }
            else {
                t2 += a[j];
            }
        }
        int d = ((t1 - t2)/2);
        b[0] = d;
        char ch = (char) d;
        s.append(ch);
        int m =n;
        if(str.charAt(n-1)<122){
            m = n-1;
        }
        for (int k=1 ;k < m; k++){
            b[k] = a [k-1] - b[k-1];
            char c = (char) b[k];
            s.append(c);
        }
        return s.toString();
    }
}
