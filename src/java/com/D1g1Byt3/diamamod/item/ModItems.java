package com.D1g1Byt3.diamamod.item;

import com.D1g1Byt3.diamamod.block.ModBlocks;
import com.D1g1Byt3.diamamod.core.Main;
import com.D1g1Byt3.diamamod.creativetabs.DMCreativeTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public final class ModItems {
	
	
	
	public static Item CopperOre;
	public static Item Pineapple;
	public static Item TinOre;
	public static Item TinIngot;
	public static Item CopperIngot;
	public static Item shardIron;
	public static Item shardGold;
	public static Item shardDiamond;
	public static Item shardCopper;
	public static Item shardTin;
	public static Item seedsGeo;
	public static Item seedsIron;
	public static Item seedsGold;
	public static Item seedsDiamond;
	public static Item seedsEmerald;
	public static Item seedsLapiz;
	public static Item seedsCopper;
	public static Item seedsTin;
//	public static Item cropIron;
//	public static Item cropGold;
//	public static Item cropDiamond;
//	public static Item cropLapiz;
//	public static Item cropEmerald;
//	public static Item cropCopper;
//	public static Item cropTin;
	public static Item itemCrop;
	
	
	
	
	
	
 
	
	public static final void init()
	{
		
		//Item Init
		Pineapple = new Item().setUnlocalizedName("pineapple").setCreativeTab(DMCreativeTabs.tabItems).setTextureName(Main.MODID + ":pineapple");
		CopperOre = new  Item().setUnlocalizedName("CopperOre").setTextureName(Main.MODID + ":" + "CopperOre").setCreativeTab(DMCreativeTabs.tabItems);
		CopperIngot = new  Item().setFull3D().setUnlocalizedName("CopperIngot").setTextureName(Main.MODID + ":" + "CopperIngot").setCreativeTab(DMCreativeTabs.tabItems);
		TinOre = new  Item().setUnlocalizedName("TinOre").setTextureName(Main.MODID + ":" + "TinOre").setCreativeTab(DMCreativeTabs.tabItems);
		TinIngot = new  Item().setFull3D().setUnlocalizedName("TinIngot").setTextureName(Main.MODID + ":" + "TinIngot").setCreativeTab(DMCreativeTabs.tabItems);
		itemCrop = new ItemCrops().setUnlocalizedName("itemCrop").setTextureName("itemCrop");
		
		//Item Shard
		shardIron = new Item().setUnlocalizedName("shardIron").setTextureName(Main.MODID + ":" + "shardIron").setCreativeTab(DMCreativeTabs.tabItems);
		shardGold = new Item().setUnlocalizedName("shardGold").setTextureName(Main.MODID + ":" + "shardGold").setCreativeTab(DMCreativeTabs.tabItems);
		shardDiamond = new Item().setUnlocalizedName("shardDiamond").setTextureName(Main.MODID + ":" + "shardDiamond").setCreativeTab(DMCreativeTabs.tabItems);
		shardCopper = new Item().setUnlocalizedName("shardCopper").setTextureName(Main.MODID + ":" + "shardCopper").setCreativeTab(DMCreativeTabs.tabItems);
		shardTin = new Item().setUnlocalizedName("shardTin").setTextureName(Main.MODID + ":" + "shardTin").setCreativeTab(DMCreativeTabs.tabItems);		
		seedsGeo = new ItemOreSeeds(ModBlocks.blockGeoStem, Blocks.farmland).setUnlocalizedName("seedsGeo").setTextureName(Main.MODID + ":" + "seedsGeo").setCreativeTab(DMCreativeTabs.tabItems);
		seedsIron = new ItemOreSeeds(ModBlocks.blockIronCrop, Blocks.farmland).setUnlocalizedName("seedsIron").setTextureName(Main.MODID + ":" + "seedsIron").setCreativeTab(DMCreativeTabs.tabItems);
		seedsGold = new ItemOreSeeds(ModBlocks.blockGoldCrop, Blocks.farmland).setUnlocalizedName("seedsGold").setTextureName(Main.MODID + ":" + "seedsGold").setCreativeTab(DMCreativeTabs.tabItems);
		seedsDiamond = new ItemOreSeeds(ModBlocks.blockDiamondCrop, Blocks.farmland).setUnlocalizedName("seedsDiamond").setTextureName(Main.MODID + ":" + "seedsDiamond").setCreativeTab(DMCreativeTabs.tabItems);
		seedsEmerald = new ItemOreSeeds(ModBlocks.blockEmeraldCrop, Blocks.farmland).setUnlocalizedName("seedsEmerald").setTextureName(Main.MODID + ":" + "seedsEmerald").setCreativeTab(DMCreativeTabs.tabItems);
		seedsLapiz = new ItemOreSeeds(ModBlocks.blockLapizCrop, Blocks.farmland).setUnlocalizedName("seedsLapiz").setTextureName(Main.MODID + ":" + "seedsLapiz").setCreativeTab(DMCreativeTabs.tabItems);
		seedsCopper = new ItemOreSeeds(ModBlocks.blockCopperCrop, Blocks.farmland).setUnlocalizedName("seedsCopper").setTextureName(Main.MODID + ":" + "seedsCopper").setCreativeTab(DMCreativeTabs.tabItems);
		seedsTin = new ItemOreSeeds(ModBlocks.blockTinCrop, Blocks.farmland).setUnlocalizedName("seedsTin").setTextureName(Main.MODID + ":" + "seedsTin").setCreativeTab(DMCreativeTabs.tabItems);
		
		//Registry
		GameRegistry.registerItem(Pineapple, "pineapple");
		GameRegistry.registerItem(CopperOre, "CopperOre");
		GameRegistry.registerItem(CopperIngot, "CopperIngot");
		GameRegistry.registerItem(TinOre, "TinOre");
		GameRegistry.registerItem(TinIngot, "TinIngot");
		GameRegistry.registerItem(itemCrop ,"itemCrop");
		
		//Seeds
		GameRegistry.registerItem(seedsIron, "seedsIron");
		GameRegistry.registerItem(seedsGold, "seedsGold");
		GameRegistry.registerItem(seedsDiamond, "seedsDiamond");
		GameRegistry.registerItem(seedsEmerald, "seedsEmerald");
		GameRegistry.registerItem(seedsLapiz, "seedsLapiz");
		GameRegistry.registerItem(seedsCopper, "seedsCopper");
		GameRegistry.registerItem(seedsTin, "seedsTin");
		
		
		//Registry Shard
		GameRegistry.registerItem(shardIron, "shardIron");
		GameRegistry.registerItem(shardGold, "shardGold");
		GameRegistry.registerItem(shardDiamond, "shardDiamond");
		GameRegistry.registerItem(shardCopper, "shardCopper");
		GameRegistry.registerItem(shardTin, "shardTin");
		GameRegistry.registerItem(seedsGeo, "seedsGeo");
		
	}

}
