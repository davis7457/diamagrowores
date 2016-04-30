package com.D1g1Byt3.diamamod.biome.features;

import java.util.List;

import com.D1g1Byt3.diamamod.block.ModBlocks;
import com.D1g1Byt3.diamamod.core.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class DMLog extends BlockLog {
	public static final String[] Logs = new String[]{"Coconut", "Maple", "Cherry", "Plum", "Apricot"};
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < Logs.length; i++)
		{
			list.add(new ItemStack(item, 1 ,i));
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister IR)
	{
		this.field_150167_a = new IIcon[Logs.length];
		this.field_150166_b = new IIcon[Logs.length];
		
		for (int i = 0; i < this.field_150167_a.length; i++)
		{
			
			this.field_150167_a[i] = IR.registerIcon(Main.MODID + ":" + this.getUnlocalizedName().substring(5) +  Logs[i]);
			this.field_150166_b[i] = IR.registerIcon(Main.MODID + ":" + this.getUnlocalizedName().substring(5) +  Logs[i] + "Top");
		}
	}

}
