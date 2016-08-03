package com.example.questdot.fcmpushnotificationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        subscribeButton.setOnClickListener(this);

        Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        logTokenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.subscribeButton){
            FirebaseMessaging.getInstance().subscribeToTopic("any");
            Log.d("main", "Subscribed to news topic");
        }
        else if(view.getId()==R.id.logTokenButton){
            Log.d("main", "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
        }
    }
}
