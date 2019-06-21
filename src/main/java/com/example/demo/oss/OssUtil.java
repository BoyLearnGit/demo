package com.example.demo.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

import java.io.*;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/5/22 15:30
 **/
public class OssUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿⾥云主账号AccessKey拥有所有API的访问权限，⻛险很⾼。强烈建议您创建并使⽤RAM
    //账号进⾏API访问或⽇常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static final String accessKeyId = "LTAIhV6xr4GnAPAd";
    private static final String accessKeySecret = "cEQ0xGlocIlO0Yb47TNlxLowPGEIta";
    private static final String bucketName = "yanluli";

    public void init() {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        ossClient.createBucket(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 上传文件到OSS
     *
     * @param objectName 文件名称
     * @param flie
     */
    public static void uploadFile(String objectName, File flie) throws Exception {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        InputStream is = new FileInputStream(flie);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的⽂件名称（objectName）。
        ossClient.putObject(bucketName, objectName, is);
        // 关闭OSSClient。
        ossClient.shutdown();

    }

    public static void download(String objectName) throws Exception {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 调⽤ossClient.getObject返回⼀个OSSObject实例，该实例包含⽂件内容及⽂件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        // 调⽤ossObject.getObjectContent获取⽂件输⼊流，可读取此输⼊流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content,"GBK"));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求⽆连接可⽤，程序⽆法正常⼯作。
            content.close();
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void downloadToNative(String objectName,String path){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 下载OSS⽂件到本地⽂件。如果指定的本地⽂件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
        // 关闭OSSClient。
        ossClient.shutdown();
    }


    /**
     * 删除指定文件
     * @param objectName
     */
    public void delete(String objectName){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 删除⽂件。
        ossClient.deleteObject(bucketName, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) {
        File file=new File("E://test.txt");
        try {
//            uploadFile("test.txt",file);
            download("test.txt");
//            downloadToNative("test.txt","E://test//test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
