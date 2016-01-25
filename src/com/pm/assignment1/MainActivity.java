package com.pm.assignment1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("NewApi") public class MainActivity extends Activity {

	public WebView mwebView;
	final Handler handler = new Handler();
	
	@SuppressLint("SetJavaScriptEnabled") 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			mwebView  = (WebView) findViewById(R.id.webview);
			    
		    mwebView.setWebViewClient(new WebViewClient() {	
		    	 @Override
		            public void onPageFinished(WebView view, String url) {
		                
		                super.onPageFinished(view, url);
		            }
		        });	    	
		        mwebView.loadUrl("http://en.wikipedia.org/wiki/Narendra_Modi");
	}
}