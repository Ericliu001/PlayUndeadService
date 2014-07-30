package com.playundeadservice.service;

import com.playundeadservice.BuildConfig;
import com.playundeadservice.MSG_SERVICE_FLAG;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class MessageService extends Service {
	public static final String MESSAGE = "message";
	private int i = 0;

	volatile Looper mServiceLooper;
	volatile ServiceHandler mServiceHander;

	private static class ServiceHandler extends Handler {

		public ServiceHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			Bundle args = new Bundle();
			if (msg.obj != null) {
				
				 args = (Bundle) msg.obj;
			}
	
			
			
			
			if (args.getString(MESSAGE) != null) {

				Log.i("eric", args.getString(MESSAGE));
			}


		}
	}

	@Override
	public void onCreate() {
		super.onCreate();

		HandlerThread thread = new HandlerThread("UndeadServiceThread",
				Process.THREAD_PRIORITY_FOREGROUND);

		thread.start();
		mServiceLooper = thread.getLooper();
		mServiceHander = new ServiceHandler(mServiceLooper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Message msg = mServiceHander.obtainMessage();
		msg.arg1 = startId;
		msg.arg2 = flags;
		msg.obj = intent.getExtras();

		mServiceHander.sendMessage(msg);

		return START_REDELIVER_INTENT;
	}

	@Override
	public void onDestroy() {
		mServiceLooper.quit();

		super.onDestroy();

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
