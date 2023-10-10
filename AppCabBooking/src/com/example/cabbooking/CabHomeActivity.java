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
import android.widget.TextView;

public class CabHomeActivity extends Activity {
	
	String did=null,dname=null,cno=null,email=null,lno=null;
	
	TextView t1;
	
	Button b1,b2,b3,b4,b5,b6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_home);
		
		Intent i=getIntent();
	    did=i.getStringExtra("did");
	    dname=i.getStringExtra("dname");	    
	    cno=i.getStringExtra("cno");
	    email=i.getStringExtra("email");
	    lno=i.getStringExtra("lno");	       
	     
	    t1=(TextView)findViewById(R.id.tv1);
	    t1.setText("Welcome, "+dname);
		
		ActionBar ab=getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efef26")));
        getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Cab Home</font>"));
        
        b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),CabViewBookingActivity.class);
				i.putExtra("did",did);
				i.putExtra("dname",dname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);
				i.putExtra("lno",lno);	
				startActivity(i);	
				
			}
		});
        
        b2=(Button)findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),CabClosingActivity.class);
				i.putExtra("did",did);
				i.putExtra("dname",dname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);
				i.putExtra("lno",lno);	
				startActivity(i);	
				
			}
		});
        
        b3=(Button)findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),CabPaymentDetailsActivity.class);
				i.putExtra("did",did);
				i.putExtra("dname",dname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);
				i.putExtra("lno",lno);	
				startActivity(i);	
				
			}
		});
        
        b4=(Button)findViewById(R.id.btn4);
        b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),CabViewFeedbackActivity.class);
				i.putExtra("did",did);
				i.putExtra("dname",dname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);
				i.putExtra("lno",lno);	
				startActivity(i);	
			
				
			}
		});
        
        b5=(Button)findViewById(R.id.btn5);
        b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),CabChangePasswordActivity.class);
				i.putExtra("did",did);
				i.putExtra("dname",dname);							
				i.putExtra("cno",cno);
				i.putExtra("email",email);
				i.putExtra("lno",lno);	
				startActivity(i);	
				
					
				
			}
		});
        
        b6=(Button)findViewById(R.id.btn6);
        b6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),CabServiceActivity.class);	
				startActivity(i);	
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cab_home, menu);
		return true;
	}

}
