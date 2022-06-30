package string_encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static string_encryption.Encryption.Encrypt;
import static string_encryption.Encryption.Decrypt;

public class EncryptionTest {
    @Test
    void encrypt() {
        assertEquals("Â", Encrypt("a"));
        assertEquals("Âaa", Encrypt("aa"));
        assertEquals("ÃÅÇÉËÍÏÑÓÕ×ÙÛÝßáãåçéëíïñóza", Encrypt("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("óñïíëéçåãáßÝÛÙ×ÕÓÑÏÍËÉÇÅÜ", Encrypt("zyxwvutsrqponmlkjihgfedcb"));
    }

    @Test
    void decrypt() {
        assertEquals("a", Decrypt("Â"));
        assertEquals("aa", Decrypt("Âaa"));
        assertEquals("abcdefghijklmnopqrstuvwxyz", Decrypt("ÃÅÇÉËÍÏÑÓÕ×ÙÛÝßáãåçéëíïñóza"));
        assertEquals("zyxwvutsrqponmlkjihgfedcb", Decrypt("óñïíëéçåãáßÝÛÙ×ÕÓÑÏÍËÉÇÅÜ"));
    }
}