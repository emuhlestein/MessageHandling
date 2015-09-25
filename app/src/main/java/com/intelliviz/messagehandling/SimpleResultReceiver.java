package com.intelliviz.messagehandling;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by edm on 9/21/2015.
 */
public class SimpleResultReceiver extends ResultReceiver {

    private MainActivity mActivity;
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public SimpleResultReceiver(Handler handler, MainActivity activity) {
        super(handler);
        mActivity = activity;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        mActivity.handleResults();
    }
}
