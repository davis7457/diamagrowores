package com.D1g1Byt3.diamagrowores.block;

import com.D1g1Byt3.diamagrowores.block.GeodeBlockStem;
import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamagrowores.item.ItemCrops;
import com.D1g1Byt3.diamagrowores.item.ItemLeafBlocks;
import com.D1g1Byt3.diamagrowores.item.ItemLogBlocks;
import com.D1g1Byt3.diamagrowores.item.ItemSaplingBlocks;
import com.D1g1Byt3.diamagrowores.item.ModItems;
import com.D1g1Byt3.diamagrowores.core.Main;

import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
//import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ModBlocks {
	public static Block blockCopperOre;
	public static Block blockTinOre;
	public static Block blockGeoOre;
	public static Block blockGeoStem;
	public static Block blockIronOre;
	public static Block blockIronCrop;
	public static Block blockGoldCrop;
	public static Block blockDiamondCrop;
	public static Block blockLapizCrop;
	public static Block blockEmeraldCrop;
	public static Block blockCopperCrop;
	public static Block blockTinCrop;
	
	
	
	public static final void init()
	{
		ItemStack iCrop = new ItemStack(ModItems.itemCrop, 1, 0);
		ItemStack gCrop = new ItemStack(ModItems.itemCrop, 1, 1);
		ItemStack dCrop = new ItemStack(ModItems.itemCrop, 1, 2);
		ItemStack lCrop = new ItemStack(ModItems.itemCrop, 1, 3);
		ItemStack eCrop = new ItemStack(ModItems.itemCrop, 1, 4);
		ItemStack cCrop = new ItemStack(ModItems.itemCrop, 1, 5);
		ItemStack tCrop = new ItemStack(ModItems.itemCrop, 1, 6);
		Item itemCrop_Iron = new ItemCrops().setUnlocalizedName("itemCrop_Iron");
		Item itemCrop_Gold = new ItemCrops().setUnlocalizedName("itemCrop_Gold");
		Item itemCrop_Diamond = new ItemCrops().setUnlocalizedName("itemCrop_Diamond");
		Item itemCrop_Lapiz = new ItemCrops().setUnlocalizedName("itemCrop_Lapiz");
		Item itemCrop_Emerald = new ItemCrops().setUnlocalizedName("itemCrop_Emerald");
		Item itemCrop_Copper = new ItemCrops().setUnlocalizedName("itemCrop_Copper");
		Item itemCrop_Tin = new ItemCrops().setUnlocalizedName("itemCrop_Tin");
		
		
		
		
		
		blockTinOre = new OreBlock("blockTinOre",Item.getItemFromBlock(blockTinOre), 1, 1).setCreativeTab(DMCreativeTabs.tabBlocks).setHardness(5.0f).setResistance(50.0f);
		blockCopperOre = new OreBlock("blockCopperOre", Item.getItemFromBlock(blockCopperOre) , 1, 1).setCreativeTab(DMCreativeTabs.tabBlocks).setHardness(5.0f);
		Block block9 = new GeodeBlockCore("blockGeoOre").setHardness(0.5f).setBlockName("blockGeoOre");
		blockGeoStem = new GeodeBlockStem(block9).setBlockName("blockGeoStem").setBlockTextureName(Main.MODID + ":" + "blockGeoStem");
		blockIronOre = new OreBlock("blockIronOre", Item.getItemFromBlock(blockIronOre), 1, 1).setCreativeTab(DMCreativeTabs.tabBlocks).setHardness(5.0f).setBlockTextureName(Main.MODID + ":" + "blockIronOre");
;
		
		blockIronCrop = new CoreCropBlock("blockIronCrop", ModItems.seedsIron, itemCrop_Iron);
		blockGoldCrop = new CoreCropBlock("blockGoldCrop", ModItems.seedsGold, itemCrop_Gold);
		blockDiamondCrop = new CoreCropBlock("blockDiamondCrop", ModItems.seedsDiamond, itemCrop_Diamond);
		blockLapizCrop = new CoreCropBlock("blockLapizCrop", ModItems.seedsLapiz, itemCrop_Lapiz);
		blockEmeraldCrop = new CoreCropBlock("blockEmeraldCrop", ModItems.seedsEmerald, itemCrop_Emerald);
		blockCopperCrop = new CoreCropBlock("blockCopperCrop", ModItems.seedsCopper, itemCrop_Copper);
		blockTinCrop = new CoreCropBlock("blockTinCrop", ModItems.seedsTin, itemCrop_Tin);
		
		
		
		
		
		
		
		GameRegistry.registerBlock(blockTinOre, "blockTinOre").setHarvestLevel("pickaxe", 1);
		GameRegistry.registerBlock(blockCopperOre, "blockCopperOre");
        GameRegistry.registerBlock(block9, "blockGeoOre");
        GameRegistry.registerBlock(blockGeoStem, "blockGeoStem");
        GameRegistry.registerBlock(blockIronOre, "blockIronOre");
        
	}
}
