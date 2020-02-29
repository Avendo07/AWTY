package com.jack.awty.repository;

import androidx.lifecycle.LiveData;

import com.google.android.gms.location.FusedLocationProviderClient;

import java.util.List;

public class AlarmRepository {
	private FusedLocationProviderClient fusedLocationProviderClient;
	private LiveData<List<Alarms>> alarms;
/*	public LiveData<List<Alarms>> getLocations(Alarms... alarms){

	}*/
}
