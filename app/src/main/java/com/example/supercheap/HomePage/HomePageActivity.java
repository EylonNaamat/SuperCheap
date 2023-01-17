package com.example.supercheap.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supercheap.AddComment.AddCommentController;
import com.example.supercheap.BaseActivity;
import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.MainActivity;
import com.example.supercheap.R;

public class HomePageActivity extends BaseWithBarActivity {
    HomePageController my_control;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        my_control = new HomePageController(this);

        ((TextView) (findViewById(R.id.home_page_username))).setText(this.user.getFirst_name()+" "+this.user.getLast_name());

        if(this.user.getIs_manager())
        {
            my_control.checkNotifiction(this.user.getSuper_id());
        }

    }

    public void throwNote(String content)
    {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void send_notifiction(String title, String text,int id){
        NotificationCompat.Builder bl = new NotificationCompat.Builder(HomePageActivity.this,"My Notification");
        bl.setContentTitle(title);
        bl.setContentText(text);
        bl.setSmallIcon(R.drawable.logo);
        bl.setAutoCancel(true);

        NotificationManagerCompat mng = NotificationManagerCompat.from(HomePageActivity.this);
        mng.notify(id,bl.build());
    }

    public void do_not(){
        NotificationCompat.Builder bl = new NotificationCompat.Builder(HomePageActivity.this,"My Notification");
        bl.setContentTitle("title");
        bl.setContentText("text");
        bl.setSmallIcon(R.drawable.logo);
        bl.setAutoCancel(true);

        NotificationManagerCompat mng = NotificationManagerCompat.from(HomePageActivity.this);
        mng.notify(1,bl.build());
    }

}