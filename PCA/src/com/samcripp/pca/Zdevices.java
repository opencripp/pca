// Zdevices v1 Modified for PCA By Samuel Rivera "SamCripp"
//
// This code is constantly evolving. So if you use this on your project please keep an eye on the repository the code came from.
// 
// http://zombidev.info
//
// This code is the intellectual property of Samuel Rivera, 2011-2012. I, Samuel Rivera, grant you the following rights.
// 1. You may modify and redistribute this code. 2. You may compile and redistribute this code. 3. You may use this code in personal or educational projects.
// 
// With that said, here is a list of rights revoked.
// 1. You may not use this code on commercial projects. 2. You may not use this code on corporate environment. 
// 3. You may not use the code in any malicious way. 4. You may not use it for profit.
//
// Conditions:
// 1. Any project utilizing this code, whether close or open source, must always provide the latest version of this code, including all modifications. 
// 2. Any project utilizing this code, must provide a link back to http://fcm.zombidev.com and http://repo.zombidev.com.
// 3. Any project utilizing this code, must provide credit to Samuel Rivera as original author of code. ie:
// Zdevices v1.11 - Original Author: Samuel Rivera "SamCripp"
//
// Thanks for following this simple rules.

package com.samcripp.pca;

import android.os.Build;
import android.os.Environment;


public class Zdevices {
	String Phone = Build.DEVICE;
	String OS = Build.VERSION.RELEASE;
	String DataPart;
	String BootPart;
	String SysPart;
	String PartF;
	String zStorage;
	String RName;
	boolean appRun;
	boolean secondInit;
		
public void SetIt(){
	
	secondInit = false;

		
    if(Phone.contentEquals("olympus")) //moto atrix
    	
    {
    	if(OS.contentEquals("2.3.4"))
    	{
    	zStorage = "/sdcard-ext";
    	} else if(OS.contentEquals("2.3.5")) {
        zStorage = "/sdcard-ext";
    	} else if(OS.contentEquals("2.3.6")) {
        zStorage = "/sdcard-ext";
    	} else if(OS.contentEquals("4.0.4")) {
        PartF = "ext3";
    	}  else {
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	}
    	RName = "Atrix 4G";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "/dev/block/mmcblk0p07";
    	BootPart = "/dev/block/mmcblk0p11";
		SysPart = "/dev/block/mmcblk0p12";
	} 
    else if(Phone.contentEquals("edison")) //moto atrix 2
    {
    	RName = "Atrix 2";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "";
    	BootPart = "";
		SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
    else if(Phone.contentEquals("dinara")) //moto atrix hd
    {
    	RName = "Atrix HD";
    	appRun = true;									
    	PartF = "ext4";
    	DataPart = "/dev/block/mmcblk0p38";
    	BootPart = "/dev/block/mmcblk0p31";
		SysPart = "/dev/block/mmcblk0p36";
		zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
        else if(Phone.contentEquals("smi")) //moto razr i
    {
    	RName = "RAZR i";
    	appRun = true;									
    	PartF = "ext4";
    	DataPart = "/dev/block/mmcblk0p17";
    	BootPart = "/dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p16";
		zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
        else if(Phone.contentEquals("vanquish")) //moto razr hd
    {
    	RName = "RAZR HD";
    	appRun = true;									
    	PartF = "ext4";
    	DataPart = "/dev/block/mmcblk0p38";
    	BootPart = "/dev/block/mmcblk0p31";
		SysPart = "/dev/block/mmcblk0p36";
		zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
            else if(Phone.contentEquals("scorpion_mini")) //moto razr m
    {
    	RName = "RAZR M";
    	appRun = true;									
    	PartF = "ext4";
    	DataPart = "/dev/block/mmcblk0p38";
    	BootPart = "/dev/block/mmcblk0p31";
		SysPart = "/dev/block/mmcblk0p36";
		zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("spyder")) //moto razr
    {
    	RName = "RAZR";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "/dev/block/mccblk1p24";
    	BootPart = "/dev/block/mccblk1p14";
		SysPart = "/dev/block/mccblk1p20";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("maserati")) //moto droid 4
    {
    	RName = "DROID 4";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "/dev/block/mccblk1p24";
    	BootPart = "/dev/block/mccblk1p14";
		SysPart = "/dev/block/mccblk1p20";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("targa")) //moto droid bionic
    {
    	RName = "DROID BIONIC";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "/dev/block/mccblk1p25";
    	BootPart = "/dev/block/mccblk1p15";
		SysPart = "/dev/block/mccblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }    
    else if(Phone.contentEquals("sunfire")) //moto photon 4g
    {
    	RName = "Photon 4G";
    	appRun = true;
    	PartF = "ext3";
    	DataPart = "/dev/block/mmcblk0p07";
    	BootPart = "/dev/block/mmcblk0p11";
		SysPart = "/dev/block/mmcblk0p12";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
    else if(Phone.contentEquals("triumph")) //moto triumph
    {
    	RName = "Triumph";
    	appRun = true;
    	PartF = "ext3";
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
    else if(Phone.contentEquals("WX435")) //moto triumph WX435
    {
    	RName = "Triumph";
    	appRun = true;
    	PartF = "ext3";
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
    else if(Phone.contentEquals("fb0")) //moto triumph fb0
    {
    	RName = "Triumph";
    	appRun = true;
    	PartF = "ext3";
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    } 
    else if(Phone.contentEquals("umts_jordan")) //motorola defy
    {
    	RName = "Defy";
    	secondInit = true;
    	PartF = "ext3";
    	appRun = true;
    	BootPart = "Not Supported";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("cdma_droid2we")) //motorola droid 2 global
    {
    	RName = "Droid 2 Global";
    	PartF = "ext3";
    	secondInit = true;
    	appRun = true;
    	BootPart = "2ndInit";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("cdma_solana")) //motorola droid 3
    {
    	RName = "Droid 3";
    	PartF = "ext3";
    	secondInit = true;
    	appRun = true;
    	BootPart = "Not Supported";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    // tablets
    else if(Phone.contentEquals("wingray")) // moto xoom	
    {
    	RName = "Xoom";
    	appRun = true;
    	BootPart = "/dev/block/platform/sdhci-tegra.3/by-name/boot";
    	SysPart = "/dev/block/platform/sdhci-tegra.3/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else if(Phone.contentEquals("stingray")) // moto xoom
    {
    	RName = "Xoom";
    	appRun = true;
    	BootPart = "/dev/block/platform/sdhci-tegra.3/by-name/boot";
    	SysPart = "/dev/block/platform/sdhci-tegra.3/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    else
    	{
    	RName = "No Device";
    	appRun = false;
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	}
}
public boolean secondInit(){
	
	return secondInit;
}
public String Storage(){

	return zStorage;
}
public String Boot(){

	return BootPart;
}
public String System(){

	return SysPart;
}
public boolean Run(){

	return appRun;
}
public String Phone(){

	return Phone;
}
public String OS(){

	return OS;
}
public String RName(){

	return RName;
}
public String FPart(){

	return PartF;
}
}
