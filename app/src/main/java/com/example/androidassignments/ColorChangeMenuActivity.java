package com.example.androidassignments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorChangeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color_change_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ConstraintLayout main = findViewById(R.id.main);
        int itemId = item.getItemId();
        if(itemId == R.id.black) {
            main.setBackgroundColor(Color.BLACK);
        }
        else if(itemId == R.id.white) {
            main.setBackgroundColor(Color.WHITE);
        }
        else if(itemId == R.id.red) {
            main.setBackgroundColor(Color.RED);
        }
        else if(itemId == R.id.vine) {
            main.setBackgroundColor(Color.parseColor("#FFC489FF"));
        }
        else {
            main.setBackgroundColor(Color.parseColor("#FFC489FF"));
        }
        return true;
    }
}