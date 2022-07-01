package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {

        String sum = "";
        char[] holder = str.toCharArray();

        if(str.length()%2 == 1) {
            for(int i = 0 ; i< holder.length ; i++){

                if( i != (holder.length-1) ){
                    sum += (char)(holder[i] + holder[i + 1]);
                }

                else
                {
                    sum += (char)(holder[i] + holder[0]);
                }
            }

        }
        else {
            for(int i = 0 ; i< holder.length ; i++){

                if( i != (holder.length-1) ){
                    sum += (char)(holder[i] + holder[i + 1]);
                }

                else
                {
                    sum += (holder[i]);
                    sum += (holder[0]);
                }
            }
        }



        return sum;
    }



    public static String Decrypt(String str) {
        StringBuilder text = new StringBuilder();
        int sum = 0;


        for (int i = 0; i < str.length(); i+=2) {
            if (i == str.length()-1)
                sum += (int) str.charAt(i) - (int) str.charAt(0);
            else
                sum += (int) str.charAt(i) - (int) str.charAt(i+1);
        }
        char tempChar = (char) ((sum + str.charAt(0))/2);
        for (int i = 0; i < str.length(); i++) {
            if (tempChar != 0)
                text.append(tempChar);
            tempChar = (char) (str.charAt(i) - tempChar);
        }
        return String.valueOf(text);
    }
}
