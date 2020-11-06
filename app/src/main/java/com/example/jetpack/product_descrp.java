package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class product_descrp extends AppCompatActivity {
private ImageView image;
private TextView imageName;
    private FloatingActionButton share;
    private String curentState;
    private int currentPosition;
    private FloatingActionButton plus;
private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_descrp);
        init();
        getIn();
        setDescription();
        share.setOnClickListener(v -> {
            shareTheCurrentName();
        });
        plus.setOnClickListener(v -> {
            addToFlowerQueue();
        });
    }

    private void setDescription() {
      String[] ar =  getResources().getStringArray(R.array.description);
        description.setText(ar[currentPosition]);
    }
    private void shareTheCurrentName() {
        Toast.makeText(getApplicationContext(), curentState, Toast.LENGTH_SHORT).show();
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_SEND);
         intent.putExtra(Intent.EXTRA_TEXT, curentState);
         intent.setType("text/plain");
         Intent intent1 = Intent.createChooser(intent, null);

         startActivity(intent1);
    }
    private void addToFlowerQueue() {
    }
    private void getIn() {
        Intent intent = getIntent();
        String val = intent.getStringExtra(MainActivity.GLOBAL_CONSTANT_IMAGE_NAME);
        imageName.setText(val);
        int idForImage = intent.getIntExtra(MainActivity.GLOBAL_CONSTANT_IMAGE, 0);
        curentState = val;
        currentPosition = intent.getIntExtra(MainActivity.GLOBAL_CONSTANT_POSITION, 0);
        if( idForImage != 0){
            image.setImageResource(idForImage);
        }
    }
    private void init() {
        image = findViewById(R.id.imageView);
        imageName  = findViewById(R.id.imageName);
        share = findViewById(R.id.share);
        plus = findViewById(R.id.plus);
        description = findViewById(R.id.descrp);
    }
}