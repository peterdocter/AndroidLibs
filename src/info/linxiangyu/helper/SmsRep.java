package info.linxiangyu.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class SmsRep {

	/**
	 * from <a href="http://stackoverflow.com/questions/5451354/get-data-from-sent-sms">Get data form sent sms</a>
	 */
	static String separator;
	public static Context context;
	static String TAG="HELLO";
	
	public int id;
	public String address;
	public long timestamp;
	public int type;
	public int protocol;
	public String subject;
	public String body;
	public String deviceId;


	public static void setContext(Context ctx) {
		context = ctx;
	}

	
	public static List<SmsRep> cursor2SmsArray(Cursor cursor) {
		if (null == cursor || 0 == cursor.getCount()) {
			return new ArrayList<SmsRep>();
		}

		List<SmsRep> messages = new ArrayList<SmsRep>();

		try {
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				SmsRep singleSms = new SmsRep();
				singleSms.id = cursor.getInt(cursor
						.getColumnIndexOrThrow("_id"));
				singleSms.address = cursor.getString(cursor
						.getColumnIndexOrThrow("address"));
				singleSms.timestamp = cursor.getLong(cursor
						.getColumnIndexOrThrow("date")) / 1000; // ### the sent
																// time
				singleSms.type = cursor.getInt(cursor
						.getColumnIndexOrThrow("type"));
				singleSms.protocol = cursor.getInt(cursor
						.getColumnIndexOrThrow("protocol"));

				/*
				 * String smsSubject =
				 * cursor.getString(cursor.getColumnIndex("subject")); byte[]
				 * subjByts = smsSubject.getBytes("UTF8"); singleSms.subject =
				 * new String(subjByts, "UTF8");
				 */

				String smsBody = cursor.getString(cursor
						.getColumnIndexOrThrow("body")); // ### body
				byte[] bodyBytes = smsBody.getBytes("UTF8");
				singleSms.body = TextUtils.htmlEncode(new String(bodyBytes,
						"UTF8")); // escape，handle '='
				//singleSms.deviceId = deviceId;

				// singleSms.body =
				// cursor.getString(cursor.getColumnIndexOrThrow("body"));
				messages.add(singleSms);
			}

		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		} finally {
			cursor.close();
		}

		return messages;
	}

	public static List<SmsRep> getOutboxSms() {
		if (null == context) {
			return new ArrayList<SmsRep>();
		}

		Uri uriSms = Uri.parse("content://sms/sent");
		Cursor cursor = context.getContentResolver().query(uriSms, null, null,
				null, null);
		List<SmsRep> outboxSms = cursor2SmsArray(cursor);

		if (!cursor.isClosed()) {
			cursor.close();
		}

		return outboxSms;
	}

}
