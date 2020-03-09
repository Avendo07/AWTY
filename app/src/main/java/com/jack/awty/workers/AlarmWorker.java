package com.jack.awty.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.jack.awty.MainActivity;
import com.jack.awty.R;

public class AlarmWorker extends Worker {
	private static String TAG = "WorkManager : ";
	//Required Constructor
	public AlarmWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
		super(context, workerParams);
	}
	
	@NonNull
	@Override
	public Result doWork() {
		//TODO: Create a work
		//Get application context to indicate start with the application
		Context context = getApplicationContext();
		//Alarm work
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context, MainActivity.CHANNEL_ID)
													.setSubText("This is just to annoy you! uWu")
													.setContentTitle("ಠ_ಠ")
													.setSmallIcon(R.drawable.ic_awtyicon)
													.setPriority(NotificationCompat.PRIORITY_DEFAULT);
		NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
		notificationManagerCompat.notify((int)(Math.random()*100), builder.build());
		Log.d(TAG, "doWork: started");
		return Result.success();
	}
}
