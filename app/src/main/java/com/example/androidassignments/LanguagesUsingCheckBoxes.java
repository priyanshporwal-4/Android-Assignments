package com.example.androidassignments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LanguagesUsingCheckBoxes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_languages_using_check_boxes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox java = findViewById(R.id.checkBox);
        CheckBox python = findViewById(R.id.checkBox6);
        CheckBox rust = findViewById(R.id.checkBox2);
        CheckBox go = findViewById(R.id.checkBox3);
        CheckBox cpp = findViewById(R.id.checkBox4);
        Button button = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder textString = new StringBuilder();
                if(java.isChecked()) textString.append(java.getText());
                if(rust.isChecked()) textString.append("\n" + rust.getText());
                if(go.isChecked()) textString.append("\n" + go.getText());
                if(cpp.isChecked()) textString.append("\n" + cpp.getText());
                if(python.isChecked()) textString.append("\n" + python.getText());

                TextView textView = findViewById(R.id.textView8);
                textView.setText(textString);
            }
        });
    }
}