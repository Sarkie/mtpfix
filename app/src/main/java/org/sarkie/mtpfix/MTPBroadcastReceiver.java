package org.sarkie.mtpfix;

import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;

public class MTPBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //we double check here for only boot complete event
        if(intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
        {
            //here we start the service
            Intent serviceIntent = new Intent(context, MTPBackgroundService.class);
            context.startService(serviceIntent);
        }
    }
}
