package info.linxiangyu.helper;

import java.net.URL;
import java.net.URLConnection;


public class HttpUtils {
	
	public static int getFileLength(String fileURL) {
		/**
		 * @author linxiangyu
		 * 以一个字符串表示的URL作为参数，返回URL对应的文件大小
		 */
		int contentLength = 0;
		try{
			URL url = new URL(fileURL);
			URLConnection connection = url.openConnection();
			contentLength = connection.getContentLength();
		}catch (Exception e){
			e.printStackTrace();
		}
		return contentLength;
	}
}
