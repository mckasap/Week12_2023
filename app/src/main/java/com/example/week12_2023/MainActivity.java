package com.example.week12_2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String,String> mp= new HashMap<>();
        mp.put("Name","ŞAMPİYON Trabzonspor");

        dbref.push().setValue(mp, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                if(error==null)
                    Toast.makeText(MainActivity.this, "KAYIT BAŞARILI",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "KAYIT BAŞARISIZ",Toast.LENGTH_LONG).show();

            }
        });

    }
}