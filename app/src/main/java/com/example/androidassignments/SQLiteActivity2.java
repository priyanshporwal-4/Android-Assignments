package com.example.androidassignments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLiteActivity2 extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private Button buttonAdd, buttonView;
    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);
        listView = findViewById(R.id.listView);

        databaseHelper = new DatabaseHelper(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String ageStr = editTextAge.getText().toString().trim();
                if (!name.isEmpty() && !ageStr.isEmpty()) {
                    int age = Integer.parseInt(ageStr);
                    if (databaseHelper.addRecord(name, age)) {
                        Toast.makeText(SQLiteActivity2.this, "Record added successfully", Toast.LENGTH_SHORT).show();
                        editTextName.setText("");
                        editTextAge.setText("");
                    } else {
                        Toast.makeText(SQLiteActivity2.this, "Failed to add record", Toast.LENGTH_SHORT).show();
                    }
                } else {
                Toast.makeText(SQLiteActivity2.this, "Please enter name and age", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseHelper.getAllRecords();
                ArrayList<String> recordsList = new ArrayList<>();
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                        int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                        int ageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE);

                        if (idIndex != -1 && nameIndex != -1 && ageIndex != -1) {
                            int id = cursor.getInt(idIndex);
                            String name = cursor.getString(nameIndex);
                            int age = cursor.getInt(ageIndex);
                            recordsList.add("ID: " + id + ", Name: " + name + ", Age: " + age);
                        } else {
                            // Handle the case where columns are not found in the cursor
                            Toast.makeText(SQLiteActivity2.this, "Columns not found in cursor", Toast.LENGTH_SHORT).show();
                        }
                    }
                    cursor.close();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SQLiteActivity2.this,
                        android.R.layout.simple_list_item_1, recordsList);
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click here (for updating or deleting record)
                // Example: Implement update or delete functionality here
            }
        });
    }
}