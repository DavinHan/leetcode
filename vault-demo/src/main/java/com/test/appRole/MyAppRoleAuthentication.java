package com.test.appRole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.vault.authentication.*;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultToken;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义权限登录
 *
 * @author yanhanf
 */
public class MyAppRoleAuthentication extends AppRoleAuthentication {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyAppRoleAuthentication.class);

    private final String appCode;
    private final String roleId;
    private final String secretId;
    private AppRoleAuthenticationOptions options;
    private RestOperations restOperations;

    /**
     * Create a {@link AppRoleAuthentication} using {@link AppRoleAuthenticationOptions}
     * and {@link RestOperations}.
     *
     * @param options        must not be {@literal null}.
     * @param restOperations must not be {@literal null}.
     */
    public MyAppRoleAuthentication(AppRoleAuthenticationOptions options,
                                   RestOperations restOperations,
                                   String appCode, String roleId, String secretId) {
        super(options, restOperations);
        this.appCode = appCode;
        this.options = options;
        this.restOperations = restOperations;
        this.roleId = roleId;
        this.secretId = secretId;
    }

    @Override
    public VaultToken login() {
        return createTokenUsingAppRole();
    }

    private VaultToken createTokenUsingAppRole() {

        Map<String, String> login = getAppRoleLoginBody();

        try {
            VaultResponse response = this.restOperations.postForObject(getLoginPath(this.options.getPath()), login,
                    VaultResponse.class);

            Assert.state(response != null && response.getAuth() != null, "Auth field must not be null");

            LOGGER.debug("Login successful using AppRole authentication");

            return from(response.getAuth());
        }
        catch (RestClientException e) {
            throw VaultLoginException.create("AppRole", e);
        }
    }

    String getLoginPath(String authMount) {
        return String.format("auth/%s/login", authMount);
    }

    private Map<String, String> getAppRoleLoginBody() {

        Map<String, String> login = new HashMap<>();

        login.put("role_id", getRoleId());

        login.put("secret_id", getSecretId());

        login.put("app_code", appCode);

        return login;
    }

    private String getSecretId() {
        return secretId;
    }

    private String getRoleId() {
        return roleId;
    }

    private LoginToken from(Map<String, Object> auth) {

        Assert.notNull(auth, "Authentication must not be null");

        String token = (String) auth.get("client_token");

        return from(token.toCharArray(), auth);
    }

    LoginToken from(char[] token, Map<String, Object> auth) {

        Assert.notNull(auth, "Authentication must not be null");

        Boolean renewable = (Boolean) auth.get("renewable");
        Number leaseDuration = (Number) auth.get("lease_duration");

        if (leaseDuration == null) {
            leaseDuration = (Number) auth.get("ttl");
        }

        if (renewable != null && renewable) {
            return LoginToken.renewable(token, Duration.ofSeconds(leaseDuration.longValue()));
        }

        if (leaseDuration != null) {
            return LoginToken.of(token, Duration.ofSeconds(leaseDuration.longValue()));
        }

        return LoginToken.of(token);
    }
}
