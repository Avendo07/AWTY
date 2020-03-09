package com.jack.awty;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jack.awty.viewmodels.MainActivityViewModel;


public class AlarmFragment extends Fragment {
    private static String TAG = "Alarm Fragment";
    private MainActivityViewModel viewModel;
    private FloatingActionButton fab_add_reminder;

    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Get the main viewmodel (required)
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        fab_add_reminder = view.findViewById(R.id.fab_add_reminder);
        /*fab_add_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createReminder(1L);
            }
        });*/
        fab_add_reminder.setOnClickListener( v -> {
            Log.d(TAG, "onStart: created alarm request");
            viewModel.startShowingNotifications();
        });
    }
    
    //Debug task, remove after learning about workmanagers
    private void createNuisance(){
    
    }

    private void createReminder(long time){
        //Show the dialog to choose the location
	    LocationChooserDialog dialog = new LocationChooserDialog();
	    dialog.show(getChildFragmentManager(), "location_chooser");
    }
}
