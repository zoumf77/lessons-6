package com.zoumf77.net;

import java.util.concurrent.CountDownLatch;

/**
 * 
 *建议大家经常访问https://blog.csdn.net/yinwenjie
 *本小节的代码参考了他的BIO和NIO的相关章节，同时他的有关线程的讲解也非常详细，图文并茂，每个图都很精心，值得赞。
 *这样的大家都只是java入门中，所以我也要不断学习。
 */

public class MultiSocketClient {
	 public static void main(String[] args) throws Exception {
	        Integer clientNumber = 10;
	        CountDownLatch countDownLatch = new CountDownLatch(clientNumber);

	        //分别开始启动这10个客户端
	        for(int index = 0 ; index < clientNumber ; index++ , countDownLatch.countDown()) {
	            SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch, index);
	            new Thread(client).start();
	        }

	        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
	        
	        synchronized (MultiSocketClient.class) {
	        	MultiSocketClient.class.wait();
	        }
	       
	    }
}
