package com.opencripp.pca;

import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity {
		
DeviceInfo CurrentDevice = new DeviceInfo();
String myPhone[];
//[0] = realname, [1] = phone, [2] = os, [3] = boot, 
//[4] = system, [5] = data, [6] = osh, [7] = storage, 
String myFormat[];
//[0] = format
boolean mySupport[];
//[0] = support, [1] = sndinit, [2] oshsupport, [3] databackup
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //identifying the device.
        Log.v("PCA", "Identifying the device.");
        CurrentDevice.Identify();
        Log.v("PCA", myPhone[1] + " " + myPhone[4] + " " + myFormat[0]);
        
        Log.v("PCA", "Loading view, fragment web.");
        
     // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of Web Fragment
            Web firstFragment = new Web();
            
            // In case this activity was started with special instructions 
            firstFragment.setArguments(getIntent().getExtras());
            
            // Add the fragment to the 'fragment_container'
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
    public void Web(View view){
    	Log.v("PCA", "Changing fragment displayed, to web");
    	// create fragment and give it an argument
    	Web newFragment = new Web();

    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    	// Replace whatever is in the fragment_container 
    	transaction.replace(R.id.fragment_container, newFragment);
    	transaction.addToBackStack(null);

    	// Commit the transaction
    	transaction.commit();
    }
    public void Servers(View view){
    	Log.v("PCA", "Changing fragment displayed, to servers");
    	Servers newFragment = new Servers();

    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    	transaction.replace(R.id.fragment_container, newFragment);
    	transaction.addToBackStack(null);

    	transaction.commit();
    }
    public void Credits(View view){
    	Log.v("PCA", "Changing fragment displayed, to servers");
    	Credits newFragment = new Credits();

    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    	transaction.replace(R.id.fragment_container, newFragment);
    	transaction.addToBackStack(null);

    	transaction.commit();
    }
    public void Update(final String server){

    	Log.v("PCA", "Requesting SU");
    	Process p;
		try{
			p = Runtime.getRuntime().exec("su"); 
			DataOutputStream os = new DataOutputStream(p.getOutputStream());
    	Log.v("PCA", "mount -o rw,remount -t " + myFormat[0] + " " + myPhone[4] + " /system");
    	os.writeBytes("mount -o rw,remount -t " + myFormat[0] + " " + myPhone[4] + " /system");
    	
    	Log.v("PCA", "rm /system/etc/motorola/com.motorola.blur.service.blur/defaults.xml");
    	os.writeBytes("rm /system/etc/motorola/com.motorola.blur.service.blur/defaults.xml\n");
    	
    	Log.v("PCA", "echo \"data_wifi_only_feat_avail=0\" > /system/etc/motorola/com.motorola.blur.service.blur/data_wifi_only_settings.mkitso");
    	os.writeBytes("echo \"data_wifi_only_feat_avail=0\" > /system/etc/motorola/com.motorola.blur.service.blur/data_wifi_only_settings.mkitso\n");
    	
    	Log.v("PCA", "echo \"<map><string name='blur.service.ws.useApnProxy'>0</string><string name='blur.service.ws.masterCloud'>" + server + "</string></map>\" > /system/etc/motorola/com.motorola.blur.service.blur/defaults.xml \n");
    	os.writeBytes("echo \"<map><string name='blur.service.ws.useApnProxy'>0</string><string name='blur.service.ws.masterCloud'>" + server + "</string></map>\" > /system/etc/motorola/com.motorola.blur.service.blur/defaults.xml \n");
    	    	
    	Log.v("PCA", "echo \"<?xml version='1.0' encoding='UTF-8'?><map><boolean name='AllowActiveSync' value='true'/><boolean name='ShowSkipSetupMenu' value='true'/><boolean name='ShowConnectionChooser' value='true'/><boolean name='ShowDataSaverInSetup' value='true'/><boolean name='WifiPreference' value='true'/><boolean name='loc_consent_unchecked' value='false'/><boolean name='CloudPreference' value='true'/></map>\" > /data/data/com.motorola.blur.setup/defaults.xml\n");
    	os.writeBytes("echo \"<?xml version='1.0' encoding='UTF-8'?><map><boolean name='AllowActiveSync' value='true'/><boolean name='ShowSkipSetupMenu' value='true'/><boolean name='ShowConnectionChooser' value='true'/><boolean name='ShowDataSaverInSetup' value='true'/><boolean name='WifiPreference' value='true'/><boolean name='loc_consent_unchecked' value='false'/><boolean name='CloudPreference' value='true'/></map>\" > /data/data/com.motorola.blur.setup/defaults.xml\n");
    	
    	Log.v("PCA", "reboot recovery\n");
    	os.writeBytes("reboot recovery\n");
		os.flush();
	} catch (IOException e) { 
		 
	}finally{ 
		
	}
	
    }
    //development server buttons
    //devlopment
    public void master_lab(View view){
    	Update("master-lab.blurdev.com");
    }
    public void master_dev(View view){
    	Update("master-dev.blurdev.com");
    }
    public void master_devtest(View view){
    	Update("master-devtest.blurdev.com");
    }
    //qa
    public void master_qa1(View view){
    	Update("master-qa1.blurdev.com");
    }
    public void master_qa2(View view){
    	Update("master-qa2.blurdev.com");
    }
    public void master_qa4(View view){
    	Update("master-qa4.blurdev.com");
    }
    public void master_qa200(View view){
    	Update("master-qa200.blurdev.com");
    }
    public void master_qa300(View view){
        Update("master-qa300.blurdev.com");
    }
    public void master_svcmot(View view){
    	Update("master-blur.svcmot.com");
    }
    public void master_sdc1svcmot(View view){
    	Update("master-sdc1.svcmot.com");
    }
    public void master_sdc100blurdev(View view){
    	Update("master-sdc100.blurdev.com");
    }
    public void master_sdc200blurdev(View view){
    	Update("master-sdc200.blurdev.com");
    }
}
