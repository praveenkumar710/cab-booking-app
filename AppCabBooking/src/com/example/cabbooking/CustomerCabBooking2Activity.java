package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerCabBooking2Activity extends Activity {
	
	EditText t1,t2,t3;	
	Button b1;
	
	String cid=null,cname=null,cno=null,email=null;	
	String cityname=null,cabtype=null;
	
	String parea=null,darea=null,pdate=null,ptime=null;
	
	String url=null,ipaddress=null;	    
    ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_cab_booking2);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Booking</font>"));
        
        ipaddress=getString(R.string.ipconfig);
        url="http://"+ipaddress+"/ACabBooking/androidCabBooking.php";
        
        Intent i=getIntent();
	    cid=i.getStringExtra("cid");
	    cname=i.getStringExtra("cname");
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    
	    cityname=i.getStringExtra("cityname");
	    cabtype=i.getStringExtra("cabtype");
	    
	    parea=i.getStringExtra("parea");
	    darea=i.getStringExtra("darea");
	    pdate=i.getStringExtra("pdate");
	    ptime=i.getStringExtra("ptime");
	    
	    t1=(EditText)findViewById(R.id.et1);
		t2=(EditText)findViewById(R.id.et2);
		t3=(EditText)findViewById(R.id.et3);
		
		t1.setText(parea);
		t2.setText(pdate);
		t3.setText(ptime);
		
		 b1=(Button)findViewById(R.id.btn1);
		 b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cabBooking l=new cabBooking();
				l.execute(url); 
				
			}
		});
	}
	
	public class cabBooking extends AsyncTask<String, String, String>
	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(CustomerCabBooking2Activity.this);
			pd.setMessage("Processing...");
			pd.setMax(100);
			pd.setCancelable(false);
			pd.setIndeterminate(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) 
		{
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("cid",cid));			
			param.add(new BasicNameValuePair("cname",cname));					
			param.add(new BasicNameValuePair("cno",cno));
			param.add(new BasicNameValuePair("email",email));
			param.add(new BasicNameValuePair("cityname",cityname));
			param.add(new BasicNameValuePair("cabtype",cabtype));
			param.add(new BasicNameValuePair("parea",parea));
			param.add(new BasicNameValuePair("darea",darea));
			param.add(new BasicNameValuePair("pdate",pdate));
			param.add(new BasicNameValuePair("ptime",ptime));
			
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
							String msg="\nCab Booking Service:\nDear,"+cname+" Your Cab Booking Successfully.\n";
         					SmsManager smsManager = SmsManager.getDefault();
         					smsManager.sendTextMessage(cno, null, msg, null, null);
							
							Toast.makeText(getApplicationContext(), "Cab Booking Successfully", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(), CustomerCabBookingFinalActivity.class);
							i.putExtra("cid",cid);
							i.putExtra("cname",cname);
							i.putExtra("cno",cno);
							i.putExtra("email",email);
							startActivity(i);
						}
						else if(s==2)
						{							
							Toast.makeText(getApplicationContext(), "Already Cab Booking..!", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(), CustomerHomeActivity.class);
							i.putExtra("cid",cid);
							i.putExtra("cname",cname);
							i.putExtra("cno",cno);
							i.putExtra("email",email);
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
		getMenuInflater().inflate(R.menu.customer_cab_booking2, menu);
		return true;
	}

}
