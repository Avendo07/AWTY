package com.jack.awty.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stations")
public class Station {
	@PrimaryKey
	@NonNull
	String station_name;

	String line_color;
	
	Boolean isIntersection;
	
	public Station(String station_name){
		this.station_name = station_name;
	}
	
	public String getStation_name(){
		return this.station_name;
	}
}
