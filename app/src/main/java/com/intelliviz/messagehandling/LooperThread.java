package com.intelliviz.messagehandling;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by edm on 9/10/2015.
 */
public class LooperThread extends Thread {
    public Handler mHandler;
    private final WeakReference<MainActivity> mActivity;

    LooperThread(MainActivity activity) {
        mActivity = new WeakReference<MainActivity>(activity);
    }

    private static class MyHandler extends Handler {

        private final WeakReference<MainActivity> mActivity;

        MyHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                //mActivity.get().doLongRunningOperation();
            }
        }
    }

    public void run() {
        Looper.prepare();
        mHandler = new MyHandler(mActivity.get());
        Looper.loop();
    }
}
