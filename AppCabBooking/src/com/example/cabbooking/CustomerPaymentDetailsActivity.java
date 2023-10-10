package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerPaymentDetailsActivity extends Activity {
	
	String cid=null,cname=null,cno=null,email=null;
	
	Button b1;
	
	private LinearLayout l2;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17;	
		
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
	final String TAG_A8 = "a8";	
	final String TAG_A9 = "a9";	
	final String TAG_A10 = "a10";	
	final String TAG_A11 = "a11";	
	final String TAG_A12 = "a12";	
	final String TAG_A13 = "a13";	
	final String TAG_A14 = "a14";	
	final String TAG_A15 = "a15";	
	final String TAG_A16 = "a16";	
	final String TAG_A17 = "a17";	
		
	ProgressBar pb;
	Dialog dialog;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_payment_details);
		
		StrictMode.setThreadPolicy(policy);	
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>View Payment Details</font>"));
        
        Intent i=getIntent();
	    cid=i.getStringExtra("cid");
	    cname=i.getStringExtra("cname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");	
	    
	    ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidCustomerViewPayment.php";  
    	 		
		l2=(LinearLayout)findViewById(R.id.LinearLayout2);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			
		new viewPaymentDetails().execute();		    
	    
	    b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),CustomerHomeActivity.class);
				i.putExtra("cid",cid);
				i.putExtra("cname",cname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);	
				startActivity(i);	
				
			}
		});
	}
	
	class viewPaymentDetails extends AsyncTask<String, String, String>
	{		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pDialog = new ProgressDialog(CustomerPaymentDetailsActivity.this);
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
						
						String cid1=cid;						
						
						params.add((NameValuePair) new BasicNameValuePair("cid", cid1));						
							
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
								final String a8=sobject.getString(TAG_A8);
								final String a9=sobject.getString(TAG_A9);
								final String a10=sobject.getString(TAG_A10);
								final String a11=sobject.getString(TAG_A11);
								final String a12=sobject.getString(TAG_A12);
								final String a13=sobject.getString(TAG_A13);
								final String a14=sobject.getString(TAG_A14);
								final String a15=sobject.getString(TAG_A15);
								final String a16=sobject.getString(TAG_A16);
								final String a17=sobject.getString(TAG_A17);
								
								tv1=new TextView(CustomerPaymentDetailsActivity.this);
								tv1.setId(1);
								tv1.setText("Booking No : "+a1);
								tv1.setTextSize(12);							
								tv1.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv1);						
								
								tv2=new TextView(CustomerPaymentDetailsActivity.this);
								tv2.setId(2);
								tv2.setText("Driver Name : "+a2);
								tv2.setTextSize(12);
								tv2.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv2);
									
								tv3=new TextView(CustomerPaymentDetailsActivity.this);
								tv3.setId(3);
								tv3.setText("Contact No : "+a3);
								tv3.setTextSize(12);
								tv3.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv3);	
								
								tv4=new TextView(CustomerPaymentDetailsActivity.this);
								tv4.setId(4);
								tv4.setText("City Name : "+a4);
								tv4.setTextSize(12);
								tv4.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv4);
								
								tv5=new TextView(CustomerPaymentDetailsActivity.this);
								tv5.setId(5);
								tv5.setText("Cab Type : "+a5);
								tv5.setTextSize(12);
								tv5.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv5);
								
								tv6=new TextView(CustomerPaymentDetailsActivity.this);
								tv6.setId(6);
								tv6.setText("Pickup Area : "+a6);
								tv6.setTextSize(12);
								tv6.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv6);
								
								tv7=new TextView(CustomerPaymentDetailsActivity.this);
								tv7.setId(7);
								tv7.setText("Pickup Date/Time : "+a7);
								tv7.setTextSize(12);
								tv7.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv7);
								
								tv8=new TextView(CustomerPaymentDetailsActivity.this);
								tv8.setId(8);
								tv8.setText("Drop Area : "+a8);
								tv8.setTextSize(12);
								tv8.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv8);
								
								tv9=new TextView(CustomerPaymentDetailsActivity.this);
								tv9.setId(9);
								tv9.setText("Drop Date/Time : "+a9);
								tv9.setTextSize(12);
								tv9.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv9);
								
								tv10=new TextView(CustomerPaymentDetailsActivity.this);
								tv10.setId(10);
								tv10.setText("Minimum Charge : "+a10);
								tv10.setTextSize(12);
								tv10.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv10);
								
								tv11=new TextView(CustomerPaymentDetailsActivity.this);
								tv11.setId(11);
								tv11.setText("Free KM : "+a11);
								tv11.setTextSize(12);
								tv11.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv11);
								
								tv12=new TextView(CustomerPaymentDetailsActivity.this);
								tv12.setId(12);
								tv12.setText("Waiting Charge : "+a12);
								tv12.setTextSize(12);
								tv12.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv12);
								
								tv13=new TextView(CustomerPaymentDetailsActivity.this);
								tv13.setId(13);
								tv13.setText("Extra Charge: "+a13);
								tv13.setTextSize(12);
								tv13.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv13);
								
								tv14=new TextView(CustomerPaymentDetailsActivity.this);
								tv14.setId(14);
								tv14.setText("Total KM : "+a14);
								tv14.setTextSize(12);
								tv14.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv14);
								
								tv15=new TextView(CustomerPaymentDetailsActivity.this);
								tv15.setId(15);
								tv15.setText("Total Waiting Charge : "+a15);
								tv15.setTextSize(12);
								tv15.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv15);
								
								tv16=new TextView(CustomerPaymentDetailsActivity.this);
								tv16.setId(16);
								tv16.setText("Total Amount : "+a16);
								tv16.setTextSize(12);
								tv16.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv16);
								
								tv17=new TextView(CustomerPaymentDetailsActivity.this);
								tv17.setId(17);
								tv17.setText("Status : "+a17);
								tv17.setTextSize(12);
								tv17.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv17);
								
							}							
										
						}
						else if(success == 2)
						{
							Toast.makeText(getApplication(), "Cab Payment Not Found", 200).show();							
							
						}
						else
						{
							Toast.makeText(getApplication(), "Cab Payment Not Found", 200).show();							
							
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
		getMenuInflater().inflate(R.menu.customer_payment_details, menu);
		return true;
	}

}
