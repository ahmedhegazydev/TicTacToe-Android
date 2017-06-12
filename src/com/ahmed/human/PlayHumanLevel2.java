package com.ahmed.human;

import java.util.ArrayList;
import java.util.Timer;

import com.ahmed.tictactoe.R;
import com.ahmed.win.WinGame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import android.widget.*;
//import android.view.*;


public class PlayHumanLevel2 extends Activity implements OnClickListener{

	
    Button withHuman, withComputer = null;
    int playerI = 0, playerII = 0;
	Button ib1, ib2, ib3, ib4, ib5, ib6, ib7, ib8, ib9;
    ArrayList<Button> newList = new ArrayList<Button>();
    boolean lock = true;
    TextView scoreTv = null;
    private String[][] arrOf_X_O = new String[3][3];
    int c = 0;
    ArrayList<Button> temp = new ArrayList<Button>();
    int delay = 1000;
    int period = 1000;
    static int interval = 10;//seconds 
    static Timer timer = null;
    TextView timerTv = null;
    Handler handler = null;
    boolean locker = true;
    int i = 10;
    
    
    
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_human_level2);
		
		
		
		//***********************************************************************
		timerTv = (TextView) findViewById(R.id.timer);
//		timer = new Timer();
//	    timer.scheduleAtFixedRate(new TimerTask() {
//	        public void run() {
//	        	timerTv.setText(""+setInterval());
//	        }
//	    }, delay, interval);
		
		handler = new Handler();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//for (int i = 10; i >= 0; i--) {
				
				while (locker){
					//final int l = i;
					handler.post(new Runnable() {
						
						@Override
						public void run() {
							
							timerTv.setText(i+"");
							if (i == 3) {
								timerTv.setTextColor(Color.YELLOW);
								//Start wrning 
							}
							if (i == 0) {
								finish();
								Intent intent = new Intent(PlayHumanLevel2.this, com.ahmed.choose.ComputerOrHuman.class);
								startActivity(intent);
								
								
							}
							
							i--;
							
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		///&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

		
	    
	    
		
		for (int h = 0; h < 3; h++) {
			for (int j = 0; j < 3; j++) {
				arrOf_X_O[h][j] = "";
				
			}
		}
		
		
		
		ib1 = (Button) findViewById(R.id.button1);
        ib1.setTag("00");
        ib2 = (Button) findViewById(R.id.button2);
        ib2.setTag("01");
        ib3 = (Button) findViewById(R.id.button3);
        ib3.setTag("02");
        ib4 = (Button) findViewById(R.id.button4);
        ib4.setTag("10");
        ib5 = (Button) findViewById(R.id.button5);
        ib5.setTag("11");
        ib6 = (Button) findViewById(R.id.button6);
        ib6.setTag("12");
        ib7 = (Button) findViewById(R.id.button7);
        ib7.setTag("20");
        ib8 = (Button) findViewById(R.id.button8);
        ib8.setTag("21");
        ib9 = (Button) findViewById(R.id.button9);
        ib9.setTag("22");

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);
        ib7.setOnClickListener(this);
        ib8.setOnClickListener(this);
        ib9.setOnClickListener(this);




        newList.add(ib1);
        newList.add(ib2);
        newList.add(ib3);
        newList.add(ib4);
        newList.add(ib5);
        newList.add(ib6);
        newList.add(ib7);
        newList.add(ib8);
        newList.add(ib9);

        
//        for (int k = 0; k < 9; k++) {
//			newList.get(k).setBackgroundResource(R.drawable.background_color);
//		}
        
        
		
	}
	
	
	
	
//	
//	private static final int setInterval() {
//	    if (interval == 1)
//	        timer.cancel();
//	    return --interval;
//	}
	
	

	public void clearText (){
		
		ib1.setText(null);
		ib2.setText(null);
		ib3.setText(null);
		ib4.setText(null);
		ib5.setText(null);
		ib6.setText(null);
		ib7.setText(null);
		ib8.setText(null);
		ib9.setText(null);
		
		
		
	}
	
	@Override
	public void onClick(View v) {
		
		for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).getTag().equals(v.getTag()) && lock){
                newList.get(i).setTextColor(Color.MAGENTA);
                newList.get(i).setText("X");
                String tag = (String) newList.get(i).getTag();
                int iTag = Integer.valueOf(tag.substring(0, 1)), jTag = Integer.valueOf(tag.substring(1, 2));
                insertXo(iTag, jTag, "X");
                temp.add(newList.get(i));
                newList.remove(i);
                
                lock = false;
                 

            }else{
                if (newList.get(i).getTag().equals(v.getTag())){

                    newList.get(i).setTextColor(Color.RED);
                    newList.get(i).setText("O");
                    String tag = (String) newList.get(i).getTag();
                    int iTag = Integer.valueOf(tag.substring(0, 1)), jTag = Integer.valueOf(tag.substring(1, 2));
                    insertXo(iTag, jTag, "O");
                    temp.add(newList.get(i));
                    newList.remove(i);
                    lock = true;

                }
            }
        }
		
		
		if (horizontallyO(arrOf_X_O) || verticalyO(arrOf_X_O) || crossO(arrOf_X_O)){
//            playerII++;
//            scoreTv.setText("Player 1 = " + playerI + " | " + "Player 2 = "+ playerII);
            
            
//            Intent intent = getIntent();
//            finish();
//            startActivity(intent);
//            clearText();
//            arrOf_X_O = new String[3][3];            
//            if (playerII == 3){
                Toast.makeText(PlayHumanLevel2.this, "The O is win , Yahoooooooooooo", Toast.LENGTH_SHORT).show();
                locker = false;
                
                //finish();
                //startActivity(new Intent(PlayHumanLevel2.this, ComputerOrHuman.class));
//                playerI = playerII = 0;
//            }

        }else{
        	
        	if (newList.isEmpty()) {
            	//Intent intent = getIntent();
        		Intent intent = new Intent(PlayHumanLevel2.this, PlayHuman.class);
                finish();
                startActivity(intent);
			}
            
        }

        if (horizontallyX(arrOf_X_O) || verticallyX(arrOf_X_O) || crossX(arrOf_X_O)){

            //playerI++;
            //scoreTv.setText("Player 1 = " + playerI + " | " + "Player 2 = "+ playerII);
            
//            clearText();
//            arrOf_X_O = new String[3][3];
//            Intent intent  = getIntent();
//            finish();
//            startActivity(intent);
//            if (playerI == 3){
                Toast.makeText(PlayHumanLevel2.this, "The X is win , Yahoooooooooooo", Toast.LENGTH_SHORT).show();
                locker = false;
                //finish();
                //startActivity(new Intent(PlayHumanLevel2.this, ComputerOrHuman.class));
//                playerI = playerII = 0;
//            }

        }else{
        	
            if (newList.isEmpty()) {
            	
            	//Intent intent = getIntent();
        		Intent intent = new Intent(PlayHumanLevel2.this, PlayHuman.class);
                finish();
                startActivity(intent);
                
                
			}
            
          }
        
        
		
		
	}
	
	
	//Handler handler = new Handler();
	ArrayList<Button> listForHandler = new ArrayList<Button>();
	
	public void colorBtnHandler (final ArrayList<Button> list){
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					final int g = i;
					handler.post(new Runnable() {			
						@Override
						public void run() {
							list.get(g).setBackgroundColor(Color.GRAY);
							MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.hit);
							mp.start();
							if (g == 2) {
				                finish();
				                //startActivity(new Intent(PlayHumanLevel2.this, ComputerOrHuman.class));
				                startActivity(new Intent(PlayHumanLevel2.this, WinGame.class));
							}
						}
					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
	 public boolean horizontallyX (String[][] strings){
         if (strings[0][0].equals("X") && strings[0][1].equals("X") && strings[0][2].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
  				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("01") | temp.get(i).getTag().equals("02")) {
  					//temp.get(i).setBackgroundColor(Color.GRAY);
  					listForHandler.add(temp.get(i));
  				}
  			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[1][0].equals("X") && strings[1][1].equals("X") && strings[1][2].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
   				if (temp.get(i).getTag().equals("10") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("12")) {
   					//temp.get(i).setBackgroundColor(Color.GRAY);
   					listForHandler.add(temp.get(i));
   				}
   			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[2][0].equals("X") && strings[2][1].equals("X") && strings[2][2].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
   				if (temp.get(i).getTag().equals("20") || temp.get(i).getTag().equals("21") | temp.get(i).getTag().equals("22")) {
   					//temp.get(i).setBackgroundColor(Color.GRAY);
   					listForHandler.add(temp.get(i));
   				}
   			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;

     }

     public boolean horizontallyO (String[][] strings){
         if (strings[0][0].equals("O") && strings[0][1].equals("O") && strings[0][2].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
   				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("01") | temp.get(i).getTag().equals("02")) {
   					//temp.get(i).setBackgroundColor(Color.GRAY);
   					listForHandler.add(temp.get(i));
   				}
   			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[1][0].equals("O") && strings[1][1].equals("O") && strings[1][2].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("10") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("12")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    		}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[2][0].equals("O") && strings[2][1].equals("O") && strings[2][2].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("20") || temp.get(i).getTag().equals("21") | temp.get(i).getTag().equals("22")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    		}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;

     }

     public boolean verticallyX (String[][] strings){
         if (strings[0][0].equals("X") && strings[1][0].equals("X") && strings[2][0].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("10") | temp.get(i).getTag().equals("20")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][1].equals("X") && strings[1][1].equals("X") && strings[2][1].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("01") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("21")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][2].equals("X") && strings[1][2].equals("X") && strings[2][2].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("02") || temp.get(i).getTag().equals("12") | temp.get(i).getTag().equals("22")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;

     }

     public boolean verticalyO (String[][] strings){
         if (strings[0][0].equals("O") && strings[1][0].equals("O") && strings[2][0].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("10") | temp.get(i).getTag().equals("20")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][1].equals("O") && strings[1][1].equals("O") && strings[2][1].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("01") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("21")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][2].equals("O") && strings[1][2].equals("O") && strings[2][2].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("02") || temp.get(i).getTag().equals("12") | temp.get(i).getTag().equals("22")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;

     }

     public boolean crossX (String[][] strings){
         if (strings[0][0].equals("X") && strings[1][1].equals("X") && strings[2][2].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("22")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][2].equals("X") && strings[1][1].equals("X") && strings[2][0].equals("X")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("02") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("20")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;
     }

     public boolean crossO (String[][] strings){
         if (strings[0][0].equals("O") && strings[1][1].equals("O") && strings[2][2].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("00") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("22")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         if (strings[0][2].equals("O") && strings[1][1].equals("O") && strings[2][0].equals("O")){
        	 for (int i = 0; i < temp.size(); i++) {
    				if (temp.get(i).getTag().equals("02") || temp.get(i).getTag().equals("11") | temp.get(i).getTag().equals("20")) {
    					//temp.get(i).setBackgroundColor(Color.GRAY);
    					listForHandler.add(temp.get(i));
    				}
    			}
        	 colorBtnHandler(listForHandler);
             return true;
         }
         return false;
     }
     
     
     
     public void insertXo (int iTag, int jTag, String str){
    	 for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == iTag && j == jTag) {
					arrOf_X_O[i][j] = str;
				}
			}
		}
     }
     
     
     


     
     
     
	
	
}
