package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disable(View v){
//        v.setEnabled(false);
////        Log.d("success", "button disabled");
//        Button b = (Button) v; // casting to a button
//        b.setText("Disabled"); // changing text on button

        View myView = findViewById(R.id.SignUpButton);
        myView.setEnabled(false);
        Button button = (Button)myView;
        button.setText("new disabled");
    }



}