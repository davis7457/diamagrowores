package com.D1g1Byt3.diamagrowores.core;

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
	      in = new URL("https://rawgit.com/davis7457/ModVersionChecker/master/VersionDM.txt").openStream();
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
	


