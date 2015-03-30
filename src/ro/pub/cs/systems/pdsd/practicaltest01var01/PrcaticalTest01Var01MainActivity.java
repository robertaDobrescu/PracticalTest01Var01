package ro.pub.cs.systems.pdsd.practicaltest01var01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PrcaticalTest01Var01MainActivity extends Activity {

	private static final String EMAIL = "email";
	private static final String PHONE = "phone";
	private static final String MSG = "msg";
public static final String EXTRA = "extra";
	
	CheckBox cbEmail, cbPhone, cbMsg;
	EditText t;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prcatical_test01_var01_main);
		
		cbPhone = (CheckBox) findViewById(R.id.cb1);
		cbEmail = (CheckBox) findViewById(R.id.cb2);
		cbMsg = (CheckBox) findViewById(R.id.cb3);
		
		t = (EditText) findViewById(R.id.et1);
		
		Log.d("onCreate", "here");
		if (savedInstanceState == null)
			t.setText("0");
		else {
			cbPhone.setChecked(savedInstanceState.getBoolean(PHONE));
			cbEmail.setChecked(savedInstanceState.getBoolean(EMAIL));
			cbMsg.setChecked(savedInstanceState.getBoolean(MSG));
		}
		
		cbMsg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (cbMsg.isChecked()) {
					int val = Integer.parseInt(t.getText().toString());
					val++;
					t.setText(val + "");
				} else {
					int val = Integer.parseInt(t.getText().toString());
					val--;
					t.setText(val + "");
				}
				
			}
		});
		
		cbEmail.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if (cbEmail.isChecked()) {
							int val = Integer.parseInt(t.getText().toString());
							val++;
							t.setText(val + "");
						} else {
							int val = Integer.parseInt(t.getText().toString());
							val--;
							t.setText(val + "");
						}
						
					}
				});

		cbPhone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (cbPhone.isChecked()) {
					int val = Integer.parseInt(t.getText().toString());
					val++;
					t.setText(val + "");
				} else {
					int val = Integer.parseInt(t.getText().toString());
					val--;
					t.setText(val + "");
				}
				
			}
		});
	}
	
	public void to_second(View view) {
		Intent intent = new Intent(this, PracticalTest01Var01SecondaryActivity.class);
		String s = "";
		if (cbEmail.isChecked()) {
			s = s + "email, ";
		}
		if (cbPhone.isChecked()) {
			s = s + "phone, ";
			
		}
		if (cbMsg.isChecked()) {
			s = s + "instant messaging";
		}
		intent.putExtra(EXTRA, s);
		startActivityForResult(intent, 1);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		cbPhone = (CheckBox) findViewById(R.id.cb1);
		cbEmail = (CheckBox) findViewById(R.id.cb2);
		cbMsg = (CheckBox) findViewById(R.id.cb3);
		t = (EditText)  findViewById(R.id.et1);
		
		outState.putBoolean(EMAIL, cbEmail.isChecked());
		outState.putBoolean(MSG, cbMsg.isChecked());
		outState.putBoolean(PHONE, cbPhone.isChecked());
		//outState.putString("sum", t.getText().toString());
		Log.d("onSave", "here lala");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prcatical_test01_var01_main, menu);
		return true;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Toast.makeText(this, "Secondary returned " + resultCode, Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("onStop", "here");
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
