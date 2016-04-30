package com.D1g1Byt3.diamamod.core;

import com.D1g1Byt3.diamamod.block.ModBlocks;
import com.D1g1Byt3.diamamod.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftMan {

	public static void init()
	{
		addCraftingRec();
		addSmeltingRec();
	}
	
	public static void addCraftingRec()
	{
		ItemStack CI = new ItemStack(ModItems.CopperIngot, 1);
		ItemStack shI = new ItemStack(ModItems.shardIron, 1);
		ItemStack shC = new ItemStack(ModItems.shardCopper, 1);
		ItemStack shT = new ItemStack(ModItems.shardTin, 1);
		ItemStack shG = new ItemStack(ModItems.shardGold, 1);
		ItemStack shD = new ItemStack(ModItems.shardDiamond, 1);
		ItemStack oT = new ItemStack(ModBlocks.blockTinOre, 1);
		ItemStack oC = new ItemStack(ModBlocks.blockCopperOre, 1);
		ItemStack oI = new ItemStack(Blocks.iron_ore, 1);
		ItemStack oG = new ItemStack(Blocks.gold_ore, 1);
		ItemStack oD = new ItemStack(Items.diamond, 1);
		
		
		//Shaped
		//GameRegistry.addRecipe(new ItemStack(ModItems.CopperIngot, 1), new Object[]{" O ","   ","   ", 'O', ModItems.CopperOre});
		GameRegistry.addRecipe (oI, new Object[]{"sss","sss","sss", 's', shI});
		GameRegistry.addRecipe (oG, new Object[]{"sss","sss","sss", 's', shG});
		GameRegistry.addRecipe (oD, new Object[]{"sss","sss","sss", 's', shD});
		GameRegistry.addRecipe (oC, new Object[]{"sss","sss","sss", 's', shC});
		GameRegistry.addRecipe (oT, new Object[]{"sss","sss","sss", 's', shT});
		//Shapeless
	}
	
	public static void addSmeltingRec()
	{
		
		ItemStack CI = new ItemStack(ModItems.CopperIngot, 1);
		ItemStack TI = new ItemStack(ModItems.TinIngot, 1);
		//Smelting
		GameRegistry.addSmelting(Items.apple,new ItemStack(Items.blaze_rod, 2), 20.0f);
		GameRegistry.addSmelting(ModBlocks.blockCopperOre ,CI, 20.f);
		GameRegistry.addSmelting(ModBlocks.blockTinOre , TI, 20.f);
	}
	
}
