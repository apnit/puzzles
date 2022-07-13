package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
       String a = "";
//        for (int i=0;i<str.length();i++){
//            int s = (int)str.charAt(i) + (int)str.charAt(i) + 1 ;
//            a += (char)s;
//        }
        for (int i=0;i<str.length();i++){

            if (i== str.length()-1){
                if (str.length()%2 == 0){
                    a += (char)str.charAt(i) + "" + (char) str.charAt(0);
                }
                else {
                    a += (char)( (int)str.charAt(i) + (int)str.charAt(0) );
                }
            }
            else {
                a+= (char)( (int) str.charAt(i) + (int)str.charAt(i+1));
            }
        }
        return a;
    }

    public static String Decrypt(String str) {
        String a = "";
        int sum = 0;
        for (int i=0;i<str.length();i+=2){
            if (i== str.length()- 1){
                int b = str.charAt(i);
                int c = str.charAt(0);
                sum += b-c;
            }
            else {
                int b= str.charAt(i);
                int c = str.charAt(i+1);
                sum+= b-c;
            }
        }

        char cha =(char) ((sum + str.charAt(0)) /2);

        for (int i=0;i<str.length();i++){
            if (cha !=  0){
                a+=cha;
                cha =(char) (str.charAt(i) - cha);
            }
        }

        return a;
    }
    
    // 195 197 199 201 203 205 207 209 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 241 243 122 97
   // 97  98  99  100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122
    
}
