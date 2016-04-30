package com.D1g1Byt3.diamamod.item;

import com.D1g1Byt3.diamamod.core.Main;
import com.D1g1Byt3.diamamod.creativetabs.DMCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class cwBucket extends ItemBucket {

	public cwBucket(String unlocalizedName, Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setCreativeTab(DMCreativeTabs.tabMisc);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}

}
