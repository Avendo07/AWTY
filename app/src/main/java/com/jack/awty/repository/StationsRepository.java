package com.jack.awty.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jack.awty.database.DBInterface;
import com.jack.awty.database.Database;
import com.jack.awty.database.Station;

import java.util.List;

public class StationsRepository {
	private DBInterface station_db_interface;
	private LiveData<List<String>> stations;
	
/*	Requesting the database package requires the database interface made from the database client
	extending the RoomDatabase abstract class, the creation of rest is handled by annotations,
	just like in Retrofit 2
 */
	public StationsRepository(Application application){
		Database db = Database.getInstance(application);
		station_db_interface = db.getDBInterface();
		stations = station_db_interface.getStations();
	}
	
	public LiveData<List<String>> getStations(){   return stations;    }
}
