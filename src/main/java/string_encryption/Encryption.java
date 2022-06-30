package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        char[] chars = str.toCharArray();
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < chars.length; i++)
            if (i == chars.length - 1)
                string.append((char) ((int) chars[i] + chars[0]));
            else
                string.append((char) ((int) chars[i] + chars[i + 1]));

        if (str.length() % 2 == 0)
            return string.substring(0, str.length() - 1) + str.charAt(str.length() - 1) + str.charAt(0);
        else
            return string.toString();
    }

    public static String Decrypt(String str) {
        char[] characters;

        if (str.charAt(str.length() - 1) < 122)
            characters = new char[str.length() - 1];
        else
            characters = new char[str.length()];

        int Sum = 0, k = 1;
        for (char character : str.toCharArray()) {
            Sum += k * character;
            k = -k;
        }

        characters[0] = (char) (Sum / 2);

        for (int i = 1; i < characters.length; i++)
            characters[i] = (char) (str.charAt(i - 1) - characters[i - 1]);

        return String.valueOf(characters);
    }
}
