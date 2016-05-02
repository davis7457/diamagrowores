package com.D1g1Byt3.diamagrowores.core;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public static void version()
	  {
	    Main.versionchecker = new VersionChecker();
	    Thread versionCheckThread = new Thread(Main.versionchecker, "Version Check");
	    versionCheckThread.start();
	  }
	  
	  public static void setCustomRenderers() {}
	
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	

}
