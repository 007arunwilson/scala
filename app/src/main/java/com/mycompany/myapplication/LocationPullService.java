package com.mycompany.myapplication;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by arun on 7/8/17.
 */

public class LocationPullService extends IntentService {

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();
        //...
        // Do work here, based on the contents of dataString
        //...
    }

    public LocationPullService() {
        super("LocationPullService");
    }

}
