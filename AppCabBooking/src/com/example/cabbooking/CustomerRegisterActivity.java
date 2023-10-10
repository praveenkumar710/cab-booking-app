package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.SmsManager;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomerRegisterActivity extends Activity {
	
	EditText t1,t2,t3,t4,t5;
	Spinner s1,s2,s3;	
	Button b1,b2,b3;
	
	String url=null,ipaddress=null;	
    String name,gender,cno,email,city,state,address,pcode,skey; 
    ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_register);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Customer Register</font>"));
        
        ipaddress=getString(R.string.ipconfig);
        url="http://"+ipaddress+"/ACabBooking/androidCreateCustomer.php";
        
        t1=(EditText)findViewById(R.id.name);
		t2=(EditText)findViewById(R.id.cno);
		t3=(EditText)findViewById(R.id.emailid);
		t4=(EditText)findViewById(R.id.address);
		t5=(EditText)findViewById(R.id.pcode);		
		
		s1=(Spinner)findViewById(R.id.gender);
		s2=(Spinner)findViewById(R.id.city);
		s3=(Spinner)findViewById(R.id.state);
		
		List<String> gender = new ArrayList<String>();
		gender.add("Select Gender");
		gender.add("Male");
        gender.add("Female");
        
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter1);
        
        List<String> city = new ArrayList<String>();
		city.add("Select City");
		city.add("Salem");        
        city.add("Chennai");
        city.add("Bangalore");
        city.add("Coimbatore");
        city.add("Pondicherry");
        
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter2);
        
        List<String> state = new ArrayList<String>();
		state.add("Select State");
		state.add("TamilNadu");        
        state.add("Kerala");       
        
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, state);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(dataAdapter3);
        
        b1=(Button)findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (t1.getText().toString().length() == 0) {
                    t1.setError("Enter Customer Name");
                    t1.requestFocus();
                }							
				else if (s1.getSelectedItem().equals("Select Gender")) {
	               	 Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_SHORT).show();                   
	            }				
				else if (t2.getText().toString().length() == 0) {
                    t2.setError("Enter Contact Number");
                    t2.requestFocus();
                }
				else if (t3.getText().toString().length() == 0) {
                    t3.setError("Enter E-Mail ID");
                    t3.requestFocus();
                }
				else if (s2.getSelectedItem().equals("Select City")) {
	               	 Toast.makeText(getApplicationContext(), "Please Select City", Toast.LENGTH_SHORT).show();                   
	            }
				else if (s3.getSelectedItem().equals("Select State")) {
	               	 Toast.makeText(getApplicationContext(), "Please Select State", Toast.LENGTH_SHORT).show();                   
	            }
				else if (t4.getText().toString().length() == 0) {
                    t4.setError("Enter Address");
                    t4.requestFocus();
                }
				
				else if (t5.getText().toString().length() == 0) {
                    t5.setError("Enter Pincode");
                    t5.requestFocus();
                }				
				else {	
					createCustomer l=new createCustomer();
					l.execute(url);  													
				}	
								
			}
		});
        
        b2=(Button)findViewById(R.id.reset);
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
								
			}
		});
        
        b3=(Button)findViewById(R.id.back);
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				Intent i=new Intent(getApplicationContext(),CabServiceActivity.class);	
				startActivity(i);				
			}
		});
	}
	public class createCustomer extends AsyncTask<String, String, String>
	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(CustomerRegisterActivity.this);
			pd.setMessage("Please Wait...");
			pd.setMax(100);
			pd.setCancelable(false);
			pd.setIndeterminate(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			name=t1.getText().toString();			
			gender=s1.getSelectedItem().toString();				
			cno=t2.getText().toString();
			email=t3.getText().toString();				
			city=s2.getSelectedItem().toString();
			state=s3.getSelectedItem().toString();
			address=t4.getText().toString();			
			pcode=t5.getText().toString();
			
			//SKey
			Random random = new Random();
			int lpass = random.nextInt(10000);
			skey=Integer.toString(lpass);	
						
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("name",name));			
			param.add(new BasicNameValuePair("gender",gender));					
			param.add(new BasicNameValuePair("cno",cno));
			param.add(new BasicNameValuePair("email",email));
			param.add(new BasicNameValuePair("city",city));
			param.add(new BasicNameValuePair("state",state));
			param.add(new BasicNameValuePair("address",address));
			param.add(new BasicNameValuePair("pcode",pcode));
			param.add(new BasicNameValuePair("skey",skey));
			
			JSONParser jp=new JSONParser();
			JSONObject obj=jp.makeHttpRequest(url, "POST", param);
			Log.d("JSON", obj.toString());
			try 
			{
				final int s=obj.getInt("success");
				Log.d("int", ""+s);
				runOnUiThread( new Runnable() 
				{
					public void run() 
					{
						if(s==1)
						{
							String msg="\nCab Booking Service:\nDear,"+name+" Your Account Created Successfully.\n"+"Login Password:"+skey+"\n";
         					SmsManager smsManager = SmsManager.getDefault();
         					smsManager.sendTextMessage(cno, null, msg, null, null);
							
							Toast.makeText(getApplicationContext(), "Customer Register Successfully", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(), CustomerActivity.class);
							startActivity(i);
						}
						else if(s==2)
						{							
							Toast.makeText(getApplicationContext(), "Customer Already Register...!", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(getApplicationContext(), CustomerActivity.class);
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
		getMenuInflater().inflate(R.menu.customer_register, menu);
		return true;
	}

}
