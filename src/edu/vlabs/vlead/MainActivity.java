package edu.vlabs.vlead;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	private static final String TAG = "LinuxLab";

	Process          mProcess;
	DataInputStream  mIn;
	DataOutputStream mOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "LinuxLab Activity rocking!!");

//		JNIHelper.nativeChangeDir("/");

		try {
			mProcess = new ProcessBuilder()
					.command("su")
					.redirectErrorStream(true).start();

			mIn  = new DataInputStream(mProcess.getInputStream());
			mOut = new DataOutputStream(mProcess.getOutputStream());
		} catch (Exception e) {
			Log.d(TAG, e.getMessage());
		}
	}
	
	public void executeCommand(View view) {
		byte   buffer[]   = new byte[4096];
		String output     = new String("");
		int    numRead;
		
		try{
			EditText commandText = (EditText) findViewById(R.id.command);
			EditText resultText  = (EditText) findViewById(R.id.result);
			
			String message = commandText.getText().toString();
			
			mOut.writeBytes(message+"\n");
            mOut.flush();
            
            while(mIn.available() > 0)
            {
            	numRead = mIn.read(buffer);
                output  += new String(buffer, 0, numRead);
            }
            Log.d(TAG, output);
            resultText.setText(output);
            
		} catch(Exception e){
			Log.d(TAG, e.getMessage());
		}
	}

	protected void onDestroy() {
		super.onDestroy();
		if (mProcess != null) {
			mProcess.destroy();
			try {
				mIn.close();
				mOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static {
		System.loadLibrary("LinuxLab");
	}
}
