package com.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main1 {

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String args[]) {
		try {
			// 创建文件夹
			boolean b = true;
			String fileContent = "hello world" + "\r\n";
			File file = new File("D:\\Test\\test.txt");
			if (!file.exists()) {
				b = new File("D:\\Test").mkdirs();
				if (b) {
					b = file.createNewFile();
				}
			}
			String fileStr = "";
			// 文件输入流
			FileInputStream fis1 = new FileInputStream(file);
			int length = 0;
			byte[] bytes = new byte[1024];
			while ((length = fis1.read(bytes)) > 0) {
				fileStr = fileStr + new String(bytes, 0, length);
			}
			System.out.println(fileStr);
			fis1.close();
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer stringBuffer = new StringBuffer();
			String temp = "";
			while ((temp = br.readLine()) != null) {
				stringBuffer.append(temp);
				// 换行
				stringBuffer = stringBuffer.append(System.getProperty("line.separator"));
			}
			FileOutputStream fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			if (stringBuffer.length() != 0) {
				fileContent = stringBuffer.toString() + fileContent;
			}
			pw.write(fileContent.toCharArray());
			pw.flush();
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
