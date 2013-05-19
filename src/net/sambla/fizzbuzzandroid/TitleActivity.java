package net.sambla.fizzbuzzandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TitleActivity extends Activity implements OnClickListener{
	
	private Button game_start;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title);
		
		game_start=(Button) findViewById(R.id.start_game);
		game_start.setOnClickListener(this);
		
	}
		
		
	@Override
	public void onClick(View v) {
		if(v == game_start){
			Intent intent = new Intent(this, GameMainActivity.class);
			startActivity(intent);
		}
	}

		
}
