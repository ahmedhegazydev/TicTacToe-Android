package com.ahmed.human;

import com.ahmed.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class HumanLevels extends Activity {

	public static TextView level2 = null;
	static String text = "";
	public static boolean b = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_human_levels);
		
		
		
		findViewById(R.id.humLevel1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(HumanLevels.this, PlayHuman.class));
				
			}
		});
		
		level2  = (TextView) findViewById(R.id.humLevel2);
		
		if (PlayHuman.status.equals("unlocked")) {
			level2.setText("Level2");
		}
		
		level2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Intent intent = getIntent();
				//if (intent.getStringExtra("locked").equals("NO")) {
				if (PlayHuman.status.equals("unlocked")) {
					startActivity(new Intent(HumanLevels.this, PlayHumanLevel2.class));
				}
				else{
					Toast.makeText(getApplicationContext(), "Sorry is locked untill now ", Toast.LENGTH_SHORT).show();
					MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.error);
					mediaPlayer.start();
				}
				
				
				
			}
		});
		
	}
}
