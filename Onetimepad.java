/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetimepad;

import java.util.Random;

/**
 *
 * @author alqods
 */
public class Onetimepad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String key ="";
      String plainText = "miss scarlet with the knife in the library";
        String cipherText = "zicvtwqngkzeiigasxstslvvwla";
        key= randString(plainText.length());
        System.out.println(encryption(plainText,key));
        System.out.println(decryption(encryption(plainText,key),key));
    }
     static String encryption(String plain ,String key) {
         //String key;
        String C = "";
        int stop = 0;
       // key= randString(plain.length());
        
        for (int i = 0; i < plain.length(); i++) {
            if (plain.charAt(i) == ' ') {
                C += ' ';
            } else if (plain.length()==key.length()){
                int value =(plain.charAt(i) - 97);
                int k= (key.charAt(stop)-97);
                
                stop++;
                C += (char) ((( value + k) % 26) + 97);
            }
            else{
                key+= plain.charAt(i);
                int value =(plain.charAt(i) - 97);
                
                int k= (key.charAt(stop)-97);
               
                stop++;
                C += (char) ((( value + k) % 26) + 97);
              
            }
             
            }
        return C;
    
    }
     public static String randString(int length) {
    Random rand = new Random();
    StringBuilder word = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
        word.append((char)('a' + rand.nextInt(26)));
    }

    return word.toString();
}
     static String decryption(String cipher ,String key ) {
         // key= randString(cipher.length());
        String P = "";
         int stop = 0;
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) == ' ') {
                P += ' ';
            } else if(cipher.length()==key.length()) {
                int value =  (cipher.charAt(i) - 97);
                int k=  (key.charAt(stop)-97);
                int flag =  (( value - k) % 26) ;
                 stop++ ;
                if (flag < 0) {
                    flag += 26;
                }
                P += (char) (flag + 97);
            }
            else{                
                int value =(cipher.charAt(i) - 97);               
                int k= (key.charAt(stop)-97); 
                int flag =  (( value - k) % 26) ;
                stop++;
                if (flag < 0) {
                    flag += 26;
                }
                P += (char) (flag + 97);
                key+= P.charAt(i);
              
            }
        }
        return P;
    }
    
}
