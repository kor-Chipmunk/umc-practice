package com.umc.practice;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class JasyptTest extends JasyptConfig {

    @Test
    public void jasypt_encrypt_decrypt_test() {
        String encryptKey = System.getProperty("jasypt.encryptor.password");

        String plainText = "";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword(encryptKey);

        String encryptedText = jasypt.encrypt(plainText);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println(encryptedText);

        assertThat(plainText).isEqualTo(decryptedText);
    }
}