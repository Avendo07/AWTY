package com.jack.awty.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.jack.awty.repository.Alarms;
import com.jack.awty.repository.StationsRepository;
import com.jack.awty.workers.AlarmWorker;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivityViewModel extends AndroidViewModel {
	//Observers
	private LiveData<List<Alarms>> mAlarms;
	private LiveData<List<String>> mStations;
	//Local Database Repo Connection
	private StationsRepository mStationsRepository;
	//WorkManger to show notifications in background
	private WorkManager mWorkManger;
	
	
	//The ViewModel lives and dies with the application, so we should start everything at creation
	public MainActivityViewModel(@NonNull Application application) {
		super(application);
		//TODO:Getting the locations from the online site
		mStationsRepository = new StationsRepository(application);
		mStations = mStationsRepository.getStations();
		//Gets the WorkManager instance to start works in background
		mWorkManger = WorkManager.getInstance(application);
	}
	
	//Shows the stations data from local database
	public LiveData<List<String>> getmStations(){return this.mStations;}
	
	//Used to start showing notifications when user clicks the plus button
	//Refactor when you have learnt WorkManager
	public void startShowingNotifications(){
		WorkRequest nuisanceRequest = new PeriodicWorkRequest.Builder(AlarmWorker.class, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, TimeUnit.MILLISECONDS)
				.build();
		mWorkManger.enqueue(nuisanceRequest);
	}
}