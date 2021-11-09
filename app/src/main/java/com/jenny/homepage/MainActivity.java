package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button part1aBtn;
    private Button part1bBtn;
    private Button part1cBtn;
    private Button part2aBtn;
    private Button part2bBtn;
    private Button part2cBtn;
    private Button part3aBtn;
    private Button part3bBtn;
    private Button part3cBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        part1aBtn = (Button) findViewById(R.id.part1aBtn);
        part1bBtn = (Button) findViewById(R.id.part1bBtn);
        part1cBtn = (Button) findViewById(R.id.part1cBtn);
        part2aBtn = (Button) findViewById(R.id.part2aBtn);
        part2bBtn = (Button) findViewById(R.id.part2bBtn);
        part2cBtn = (Button) findViewById(R.id.part2cBtn);
        part3aBtn = (Button) findViewById(R.id.part3aBtn);
        part3bBtn = (Button) findViewById(R.id.part3bBtn);
        part3cBtn = (Button) findViewById(R.id.part3cBtn);

        part1aBtn.setOnClickListener(this);
        part1bBtn.setOnClickListener(this);
        part1cBtn.setOnClickListener(this);
        part2aBtn.setOnClickListener(this);
        part2bBtn.setOnClickListener(this);
        part2cBtn.setOnClickListener(this);
        part3aBtn.setOnClickListener(this);
        part3bBtn.setOnClickListener(this);
        part3cBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.part1aBtn:
                Intent intentPart1a = new Intent(MainActivity.this, part1A.class);
                startActivity(intentPart1a);
                break;
            case R.id.part1bBtn:
                Intent intentPart1b = new Intent(MainActivity.this, part1B.class);
                startActivity(intentPart1b);
                break;
            case R.id.part1cBtn:
                Intent intentPart1c = new Intent(MainActivity.this, part1C.class);
                startActivity(intentPart1c);
                break;
            case R.id.part2aBtn:
                Intent intentPart2a = new Intent(MainActivity.this, part2A.class);
                startActivity(intentPart2a);
                break;
            case R.id.part2bBtn:
                Intent intentPart2b = new Intent(MainActivity.this, part2B.class);
                startActivity(intentPart2b);
                break;
            case R.id.part2cBtn:
                Intent intentPart2c = new Intent(MainActivity.this, part2C.class);
                startActivity(intentPart2c);
                break;
            case R.id.part3aBtn:
                Intent intentPart3a = new Intent(MainActivity.this, part3A.class);
                startActivity(intentPart3a);
                break;
            case R.id.part3bBtn:
                Intent intentPart3b = new Intent(MainActivity.this, part3B.class);
                startActivity(intentPart3b);
                break;
            case R.id.part3cBtn:
                Intent intentPart3c = new Intent(MainActivity.this, part3C.class);
                startActivity(intentPart3c);
                break;
        }
    }
}