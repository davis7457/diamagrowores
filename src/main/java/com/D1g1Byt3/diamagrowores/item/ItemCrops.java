package com.D1g1Byt3.diamagrowores.item;

import java.util.List;

import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ItemCrops extends ItemDye {
	private static String[] Crops = new String[] {"Iron","Gold","Diamond","Lapiz","Emerald","Copper","Tin"};
	private static String[] CropI = new String[] {"Iron","Gold","Diamond","Lapiz","Emerald","Copper","Tin"};
	@SideOnly(Side.CLIENT)
	private IIcon[] Icon;
	
	public ItemCrops()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(DMCreativeTabs.tabMisc);
        
    }
	
	
	 /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int icon)
    {
        int j = MathHelper.clamp_int(icon, 0, 6);
        return this.Icon[j];
    }
    
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack iS)
    {
        int i = MathHelper.clamp_int(iS.getItemDamage(), 0, 6);
        return super.getUnlocalizedName() + "." + Crops[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < 7; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iR)
    {
        this.Icon = new IIcon[CropI.length];

        for (int i = 0; i < CropI.length; ++i)
        {
            this.Icon[i] = iR.registerIcon(this.getIconString() + "_" + CropI[i]);
        }
    }

}
