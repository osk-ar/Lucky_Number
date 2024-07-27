package com.example.lucky_number;

import static com.example.lucky_number.MainActivity.key;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GoalActivity extends AppCompatActivity {

    TextView numTV;
    Button share;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_goal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.GoalBackground), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            numTV = findViewById(R.id.Result);
            numTV.setText("" + Math.round(Math.random()*100));

            share = findViewById(R.id.shareBtn);

            name = getIntent().getStringExtra(key);

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_SEND);
                    i.putExtra(Intent.EXTRA_SUBJECT,"Hey, Check my lucky number !");
                    i.putExtra(Intent.EXTRA_TEXT,name + "'s Lucky number is: " + numTV.getText().toString());
                    i.setType("text/plain");

                    Intent share = Intent.createChooser(i,null);
                    startActivity(share);

                }
            });





            return insets;
        });
    }
}