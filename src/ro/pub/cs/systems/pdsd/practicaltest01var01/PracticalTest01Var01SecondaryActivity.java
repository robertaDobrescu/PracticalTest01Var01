package ro.pub.cs.systems.pdsd.practicaltest01var01;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PracticalTest01Var01SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_secondary);
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		
		Intent intent = getIntent();
		if (intent != null)
			tv.setText(intent.getStringExtra(PrcaticalTest01Var01MainActivity.EXTRA).toString());
	}
	
	public void click_ok(View view) {
		setResult(RESULT_OK);
		finish();
	}
	
	public void click_cancel(View view) {
		setResult(RESULT_CANCELED);
		finish();	
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var01_secondary, menu);
		return true;
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
