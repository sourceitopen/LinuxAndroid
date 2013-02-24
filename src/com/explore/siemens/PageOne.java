package com.explore.siemens;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class PageOne extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_page_one);
		//http://www.google.com/ig/calculator?hl=en&q=150GBP=?USD
		String url = "http://www.google.com/ig/calculator?hl=en&q=150GBP=?USD";
		String cost = getResponse(url);
		System.out.println("cost received is==="+cost);
		ArrayList<String> receivedResponse = renderResponse(cost);
		System.out.println(receivedResponse);
	}
	private String getResponse (String url)
	{
	    HttpEntity entity = null;
	    StringBuilder sb = null;
	    try
	    {
	        HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost(url);
	        Log.e("log_tag_htppost", httppost.toString());
	        HttpResponse response = httpclient.execute(httppost);
	        entity = response.getEntity();
	        InputStream is = entity.getContent();
	        Log.e("log_tag", "after input stream");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	        sb = new StringBuilder();
	        sb.append(reader.readLine() + "\n");
	        String line="0";
	        while ((line = reader.readLine()) != null)
	        {
	            sb.append(line + "\n");
	        }
	        is.close();
	    }catch(Exception e)
	    {
	        Log.e("log_tag", "Error in http connection"+e.toString());
	    }
	    return sb.toString();
	}
	public ArrayList<String> renderResponse(String response){
		JSONObject jsonResponse;
		ArrayList<String> arrCostData=new ArrayList<String>();
		try {
			// obtain the reponse
			jsonResponse = new JSONObject(response);
			// get the array
			Log.e("log_tag", "Response received is now as json"+jsonResponse.toString());
			arrCostData.add(jsonResponse.getString("icc"));
			arrCostData.add(jsonResponse.getString("rhs"));
			arrCostData.add(jsonResponse.getString("lhs"));

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return arrCostData;
	}	
}
