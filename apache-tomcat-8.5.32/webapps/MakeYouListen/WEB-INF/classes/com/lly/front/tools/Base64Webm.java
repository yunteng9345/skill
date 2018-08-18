package com.lly.front.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class Base64Webm {
	/*
	public static void readTxtFile(String filePath) {
		
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				StringBuilder lineTxt = new StringBuilder();
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					lineTxt.append(line);
				}
				read.close();

				String olddata = lineTxt.toString();
				olddata = olddata.replace("data:audio/webm;base64,", "");
				System.out.println(olddata);

				try {

					File webmFile = new File("D:\\project\\liulei\\Doc\\互动直播室\\微课网页开发\\silk2mp3\\caole.webm");
					byte[] bt = Base64.decode(olddata);
					FileOutputStream in = new FileOutputStream(webmFile);
					try {
						in.write(bt, 0, bt.length);
						in.close();
						// boolean success=true;
						// System.out.println("写入文件成功");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}
	
	*/
}
