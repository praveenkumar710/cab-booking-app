package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.cabbooking.CabChangePasswordActivity.cabPassword;

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

public class CustomerChangePasswordActivity extends Activity {
	
	String cid=null,cname=null,cno=null,email=null;
	
	Button b1,b2;
	EditText t1,t2,t3;	
	
	String url=null,ipaddress=null;	
	ProgressDialog pd;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_change_password);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));  
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Change Password</font>"));
        
        ipaddress=getString(R.string.ipconfig);
        url="http://"+ipaddress+"/ACabBooking/androidCustomerChangePassword.php";
        
        Intent i=getIntent();
	    cid=i.getStringExtra("cid");
	    cname=i.getStringExtra("cname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    
	    t1=(EditText)findViewById(R.id.et1);
		t2=(EditText)findViewById(R.id.et2);
		t3=(EditText)findViewById(R.id.et3);
		
		b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String npass=t2.getText().toString();
				String cpass=t3.getText().toString();
				
				if (t1.getText().toString().length() == 0) {
                    t1.setError("Enter Current Password");
                    t1.requestFocus();
                }
				else if (t2.getText().toString().length() == 0) {
                    t2.setError("Enter New Password");
                    t2.requestFocus();
                }
				else if (t3.getText().toString().length() == 0) {
                    t3.setError("Enter Confirm Password");
                    t3.requestFocus();
                }
				else if(!npass.equals(cpass))
				{
					t3.setError("Confirm Password Mismatch");
                    t3.requestFocus();
				}
				else {
					changePassword l=new changePassword();
					l.execute(url); 
							
				}	
			}
		});
        
        b2=(Button)findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(),CustomerHomeActivity.class);
				i.putExtra("cid",cid);
				i.putExtra("cname",cname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);	
				startActivity(i);		
								
			}
		});     
	}
	
	public class changePassword extends AsyncTask<String, String, String>
	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(CustomerChangePasswordActivity.this);
			pd.setMessage("Processing...");
			pd.setMax(100);
			pd.setCancelable(false);
			pd.setIndeterminate(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) 
		{
			String opass=t1.getText().toString();
			String npass=t2.getText().toString();
			
			List<NameValuePair> param=new ArrayList<NameValuePair>();
					
			param.add(new BasicNameValuePair("cid",cid));
			param.add(new BasicNameValuePair("opass",opass));			
			param.add(new BasicNameValuePair("npass",npass));
			
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
							Toast.makeText(getApplicationContext(), "Password Change Successfully", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(),CustomerHomeActivity.class);
							i.putExtra("cid",cid);
							i.putExtra("cname",cname);							
							i.putExtra("cno",cno);
							i.putExtra("email",email);	
							startActivity(i);	
						}						
						else
						{
							Toast.makeText(getApplicationContext(), "Your Old Password Incorrect", Toast.LENGTH_SHORT).show();							
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
		getMenuInflater().inflate(R.menu.customer_change_password, menu);
		return true;
	}

}
