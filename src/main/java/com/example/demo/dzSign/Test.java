package com.example.demo.dzSign;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/5/21 17:17
 **/
public class Test {
    /**
     * 暴露给h5方法返回签名及其公共数据
     *
     * @param type type
     * @param data data
     * @return String
     */
//    public String getH5AddSignHeaderData(String data, String type) {
//        String queryString = getQueryString();
//        String sign;
//        if (TextUtils.equals(type, HwEncrpt.SIGN_TYPE_1 + "")) {
//            sign = HwEncrpt.hwEncrptSign(queryString + data, HwEncrpt.SIGN_TYPE_1);
//        } else {
//            sign = HwEncrpt.hwEncrptSign(queryString + data, HwEncrpt.SIGN_TYPE_2);
//        }
//        Map<String, Object> map = newHashMap();
//        map.put("queryString", queryString);
//        Map<String, String> headMap = getCommonHeader();
//
//        headMap.put(KEY_SIGN_TYPE, type);
//        headMap.put(KEY_SIGN, sign);
//
//        String token = SpUtil.getinstance(AppConst.getApp()).getAppToken();
//        if (!TextUtils.isEmpty(token)) {
//            headMap.put("t", token);
//        }
//
//        map.put("headers", headMap);
//
//        return JsonUtils.fromHashMap(map);
//    }
//
//    private String getQueryString() {
//        if (TextUtils.isEmpty(nativeQueryString)) {
//            String partQueryString;
//            partQueryString = putUrlValue(null, "appId", getAppId());
//            partQueryString = putUrlValue(partQueryString, "country", getCOUNTRY());
//            partQueryString = putUrlValue(partQueryString, "lang", getLang());
//            partQueryString = putUrlValue(partQueryString, "ver", getVer());
//            partQueryString = putUrlValue(partQueryString, "appVer", getAppVer());
//            nativeQueryString = partQueryString;
//        }
//        return putUrlValue(nativeQueryString, "timestamp", UtilTimeOffset.getFormatDateByTimeZone());
//    }
//
//
//    private String putUrlValue(String src, String key, String value) {
//        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
//            if (!TextUtils.isEmpty(src)) {
//                return src + "&" + key + "=" + value;
//            } else {
//                return key + "=" + value;
//            }
//        }
//        return src;
//    }


}
