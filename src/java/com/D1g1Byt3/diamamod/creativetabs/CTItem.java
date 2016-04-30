package com.D1g1Byt3.diamamod.creativetabs;

import com.D1g1Byt3.diamamod.block.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CTItem extends CreativeTabs {

	public CTItem(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.blockLog);
	}

}
