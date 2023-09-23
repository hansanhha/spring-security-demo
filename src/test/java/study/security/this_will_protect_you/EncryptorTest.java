package study.security.this_will_protect_you;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class EncryptorTest {

    @Test
    public void textEncryptor() {
        String valueToEncrypt = "Hello";
//        TextEncryptor e = Encryptors.noOpText();
//        String encrypted = e.encrypt(valueToEncrypt);

//        System.out.println(encrypted);

        String salt = KeyGenerators.string().generateKey();
        String password = "secret";

        TextEncryptor e = Encryptors.text(password, salt);
        String encrypted = e.encrypt(valueToEncrypt);
        String decrypted = e.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }

    @Test
    public void bytesEncryptor() {
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "Hello";

        BytesEncryptor e = Encryptors.standard(password, salt);
        byte[] encrypted = e.encrypt(valueToEncrypt.getBytes());
        byte[] decrypted = e.decrypt(encrypted);

        System.out.println();
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}
