package com.D1g1Byt3.diamagrowores.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlockWithMetadata{

    public static final String[] Leaves = new String[] {"Coconut", "Maple", "Cherry", "Plum", "Apricot"};
	
	public ItemLeafBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}
     
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= Leaves.length)
		{
			i = 0;
		}
		return super.getUnlocalizedName() + "." + Leaves[i];
	}
	
	public int getMetadata (int meta)
	{
		return meta;
	}
}
