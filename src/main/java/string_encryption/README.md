# Simple String Encryption

We want to send a secret message over the network so that
 we  decided  to  encrypt  that  message  to prevent  any
 unwanted access to it.
 
There  is an algorithm which seems to be good  enough for
 this situation. But the  problem is no one can implement
 it.

The  algorithm works  on a string.  For each character in
 the string,  calculate  sum  of  its  ASCII (or unicode)
 value with ASCII value  of next  character. For the last
 character,  calculate   sum  of  its  value  with  first
 character.  Store  these  ASCCI  values in a new  string
 with the same size of the  initial string.
 
To solve this puzzle complete these methods
+ encrypt message (`String Encrypt(String str)`)
+ decrypt message (`String Decrypt(String str)`)
