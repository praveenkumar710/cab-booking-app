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

public class CabViewFeedback1Activity extends Activity {
	
	String did=null,dname=null,cno=null,email=null,lno=null;
	
	String bid=null,cname=null,ccno=null;
	
	Button b1;
	
	private LinearLayout l2;
	private TextView tv1,tv2;	
			
	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();	
	
	private ProgressDialog pDialog;    
	JSONParser jsonParser = new JSONParser();
	
	String ipaddress=null,url=null;
	
	final String TAG_SUCCESS = "success";
	final String TAG_DETAILS = "details";
	final String TAG_A1 = "a1";
	final String TAG_A2 = "a2";	
	
	ProgressBar pb;
	Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_view_feedback1);
		
		StrictMode.setThreadPolicy(policy);	
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>View Feedback</font>"));
        
        ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidCabViewFeedback.php"; 
    	
    	l2=(LinearLayout)findViewById(R.id.LinearLayout2);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
    	
    	Intent i=getIntent();
	    did=i.getStringExtra("did");
	    dname=i.getStringExtra("dname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    lno=i.getStringExtra("lno");
	    
	    bid=i.getStringExtra("bid");
	    cname=i.getStringExtra("cname");
	    ccno=i.getStringExtra("ccno");
	    
	    new cabViewFeedback().execute();	
	    
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
	
	class cabViewFeedback extends AsyncTask<String, String, String>
	{		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pDialog = new ProgressDialog(CabViewFeedback1Activity.this);
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
						params.add((NameValuePair) new BasicNameValuePair("bid", bid));
						params.add((NameValuePair) new BasicNameValuePair("cname", cname));
							
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
																								
								tv1=new TextView(CabViewFeedback1Activity.this);
								tv1.setId(1);
								tv1.setText("Customer Name : "+a1);
								tv1.setTextSize(12);							
								tv1.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv1);						
								
								tv2=new TextView(CabViewFeedback1Activity.this);
								tv2.setId(2);
								tv2.setText("Feedback : "+a2);
								tv2.setTextSize(12);
								tv2.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv2);								
								
							}							
										
						}
						else if(success == 2)
						{
							Toast.makeText(getApplication(), "Customer No Feedback Send", 200).show();							
							
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
		getMenuInflater().inflate(R.menu.cab_view_feedback1, menu);
		return true;
	}

}
