package com.D1g1Byt3.diamamod.creativetabs;

import com.D1g1Byt3.diamamod.block.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CTMisc extends CreativeTabs {

	public CTMisc(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.blockLog);
	}

}
