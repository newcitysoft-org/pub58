package com.renren.pub58.api.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

public class ImageReadWriteTest {
	/**
	 * 将图片读取为字节，然后将字节读到新的图片中
	 */
	public static void test() {
		byte[] byteRtn = new byte[1024];

		byteRtn = BufferStreamForByte("E:/car1.jpg", 1024);
		writeByteArryToImage(byteRtn);

	}

	private static void writeByteArryToImage(byte[] byteRtn) {
		try {
			FileImageOutputStream output = new FileImageOutputStream(new File("E:/wo1132mage.jpg"));
			output.write(byteRtn);
			output.flush();
			output.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * url 连接获取返回值
	 *
	 * @param spec
	 * @param size
	 * @return url请求结果
	 */
	public static byte[] BufferStreamForByte(String spec, int size) {
		byte[] content = null;
		try {
			BufferedInputStream bis = null;
			ByteArrayOutputStream out = null;
			try {
				FileInputStream input = new FileInputStream(spec);
				bis = new BufferedInputStream(input, size);
				byte[] bytes = new byte[1024];
				int len;
				out = new ByteArrayOutputStream();
				while ((len = bis.read(bytes)) > 0) {
					out.write(bytes, 0, len);
				}

				bis.close();
				// bos.flush();
				// bos.close();
				content = out.toByteArray();
			}
			finally {
				if (bis != null)
					bis.close();
				if (out != null)
					out.close();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;

	}

	public static void main(String args[]) {
		test();
	}
}