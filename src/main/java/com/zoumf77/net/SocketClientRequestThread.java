package com.zoumf77.net;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一个SocketClientRequestThread线程模拟一个客户端请求。
 * 
 * 
 */
public class SocketClientRequestThread implements Runnable {

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(SocketClientRequestThread.class);

	private CountDownLatch countDownLatch;

	/**
	 * 这个线层的编号
	 * 
	 * @param countDownLatch
	 */
	private Integer clientIndex;

	/**
	 * countDownLatch是java提供的同步计数器。 当计数器数值减为0时，所有受其影响而等待的线程将会被激活。这样保证模拟并发请求的真实性
	 * 
	 * @param countDownLatch
	 */
	public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
		this.countDownLatch = countDownLatch;
		this.clientIndex = clientIndex;
	}

	@Override
	public void run() {

		try (Socket socket = new Socket("localhost", 83);
				PrintWriter clientRequest = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader clientResponse = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		) {

			// 等待，直到所有线程的启动，然后所有线程一起发送请求
			this.countDownLatch.await();

			// 发送请求信息
			clientRequest.println("这是第" + this.clientIndex + " 个客户端的请求。over");
			clientRequest.flush();

			
			// 在这里等待，直到服务器返回信息
			logger.info("端口号:"+socket.getLocalPort()+"第" + this.clientIndex + "个客户端的请求发送完成，等待服务器返回信息");
			
			// 程序执行到这里，会一直等待服务器返回信息（注意，前提是in和out都不能close，如果close了就收不到服务器的反馈了）
			String message = clientResponse.readLine();
			
			logger.info("接收到来自服务器的信息:" + message);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}