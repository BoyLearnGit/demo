package com.example.demo.zcc;

import org.springframework.util.StringUtils;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class FileHanderThread extends Thread {


    private String orgNo;

    private String srcFile;

    private String processClass;

    private int start;

    private int end;

    private int batchNum;
    
    private CountDownLatch latch;

//    @SuppressWarnings("rawtypes")
//    private FileToDbService service;
//
//    @SuppressWarnings("rawtypes")
//    public FileHanderThread(CountDownLatch latch,String orgNo, String srcFile, String processClass, int start, int end, int batchNum, FileToDbService service) {
//    	this.latch = latch;
//        this.orgNo = orgNo;
//        this.srcFile = srcFile;
//        this.start = start;
//        this.end = end;
//        this.batchNum = batchNum;
//        this.processClass = processClass;
//        this.service = service;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public void run() {
//        try (RandomAccessFile src = new RandomAccessFile(srcFile, "r")) {
//            List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
//            src.seek(start);
//            int len = start;
//            while (len < end) {
//                String data = src.readLine();
//
//                if (!StringUtils.isEmpty(data)) {
//                	int readLen = data.length();
//                    len += (readLen + 1);
//                    if((len-1) > end) {
//                       break;
//                    }
//                    String changeData = new String(data.getBytes("ISO-8859-1"),"utf-8");
//                    Object object = service.dataToModel(orgNo,changeData);
//                    if(null!=object) {
//                        list.add(object);
//                    }
//                    if (list.size()!=0 && list.size() % batchNum == 0) {
//                        try{
//                            service.insertBatch(list);
//                        }catch (Exception e) {
//                            for(Object o: list) {
//                                log.info("错误的入库o={}",o);
//                            }
//
//                            log.error("重复入库错误。。。。。。", e);
//                        }
//
//                        list.clear();
//                    }
//                }else {
//                	len += 1;
//                }
//            }
//            if (list != null && list.size() > 0) {
//                try{
//                    service.insertBatch(list);
//                }catch (Exception e) {
//                    for(Object o: list) {
//                        log.info("2222错误的入库o={}",o);
//                    }
//
//                    log.error("2222重复入库错误。。。。。。", e);
//                }
//                list.clear();
//            }
//            log.info("数据操作执行完成！");
//        } catch (Exception e) {
//            log.error("文件处理异常！{}", e);
//        }finally {
//        	latch.countDown();
//		}
//    }


    public String getSrcFile() {
        return srcFile;
    }

    public void setSrcFile(String srcFile) {
        this.srcFile = srcFile;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(int batchNum) {
        this.batchNum = batchNum;
    }

    public String getProcessClass() {
        return processClass;
    }

    public void setProcessClass(String processClass) {
        this.processClass = processClass;
    }

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}


}

