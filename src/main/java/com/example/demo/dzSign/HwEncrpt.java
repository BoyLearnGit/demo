package com.example.demo.dzSign;



import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/**
 * <p>
 * 查询类接口要求：HTTPS+HmacSha256参数鉴权
 * 操作类接口要求：HTTPS+SHA256WithRSA签名
 * <p>
 * 【华为阅读-SDV1】【设计类-加密问题-密钥硬编码-非合规】【白盒】【红十条】发现多处密钥硬编码和返回值硬编码，私钥需分段存储，已增加攻击获取私钥难度
 *
 * @author lizz 2018年04月12日
 */
public class HwEncrpt {

    /**
     * key  签名类型
     */
    public static final String KEY_SIGN_TYPE = "signType";

    public static final String KEY_SIGN = "sign";

    /**
     * 签名类型 1 查询类
     */
    public static final int SIGN_TYPE_1 = 1;
    /**
     * 签名类型 2 操作类
     */
    public static final int SIGN_TYPE_2 = 2;

//    private final static byte[] RSA_PRIVATE_KEY = Base64.decode("MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCKeaOFPXGp7N80uoPzQ8Ncz9fy" +
//            "PM8fvKj52szC4bSFWuS66ZZdo/vHFj4zLahQ2slL/begQfGSC4elaaX1wpFgEbyucYyulDOcHz0O" +
//            "5vvQDtySpnEu4b3AX2JfhQKtEJdK1pwDgzV+uLi0T2wBua7NADyiVL9J1KiVrywDKN+pclgVy2+s" +
//            "qK1wKWWKMha2HS/NlqfmNyxCdvnTuE6D20lIsPUmrkE2ZwkrlqivHTI4gWh6ONqjtPSd76lhgBV2" +
//            "svO9D7aMRz96BcV4XVqYdBXzbArOmd/rfXFWty6spGqqCBcHX79QUwarNVWrK7cprPZMatx3Y4N5" +
//            "pIait/F9c3jBAgMBAAECggEBAIfJmdDJHNF9Zq8lCskcNNGpOl/ew1iivqwro0ii3Us7gznKXtm6" +
//            "OOXT6PB0oC2RLX1n8Y2jvIfy6HQK8mPZBIdJPVVuIX778tPwSgZ3+IvgVukzb5+CW3jtz+BM5P/i" +
//            "WglYAyrqmiWGbBDcJNRYSZHa3ppsMhvq/dmyKZ17kj9sVRaJXauejkbhiIYKpOFXdYnPGQEU1sMj" +
//            "YNfSzo7h3OtfunFuPuQ+TCTHUetkJHy2cMy3bYsl/diRmvM+dqOJit+uFDVAxxg/j4LDu1q4yHhQ" +
//            "ofJ8/kpQNRYDOT1xi/vKPf+XoLwHns9fw/Azv1JCg76kc0uMIA5EzXyCIME0VHUCgYEA8cwQk/he" +
//            "Ab8OiUgSc1YRE7ztGFYMBZ838LVUboIX38h4EeCBlsrlNhQoXEbuXh+x1kVKElURwLA8BJoXJMyQ" +
//            "fAvi8QWkfTPWGm0b7V0KMdCWW9oM00nU5iVyFWkk2mAn+/j8uvVqlUVEDtWFgQZ/QefPS25jzuDf" +
//            "yuZ1fe4Yp2sCgYEAkpvoZ6ECt46Tn2t+4EuE2aSegd8CvzGwGHZeBIt6utfWO6bLr5vHS529qb3d" +
//            "KL41019P9oiRR/SSTLZSsVOsAytv1JMEPeoDY3Fxh/GULODkLq2NnapskQP11XlDt7xjazeJsxS8" +
//            "s2KP6yeA63dxOZ3iv4C0nCgIJ7gSCe+dp4MCgYBsbhNdF7qoU9Ij8+L6P7VGwakdCbE4cC74zYgA" +
//            "SmyEWPSnJ6NVSMVC3AVBZDmOke4A5W+TCvz8CMvRUHxiby23wujRJrOdxboUfatRZTCmKCDVLdIk" +
//            "ie5kCpS/TzhMiWRE1WIYQOe76qTbdhr5Qj2dA2PtMqKlaihRZ8l2YGhD4wKBgQCHJ8WzqyJ3F7CN" +
//            "2iqIGfaqMfGSZoYAvozJsG1yISeOkiXErjq+dIzg79WGYys8QUYby5VLAJF2VUh+AeLv6OP9tBCP" +
//            "Vs0lStO+3Dk+iv3/9X9GbObN/+vAMHd0Siucecbpc7S07Bwd/3IP5kYaTO2LoTsFMmDOSLVj8HRo" +
//            "xoZ/gwKBgQCXjMPO9bnv03JYQ3EzJbM1UuokRu0iXRaZ3BzRj3jHBKELrsKBDXNdaJLUJyqDQJE1" +
//            "8lJJRQC+JciNA5kFuzdLjwfu4GHIHFXQSBuNdz8BKXPltxjBObhr9ycNeLXWIQnZo0iGQiHc/+6a" +
//            "C88cw4gGZtuW+gWRa7QxTtgTNWrbgw==");
//
//    private static PrivateKey priKey = null;
//
//    private static byte[] secretKeys = null;
//
//    static {
//
//        try {
//            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(RSA_PRIVATE_KEY);
//
//            secretKeys = "wj3imab73kwceuf51lf01ORHe2cmo8X0YrZwF4p2uv3WEfmqxrT2oIBwRFRNErXW20UKal15ZTDdxPKU43puZFqcuXkvrQmadhp1wn6YPEDO4WRgInp8NNNQo4uNsWF1CELOzx7yPOS4pQbhTRWB4qRm0a4ENIegN0SH7K2STbsyaCuWh7m7s3rTpb5dK3CcDdsT35vo0xNbPZI2dJmKoIeKk9p3YhBLNWp9WoZqn9Qihpvn4nvgJzVSacgy2MTo".getBytes("UTF-8");
//
//            KeyFactory keyf = KeyFactory.getInstance("RSA");
//            priKey = keyf.generatePrivate(priPKCS8);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * sha256_HMAC加密
//     *
//     * @param message 消息
//     * @return 加密后字符串
//     */
//    private static String hmacSha256(String message) {
//        String hash = "";
//        try {
//            Mac sha256HMAC = Mac.getInstance("HmacSHA256");
//            SecretKeySpec secretKey = new SecretKeySpec(secretKeys, "HmacSHA256");
//            sha256HMAC.init(secretKey);
//            hash = Base64.encode(sha256HMAC.doFinal(message.getBytes("UTF-8")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return hash;
//    }
//
//    /**
//     * 使用开发者联盟网站分配的支付私钥对支付信息进行签名
//     * 强烈建议在 商户服务端做签名处理，且私钥存储在服务端，防止信息泄露
//     * 开发者通过服务器获取服务器端的签名之后，再进行支付请求
//     *
//     * @param content
//     * @return
//     */
//    private static String sha256withRsa(String content) {
//        //使用加密算法规则
//        try {
//            Signature signature = Signature.getInstance("SHA256WithRSA");
//            signature.initSign(priKey);
//            signature.update(content.toString().getBytes("UTF-8"));
//            byte[] signed = signature.sign();
//            return Base64.encode(signed);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (SignatureException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    /**
//     * 1：查询类签名
//     * 2：操作类签名
//     *
//     * @param content  content
//     * @param signType signType
//     * @return sign
//     */
//    public static String hwEncrptSign(String content, int signType) {
//        String sign = "";
//        String md5sign = "";
//        if (null != HwSdkAppConstant.getApp()) {
//            String sign1 = HwDeviceInfoUtils.getSign(HwSdkAppConstant.getApp());
//            if (!TextUtils.isEmpty(sign1)) {
//                md5sign = HwMd5Util.getMD5Str(sign1);
//            }
//        }
//        if (!TextUtils.isEmpty(md5sign)){
//            content += md5sign;
//        }
//        if (signType == SIGN_TYPE_1) {
//            sign = hmacSha256(content);
//        } else if (signType == SIGN_TYPE_2) {
//            sign = sha256withRsa(content);
//        }
//        return sign;
//    }

}
