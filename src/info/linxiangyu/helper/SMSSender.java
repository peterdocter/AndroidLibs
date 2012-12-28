package info.linxiangyu.helper;

import java.util.List;

import android.telephony.SmsManager;
import android.util.Log;

public class SMSSender {
    static String TAG = "HELLO";

    public static void sendSMS(String message, String phoneNumber) {
        SmsManager sms = SmsManager.getDefault();
        List<String> texts = sms.divideMessage(message);
        for (@SuppressWarnings("unused") String text : texts) {
            sms.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i(TAG, "Send " + message + "To " + phoneNumber);
        }
    }

}
