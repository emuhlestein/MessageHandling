package com.intelliviz.messagehandling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button mButton;
    private TextView mText;
    private SimpleResultReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("EDM", Thread.currentThread().getName());

        mReceiver = new SimpleResultReceiver(new Handler(), this);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleIntentService.class);
                intent.putExtra("data", "hi there, from the activity");
                intent.putExtra(SimpleIntentService.INTENT_RECEIVER, mReceiver);
                MainActivity.this.startService(intent);
            }
        });

        mText = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void handleResults() {
        Log.d("EDM", "Activity: handleResults");
    }
}
