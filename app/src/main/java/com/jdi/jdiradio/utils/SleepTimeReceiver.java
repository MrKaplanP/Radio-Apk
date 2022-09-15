package com.jdi.jdiradio.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jdi.jdiradio.database.prefs.SharedPref;
import com.jdi.jdiradio.services.RadioPlayerService;

public class SleepTimeReceiver extends BroadcastReceiver {

    SharedPref sharedPref;

    @Override
    public void onReceive(Context context, Intent intent) {

        sharedPref = new SharedPref(context);

        if (sharedPref.getIsSleepTimeOn()) {
            sharedPref.setSleepTime(false, 0,0);
        }

        Intent intent_close = new Intent(context, RadioPlayerService.class);
        intent_close.setAction(RadioPlayerService.ACTION_STOP);
        context.startService(intent_close);
    }
}