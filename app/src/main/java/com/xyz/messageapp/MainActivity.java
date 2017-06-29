package com.xyz.messageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMessage;
    Button btnSend, btnWhatsapp, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = (EditText) findViewById(R.id.etMessage);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnWhatsapp = (Button) findViewById(R.id.btnWhatsapp);
        btnSms = (Button) findViewById(R.id.btnSms);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = etMessage.getText().toString();

                if (msg.length() == 0) {
                    etMessage.setError("Message cannot be empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i= new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(i);

            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = etMessage.getText().toString();

                if (msg.length() == 0) {
                    etMessage.setError("Message cannot be empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i= new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT, msg);
                try {
                    startActivity(i);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Whatsapp not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = etMessage.getText().toString();

                if (msg.length() == 0) {
                    etMessage.setError("Message cannot be empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i= new Intent(MainActivity.this, SmsActivity.class);
                i.putExtra("m", msg);
                startActivity(i);

            }
        });
    }
}
