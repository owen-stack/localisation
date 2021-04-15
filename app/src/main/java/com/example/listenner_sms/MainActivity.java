package com.example.listenner_sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnEnvoie;
    EditText numero;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //On récupère le bouton créé en XML grâce à son id
        //On récupère les deux EditText correspondant aux champs pour entrer le numéro et le message
        numero = (EditText) findViewById(R.id.numero);
        btnEnvoie = (Button) findViewById(R.id.envoyer);

        btnEnvoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String al = numero.getText().toString();
                Intent intent = new Intent(getApplicationContext(), envoiee.class); // Ouverture de la classe Envoi pour envoyer le message

                //envoi du numero dans la classe Envoi
                intent.putExtra("value", al); // la clé, la valeur

                startActivity(intent);

            }
        });

        }


}
     /*   EditText message = (EditText)findViewById(R.id.message);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        //On affecte un écouteur d'évènement au bouton
        btnEnvoie.setOnClickListener(new View.OnClickListener() {
            // @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                //On récupère ce qui a été entré dans les EditText
                String num = numero.getText().toString();

                System.out.println("MON NUMERO : " + num);

                sendSms(num);
            }
        });
    }

    private void sendSms(String phoneNumber){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, "VOTRE MESSAGE", null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again later!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
*/
