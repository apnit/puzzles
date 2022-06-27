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
        int n = str.length(), sum = 0;

        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                int temp1 = str.charAt(i);
                int temp2;
                if (i == n - 1){
                    temp2 = str.charAt(0);
                }
                else {
                    temp2 = str.charAt(i + 1);
                }
                sum += temp1 - temp2;
            }
        }

        char temp = (char) ((sum + str.charAt(0)) / 2);

        for (int i = 0; i < n; i++){
            if (temp != 0){
                stringBuilder.append(temp);
            }
            temp = (char) (str.charAt(i) - temp);
        }
        return String.valueOf(stringBuilder);
    }
}
