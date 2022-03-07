#Simple String Encryption

We want to encrypt a message and send it to network
so that no one except main receiver can read its content.  
You should encrypt message in this way:
 
For each character in the string, calculate sum of its
ASCII (or unicode) value with value of next character
and replace the character with the result.  
For the last character, calculate sum of its value with
first character.

Write methods to encrypt message (`String Encrypt(String str)`)
and decrypt it back (`String Decrypt(String str)`).