package com.example.tap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Contact_Clicked extends AppCompatActivity {

    private Button mCall;
    private String mNum;
    private String Ph_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__clicked);

        TextView name = findViewById(R.id.textView1);
        final TextView number = findViewById(R.id.textView2);
        ImageView image = findViewById(R.id.imageView1);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        Ph_no = intent.getStringExtra("number");
        number.setText(Ph_no);
        image.setImageResource(intent.getIntExtra("image",0));


        mCall = (Button) findViewById(R.id.btnCall);

        mCall.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Context c = v.getContext();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String dialog_no = Ph_no.replaceAll("-","");


                intent.setData(Uri.parse("tel:"+dialog_no));

                try {
                    c.startActivity(intent);
                } catch (Exception e) {
                    //
                    e.printStackTrace();
                }
            }
        });

    }

/*
    public void onClick(View v) {
        Intent intent = getIntent();
        mNum = intent.getStringExtra("number");
        String tel = "tel:" + mNum;
        startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel)));
    }


 */

}