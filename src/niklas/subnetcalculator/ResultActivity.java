package niklas.subnetcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	String Ip;
	String SubnetMask;
	String SubnetBits;
	String MaximumSubnets;
	
	//String FOR = "128-191";
	//String Hex
	
	String MaskBits;
	String HostsPerSubnet;
	String HostAddressRange;
	String SubnetID;
	String BroadCastAddress;
	
	TextView iPAddress;
	TextView netMask;
	TextView subnetBits;
	TextView maskBits;
	TextView maxSubnets;
	TextView HPS;
	TextView HAR;
	TextView subID;
	TextView broadCastAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.resultlayout);
		
		Ip = getIntent().getExtras().getString("Ip");
		SubnetMask = getIntent().getExtras().getString("SubnetMask");
		SubnetBits = getIntent().getExtras().getString("SubnetBits");
		MaximumSubnets = getIntent().getExtras().getString("MaximumSubnets");
		
		MaskBits = getIntent().getExtras().getString("MaskBits");
		HostsPerSubnet = getIntent().getExtras().getString("HostsPerSubnet");
		HostAddressRange = getIntent().getExtras().getString("HostAddressRange");
		SubnetID = getIntent().getExtras().getString("SubnetID");
		BroadCastAddress = getIntent().getExtras().getString("BroadCastAddress");
		
		iPAddress = (TextView) findViewById(R.id.textView_IP);
		netMask = (TextView) findViewById(R.id.textView_SubnetMask);
		subnetBits = (TextView) findViewById(R.id.textView_SubnetBits);
		maskBits = (TextView) findViewById(R.id.textView_MaskBits);
		maxSubnets = (TextView) findViewById(R.id.textView_MaximumSubnets);
		HPS = (TextView) findViewById(R.id.textView_HostPerSubnet);
		HAR = (TextView) findViewById(R.id.textView_HostAddressRange);
		subID = (TextView) findViewById(R.id.textView_SubnetID);
		broadCastAddress = (TextView) findViewById(R.id.textView_BroadcastAddress);
		
		iPAddress.setText(Ip);
		netMask.setText(SubnetMask);
		subnetBits.setText(SubnetBits);
		maskBits.setText(MaskBits);
		maxSubnets.setText(MaximumSubnets);
		HPS.setText(HostsPerSubnet);
		HAR.setText(HostAddressRange);
		subID.setText(SubnetID);
		broadCastAddress.setText(BroadCastAddress);
		
		
	}
	
	/**Keeps the up button from reseting activity*/
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

}
