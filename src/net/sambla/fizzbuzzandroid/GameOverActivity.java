package net.sambla.fizzbuzzandroid;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends Activity implements OnClickListener {

	private Button title;
	private TextView game_over;
	private TextView result;
	private TextView rank;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_over);

		title=(Button) findViewById(R.id.start_game);
		title.setOnClickListener(this);
		game_over=(TextView) findViewById(R.id.game_title);
		result = (TextView) findViewById(R.id.result);
		rank = (TextView) findViewById(R.id.rank);

		Intent intent = getIntent();
		int score = intent.getExtras().getInt("score");
		result.setText("Score:"+score);

		if(score < 10){
			rank.setText("Rank:Fool!");
		}else if(score < 20){
			rank.setText("Rank:Too Bad!");
		}else if(score < 50){
			rank.setText("Rank:Bad!");
		}else if(score < 120){
			rank.setText("Rank:Not Bad.");
		}else if(score < 150){
			rank.setText("Rank:Good.");
		}else if(score < 200){
			rank.setText("Rank:Great!");
		}else if(score == 255){
			rank.setText("11111111");
		}else if(score < 300){
			rank.setText("Rank:You are FizzBuzzMaster!");
		}else if(score < 350){
			rank.setText("Rank:Oh my god!");
		}else{
			rank.setText("Good Cheat.");
		}
	}

	@Override
	public void onClick(View v) {
		if(v == title){
			Intent intent = new Intent(this, TitleActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
		}
	}

}
