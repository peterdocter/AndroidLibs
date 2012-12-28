package info.linxiangyu.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;

public class GetInfo {
	
	
	@SuppressLint("NewApi")
	public static Point getScreen(Context context) {
		/**
		 * get the device screen's display size
		 * 
		 */
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		return size;
	}
	
	public static String getID(Context context){
		/**
		 * return the Device ID: IMEI on GSM, MEID for CDMA
		 * 
		 * !!! <uses-permission android:name="android.permission.READ_PHONE_STATE" />
		 * 
		 * to get the android:  Secure.getString(getContentResolver(), Secure.ANDROID_ID));
		 * @see <a href="http://android-developers.blogspot.com/2011/03/identifying-app-installations.html">identifying-app-installations</a>
		 * @see <a href="http://blog.csdn.net/billpig/article/details/6728573">Android 唯一识别码</a>
		 */
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}
	
	
}
