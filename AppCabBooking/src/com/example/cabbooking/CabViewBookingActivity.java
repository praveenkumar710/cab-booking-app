package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CabViewBookingActivity extends Activity {
	
	String did=null,dname=null,cno=null,email=null,lno=null;
	
	Button b1;
	
	private LinearLayout l2;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;	
	private Button b;
	
	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();	
	
	private ProgressDialog pDialog;    
	JSONParser jsonParser = new JSONParser();
	
	String ipaddress=null,url=null;
	
	final String TAG_SUCCESS = "success";
	final String TAG_DETAILS = "details";
	final String TAG_A1 = "a1";
	final String TAG_A2 = "a2";
	final String TAG_A3 = "a3";
	final String TAG_A4 = "a4";	
    final String TAG_A5 = "a5";	
	final String TAG_A6 = "a6";	
	final String TAG_A7 = "a7";	
	
	ProgressBar pb;
	Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_view_booking);
		 
		StrictMode.setThreadPolicy(policy);	
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>View Booking</font>"));
        
        ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidCabViewBooking.php";  
    	 		
		l2=(LinearLayout)findViewById(R.id.LinearLayout2);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			
	    		
		Intent i=getIntent();
	    did=i.getStringExtra("did");
	    dname=i.getStringExtra("dname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    lno=i.getStringExtra("lno");	
	    
	    new viewCabBooking().execute();	
	    
	    b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
			
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
	
	class viewCabBooking extends AsyncTask<String, String, String>
	{		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pDialog = new ProgressDialog(CabViewBookingActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
		
		protected String doInBackground(String... params) 
		{
			runOnUiThread(new Runnable() 
			{				
				public void run() 
				{			
					int success;
					
					try
					{	
						
						List<NameValuePair> params = new ArrayList<NameValuePair>();					
						
						String did1=did;						
						
						params.add((NameValuePair) new BasicNameValuePair("did", did1));						
							
						JSONObject json = jsonParser.makeHttpRequest(url, "GET", (List<org.apache.http.NameValuePair>)params);
				
						success = json.getInt(TAG_SUCCESS);
									
						if (success == 1) 
						{													
							JSONArray sarray = json.getJSONArray(TAG_DETAILS); 							
																											
							for(int i=0;i<sarray.length();i++)			        	        
							{									
								JSONObject sobject = sarray.getJSONObject(i);
								
								//final String a1=sobject.getString(TAG_A1);
								
								//final String a1=String.valueOf(sobject.getInt(TAG_A1));	
								final String a1=sobject.getString(TAG_A1);
								final String a2=sobject.getString(TAG_A2);
								final String a3=sobject.getString(TAG_A3);
								final String a4=sobject.getString(TAG_A4);	
								final String a5=sobject.getString(TAG_A5);
								final String a6=sobject.getString(TAG_A6);
								final String a7=sobject.getString(TAG_A7);
								
								tv1=new TextView(CabViewBookingActivity.this);
								tv1.setId(1);
								tv1.setText("Booking No : "+a1);
								tv1.setTextSize(12);							
								tv1.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv1);						
								
								tv2=new TextView(CabViewBookingActivity.this);
								tv2.setId(2);
								tv2.setText("Pickup Date : "+a2);
								tv2.setTextSize(12);
								tv2.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv2);
									
								tv3=new TextView(CabViewBookingActivity.this);
								tv3.setId(3);
								tv3.setText("Pickup Time : "+a3);
								tv3.setTextSize(12);
								tv3.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv3);	
								
								tv4=new TextView(CabViewBookingActivity.this);
								tv4.setId(4);
								tv4.setText("Customer Name : "+a4);
								tv4.setTextSize(12);
								tv4.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv4);
								
								tv5=new TextView(CabViewBookingActivity.this);
								tv5.setId(5);
								tv5.setText("Contact No : "+a5);
								tv5.setTextSize(12);
								tv5.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv5);
								
								tv6=new TextView(CabViewBookingActivity.this);
								tv6.setId(6);
								tv6.setText("City Name : "+a6);
								tv6.setTextSize(12);
								tv6.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv6);
								
								tv7=new TextView(CabViewBookingActivity.this);
								tv7.setId(7);
								tv7.setText("Area Name : "+a7);
								tv7.setTextSize(12);
								tv7.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv7);
								
								b=new Button(CabViewBookingActivity.this);
								b.setId(8);								
								b.setText("View Customer");
								b.setTextSize(12);	
								b.setWidth(100);
								b.setHeight(30);
								b.setBackgroundColor(Color.parseColor("#33FF00"));
								l2.addView(b);
								
								b.setOnClickListener(new View.OnClickListener() {									
									@Override
									public void onClick(View v) {
																				
										Intent i=new Intent(getApplicationContext(),CabViewBooking1Activity.class);
										i.putExtra("did",did);
										i.putExtra("dname",dname);							
										i.putExtra("cno",cno);
										i.putExtra("email",email);	
										i.putExtra("lno",lno);	
										
										i.putExtra("bid",a1);
										i.putExtra("pdate",a2);
										i.putExtra("ptime",a3);
										i.putExtra("cname",a4);
										i.putExtra("cno1",a5);
										i.putExtra("cityname",a6);
										i.putExtra("aname",a7);
										
										startActivity(i);
										
									}
								});
							}							
										
						}
						else
						{
							
						}
					} 
					catch (JSONException e) 
					{
						e.printStackTrace();
					}
			
				}
			});

			return null;
		}

		protected void onPostExecute(String file_url) 
		{			
			pDialog.dismiss();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cab_view_booking, menu);
		return true;
	}

}
