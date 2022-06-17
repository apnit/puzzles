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


    // probably uses recursion
    public static String Decrypt(String str) {
        char[] holder = str.toCharArray();
        String sum = "";

        for( int i = 0 ; i<str.length() ; i++){

        }


        return "";
    }
}
