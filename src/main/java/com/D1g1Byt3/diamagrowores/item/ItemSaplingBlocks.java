package com.D1g1Byt3.diamagrowores.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaplingBlocks extends ItemBlockWithMetadata{

    public static final String[] Saplings = new String[] {"CoconutSapling", "MapleSapling", "CherrySapling", "PlumSapling", "ApricotSapling"};
	
	public ItemSaplingBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}
     
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= Saplings.length)
		{
			i = 0;
		}
		return super.getUnlocalizedName() + "." + Saplings[i];
	}
	
	public int getMetadata (int meta)
	{
		return meta;
	}
}
