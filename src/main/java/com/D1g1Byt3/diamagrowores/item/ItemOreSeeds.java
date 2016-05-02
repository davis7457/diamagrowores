package com.D1g1Byt3.diamagrowores.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemOreSeeds  extends ItemSeeds{

	private Block plant;
	public Block soilBlockID;
	private static String[] Seeds = new String[] {"Iron","Gold","Diamond","Lapiz","Emerald","Copper","Tin","Ore"};
	public static String[] SeedI = new String[] {"Iron","Gold","Diamond","Lapiz","Emerald","Copper","Tin","Ore"};

	public ItemOreSeeds(Block plant, Block soil) {
		super(plant, soil);
		this.plant = plant;
		this.soilBlockID = soil;
	}
	
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, @SuppressWarnings("rawtypes") List list)
    {
        for (int i = 0; i < 7; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
	
	
	public int damageDropped(int meta) {
	    return meta;
	}
	
	public String getUnlocalizedName(ItemStack iS)
    {
        int i = MathHelper.clamp_int(iS.getItemDamage(), 0, 6);
        return super.getUnlocalizedName() + "." + Seeds[i];
    }
	
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack iS, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, iS) && player.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, iS))
        {
            if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant(world, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, this) && world.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
            {
                world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.plant);
                --iS.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

}
