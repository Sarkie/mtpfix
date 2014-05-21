package org.sarkie.mtpfix;

import android.app.Service;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.FileObserver;
import android.os.IBinder;
import android.content.Intent;
import android.util.Log;

import org.sarkie.utils.RecursiveFileObserver;

public class MTPBackgroundService extends Service {

    private RecursiveFileObserver observer;

    private String pathToWatch = Environment.getExternalStorageDirectory().getAbsolutePath();


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // do something when the service is created

        runFileObserver();
    }

    private void runFileObserver() {

        observer = new RecursiveFileObserver(pathToWatch, FileObserver.CLOSE_WRITE) {

            @Override
            public void onEvent(int event, String file) {

                Log.i("MTPService", "File created [" + pathToWatch + file + "]");

                MediaScannerConnection.scanFile(getBaseContext(), new String[]{file}, null, null);
            }
        };

        observer.startWatching();

        Log.i("MTPService", "Watching " + pathToWatch);

    }
}
