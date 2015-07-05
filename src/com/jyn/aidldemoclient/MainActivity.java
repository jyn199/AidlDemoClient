package com.jyn.aidldemoclient;

import com.jyn.aidl.Demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	Demo demo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		Intent intent = new Intent("com.jyn.aidldemoservice.DemoService");
		bindService(intent, new MyServiceConnection(), BIND_AUTO_CREATE);
		System.out.println(demo);
//		invokeRemoteMethod();
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("onResume");
	}
	
	private void invokeRemoteMethod(){
		try {
			System.out.println(demo.getDemo());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private final class MyServiceConnection implements android.content.ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			//这个方法是在onResume之后才调用的
			demo = Demo.Stub.asInterface(arg1);
			System.out.println("test==========");
			System.out.println(demo);
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
