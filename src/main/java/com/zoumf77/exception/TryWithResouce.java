package com.zoumf77.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 *实现了java.lang.autocloseabl和java.io.closeable的对象，都可以在try-with-resource中使用
 *try-with-resource保证在使用完后，关闭资源；
 */
public class TryWithResouce {

	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	public static void main(String[] args) {

	}
}
