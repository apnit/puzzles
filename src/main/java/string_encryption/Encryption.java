package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        String s = "";
        int n = str.length();
        for (int i = 0; i < n; i++){

            if (i < (n-1)){
                int a = (int) str.charAt(i) ;
                int b = (int) str.charAt(i+1);
                char c = (char) (a + b);
                s += String.valueOf(c);
            }

            else {

                int a = (int) str.charAt(0);
                int b = (int) str.charAt(n-1);
                char c = (char) (a + b);
                s += String.valueOf(c);
            }
        }

        if (n % 2 == 0){

            String first = String.valueOf(str.charAt(0));
            String last = String.valueOf(str.charAt(n-1));
            String t = s.substring(0,n-1);
            s = t + last + first;
        }
        return s;
    }

    public static String Decrypt(String str) {
        int n = str.length();
        int [] a = new int[n];
        int [] b = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = (int) str.charAt(i);
        }

        String s = "";
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
        s += String.valueOf(ch);

        int m = n;
        if(str.charAt(n - 1) < 123){
            m = n - 1;
        }

        for (int k=1 ;k < n; k++){
            b[k] = a [k-1] - b[k-1];
            char c = (char) b[k];
            s += String.valueOf(c);
        }
        return s;
    }
}
