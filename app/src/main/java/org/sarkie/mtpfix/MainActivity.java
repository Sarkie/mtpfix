package org.sarkie.mtpfix;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startServiceCommand(View view) {
        Intent serviceIntent = new Intent(this, MTPBackgroundService.class);
        startService(serviceIntent);
    }
}
