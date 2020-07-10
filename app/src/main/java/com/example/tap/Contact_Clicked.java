package com.example.tap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_Clicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__clicked);

        TextView name = findViewById(R.id.textView1);
        TextView number = findViewById(R.id.textView2);
        ImageView image = findViewById(R.id.imageView1);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        number.setText(intent.getStringExtra("number"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}