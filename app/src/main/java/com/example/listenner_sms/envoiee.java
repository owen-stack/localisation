package com.example.listenner_sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class envoiee extends AppCompatActivity {
Button envoyer;
    private static final int PERMISSION_SEND_SMS = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoiee);
        envoyer = (Button) findViewById(R.id.envoyer_id);

        final EditText numero =(EditText)findViewById(R.id.numero);
        EditText message = (EditText)findViewById(R.id.message);


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        //On affecte un écouteur d'évènement au bouton pour envoyer le messages au numero entré dans la MainActivity
        envoyer.setOnClickListener(new View.OnClickListener() {
            // @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                //On récupère ce qui a été envoyé dans la MainActivity
                //Intent intent = getIntent();
               String num = getIntent().getStringExtra("value");

                System.out.println("MON NUMERO : " + num);

                sendSms(num);
            }
        });
    }

    private void sendSms(String phoneNumber){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, "20.8781753;15.3481637", null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again later!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}