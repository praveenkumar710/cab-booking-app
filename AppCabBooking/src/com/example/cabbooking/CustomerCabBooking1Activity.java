package com.example.cabbooking;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomerCabBooking1Activity extends Activity {
	
	EditText t1,t2;
	Spinner s1,s2;	
	Button b1;
	
	String cid=null,cname=null,cno=null,email=null;	
	String cityname=null,cabtype=null;
	
	String parea=null,darea=null,pdate=null,ptime=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_cab_booking1);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Booking</font>"));
        
        Intent i=getIntent();
	    cid=i.getStringExtra("cid");
	    cname=i.getStringExtra("cname");
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    
	    cityname=i.getStringExtra("cityname");
	    cabtype=i.getStringExtra("cabtype");
	    
	    t1=(EditText)findViewById(R.id.et1);
		t2=(EditText)findViewById(R.id.et2);
		
		s1=(Spinner)findViewById(R.id.sp1);
		s2=(Spinner)findViewById(R.id.sp2);
		
		List<String> pa = new ArrayList<String>();
		pa.add("Pickup Area");
		pa.add("Area 24-A");
        pa.add("Area 24-B");
        pa.add("Area 24-c");
        
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pa);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter1);
        
        List<String> da = new ArrayList<String>();
        da.add("Drop Area");
        da.add("Area 24-A");
        da.add("Area 24-B");
        da.add("Area 24-c");
        
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, da);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter2);
        
        b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (s1.getSelectedItem().equals("Pickup Area")) {
	               	 Toast.makeText(getApplicationContext(), "Pickup Area", Toast.LENGTH_SHORT).show();                   
	            }
				else if (s2.getSelectedItem().equals("Drop Area")) {
	               	 Toast.makeText(getApplicationContext(), "Drop Area", Toast.LENGTH_SHORT).show();                   
	            }
				else if (t1.getText().toString().length() == 0) {
                    t1.setError("Enter Pickup Date");
                    t1.requestFocus();
                }
				else if (t2.getText().toString().length() == 0) {
                    t2.setError("Enter Pickup Time");
                    t2.requestFocus();
                }
				else
				{
					parea=s1.getSelectedItem().toString();
					darea=s2.getSelectedItem().toString();
					pdate=t1.getText().toString();
					ptime=t2.getText().toString();	
					
					Intent i = new Intent(getApplicationContext(),CustomerCabBooking2Activity.class);
					i.putExtra("cityname",cityname);	
					i.putExtra("cabtype",cabtype);						
					i.putExtra("cid",cid);
					i.putExtra("cname",cname);
					i.putExtra("cno",cno);
					i.putExtra("email",email);
					
					i.putExtra("parea",parea);
					i.putExtra("darea",darea);
					i.putExtra("pdate",pdate);
					i.putExtra("ptime",ptime);
					
					startActivity(i);
					
				}
				
			}
		});
		
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_cab_booking1, menu);
		return true;
	}

}
