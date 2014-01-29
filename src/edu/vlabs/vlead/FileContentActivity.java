package edu.vlabs.vlead;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class FileContentActivity extends Activity {

	Intent mTerminalIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_content);
		mTerminalIntent = new Intent(this, MainActivity.class);
	}
	
	public void callTerminal(View view) {
		startActivity(mTerminalIntent);
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_content, menu);
		return true;
	}

}
