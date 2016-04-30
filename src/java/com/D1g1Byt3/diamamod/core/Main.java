package com.D1g1Byt3.diamamod.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, dependencies = Main.DEPENDENCIES)
public class Main 
{

    public static final String CHANNEL_NAME = "DiamaMod";
	public static final String MASTER = "DiamaMod";
	public static final int RAW_VERSION_NUMBER = 100;
	public static String LATEST_VERSION;
	public static final String MODID = "diamamod";
	public static final String MODNAME = "DiamaMod";
	public static final String VERSION = "1.0.0";
	public static final String DEPENDENCIES = "after:ThermalExpansion;after:appliedenergistics2;after:arsmagica2;after:BiomesOPlenty;after:Forestry;after:Metallurgy;after:Thaumcraft;after:TConstruct;after:GalacticraftMars;after:GalacticraftCore;after:Railcraft;after:simpleores;after:BigReactors;after:DraconicEvolution;after:Eln;before:Steamcraft;after:Botania;after:CreepTech;after:ProjectRed Exploration;after:ProjectRed Core";
	public static int growTexture; 
	public static boolean doCropsGenerate;
	public static VersionChecker versionchecker;
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> hardcoded = new ArrayList();
	@Instance 
	public static Main instance = new Main();
	
	
	public void initConfiguration(FMLInitializationEvent event)
	  {
	    Configuration config = new Configuration(new File("config/DiamaMod.cfg"));
	    
	    config.load();
	    
	    config.addCustomCategoryComment("Textures", "Here you can change the growing block texture. 0 is the default texture,1 is the orange texture and 2 is the original texture.");
	    
	    growTexture = config.get("Textures", "Growing Block Texture Type", 0).getInt();
	    
	    config.save();
	  }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}
	
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
	
	public static void addHardcoded()
	  {
	    hardcoded.add("Coal");
	    hardcoded.add("Iron");
	    hardcoded.add("Gold");
	    hardcoded.add("Redstone");
	    hardcoded.add("Lapis");
	    hardcoded.add("Diamond");
	    hardcoded.add("Emerald");
	    hardcoded.add("Quartz");
	    hardcoded.add("NetherQuartz");
	    hardcoded.add("Obsidian");
	    hardcoded.add("Clay");
	    hardcoded.add("Ender");
	    hardcoded.add("Blaze");
	    
	    hardcoded.add("Saltpeter");
	    hardcoded.add("Sulphur");
	    hardcoded.add("Sulfur");
	    
	    hardcoded.add("Copper");
	    hardcoded.add("Tin");
	    hardcoded.add("Lead");
	    hardcoded.add("Draconium");
	    hardcoded.add("ElnTungsten");
	    hardcoded.add("Cinnabar");
	    hardcoded.add("Onyx");
	    hardcoded.add("CertusQuartz");
	    hardcoded.add("Uranium");
	    
	    hardcoded.add("Yellorite");
	    hardcoded.add("Yellorium");
	    hardcoded.add("Aluminium");
	    hardcoded.add("Silicon");
	    hardcoded.add("Cheese");
	    hardcoded.add("Desh");
	    hardcoded.add("Ilmenite");
	    
	    hardcoded.add("BlueTopaz");
	    hardcoded.add("Vinteum");
	    hardcoded.add("Chimerite");
	    hardcoded.add("Moonstone");
	    hardcoded.add("Sunstone");
	    hardcoded.add("Ruby");
	    hardcoded.add("Topaz");
	    hardcoded.add("Peridot");
	    hardcoded.add("Tanzanite");
	    hardcoded.add("Malachite");
	    hardcoded.add("Sapphire");
	    hardcoded.add("Amethyst");
	    hardcoded.add("ElnTungsten");
	    hardcoded.add("Zinc");
	    
	    hardcoded.add("Apatite");
	    hardcoded.add("Electrotine");
	  }
	
	
	
	@SidedProxy(clientSide="com.D1g1Byt3.diamamod.ClientProxy", serverSide="com.D1g1Byt3.diamamod.ServerProxy")
	public static CommonProxy proxy;
}
