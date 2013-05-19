package net.sambla.fizzbuzzandroid;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import net.sambla.fizzbuzz.FizzBuzz;

public class GameMainActivity extends Activity implements OnClickListener {
	
	private TextView score;
	private TextView number;
	private TextView time;
	
	private Button btn_next;
	private Button btn_fizz;
	private Button btn_buzz;
	private Button btn_fizzbuzz;
	private Button btn_to_title;

	private int score_num = 0;
	private int time_num = 60;
	
	private Handler mHandler;
	private Timer timer;
	private TimerTask task;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_main);
		score=(TextView) findViewById(R.id.score);
		number=(TextView) findViewById(R.id.number);
		time=(TextView) findViewById(R.id.time);
		btn_next=(Button) findViewById(R.id.next);
		btn_next.setOnClickListener(this);
		btn_fizz=(Button) findViewById(R.id.fizz);
		btn_fizz.setOnClickListener(this);
		btn_buzz=(Button) findViewById(R.id.buzz);
		btn_buzz.setOnClickListener(this);
		btn_fizzbuzz=(Button) findViewById(R.id.fizzbuzz);
		btn_fizzbuzz.setOnClickListener(this);
		mHandler = new Handler();
		btn_to_title=(Button) findViewById(R.id.to_title);
		btn_to_title.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int add_score = 0;
		String answer="";
		switch(v.getId()){
		case R.id.next:
			answer=(String) number.getText();
			add_score = 1;
			break;
		case R.id.fizz:
			answer="Fizz";
			add_score = 3;
			break;
		case R.id.buzz:
			answer="Buzz";
			add_score = 5;
			break;
		case R.id.fizzbuzz:
			answer="FizzBuzz";
			add_score = 15;
			break;
		case R.id.to_title:
			Intent intent = new Intent(this, TitleActivity.class);
			startActivity(intent);
			finish();
		}
		
		if(answer.equals(FizzBuzz.fizzbuzz(Integer.parseInt((String) number.getText())))){
			score_num += add_score;
		}else{
			score_num -= 2;
			if(score_num < 0) score_num = 0;
		}
		number.setText(Integer.parseInt((String) number.getText()) + 1 + "");
		score.setText("score:"+score_num);
	}
	
   @Override
   public void onStop(){
	   super.onStop();
	   timer.cancel();
	   task=null;
   }
	
   @Override
   public void onResume(){
	   super.onResume();
	   timer_start();
   }
	private void timer_start(){
		timer = new Timer();
		task = new MyTimer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	private class MyTimer extends TimerTask {
		
		@Override
		public void run() {
			time_num--;
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					time.setText("time:"+time_num);
					if(time_num <= 0){
						timer.cancel();
						Intent intent = new Intent(GameMainActivity.this, GameOverActivity.class);
						intent.putExtra("score", score_num);
						startActivity(intent);
						finish();
					}
				}	
			});
		}
	}
}
