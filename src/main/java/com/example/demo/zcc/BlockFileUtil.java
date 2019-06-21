package com.example.demo.zcc;

import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public  class BlockFileUtil {

    private String orgNo; 
   
    private String srcName;
    
    private String processClass;

    private int indexThread;
    
    private int batchNum;
    
    private boolean isDelFirst = true;

    //空闲线程存活时间
  	private static final  long KEEP_ALIVE_TIME =5;

  	private ThreadPoolExecutor executor;
  	
//    @SuppressWarnings("rawtypes")
//	private FileToDbService service;
//
//    /**
//     * 构造器（是否删除第一行）
//     * @param orgNo
//     * @param srcName
//     * @param processClass
//     * @param indexThread
//     * @param batchNum
//     * @param isDelFirst    是否删除第一行
//     */
//    @SuppressWarnings("rawtypes")
//	public BlockFileUtil(String orgNo, String srcName, String processClass, int indexThread ,int batchNum, boolean isDelFirst) {
//        this.isDelFirst = isDelFirst;
//        this.orgNo = orgNo;
//        this.srcName = srcName;
//        this.processClass = processClass;
//        this.indexThread = indexThread;
//        this.batchNum = batchNum;
//        this.service = (FileToDbService) BeanFactory.getBean(processClass);
//        this.executor = new ThreadPoolExecutor(indexThread, indexThread, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//    }
//
//
//    /**
//     * 读数据
//     * @return
//     */
//    public boolean read4File() {
//    	final long startTime = System.currentTimeMillis();
//        int start, end;
//
//        CountDownLatch latch = new CountDownLatch(this.indexThread);
//        RandomAccessFile raf=null;
//        try {
//        	raf = new RandomAccessFile(srcName, "r");
//            int fileLength = (int) raf.length();
//            int onelineLength = 0;
//            if(isDelFirst) {
//                onelineLength = raf.readLine().length();
//            }
//            // 每个线程处理的块大小
//            int block = (fileLength-onelineLength) / indexThread;
//            log.info("每个线程处理文件大小：{}", block);
//            // 以完整的换行分割文件 所带来的 偏移量。
//            int offSet = onelineLength;
//            for (int i = 0; i < indexThread; i++) {
//                start = (i * block) + offSet;
//                if (i != (indexThread - 1)) {
//                    int num = 0;
//                    end = (i + 1) * block - 1;
//                    raf.seek(end);
//                    while (true) {
//                        int charge = raf.readByte();
//                        if (charge == 10 || charge == 13) {
//                            offSet = num;
//                            break;
//                        }
//                        num++;
//                        end++;
//                    }
//                } else {
//                    end = fileLength;
//                }
//                log.info("start={},end={}", start, end);
//                executor.execute(new FileHanderThread(latch,orgNo, srcName, processClass, start, end ,batchNum, service));
//            }
//            latch.await();
//            log.info("运行时间为：{}ms",(System.currentTimeMillis() - startTime));
//            return true;
//        } catch (Exception e) {
//            log.error("文件分快异常：{}", e);
//        }finally {
//        	try {
//				raf.close();
//			} catch (Exception e) {
//			}
//		}
//        return false;
//    }
//
//
//    public String getSrcName() {
//        return srcName;
//    }
//
//    public void setSrcName(String srcName) {
//        this.srcName = srcName;
//    }
//    public int getIndexThread() {
//        return indexThread;
//    }
//
//    public void setIndexThread(int indexThread) {
//        this.indexThread = indexThread;
//    }
//
//
//	public String getOrgNo() {
//		return orgNo;
//	}
//
//
//	public void setOrgNo(String orgNo) {
//		this.orgNo = orgNo;
//	}
//
//
//	public String getProcessClass() {
//		return processClass;
//	}
//
//
//	public void setProcessClass(String processClass) {
//		this.processClass = processClass;
//	}
//
//
//	public int getBatchNum() {
//		return batchNum;
//	}
//
//
//	public void setBatchNum(int batchNum) {
//		this.batchNum = batchNum;
//	}
//
//
//	@SuppressWarnings("rawtypes")
//	public FileToDbService getService() {
//		return service;
//	}
//
//
//	public void setService(@SuppressWarnings("rawtypes") FileToDbService service) {
//		this.service = service;
//	}

	
    
}
