package com.D1g1Byt3.diamagrowores.block;

import java.util.ArrayList;
import java.util.Random;

import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamagrowores.item.ModItems;
import com.D1g1Byt3.diamagrowores.core.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockMelon;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class GeodeBlockCore extends BlockMelon {
	
	@SideOnly(Side.CLIENT)
    private IIcon icon;
	
	
	protected GeodeBlockCore(String unlocalizedName)
    {
        super();
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
        this.setCreativeTab(DMCreativeTabs.tabDeco);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(5.0f);
    }

	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side != 1 && side != 0 ? this.blockIcon : this.icon;
    }

    // public Item getItemDropped(int meta, Random rand, int fort)
    //{
    //    return Items.melon;
    //}

    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
    	ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
    	if (world.rand.nextFloat() < 0.5f)
    	    drops.add(new ItemStack(Items.coal, world.rand.nextInt(2) + 1));
    	    drops.add(new ItemStack(ModItems.shardIron, world.rand.nextInt(2) + 1));
    	if (world.rand.nextFloat() < 0.4f)
    	    drops.add(new ItemStack(ModItems.shardGold, world.rand.nextInt(2) + 1));
    	if (world.rand.nextFloat() < 0.3f)
        	drops.add(new ItemStack(ModItems.shardCopper, world.rand.nextInt(2) + 1));
        	drops.add(new ItemStack(ModItems.shardTin, world.rand.nextInt(2) + 1));
        if (world.rand.nextFloat() < 0.2f)
            drops.add(new ItemStack(ModItems.shardDiamond, world.rand.nextInt(2) + 1));
    	
    	return drops;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    //public int quantityDropped(Random random)
    //{
    //    return 3 + random.nextInt(5);
    //}

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int fort, Random rand)
    {
        int j = this.quantityDropped(rand) + rand.nextInt(1 + fort);

        if (j > 9)
        {
            j = 9;
        }

        return j;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iR)
    {
        this.blockIcon = iR.registerIcon(this.getTextureName() + "_side");
        this.icon = iR.registerIcon(this.getTextureName() + "_top");
    }
	
}
