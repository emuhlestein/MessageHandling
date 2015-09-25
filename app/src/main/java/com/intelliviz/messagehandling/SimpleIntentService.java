package com.intelliviz.messagehandling;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class SimpleIntentService extends IntentService {
    public static final String INTENT_RECEIVER = "com.intelliviz.INTENT_RECEIVER";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public SimpleIntentService() {
        super(SimpleIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String data = intent.getStringExtra("data");
        ResultReceiver receiver = intent.getParcelableExtra(INTENT_RECEIVER);

        receiver.send(0, new Bundle());

        Log.d("EDM", "In the Service: " + data);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("EDM", "Service: onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("EDM", "Service: onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("EDM", "Service: onDestroy");
    }
}
