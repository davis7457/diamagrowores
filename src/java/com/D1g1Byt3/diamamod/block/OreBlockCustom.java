package com.D1g1Byt3.diamamod.block;

import java.util.Random;

import com.D1g1Byt3.diamamod.core.Main;
import com.D1g1Byt3.diamamod.creativetabs.DMCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class OreBlockCustom extends Block{

	public Item drop;
	public int meta;
	public int least_quantity;
	public int most_quantity;
	
	
	protected OreBlockCustom(String unlocalizedName, Material mat, Item drop, int meta, int least_quantity, int most_quantity) {
		super(mat);
		this.drop = drop;
		this.meta = meta;
		this.least_quantity = least_quantity;
		this.most_quantity = most_quantity;
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(DMCreativeTabs.tabBlocks);
		this.setStepSound(soundTypeStone);
		this.setHardness(10.0f);
		this.setResistance(20.0f);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	protected OreBlockCustom(String unlocalizedName, Material mat, Item drop, int least_quantity, int most_quantity)
	{
		this(unlocalizedName, mat, drop, 0, least_quantity, most_quantity);
	}
	
	protected OreBlockCustom(String unlocalizedName, Material mat, Item drop)
	{
		this(unlocalizedName, mat, drop, 1, 1);
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return this.drop;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return this.meta;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (this.least_quantity >= this.most_quantity)
			return this.least_quantity;
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
	
	
	

}
