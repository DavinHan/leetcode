package com.test.config;

import com.test.appRole.MyAppRoleAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;
import java.net.URISyntaxException;
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

    private String roleId = "8caf0a8b-836a-fcc7-1bce-b0e07b98559e";
    private String secretId = "a765cc39-f4e5-e879-aae1-f25e07e843a5";

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
            return VaultEndpoint.from(new URI("http://localhost:8200/iuap-key-manage/v1/"));
        } catch (URISyntaxException e) {
            LOGGER.error("初始化vault访问地址报错：", e);
            return null;
        }
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        AppRoleAuthenticationOptions options = AppRoleAuthenticationOptions
                .builder()
                .roleId(AppRoleAuthenticationOptions.RoleId.provided(roleId))
                .secretId(AppRoleAuthenticationOptions.SecretId.provided(secretId))
                .build();
        return new MyAppRoleAuthentication(options, restOperations(), appCode, roleId, secretId);
    }


}
