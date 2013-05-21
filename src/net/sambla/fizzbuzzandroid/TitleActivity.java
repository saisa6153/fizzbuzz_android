package net.sambla.fizzbuzzandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TitleActivity extends Activity implements OnClickListener{

	private Button game_start;
	private TextView highscore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title);

		game_start=(Button) findViewById(R.id.start_game);
		game_start.setOnClickListener(this);
		highscore=(TextView) findViewById(R.id.highscore);
		SharedPreferences pre = getSharedPreferences("fizzbazz", MODE_WORLD_READABLE);
		if(pre.getInt("highscore", -1)==-1){
			Editor editor = pre.edit();
			editor.putInt("highscore", 0);
			editor.commit();
		}
		highscore.setText("high score:"+pre.getInt("highscore", 0));

	}


	@Override
	public void onClick(View v) {
		if(v == game_start){
			Intent intent = new Intent(this, GameMainActivity.class);
			startActivity(intent);
		}
	}


}
