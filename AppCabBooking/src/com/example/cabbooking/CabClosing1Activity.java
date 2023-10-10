package com.example.cabbooking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CabClosing1Activity extends Activity {
	
	EditText t1,t2,t3,t4,t5,t6,t7;	
	Button b2,b3;
	
	String did=null,dname=null,cno=null,email=null,lno=null;
	
	String bid=null,pdate=null,ptime=null,cname=null,cno1=null,cityname=null,aname=null;
	
	Button b1;
	
	String ipaddress=null,url=null;
	ProgressDialog pd;
	
	 GPSTracker gps;
	 private double latitude;
     private double longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_closing1);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Closing</font>"));
        
        ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidCabDropCustomer.php"; 
    	
    	Intent i=getIntent();
	    did=i.getStringExtra("did");
	    dname=i.getStringExtra("dname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    lno=i.getStringExtra("lno");
	    
	    bid=i.getStringExtra("bid");
	    pdate=i.getStringExtra("pdate");
	    ptime=i.getStringExtra("ptime");
	    cname=i.getStringExtra("cname");
	    cno1=i.getStringExtra("cno1");
	    cityname=i.getStringExtra("cityname");
	    aname=i.getStringExtra("aname");
	    
	    t1=(EditText)findViewById(R.id.et1);
		t2=(EditText)findViewById(R.id.et2);
		t3=(EditText)findViewById(R.id.et3);
		t4=(EditText)findViewById(R.id.et4);
		t5=(EditText)findViewById(R.id.et5);
		t6=(EditText)findViewById(R.id.et6);
		t7=(EditText)findViewById(R.id.et7);
		
		t1.setText(bid);
		t2.setText(pdate);
		t3.setText(ptime);
		t4.setText(cname);
		t5.setText(cno1);
		
		b2=(Button)findViewById(R.id.btn2);
		 b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (t6.getText().toString().length() == 0) {
                    t6.setError("Enter Total Distance KM");
                    t6.requestFocus();
                }
				else if (t7.getText().toString().length() == 0) {
                    t7.setError("Enter Wating Time");
                    t7.requestFocus();
                }
				else
				{
				gps = new GPSTracker(CabClosing1Activity.this);    				
  		        if(gps.canGetLocation())
  		        {		        	
  		        	latitude = gps.getLatitude();
  		        	longitude = gps.getLongitude();    
  		        	
  		        	Geocoder geocoder = new Geocoder(CabClosing1Activity.this, Locale.getDefault());
  		        	List<Address> addresses;
  					try 
  					{
  						addresses = geocoder.getFromLocation(latitude, longitude, 1);
  						
  						//cityName = addresses.get(0).getLocality();						
  						
  						//String cityName = addresses.get(0).getAddressLine(0);
  			        	//String stateName = addresses.get(0).getAddressLine(1);
  			        	//String countryName = addresses.get(0).getAddressLine(2);	        	
  			        	//Toast.makeText(getApplicationContext(), "Your City Name is:"+cityName, Toast.LENGTH_LONG).show();	
  			        	
  					} 
  					catch (IOException e) 
  					{
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  		        }
  		        else
		        {    		        	
		        	gps.showSettingsAlert();
		        }
				
				cabDropCustomer l=new cabDropCustomer();
				l.execute(url); 
				}
			}
		});
		 
		 b3=(Button)findViewById(R.id.btn3);
	        b3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),CabHomeActivity.class);
					i.putExtra("did",did);
					i.putExtra("dname",dname);							
					i.putExtra("cno",cno);
					i.putExtra("email",email);	
					i.putExtra("lno",lno);	
					startActivity(i);		
					
				}
			});
	    
	}
	
	public class cabDropCustomer extends AsyncTask<String, String, String>
	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(CabClosing1Activity.this);
			pd.setMessage("Processing...");
			pd.setMax(100);
			pd.setCancelable(false);
			pd.setIndeterminate(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) 
		{
			
			String tkm=t6.getText().toString();
			String twcharge=t7.getText().toString();
			
			String v1=Double.toString(latitude);
			String v2=Double.toString(longitude);
			
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("bid",bid));			
			param.add(new BasicNameValuePair("did",did));
			param.add(new BasicNameValuePair("tkm",tkm));
			param.add(new BasicNameValuePair("twcharge",twcharge));
			
			param.add(new BasicNameValuePair("latvalue",v1));
			param.add(new BasicNameValuePair("longvalue",v2));
			
			JSONParser jp=new JSONParser();
			JSONObject obj=jp.makeHttpRequest(url, "POST", param);
			//Log.d("JSON", obj.toString());
			try 
			{
				final int s=obj.getInt("success");
				//Log.d("int", ""+s);
				
				runOnUiThread( new Runnable() 
				{
					public void run() 
					{
						if(s==1)
						{							
							Toast.makeText(getApplicationContext(), "Customer Drop Successfully", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(),CabHomeActivity.class);
							i.putExtra("did",did);
							i.putExtra("dname",dname);							
							i.putExtra("cno",cno);
							i.putExtra("email",email);	
							i.putExtra("lno",lno);	
							startActivity(i);	
						}						
						else
						{
							Toast.makeText(getApplicationContext(), "Failed to Created", Toast.LENGTH_SHORT).show();
							
						}
					}
				});
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(pd!=null && pd.isShowing())
				pd.dismiss();
		}		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cab_closing1, menu);
		return true;
	}

}
