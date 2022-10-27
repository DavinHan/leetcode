//package com.test.web;
//
//import org.springframework.vault.core.VaultTemplate;
//import org.springframework.vault.support.Versioned;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * vault请求接口
// *
// * @author yanhanf
// */
////@RestController
//public class VaultWeb {
//
////    @Resource
//    private VaultTemplate vaultTemplate;
//
//    private final static String DEFAULT_PATH = "kms-sm4";
//    private final static String DEFAULT_PATH_2 = "tenant_id";
//
//    @GetMapping("/get")
//    public String get(String tenantId) {
//        try {
//            Versioned<Map<String, Object>> versioned = vaultTemplate.opsForVersionedKeyValue(DEFAULT_PATH).get(DEFAULT_PATH_2);
//            return versioned == null || !versioned.hasData() ? "kms数据为空" : String.valueOf(versioned.getData().get(tenantId));
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//
//    @GetMapping("/save")
//    public String save(String tenantId, String value) {
//        Versioned<Map<String, Object>> versioned;
//        try {
//            versioned = vaultTemplate.opsForVersionedKeyValue(DEFAULT_PATH).get(DEFAULT_PATH_2);
//        } catch (Exception e) {
//            return "get:" + e.getMessage();
//        }
//        Map<String, Object> data;
//        if(versioned == null || !versioned.hasData()) {
//            data = new HashMap<>(4);
//            data.put(tenantId, value);
//        } else {
//            data = versioned.getData();
//            data.put(tenantId, value);
//        }
//        try {
//            return vaultTemplate.opsForVersionedKeyValue(DEFAULT_PATH).put(DEFAULT_PATH_2, data).toString();
//        } catch (Exception e) {
//            return "put:" + e.getMessage();
//        }
//    }
//
//}
