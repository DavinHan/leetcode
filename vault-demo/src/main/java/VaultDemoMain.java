import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限验证
 *
 * @author yanhanf
 */
public class VaultDemoMain {

    public static void main(String[] args) {
        VaultEndpoint e = new VaultEndpoint();
        e.setHost("172.20.45.93");
        e.setPort(8200);
        e.setScheme("http");

        VaultTemplate template = new VaultTemplate(e, new TokenAuthentication("hvs.GKPiIw8PIrevwlb3gfNmYRmy"));

        Map<String, String> encryptKey = new HashMap<>();
        encryptKey.put("ois99ads", "ccfc967737ab2a75f4880e6356f11f14");

        Versioned.Metadata metadata = template.opsForVersionedKeyValue("secretKey")
                .put("tenantIdKey", encryptKey);
        System.out.println("add success" + metadata);

        Versioned<Map<String, Object>> versioned = template.opsForVersionedKeyValue("secretKey")
                .get("tenantIdKey");
        if(versioned != null && versioned.hasData()) {
            System.out.println("result map is " + versioned.getData());
        }
    }
}
