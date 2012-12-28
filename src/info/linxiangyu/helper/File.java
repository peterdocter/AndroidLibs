package info.linxiangyu.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class File {
	
	//http://my.oschina.net/u/149945/blog/29076  Android读写文件
	

//	public void write2File(String content, String fileName){
//		/**
//		 * write string to /data/data/package/file
//		 */
//        FileOutputStream os=null;
//        int mode=Context.MODE_WORLD_WRITEABLE|Context.MODE_WORLD_READABLE;
//        try{
//            os=openFileOutput(fileName, mode);
//            os.write(content.getBytes());
//        }catch(Exception e){
//        	e.printStackTrace();
//        }
//        finally
//        {
//            if(os!=null)
//            {
//                try{
//                os.flush();
//                os.close();
//                }catch(IOException e)
//                {
//                	e.printStackTrace();
//                }
//            }
//        }
//    }
//    
//    
//    public String readFromFile(String fileName)
//    {
//    	/**
//		 * read string file /data/data/package/file
//		 */
//        String content = null;
//        FileInputStream is=null;
//        try{
//            is=openFileInput(fileName);
//            byte buffer[]=new byte[is.available()];
//            is.read(buffer);
//            content=new String(buffer);
//        }catch(Exception e)
//        {
//        	e.printStackTrace();
//        }
//        finally
//        {
//            if(is!=null)
//            {
//                try{
//                is.close();
//                }catch(IOException e)
//                {
//                	e.printStackTrace();
//                }
//            }
//        }      
//        return content;
//    }
    

}
