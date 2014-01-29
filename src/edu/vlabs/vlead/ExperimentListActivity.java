package edu.vlabs.vlead;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ExperimentListActivity extends ListActivity {

	ArrayList<HashMap<String,String>> mExpList;
	Intent mFileManagementIntent;
	Intent mTextEditorIntent;
	Intent mFileContentIntent;
	Intent mFilePermissionsIntent;
	Intent mArchivalAndCompressionIntent;
	Intent mObtainingSystemInformationIntent;
	Intent mPipesAndRedirectionIntent;
	Intent mSearchingIntent;
	Intent mBasicNetworkingIntent;
	
	final int ONE   = 0;
	final int TWO   = 1;
	final int THREE = 2;
	final int FOUR  = 3;
	final int FIVE  = 4;
	final int SIX   = 5;
	final int SEVEN = 6;
	final int EIGHT = 7;
	final int NINE  = 8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_experiment_list);
		
		mFileManagementIntent = new Intent(this, FileManagementActivity.class);
		mTextEditorIntent = new Intent(this, TextEditorActivity.class);
		mFileContentIntent = new Intent(this, FileContentActivity.class);
		mFilePermissionsIntent = new Intent(this, FilePermissionsActivity.class);
		mArchivalAndCompressionIntent = new Intent(this, ArchivalAndCompressionActivity.class);
		mObtainingSystemInformationIntent = new Intent(this, ObtainingSystemInformationActivity.class);
		mPipesAndRedirectionIntent = new Intent(this, PipesAndRedirectionActivity.class);
		mSearchingIntent = new Intent(this, SearchingActivity.class);
		mBasicNetworkingIntent = new Intent(this, BasicNetworkingActivity.class);
		mExpList = new ArrayList<HashMap<String,String>>();
		
	    SimpleAdapter adapter = new SimpleAdapter(
	    	this,
	    	mExpList,
	    	R.layout.custom_row_view,
	    	new String[] {"title","detail"},
	    	new int[] {R.id.title,R.id.detail}
	    );

	    populateList();
	    
	    setListAdapter(adapter);
	    
	}

    private void populateList() {
 
    	HashMap<String,String> temp1 = new HashMap<String,String>();
    	temp1.put("title","File Management");
    	temp1.put("detail", "File Management includes manipulation of data and files contained in a system. One may create, delete, move, copy, rename and perform many such operations on the files and directories. This experiment provides a brief overview of these basic commands which can be used in a Linux-based environment.");
    	mExpList.add(temp1);
    	
    	HashMap<String,String> temp2 = new HashMap<String,String>();
    	temp2.put("title","Text Editor");
    	temp2.put("detail", "This experiment introduces a console-based text editor called vim. Vim is a popular editor for editing text files such as computer programs as it has a lot of features such as syntax highlighting, line numbering, block operations and multi-level undo. To know more about vim, visit www.vim.org. To learn vim, most linux systems come with a tutorial called vimtutor. Just type vimtutor at the shell prompt to start the tutorial. After this experiment, learners are expected to go through vimtutor and complete the lessons there.");
    	mExpList.add(temp2);
    	
    	HashMap<String,String> temp3 = new HashMap<String,String>();
    	temp3.put("title","File Content");
    	temp3.put("detail", "This experiment describes various commands that perform different types of operations on file content such as listing, sorting, counting number of lines or words, etc. Various commands which can be used to display first few lines of a file, last few lines of a file, etc. are explained. Further, this experiment also explains commands which can be used to see contents of large text files in manageable way.");
    	mExpList.add(temp3);
    	
    	HashMap<String,String> temp4 = new HashMap<String,String>();
    	temp4.put("title","File Permissions");
    	temp4.put("detail", "This experiment is intended to provide an understanding of Linux file permissions. This experiment involves explanation of various command(s) which can be used to modify file permissions in Linux Operating System. The experimental platform for this experiment is a command line interface which mimics the terminal of a Linux machine. This interface is intended to help in learning the basics of file permissions. A set of tasks which can be performed on the available command-line interface have also been provided. This experiment is divided into various sections for ease of use. An objective section describes the objective of this experiment. A theory section provides necessary background and theory details for the experiment. An experiment section provides link to command-line interface along with a set of tasks to be performed. Quiz section contains questions to test the understanding of concepts covered as part of this experiment. Finally more reading material is suggested in further reading section. Users are welcome to submit any feedback related to this experiment using the feedback section. ");
    	mExpList.add(temp4);
    	
    	HashMap<String,String> temp5 = new HashMap<String,String>();
    	temp5.put("title","Archival and Compression");
    	temp5.put("detail", "File Compression and File Archiving are two different functions. File Archiving is useful when a number of files need to be combined into a single file. This is useful when the files need to be transferred or sent across e-mails. Compressions involves reducing the file size so as to save the disk space or to create backups of the data. ");
    	mExpList.add(temp5);
    	
    	HashMap<String,String> temp6 = new HashMap<String,String>();
    	temp6.put("title","Obtaining System Information");
    	temp6.put("detail", "This experiment explains you how to obtain the information related to system, processes and user's status. This also explains how to check that how much hardware resource has been utilized by the GNU/Linux Operating system which is currently used in the web based shell of the experiment which you are going to use. ");
    	mExpList.add(temp6);
    	
    	HashMap<String,String> temp7 = new HashMap<String,String>();
    	temp7.put("title","Pipes and Redirection");
    	temp7.put("detail", "Linux shell provides a number of commands that are focussed towards a specific and simple task. In practical applications, it is often required to perform complex tasks that involve multiple commands, with the output of one command being used as input in the execution of another command. In other words, one may need to manipulate the input and output of these commands. For this purpose, Linux shell provides Pipes and Redirection operators. ");
    	mExpList.add(temp7);
    	
    	HashMap<String,String> temp8 = new HashMap<String,String>();
    	temp8.put("title","Searching");
    	temp8.put("detail", "Searching is an essential functionality in any Operating System. Linux provides powerful utilities which not only searches for files and folders but also makes it easy to search for some text snippet within the content of the files in any directory. In this experiment, grep and find utilities have been explained. ");
    	mExpList.add(temp8);
    	
    	HashMap<String,String> temp9 = new HashMap<String,String>();
    	temp9.put("title","Basic Networking");
    	temp9.put("detail", "This experiment introduces basic networking-related commands so that users can work across multiple machines connected via network. Users will learn the following: \nWhat is an IP address\nHow to find current machine's IP address\nHow to check network connectivity\nHow to login to another machine connected via network\nHow to transfer files from one machine to another machine\nHow to synchronize files and directories across two machines on a network");
    	mExpList.add(temp9);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.experiment_list, menu);
		return true;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

	    super.onListItemClick(l, v, position, id);
	    
	    switch(position)
    	{
      		case ONE : 
      				startActivity(mFileManagementIntent);
      				break;
      	
      		case TWO : 
      				startActivity(mTextEditorIntent);
	  				break;
	  	
      		case THREE : 
      				startActivity(mFileContentIntent);
	  				break;
	  		
      		case FOUR : 
      				startActivity(mFilePermissionsIntent);
	  				break;
	  		
      		case FIVE : 
      				startActivity(mArchivalAndCompressionIntent);
	  				break;
	  		
      		case SIX : 
      				startActivity(mObtainingSystemInformationIntent);
	  				break;
	  		
      		case SEVEN : 
      				startActivity(mPipesAndRedirectionIntent);
      				break;
      				
      		case EIGHT : 
      				startActivity(mSearchingIntent);
  					break;
  					
      		case NINE : 
      				startActivity(mBasicNetworkingIntent);
  					break;
	  		
      		default :
      				break;
    	}
	}


}
