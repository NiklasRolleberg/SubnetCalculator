package niklas.subnetcalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	private CheckBox ipBox;
	private CheckBox netMaskBox;
	private CheckBox subNetBitsBox;
	private CheckBox maskBitsBox;
	private CheckBox maximumSubnetsBox;
	private CheckBox hostsPerSubnetBox;
	
	private EditText ipAddress;
	
	private Spinner subnetMask;
	private Spinner subnetBits;
	private Spinner maskBits;
	private Spinner maxSubNet;
	private Spinner hostsPerSubnet;
	
	private Button cal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setContentView(R.layout.resultlayout);
		/*
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
		
		
		/**Initiate all checkboxes and textfields etc.*/
		
		ipBox = (CheckBox) findViewById(R.id.checkBox_IpAddress);
		netMaskBox = (CheckBox) findViewById(R.id.checkBox_NetMask);
		subNetBitsBox = (CheckBox) findViewById(R.id.checkBox_SubnetBits);
		maskBitsBox = (CheckBox) findViewById(R.id.checkBox_MaskBits);
		maximumSubnetsBox = (CheckBox) findViewById(R.id.checkBox_MaxSubnet);
		hostsPerSubnetBox = (CheckBox) findViewById(R.id.checkBox_HostPerSubnet);
		
		ipAddress = (EditText) findViewById(R.id.IpAddress);
		
		subnetMask = (Spinner) findViewById(R.id.Spinner_NetMask);
		subnetBits = (Spinner) findViewById(R.id.spinner_SubnetBits);
		maskBits = (Spinner) findViewById(R.id.spinner_MaskBits);
		maxSubNet = (Spinner) findViewById(R.id.spinner_MaxSubnet);
		hostsPerSubnet = (Spinner) findViewById(R.id.spinner_HostPerSubnet);
		
		cal = (Button) findViewById(R.id.button1);
		
		/**Add drop down lists*/
		
		ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this,R.array.SubnetMask_DropDown,
				android.R.layout.simple_spinner_item);
		adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		subnetMask.setAdapter(adapter0);
		
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.SubnetBits_DropDown,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		subnetBits.setAdapter(adapter1);
		
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.MaskBits_DropDown,
				android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		maskBits.setAdapter(adapter2);
		
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.MaxSubnets_DropDown,
				android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		maxSubNet.setAdapter(adapter3);
		
		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,R.array.HostsPerSubnet_DropDown,
				android.R.layout.simple_spinner_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		hostsPerSubnet.setAdapter(adapter4);
		
		/**Add clickListener*/
		cal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Calculate();
            }
        });
	}
	
	
	/**Check if data given is OK and calculate subnet stuff*/
	private void Calculate() {
		
		/*Beräkna massa saker*/
		
		
		/*klar med beräkningar*/
		String Ip = "172.16.0.1";
		String SubnetMask = "255.255.240.0";
		String SubnetBits = "4";
		String MaximumSubnets = "16";
		
		//String FOR = "128-191";
		//String Hex
		
		String MaskBits = "20";
		String HostsPerSubnet = "4094";
		String HostAddressRange = "172.16.0.1-172.16.15.254";
		String SubnetID = "172.16.0.0";
		String BroadCastAddress = "172.16.15.255";
		
		Intent myIntent = new Intent(this.getBaseContext(), ResultActivity.class);
		
		myIntent.putExtra("Ip", Ip);
		myIntent.putExtra("SubnetMask", SubnetMask);
		myIntent.putExtra("SubnetBits", SubnetBits);
		myIntent.putExtra("MaximumSubnets", MaximumSubnets);
		
		myIntent.putExtra("MaskBits", MaskBits);
		myIntent.putExtra("HostsPerSubnet", HostsPerSubnet);
		myIntent.putExtra("HostAddressRange", HostAddressRange);
		myIntent.putExtra("SubnetID", SubnetID);
		myIntent.putExtra("BroadCastAddress",BroadCastAddress);
		
    	startActivityForResult(myIntent, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
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
