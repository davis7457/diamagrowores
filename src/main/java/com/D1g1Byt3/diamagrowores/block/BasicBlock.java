package com.D1g1Byt3.diamagrowores.block;

import com.D1g1Byt3.diamagrowores.core.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {

	public BasicBlock(String unLocalizedName, Material material) {
		super(material);
		this.setBlockName(unLocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unLocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0f);
		this.setResistance(6.0f);
		this.setLightLevel(1.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}

}
