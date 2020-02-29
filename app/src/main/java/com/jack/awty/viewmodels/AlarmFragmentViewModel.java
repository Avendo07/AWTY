package com.jack.awty.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jack.awty.database.Database;
import com.jack.awty.database.Station;
import com.jack.awty.repository.Alarms;
import com.jack.awty.repository.StationsRepository;

import java.util.ArrayList;
import java.util.List;

public class AlarmFragmentViewModel extends AndroidViewModel {
	private LiveData<List<Alarms>> mAlarms;
	private LiveData<List<String>> mStations;
	private StationsRepository stationsRepository;
	
	public AlarmFragmentViewModel(@NonNull Application application) {
		super(application);
		//TODO:Getting the locations from the repository
		stationsRepository = new StationsRepository(application);
		mStations = stationsRepository.getStations();
	}
	public LiveData<List<String>> getmStations(){return this.mStations;}
	
}