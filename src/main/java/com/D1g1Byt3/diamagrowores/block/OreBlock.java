package com.D1g1Byt3.diamagrowores.block;

import java.util.ArrayList;
import java.util.Random;

import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamagrowores.item.ModItems;
import com.D1g1Byt3.diamagrowores.core.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OreBlock extends BlockOre{

	public Item drop;
	public int meta;
	public int least_quantity;
	public int most_quantity;
	
	
	protected OreBlock(String unlocalizedName,Item drop, int meta, int least_quantity, int most_quantity) {
		super();
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
	
	protected OreBlock(String unlocalizedName,Item drop, int least_quantity, int most_quantity)
	{
		this(unlocalizedName,drop, 0, least_quantity, most_quantity);
	}
	
	protected OreBlock(String unlocalizedName, Material mat, Item drop)
	{
		this(unlocalizedName,drop, 1, 1);
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return Item.getItemFromBlock(this);
	}
	
//	@Override
//	public ArrayList<ItemStack> getDrops(World world, int x, int y , int z, int metatdata, int fort)
//	{
//		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
//		if 
//				drops.add(new ItemStack(ModBlocks.blockCopperOre, 1));
//		
//		
//		
//		return drops;
//	}
	
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
