package com.example.cabbooking;

import java.util.ArrayList;
import java.util.HashMap;
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
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CabServiceActivity extends Activity {
	
	Button b1,b2,b3;
	EditText t1,t2;
	
	String lid,lpass;	
	String url=null,ipaddress=null;	
	ProgressDialog pd;
	ArrayList<HashMap<String, String>> list;
	JSONObject obj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_service);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));  
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Service</font>"));
        
        ipaddress=getString(R.string.ipconfig);
        url="http://"+ipaddress+"/ACabBooking/androidLoginDriver.php";
        
        t1=(EditText)findViewById(R.id.cno);
		t2=(EditText)findViewById(R.id.lpass);
        
        b1=(Button)findViewById(R.id.signin);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (t1.getText().toString().length() == 0) {
                    t1.setError("Enter Conatc No");
                    t1.requestFocus();
                }
				else if (t2.getText().toString().length() == 0) {
                    t2.setError("Enter Login Password");
                    t2.requestFocus();
                }
				else {
					
					loginDriver l = new loginDriver();
					l.execute(url);		
				}	
			}
		});
        
        b2=(Button)findViewById(R.id.signup);
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(),CabRegisterActivity.class);	
				startActivity(i);
								
			}
		});
        
        b3=(Button)findViewById(R.id.back);
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				Intent i=new Intent(getApplicationContext(),ServiceActivity.class);	
				startActivity(i);				
			}
		});
	}
	
	public class loginDriver extends AsyncTask<String, String, String>
	{
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(CabServiceActivity.this);
			pd.setTitle("Signin...");
			pd.setMax(100);
			pd.setCancelable(false);
			pd.setIndeterminate(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			lid=t1.getText().toString();
            lpass=t2.getText().toString();
			
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("lid", lid));
			param.add(new BasicNameValuePair("lpass", lpass));
			
			list=new ArrayList<HashMap<String,String>>();
			JSONParser jp=new JSONParser();
			obj=jp.makeHttpRequest(url, "POST", param);			
			Log.d("JSON", obj.toString());
			
			runOnUiThread(new Runnable() {				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						
						if(obj.getInt("success")==1)
						{
							
							String did=obj.getString("did").toString();	
							String dname=obj.getString("dname").toString();								
							String cno=obj.getString("cno").toString();	
							String email=obj.getString("email").toString();	
							String lno=obj.getString("lno").toString();								
							
							Toast.makeText(CabServiceActivity.this, "Welcome, "+dname, 200).show();
							Intent i = new Intent(CabServiceActivity.this,CabHomeActivity.class);
							i.putExtra("did",did);
							i.putExtra("dname",dname);							
							i.putExtra("cno",cno);
							i.putExtra("email",email);
							i.putExtra("lno",lno);							
							startActivity(i);
						}
						else if(obj.getInt("success")==2)
						{
							Toast.makeText(CabServiceActivity.this, "Your Account Not Activate...!", 200).show();
							
							Intent i=new Intent(CabServiceActivity.this,ServiceActivity.class);	
							startActivity(i);	
						}
						else
						{
							Toast.makeText(CabServiceActivity.this, "Incorrect Contact No and Password...!", 200).show();
						}						
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
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
		getMenuInflater().inflate(R.menu.cab, menu);
		return true;
	}

}
