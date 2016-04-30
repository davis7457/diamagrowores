package com.D1g1Byt3.diamamod.core;

import com.D1g1Byt3.diamamod.block.ModBlocks;
import com.D1g1Byt3.diamamod.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamamod.fluid.ModFluids;
import com.D1g1Byt3.diamamod.item.ModItems;
//import com.D1g1Byt3.diamamod.oredict.OreDict;
import com.D1g1Byt3.diamamod.worldgen.DMWorldGen;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e)
	{
		//Configuration config = new Configuration(e.getSuggestedConfigurationFile())
		DMCreativeTabs.init();
	    ModBlocks.init();
		ModItems.init();
		ModFluids.init();
		DMWorldGen.init();
		CraftMan.init();
	}
	
	
	
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	public static void OreDictinary()
	{
		OreDictionary.registerOre("oreCopper",new ItemStack (ModItems.CopperOre));
		OreDictionary.registerOre("ingotCopper",new ItemStack (ModItems.CopperIngot));
		OreDictionary.registerOre("oreTin", new ItemStack(ModItems.TinOre));
		OreDictionary.registerOre("ingotTin",new ItemStack (ModItems.TinIngot));
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
	

}
