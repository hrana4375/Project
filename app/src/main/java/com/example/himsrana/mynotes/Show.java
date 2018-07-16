
package com.example.himsrana.mynotes;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

    ListView lv;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lv = findViewById(R.id.list);
        final ArrayList<String> titleList = new ArrayList<String>();
        final ArrayList<String> contentList = new ArrayList<String>();


        DataBase dataBase = new DataBase(getApplicationContext());

        Cursor cursor = dataBase.getData();
        String title;
        String content;

        if(cursor.moveToFirst()) {

            do {
                title = cursor.getString(cursor.getColumnIndex("Title"));
                content = cursor.getString(cursor.getColumnIndex("Content"));

                titleList.add(title);
                contentList.add(content);

            }while(cursor.moveToNext());


            ArrayList<String> finalData = new ArrayList<>();

            for(int i=0; i<titleList.size(); i++){

                finalData.add(titleList.get(i) + "\n----------------------------------------------------------------------------------\n" + contentList.get(i));

            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Show.this,android.R.layout.simple_list_item_1,finalData);
            lv.setAdapter(arrayAdapter);

  }
        else
        Toast.makeText(getApplicationContext(),"Add yout First Note",Toast.LENGTH_SHORT).show();



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Show.this,Show2.class);
                intent.putExtra("Title", titleList.get(i));
                intent.putExtra("Content", contentList.get(i));

                startActivity(intent);
            }
        });


        button = findViewById(R.id.add);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Show.this,Add.class);
                startActivity(intent);

            }
        });
    }
}
