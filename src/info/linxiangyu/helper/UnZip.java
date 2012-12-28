package info.linxiangyu.helper;


import android.util.Log;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class UnZip extends Thread{
	/**
	 * @author linxiangyu 
	 * 
	 * 对Java中zip4j开源库简单的封装
	 * 构造方法接受 需解压zip文件的完整路径，以及解压目录的完整路径作为参数，run方法调用zip4j提供的方法进行解压操作
	 * 
	 * Example: new Unzip("file-name-of-zip-file", "unzip-to-dir").start();
	 */
	
	ZipFile fileToUnZip;
	String toDir;
	boolean  isFinished = false;
	

	public boolean isFinished() {
		return isFinished;
	}



	public UnZip(String fileToUnZip, String toDir) throws net.lingala.zip4j.exception.ZipException {
		super();
		this.fileToUnZip = new ZipFile(fileToUnZip);
		this.toDir = toDir;
	}

	@Override
	public void run(){
		try {
			fileToUnZip.extractAll(toDir);
			isFinished = true;
			Log.d("UNZIP","Finished");
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

}
