package com.ahmed.machine;

import com.ahmed.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MachineLevels extends Activity {

	
	public static TextView compLev2 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_machine_levels);
		
		
		
		
		
		findViewById(R.id.compLevel1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), PlayMachine.class));
			}
		});
		
		compLev2 = (TextView) findViewById(R.id.compLevel2);
		
        if (PlayMachine.status.equals("unlocked")) {
        	compLev2.setText("Level2");
        }
		compLev2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//compLev2.getTag().equals("unlocked")
				if (PlayMachine.status.equals("unlocked")) {
					startActivity(new Intent(getApplicationContext(), PlayMachineLevel2.class));
				}
				else{
					Toast.makeText(getApplicationContext(), "Locked uptill now ", Toast.LENGTH_SHORT).show();
					MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.error);
					mediaPlayer.start();
				}
				
			}
		});
		
	}
}
