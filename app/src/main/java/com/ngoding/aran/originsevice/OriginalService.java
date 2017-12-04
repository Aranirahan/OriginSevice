package com.ngoding.aran.originsevice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class OriginalService extends Service {
    public static final String ORIGINAL_SERVICE = "OriginService";
    public OriginalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Proses service terjadi disini
        Log.d(ORIGINAL_SERVICE, "OriginalService dijalankan");
        ProsesAsync mProsesAsync = new ProsesAsync();
        mProsesAsync.execute();
        return START_STICKY;
        // START_STICKY - Jika sistem android mematikan service tersebut
        // setelah onStartCommand() dijalankan maka akan diciptakan kembali
        // dan dilakukan pemanggilan kembali method onStartCommand()
        // Namun jika ada intent yang dikirimkan sebelumnya menjadi tidak ada alias null.
    }

    private class ProsesAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(ORIGINAL_SERVICE, "Stop Service");
            stopSelf();
        }
    }
}
