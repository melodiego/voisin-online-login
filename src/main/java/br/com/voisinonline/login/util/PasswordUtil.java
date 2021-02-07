package br.com.voisinonline.login.util;

import at.favre.lib.bytes.Bytes;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Version;
import br.com.voisinonline.login.enums.CryptoParamsEnum;

import java.security.SecureRandom;
public class PasswordUtil {

    private PasswordUtil() { throw new IllegalStateException("Utility class");}

    public static byte[] generateSaltBcrypt() {
        SecureRandom secureRandom = new SecureRandom();
        return Bytes.random(16, secureRandom).array();
    }

    public static byte[] hashBcrypt(byte[] password, byte[] salt){
        return BCrypt.with(Version.VERSION_2Y).hashRaw(CryptoParamsEnum.BCRYPT.getCost(), salt, password).rawHash;
    }

    public static boolean doesMatchBcrypt(String password, byte[] salt, byte[] hash) {
        return BCrypt.verifyer().verify(password.getBytes(), CryptoParamsEnum.BCRYPT.getCost(), salt, hash).verified;
    }
}