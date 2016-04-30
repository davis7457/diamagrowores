package com.D1g1Byt3.diamamod.block;

import java.util.Random;

import com.D1g1Byt3.diamamod.core.Main;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LogBlock extends BlockLog {

	protected LogBlock(String unLocalizedName, Material material) {
		super();
		material = Material.wood;
		this.setBlockName(unLocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unLocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0f);
		this.setResistance(6.0f);
		this.setLightLevel(0f);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
	}
	
	public int quantityDropped(Random random)
    {
        return 1;
    }
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }

}
