package com.D1g1Byt3.diamamod.block;

import java.util.Random;

import com.D1g1Byt3.diamamod.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

public class CoreOreBlock extends BlockOre{
	public CoreOreBlock()
	{
		super();
	}
	
	public Item getItemDropped(int par1, Random rand, int par2)
	{
		return ModItems.CopperOre.setUnlocalizedName("CopperOre");
	}

}
