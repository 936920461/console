package com.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main4 {

	private static FileInputStream fis;
	private static FileOutputStream fos;

	public static void main(String[] args) {
		File file = new File("D:\\Test\\test.txt");
		String fileContent = "hello world";
		try {
			fis = new FileInputStream(file);
			readToBuf(fis);
			fis.close();
			fos = new FileOutputStream(file);
			writeToFile(fos, fileContent);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取数据到buf
	 * 
	 * @param fis
	 */
	public static void readToBuf(FileInputStream fis) {
		try {
			// 获取通道
			FileChannel channel = fis.getChannel();
			// 创建缓存
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			channel.read(buffer);
			// 置0
			buffer.flip();
			while (buffer.remaining() > 0) {
				byte b = buffer.get();
				System.out.print((char) b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取数据到文件
	 * 
	 * @param fos
	 */
	public static void writeToFile(FileOutputStream fos, String fileContent) {
		try {
			FileChannel fileChannel = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			byte[] bytes = fileContent.getBytes();
			for (byte b : bytes) {
				buffer.put(b);
			}
			buffer.flip();
			fileChannel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
