package com.D1g1Byt3.diamagrowores.core;

import com.D1g1Byt3.diamagrowores.block.ModBlocks;
import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamagrowores.item.ModItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e)
	{
		DMCreativeTabs.init();
	    ModBlocks.init();
		ModItems.init();
		CraftMan.init();
	}
	
	
	
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	public static void OreDictinary()
	{

	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
	

}
