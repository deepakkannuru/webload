package com.pm.assignment1;

import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.webkit.WebSettings;
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
			WebSettings webSettings = mwebView.getSettings();
			 webSettings.setJavaScriptEnabled(true); // enable javascript
		    mwebView.setWebViewClient(new WebViewClient() {	
		    	 @Override
		            public void onPageFinished(WebView view, String url) {	                
		                super.onPageFinished(view, url);
		                injectJS();
		                mwebView.loadUrl("javascript:init()");
		            }
		        });	    	
		        mwebView.loadUrl("http://en.wikipedia.org/wiki/Narendra_Modi");
	}
	private void injectJS() {
	    try {
	        InputStream inputStream = getAssets().open("my.js");
	        byte[] buffer = new byte[inputStream.available()];
	        inputStream.read(buffer);
	        inputStream.close();
	        String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
	        mwebView.loadUrl("javascript:(function() {" +
	                "var parent = document.getElementsByTagName('head').item(0);" +
	                "var script = document.createElement('script');" +
	                "script.type = 'text/javascript';" +
	                "script.innerHTML = window.atob('" + encoded + "');" +
	                "parent.appendChild(script)" +
	                "})()");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
}
}