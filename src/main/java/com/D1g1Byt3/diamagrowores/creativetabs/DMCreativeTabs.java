package com.D1g1Byt3.diamagrowores.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class DMCreativeTabs {
	
	public static CreativeTabs tabBlocks;
	public static CreativeTabs tabItems;
	public static CreativeTabs tabTools;
	public static CreativeTabs tabDeco;
	public static CreativeTabs tabMisc;
	
	
	public static void init()
	{
		tabBlocks = new CTBlock("BlockTab");
		tabItems = new CTItem("ItemTab");
		tabTools = new CTTool("ToolTab");
		tabDeco = new CTDeco("DecoTab");
		tabMisc = new CTMisc("MiscTab");
	}

}
