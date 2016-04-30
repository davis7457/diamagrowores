package com.D1g1Byt3.diamamod.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class VersionChecker implements Runnable {

	private static boolean isLatestVersion = false;
    private static String latestVersion = "";
	@Override
	public void run() {
		InputStream in = null;
	    try
	    {
	      in = new URL("https://raw.githubusercontent.com/Davis7457/VersionCheckerDavis7457/master/gon.txt").openStream();
	    }
	    catch (MalformedURLException e)
	    {
	      e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    try
	    {
	      latestVersion = (String)IOUtils.readLines(in).get(0);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      IOUtils.closeQuietly(in);
	    }
	    System.out.println("Latest mod version = " + latestVersion);
	    isLatestVersion = "1.0.0".equals(latestVersion);
	    System.out.println("Are you running latest version = " + isLatestVersion);
	  }
	  
	  public boolean isLatestVersion()
	  {
	    return isLatestVersion;
	  }
	  
	  public String getLatestVersion()
	  {
	    return latestVersion;
	  }
		
	}
	


