package com.explore.siemens;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PageOne extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_one);
		//http://www.google.com/ig/calculator?hl=en&q=150GBP=?USD
		GenericUtility gu = new GenericUtility();
		String url = "http://www.google.com/ig/calculator?hl=en&q=150GBP=?USD";
		String cost = gu.getResponse(url);
		ArrayList<String> receivedResponse = gu.renderResponse(cost);
		System.out.println(receivedResponse);
		TextView dataToView = (TextView) findViewById(R.id.page_one_home);
		dataToView.setText(receivedResponse.get(0));
		dataToView.setText(receivedResponse.get(1));
		dataToView.setText(receivedResponse.get(2));
		Button backButton = (Button)findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
    	case R.id.back_button:
    	Intent i = new Intent(this,Home.class);
    	startActivity(i);
    	break;
    	// More buttons go here (if any) ...
    	}
		
	}	
}
