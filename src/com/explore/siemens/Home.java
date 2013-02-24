package com.explore.siemens;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Home extends Activity implements OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       Button pageOneButton = (Button)findViewById(R.id.page_one_button);
		pageOneButton.setOnClickListener(this);
    }
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.page_one_button:
    	Intent i = new Intent(this,PageOne.class);
    	startActivity(i);
    	break;
    	// More buttons go here (if any) ...
    	}
    	}

}
