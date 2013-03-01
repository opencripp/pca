package com.samcripp.pca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v4.app.Fragment;

public class Web extends Fragment {
	
	//the variable holding the website
	String HOME = "http://app.motocheck.tk/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) {
    	View mainView = (View) inflater.inflate(R.layout.web, container, false);
    	
    	//creating and loading the website.
    	WebView website = (WebView) mainView.findViewById(R.id.webView1);
        website.loadUrl(HOME);
        website.setWebViewClient(new MainWebViewClient());
    	
    	return mainView;
    }
    //overwriting the website intent into our webview client
	public class MainWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
