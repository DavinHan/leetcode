package com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultMount;
import org.springframework.vault.support.VaultToken;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 *
 * @author yanhanf
 */
@Configuration
public class VaultConfiguration extends AbstractVaultConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(VaultConfiguration.class);

    @Value("${spring.application.name}")
    private String appCode;

//    @Override
//    public VaultTemplate vaultTemplate() {
//        VaultTemplate template = super.vaultTemplate();
//
//        // Ensure approle auth enabled
//        template.opsForSys().authMount("kms-role", VaultMount.create("approle"));
//
//        Map<String, Object> config = new HashMap<>(8);
//        config.put("secret_id_ttl", "10m");
//        config.put("token_num_uses", "10");
//        // should be at least check_interval + 2 seconds
//        config.put("token_ttl", "5s");
//        config.put("token_max_ttl", "30m");
//        config.put("secret_id_num_uses", "40");
//        config.put("policies", new String[]{"default"});
//        template.write("auth/kms-role/role/" + appCode, config);
//
//        roleId = String.valueOf(template.read("auth/kms-role/role/" + appCode + "/role-id").getData().get("role-id"));
//        secretId = String.valueOf(template.write("auth/kms-role/role/" + appCode + "/secret-id", null).getData().get("secret-id"));
//
//        return template;
//    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        try {
            return VaultEndpoint.from(new URI("http://localhost:8200"));
        } catch (URISyntaxException e) {
            LOGGER.error("初始化vault访问地址报错：", e);
            return null;
        }
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        AppRoleAuthenticationOptions options = AppRoleAuthenticationOptions
                .builder()
                .roleId(AppRoleAuthenticationOptions.RoleId.provided("8caf0a8b-836a-fcc7-1bce-b0e07b98559e"))
                .secretId(AppRoleAuthenticationOptions.SecretId.provided("d3757687-7443-1bf5-a715-1c45f9d8b329"))
                .build();
        return new AppRoleAuthentication(options, restOperations());
    }
}
