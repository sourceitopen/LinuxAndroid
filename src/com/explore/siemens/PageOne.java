package com.explore.siemens;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class PageOne extends Activity {

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
	}	
}
