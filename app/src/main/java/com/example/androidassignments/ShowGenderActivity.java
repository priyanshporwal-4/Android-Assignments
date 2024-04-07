package com.example.androidassignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowGenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_gender);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        Button button = findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedRadioId);
//                if (selectedRadioId == R.id.radioButton)
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                else if (selectedRadioId == R.id.radioButton2) {
//                    startActivity(new Intent(getApplicationContext(), IntentActivity2.class));
//                } else {
                    Toast.makeText(ShowGenderActivity.this, "" + radioButton.getText(), Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}