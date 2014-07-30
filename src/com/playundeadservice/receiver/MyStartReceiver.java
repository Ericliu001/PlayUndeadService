package com.playundeadservice.receiver;

import com.playundeadservice.service.MessageService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;

public class MyStartReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent receivedIntent) {
		Intent intent = new Intent(context, MessageService.class);
		context.startService(intent);
	}

}
