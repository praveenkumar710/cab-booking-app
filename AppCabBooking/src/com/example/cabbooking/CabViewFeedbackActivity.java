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
import android.widget.Toast;

public class CabViewFeedbackActivity extends Activity {
	
	String did=null,dname=null,cno=null,email=null,lno=null;
	
	Button b1;
	
	private LinearLayout l2;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;	
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
	final String TAG_A8 = "a8";	
	final String TAG_A9 = "a9";	
	
	ProgressBar pb;
	Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_view_feedback);
		
		StrictMode.setThreadPolicy(policy);	
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>View Feedback</font>"));
        
        ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidCabViewPayment1.php";  
    	 		
		l2=(LinearLayout)findViewById(R.id.LinearLayout2);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		Intent i=getIntent();
	    did=i.getStringExtra("did");
	    dname=i.getStringExtra("dname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    lno=i.getStringExtra("lno");
	    
	    new viewPaymentDetails().execute();	
	    
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
	
	class viewPaymentDetails extends AsyncTask<String, String, String>
	{		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pDialog = new ProgressDialog(CabViewFeedbackActivity.this);
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
								final String a8=sobject.getString(TAG_A8);
								final String a9=sobject.getString(TAG_A9);
																
								tv1=new TextView(CabViewFeedbackActivity.this);
								tv1.setId(1);
								tv1.setText("Booking No : "+a1);
								tv1.setTextSize(12);							
								tv1.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv1);						
								
								tv2=new TextView(CabViewFeedbackActivity.this);
								tv2.setId(2);
								tv2.setText("Customer Name : "+a2);
								tv2.setTextSize(12);
								tv2.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv2);
									
								tv3=new TextView(CabViewFeedbackActivity.this);
								tv3.setId(3);
								tv3.setText("Contact No : "+a3);
								tv3.setTextSize(12);
								tv3.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv3);	
								
								tv4=new TextView(CabViewFeedbackActivity.this);
								tv4.setId(4);
								tv4.setText("City Name : "+a4);
								tv4.setTextSize(12);
								tv4.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv4);
								
								tv5=new TextView(CabViewFeedbackActivity.this);
								tv5.setId(5);
								tv5.setText("Cab Type : "+a5);
								tv5.setTextSize(12);
								tv5.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv5);
								
								tv6=new TextView(CabViewFeedbackActivity.this);
								tv6.setId(6);
								tv6.setText("Pickup Area : "+a6);
								tv6.setTextSize(12);
								tv6.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv6);
								
								tv7=new TextView(CabViewFeedbackActivity.this);
								tv7.setId(7);
								tv7.setText("Pickup Date/Time : "+a7);
								tv7.setTextSize(12);
								tv7.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv7);
								
								tv8=new TextView(CabViewFeedbackActivity.this);
								tv8.setId(8);
								tv8.setText("Drop Area : "+a8);
								tv8.setTextSize(12);
								tv8.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv8);
								
								tv9=new TextView(CabViewFeedbackActivity.this);
								tv9.setId(9);
								tv9.setText("Drop Date/Time : "+a9);
								tv9.setTextSize(12);
								tv9.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv9);
								
								b=new Button(CabViewFeedbackActivity.this);
								b.setId(10);								
								b.setText("View Feedback");
								b.setTextSize(12);	
								b.setWidth(100);
								b.setHeight(30);
								b.setBackgroundColor(Color.parseColor("#58548c"));
								l2.addView(b);
								
								b.setOnClickListener(new View.OnClickListener() {									
									@Override
									public void onClick(View v) {																			
										Intent i = new Intent(getApplicationContext(),CabViewFeedback1Activity.class);
										i.putExtra("bid",a1);	
										i.putExtra("cname",a2);	
										i.putExtra("ccno",a3);	
										
										i.putExtra("did",did);
										i.putExtra("dname",dname);							
										i.putExtra("cno",cno);
										i.putExtra("email",email);
										i.putExtra("lno",lno);	
										startActivity(i);
									}
								});						
								
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
		getMenuInflater().inflate(R.menu.cab_view_feedback, menu);
		return true;
	}

}
