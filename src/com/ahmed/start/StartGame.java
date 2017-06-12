package com.ahmed.start;

import com.ahmed.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class StartGame extends Activity {

	ImageButton imgBtn = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
		
		
		imgBtn = (ImageButton)findViewById(R.id.imageBtnStart);
		imgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), com.ahmed.choose.ComputerOrHuman.class));
				
			}
		});
		
	}

}
