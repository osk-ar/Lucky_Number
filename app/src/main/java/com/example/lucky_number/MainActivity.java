package com.example.lucky_number;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nameTV;
    Button generate;
    String name;
    public final static String key = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            nameTV = findViewById(R.id.nameInput);
            generate = findViewById(R.id.generateBtn);

            generate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = nameTV.getText().toString();

                    Intent home = new Intent( MainActivity.this , GoalActivity.class );
                    home.putExtra(key,name);

                    startActivity(home);
                }
            });






            return insets;
        });
    }
}