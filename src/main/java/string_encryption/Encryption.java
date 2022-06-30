package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {

        StringBuilder x = new StringBuilder();
        int q = str.length();
        for (int i = 0; i < q; i++) {
            if (i < (q - 1)) {
                int w = str.charAt(i);
                int e = str.charAt(i + 1);
                char r = (char) (w + e);
                x.append(r);
            } else {
                int w = str.charAt(0);
                int e = str.charAt(q - 1);
                char r = (char) (w + e);
                x.append(r);
            }
        }

        if (q % 2 == 0) {
            String first = String.valueOf(str.charAt(0));
            String last = String.valueOf(str.charAt(q - 1));
            String z = x.substring(0, q - 1);
            x = new StringBuilder(z + last + first);
        }
        return x.toString();
    }

    public static String Decrypt(String str) {

        int q = str.length();
        if (str.charAt(q - 1) < 122) {
            str = str + "a";
        }
        int[] a = new int[q];
        int[] b = new int[q];

        for (int i = 0; i < q; i++) {
            a[i] = str.charAt(i);
        }

        StringBuilder x = new StringBuilder();
        int p = 0;
        int o = 0;

        for (int j = 0; j < q; j++) {

            if (j % 2 == 0) {
                p += a[j];
            } else {
                o += a[j];
            }
        }
        int u = ((p - o) / 2);
        b[0] = u;
        char ch = (char) u;
        x.append(ch);
        int y = q;
        if (str.charAt(q - 1) < 122) {
            y = q - 1;
        }
        for (int k = 1; k < y; k++) {
            b[k] = a[k - 1] - b[k - 1];
            char l = (char) b[k];
            x.append(l);
        }
        return x.toString();
    }
}

