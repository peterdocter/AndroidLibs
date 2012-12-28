package info.linxiangyu.helper;

import java.io.IOException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class ImageUtils {
	
	String TAG = "HELLO";
	
	
	
	 public Drawable loadDrawableFromURL(String imageUrl)
	    {
		    	Drawable drawable = null;
		    	try {
		    		drawable = Drawable.createFromStream(
		    				new URL(imageUrl).openStream(), "image.jpg");
		    	} catch (IOException e) {
		    		Log.e(TAG, e.getMessage());
		    	}
		   if (drawable == null)
			   Log.d(TAG, "Not Got");
		   return drawable;
	    }

}
