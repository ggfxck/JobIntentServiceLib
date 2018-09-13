package com.safeon.pushlib;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;


public class MyJobIntentService extends JobIntentService  {
	private static final String TAG = MyJobIntentService.class.getSimpleName();
	private static String mTestString = "";
	public MyJobIntentService() {
		super();
	}

	public static void setTextString(String text) {
		mTestString = text;
	}


//    @Override
//    protected void onHandleIntent(Intent intent) {
//        Log.d("GcmItentService", "onHandleIntent!");
//        Bundle extras = intent.getExtras();
//        Log.d(TAG,String.valueOf(test()));
//        // Release the wake lock provided by the WakefulBroadcastReceiver.
//        SafeOnGCMBroadcastReceiver.completeWakefulIntent(intent);
//    }

	/**
	 * Convenience method for enqueuing work in to this service.
	 */
	public static void enqueueWork(Context context, Intent work) {
		try {
			enqueueWork(context, MyJobIntentService.class, 1000, work);
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public boolean test() {
		// GCM IntentService 에서 오버라이드 할 메소드
		return true;
	}
	@Override
	protected void onHandleWork(@NonNull Intent intent) {
		// 여기서 test() 를 GCMIntentService 에서 오버라이드 함
		Log.d(TAG,String.valueOf(test()));
		// GCMIntentService 에서 setTextString를 호출 하여 mTestString 을 셋팅
		Log.d(TAG,"셋팅 값 : "+mTestString);
	}
}
