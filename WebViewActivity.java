package com.raju.WebView;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView wv = (WebView) findViewById(R.id.webview1);
        wv.setWebViewClient(new Callback());
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        //wv.loadUrl("http://www.google.com");
        
        /*
          stackoverflowed
          
         mWebView = (WebView) findViewById(R.id.webview);
  mWebView.getSettings().setAllowFileAccess(true);
	mWebView.getSettings().setJavaScriptEnabled(true);
	mWebView.getSettings().setBuiltInZoomControls(true);
	String base = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
	String imagePath = "file://"+ base + "/test.jpg";
	String html = "<html><head></head><body><img src=\""+ imagePath + "\"></body></html>";
	mWebView.loadDataWithBaseURL("", html, "text/html","utf-8", "");  
           */
        
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String base = Environment.getExternalStorageDirectory().getAbsolutePath().toString();//1. mnt>sdcard
    	String imagePath = "file://"+ base + "/kirsten.jpg";  //2."file://"+path       
    	String html = "<H1>A simple HTML page</H1><body>" +"<a>link using anchor tag</a>"+"<img src=\""+imagePath+"\">"+
        		"<p>text text text</p>";
        		wv.loadDataWithBaseURL("", html, mimeType, encoding, "");
                                 //public void loadDataWithBaseURL (String baseUrl, String data, String mimeType, String encoding, String historyUrl)
                                //this loads data in our new webpage
       /*  baseUrl = the URL to use as the page's base URL. If null defaults to 'about:blank'. 
        data  =a String of data in the given encoding 
        mimeType=  the MIMEType of the data, e.g. 'text/html'. If null, defaults to 'text/html'. 
        encoding = the encoding of the data 
        historyUrl = the URL to use as the history entry. If null defaults to 'about:blank'.   */

    }
    
   	private class Callback extends WebViewClient {
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		                        //How to implement the case when shouldOverrideUrlLoading(WebView view, String url)
                                                                           //returns true? 
    	return(false);
    	}
    	}
 
}
