package com.example.listenner_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.app.*;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        //get message passed in
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        String lat = "";
        String lon = "";
        if (bundle != null)
        {
// --- récupérer le message reçu ---c

            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i=0; i<msgs.length; i++)
            {
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                str += msgs[i].getMessageBody().toString();

                String[] coords = str.split(";");
                lat = coords[0];
                lon = coords[1];

            }
// --- afficher le nouveau message SMS ---

            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
// --- cette partie consiste à envoyer une intention de diffusion pour mettre à jour le message reçu dans l'activité ---

            Intent broadcastIntent = new Intent(context, mapp.class);


           // Intent mainActivityIntent = new Intent(context, SMSTest.class);
            broadcastIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           // mainActivityIntent.putExtra("sms", str);
            //context.startActivity(mainActivityIntent)
            broadcastIntent.setAction("SMS_RECEIVED_ACTION");
            broadcastIntent.putExtra("Latitude", lat);
            broadcastIntent.putExtra("Longitude", lon);
            context.startActivity(broadcastIntent);


        }
    }

}