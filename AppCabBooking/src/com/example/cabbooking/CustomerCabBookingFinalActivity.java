package com.example.cabbooking;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CustomerCabBookingFinalActivity extends Activity {
	
	String cid=null,cname=null,cno=null,email=null;
	
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_cab_booking_final);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Booking</font>"));
		
		Intent i=getIntent();
	    cid=i.getStringExtra("cid");
	    cname=i.getStringExtra("cname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
		
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_cab_booking_final, menu);
		return true;
	}

}
