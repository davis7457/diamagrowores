package com.D1g1Byt3.diamamod.fluid;


import com.D1g1Byt3.diamamod.block.CWBlock;
import com.D1g1Byt3.diamamod.core.Main;
import com.D1g1Byt3.diamamod.item.cwBucket;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public final class ModFluids {
	
    public static Fluid fluidCW = new Fluid("CoconutWater");
	public static Block cwBlock;
	public static Item cwBucket = new cwBucket("cwBucket", cwBlock);
    
    
	public static final void init()
	{

		FluidRegistry.registerFluid(fluidCW);
	    //fluidCW.setUnlocalizedName(cwBlock.getUnlocalizedName());
		//Block
		
		cwBlock = new CWBlock(fluidCW, Material.water).setBlockName("fluidCW");
		//Block Reg
		cwBucket.setUnlocalizedName("cwBucket").setContainerItem(Items.bucket);
		GameRegistry.registerBlock(cwBlock, Main.MODID + cwBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cwBucket, "cwBucket");
	    //Fluid Container Reg
		FluidContainerRegistry.registerFluidContainer(fluidCW, new ItemStack(cwBucket), new ItemStack(Items.bucket));
		//Fluid Reg
	    
		
	}

}

