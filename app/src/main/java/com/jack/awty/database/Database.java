package com.jack.awty.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Station.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
	
	private static volatile Database INSTANCE;
	public abstract DBInterface getDBInterface();
	private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
		@Override
		public void onCreate(@NonNull SupportSQLiteDatabase db) {
			super.onCreate(db);
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			executorService.execute(() -> {
				//Insert the stations
				DBInterface dbInterface = INSTANCE.getDBInterface();
				List<Station> stations = new ArrayList<>();
				stations.add(new Station("Noida Sector 15"));
				stations.add(new Station("Noida Sector 16"));
				stations.add(new Station("Noida Sector 18"));
				dbInterface.insertStations(stations);
				Log.i("Add CallBack", "Finished");
			});
		}
	};
	
	//SingleTon Pattern
	public static Database getInstance(final Context context){
		if(INSTANCE == null){
			synchronized (Database.class){
				if(INSTANCE == null){
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "app_db")
							.addCallback(callback).build();
				}
			}
		}
		return INSTANCE;
	}
}