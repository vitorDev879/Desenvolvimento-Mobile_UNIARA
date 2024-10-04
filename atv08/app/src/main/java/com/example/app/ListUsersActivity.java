package com.example.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListUsersActivity extends AppCompatActivity {

    ListView listViewUsers;
    DBHelper dbHelper;
    ArrayList<String> userList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_users);

        listViewUsers = findViewById(R.id.listViewUsers);
        dbHelper = new DBHelper(this);
        userList = new ArrayList<>();

        loadData();
    }

    private void loadData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String surname = cursor.getString(cursor.getColumnIndexOrThrow("sobrenome"));
                userList.add(name + " " + surname);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        listViewUsers.setAdapter(adapter);
    }
}