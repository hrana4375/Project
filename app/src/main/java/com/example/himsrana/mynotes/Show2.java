package com.example.himsrana.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Show2 extends AppCompatActivity {

    EditText title2,content2;
    Button delete,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2);
        title2 = findViewById(R.id.title2);
        content2 = findViewById(R.id.content2);
        save = findViewById(R.id.save2);
        delete = findViewById(R.id.delete2);
        final DataBase dataBase = new DataBase(getApplicationContext());

        Bundle bundle = getIntent().getExtras();

        String string1 = bundle.getString("Title");
        String string2 = bundle.getString("Content");

        title2.setText(string1);
        content2.setText(string2);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase.onDelete(title2.getText().toString());
                Intent intent = new Intent(getApplicationContext(),Show.class);
                Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBase.onUpdate(title2.getText().toString(),content2.getText().toString());
                Intent intent = new Intent(getApplicationContext(),Show.class);
                Toast.makeText(Show2.this, "Note Updated", Toast.LENGTH_SHORT).show();
                startActivity(intent);


            }
        });
    }
}
