package com.example.himsrana.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add extends AppCompatActivity {


    EditText content,title;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        save = findViewById(R.id.save);
        final String str = null;


        final DataBase dataBase = new DataBase(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((title.getText().toString()).equals(str))
                {
                    Toast.makeText(Add.this, "Empty Note", Toast.LENGTH_SHORT).show();
                }
                else {

                    dataBase.onAdd(title.getText().toString(), content.getText().toString());

                    Toast.makeText(Add.this, "Note Added", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Add.this, Show.class);
                    startActivity(intent);
                }
            }
        });







    }
}
