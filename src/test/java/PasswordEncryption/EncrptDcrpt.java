package PasswordEncryption;

import java.util.Base64;

public class EncrptDcrpt {

    String Devlab_userid = "sushil.sarma@gmail.com";
    String Devlab_password = "JaiGanesh@2024";

    public String returnDevlabUserID()
    {
        // encrypt
        byte[] encrypt_uid = Base64.getEncoder().encode(Devlab_userid.getBytes());

        String Devlab_userid1 = new String(encrypt_uid);
        // Decrypt
        byte[] decrypt_uid= Base64.getDecoder().decode(Devlab_userid1);

        return new String(decrypt_uid);
    }

    public String returnDevlabPassword()
    {
        byte[] encrypt_pwd = Base64.getEncoder().encode(Devlab_password.getBytes());
        String Devlab_pwd1 = new String(encrypt_pwd);
        // Decrypt
        byte[] decrypt_pwd= Base64.getDecoder().decode(Devlab_pwd1);

        return new String(decrypt_pwd);
    }
}
