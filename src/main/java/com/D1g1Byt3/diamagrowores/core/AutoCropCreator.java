package com.D1g1Byt3.diamagrowores.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class AutoCropCreator {
	
	public static void addCrop(Block b, String mat)
	{
	 GameRegistry.registerBlock(b, "crop" + mat);
	 GameRegistry.addRecipe(new ShapedOreRecipe(b, new Object[] {Boolean.valueOf(true), }));
		
		
	}
	

}
