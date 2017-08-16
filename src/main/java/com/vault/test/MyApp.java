package com.vault.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

/**
 * Created by avijit on 8/7/2017.
 */
public class MyApp {

    @Autowired
    VaultOperations vaultOperations;

    public void writeVault() {

        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

       vaultOperations.write("secret/myapp", secrets);

        System.out.println("Secret written to Vault..");

    }

    public void readVault() {

        VaultResponseSupport<Secrets> response = vaultOperations.read("secret/myapp", Secrets.class);
        System.out.println(response.getData().getUsername());

        //vaultOperations.delete("secret/myapp");
    }

    public void deleteVault() {

        vaultOperations.delete("secret/myapp");
        System.out.println("Secret vault backend delete..");
    }
}
