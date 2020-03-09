package com.jack.awty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jack.awty.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    public final static String CHANNEL_ID = "AWTY";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv_main);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        createNotificationChannel();
    }

    @TargetApi(26)
    private void createNotificationChannel(){
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Location Based Alarm", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("Notifications for set alarms");
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

}