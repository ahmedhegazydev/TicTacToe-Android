package com.ahmed.win;

import com.ahmed.choose.ComputerOrHuman;
import com.ahmed.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class WinGame extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win_game);
		
		findViewById(R.id.home).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), com.ahmed.choose.ComputerOrHuman.class));
				
			}
		});
		
		
	}

}
