package com.xyz.messageapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {

    TextView txtMsg;
    EditText etPhone;
    Button btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btnSendSms = (Button) findViewById(R.id.btnSendSms);

        final Intent i = getIntent();
        final String msg = i.getStringExtra("m");
        txtMsg.setText(msg);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String ph = etPhone.getText().toString();

                if (ph.length() == 0) {
                    etPhone.setError("Phone number cannot be empty");
                    etPhone.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:" + ph));
                i.putExtra("sms_body", msg);
                startActivity(i);

            }
        });

    }
}
