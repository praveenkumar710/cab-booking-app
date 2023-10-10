package com.example.cabbooking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerCabBookingActivity extends Activity {
	
	String cid=null,cname=null,cno=null,email=null;
	
	Button b1;
	
	private LinearLayout l2;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6;	
	private Button b;
	private ImageView iv1;
	
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
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_cab_booking);
	    
		StrictMode.setThreadPolicy(policy);		
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Booking</font>"));
        
    	ipaddress=getString(R.string.ipconfig);
    	url="http://"+ipaddress+"/ACabBooking/androidViewCabType.php";    	
        		
		l2=(LinearLayout)findViewById(R.id.LinearLayout2);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			
	     
	     Intent i=getIntent();
	     cid=i.getStringExtra("cid");
	     cname=i.getStringExtra("cname");
	     cno=i.getStringExtra("cno");
	     email=i.getStringExtra("email");
	     
	     new viewCabType().execute();	
	     
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
	
	class viewCabType extends AsyncTask<String, String, String>
	{		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pDialog = new ProgressDialog(CustomerCabBookingActivity.this);
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
						
						String cityname="cityname";						
						
						params.add((NameValuePair) new BasicNameValuePair("cityname", cityname));						
							
						JSONObject json = jsonParser.makeHttpRequest(url, "GET", (List<org.apache.http.NameValuePair>)params);
				
						success = json.getInt(TAG_SUCCESS);
									
						if (success == 1) 
						{													
							JSONArray sarray = json.getJSONArray(TAG_DETAILS); 							
																											
							for(int i=0;i<sarray.length();i++)			        	        
							{									
								JSONObject sobject = sarray.getJSONObject(i);
								
								//final String a1=String.valueOf(sobject.getInt(TAG_A1));
								
								final String a1=sobject.getString(TAG_A1);
								final String a2=sobject.getString(TAG_A2);
								final String a3=sobject.getString(TAG_A3);
								final String a4=sobject.getString(TAG_A4);	
								final String a5=sobject.getString(TAG_A5);
								final String a6=sobject.getString(TAG_A6);
								final String a7=sobject.getString(TAG_A7);
								
								tv1=new TextView(CustomerCabBookingActivity.this);
								tv1.setId(1);
								tv1.setText("City Name : "+a1);
								tv1.setTextSize(12);							
								tv1.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv1);						
								
								tv2=new TextView(CustomerCabBookingActivity.this);
								tv2.setId(2);
								tv2.setText("Cab Type : "+a2);
								tv2.setTextSize(12);
								tv2.setTextColor(Color.parseColor("#000000"));
								l2.addView(tv2);
								
								iv1=new ImageView(CustomerCabBookingActivity.this);
								iv1.setId(3);
								URL url = new URL("http://"+ipaddress+"/ACabBooking/"+a3);								
								Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
								iv1.setImageBitmap(bmp);
								l2.addView(iv1);
								
								tv3=new TextView(CustomerCabBookingActivity.this);
								tv3.setId(4);
								tv3.setText("Minimum Charge : "+a4);
								tv3.setTextSize(12);
								tv3.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv3);	
								
								tv4=new TextView(CustomerCabBookingActivity.this);
								tv4.setId(5);
								tv4.setText("Free KMs : "+a5);
								tv4.setTextSize(12);
								tv4.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv4);
								
								tv5=new TextView(CustomerCabBookingActivity.this);
								tv5.setId(6);
								tv5.setText("Waiting Charge : "+a6);
								tv5.setTextSize(12);
								tv5.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv5);
								
								tv6=new TextView(CustomerCabBookingActivity.this);
								tv6.setId(7);
								tv6.setText("Extra Per KM : "+a7);
								tv6.setTextSize(12);
								tv6.setTextColor(Color.parseColor("#000000"));								
								l2.addView(tv6);
								
								b=new Button(CustomerCabBookingActivity.this);
								b.setId(8);								
								b.setText("Booking");
								b.setTextSize(12);	
								b.setWidth(100);
								b.setHeight(30);
								b.setBackgroundColor(Color.parseColor("#33FF00"));
								l2.addView(b);
								
								b.setOnClickListener(new View.OnClickListener() {									
									@Override
									public void onClick(View v) {																			
										Intent i = new Intent(getApplicationContext(),CustomerCabBooking1Activity.class);
										i.putExtra("cityname",a1);	
										i.putExtra("cabtype",a2);
											
										i.putExtra("cid",cid);
										i.putExtra("cname",cname);
										i.putExtra("cno",cno);
										i.putExtra("email",email);
										startActivity(i);
									}
								});
							}							
										
						}
						else
						{
							Toast.makeText(getApplication(), "Cab Details Not Found", 200).show();							
						}
					} 
					catch (JSONException e) 
					{
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_cab_booking, menu);
		return true;
	}

}
