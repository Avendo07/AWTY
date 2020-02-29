package com.jack.awty;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AlarmFragment extends Fragment {
    private FloatingActionButton fab_add_reminder;

    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        fab_add_reminder = view.findViewById(R.id.fab_add_reminder);
        fab_add_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createReminder(1L);
            }
        });
    }

    private void createReminder(long time){
	    LocationChooserDialog dialog = new LocationChooserDialog();
	    dialog.show(getChildFragmentManager(), "location");
        /*NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), MainActivity.CHANNEL_ID).setContentTitle("HERE!").setSmallIcon(R.mipmap.ic_launcher_round).setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
        notificationManagerCompat.notify(12, builder.build());*/
    }
}
