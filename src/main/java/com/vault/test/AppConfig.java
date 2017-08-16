package com.vault.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;

/**
 * Created by avijit on 8/7/2017.
 */
@Configuration
public class AppConfig extends AbstractVaultConfiguration {

    /**
     * Specify an endpoint for connecting to Vault.
     */
    @Override
    public VaultEndpoint vaultEndpoint() {
        String uri = getEnvironment().getProperty("vault.uri");
        if (null != uri) {
            return VaultEndpoint.from(URI.create(uri));
        }
        throw new IllegalStateException();
        //return new VaultEndpoint();
    }

    /**
     * Configure a client authentication.
     * Please consider a more secure authentication method
     * for production use.
     */
    @Override
    public ClientAuthentication clientAuthentication() {
        String token = getEnvironment().getProperty("vault.token");
        if (null != token) {
            return new TokenAuthentication(token);
        }
        throw new IllegalStateException();
    }
}