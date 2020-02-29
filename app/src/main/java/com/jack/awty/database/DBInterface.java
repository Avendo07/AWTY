package com.jack.awty.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DBInterface {
	@Query("SELECT station_name FROM stations ORDER BY station_name ASC")
	LiveData<List<String>> getStations();
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertStations(List<Station> stations);
	
	@Query("DELETE FROM stations")
	void deleteAll();
}