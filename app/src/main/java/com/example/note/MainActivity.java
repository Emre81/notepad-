package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text_title;

    EditText edit_text_note;

    SharedPreferences sharedpref;

    String notes;

    Button button_save, button_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_title = findViewById(R.id.text_title);
        edit_text_note = findViewById(R.id.edit_text_note);
        button_save = findViewById(R.id.button_save);
        button_load = findViewById(R.id.button_load);

        text_title.setText("Note App");

        button_load.setVisibility(View.INVISIBLE);

        sharedpref = getSharedPreferences("Note App", Context.MODE_PRIVATE);
        notes = sharedpref.getString("Notes","");

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_data();
            }
        });

        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_data();
            }
        });


        edit_text_note.setText(notes);

    }


        public void save_data(){
            SharedPreferences.Editor editor = getSharedPreferences("Note App", Context.MODE_PRIVATE).edit();
            editor.putString("Notes", edit_text_note.getText().toString());
            editor.apply();

            Toast toast = Toast.makeText(getApplicationContext(), "Text Saved!", Toast.LENGTH_SHORT);
            toast.show();
        }

        public void load_data(){
            edit_text_note.setText(notes);

            Toast toast = Toast.makeText(getApplicationContext(), "Text Loaded", Toast.LENGTH_SHORT);
        }

}