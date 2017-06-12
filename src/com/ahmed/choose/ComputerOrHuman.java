package com.ahmed.choose;

import com.ahmed.human.HumanLevels;
import com.ahmed.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ComputerOrHuman extends Activity {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/** Called when the activity is first created. */
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_computer_or_human);
		
		
		
		Button humanBtn = (Button) findViewById(R.id.human);
		
		humanBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(ComputerOrHuman.this, HumanLevels.class));
				
			}
		});
		
		Button machineBtn = (Button) findViewById(R.id.machine);
		machineBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(ComputerOrHuman.this, com.ahmed.machine.MachineLevels.class));
				
			}
		});
		
		
	}

	
	
	
	
	
	
}
