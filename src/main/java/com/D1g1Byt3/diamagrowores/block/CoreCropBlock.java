package com.D1g1Byt3.diamagrowores.block;

import java.util.ArrayList;
import java.util.Random;

import com.D1g1Byt3.diamagrowores.creativetabs.DMCreativeTabs;
import com.D1g1Byt3.diamagrowores.core.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class CoreCropBlock extends BlockCrops{
	
	private IIcon[] Icon;
	public Item drop_seed;
	public Item drop_crop;
	
	
	protected CoreCropBlock(String unlocalizedName, Item drop_seed, Item drop_crop)
	{
		super();
		this.drop_seed = drop_seed;
		this.drop_crop = drop_crop;
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(DMCreativeTabs.tabBlocks);
		
		
	}
	
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta > 7)
        {
            meta = 7;
        }

        return this.Icon[meta];
    }
    
    
    protected Item func_149866_i()
    {
        return this.drop_seed;
        
    }

    
    protected Item func_149865_P()
    {
        return this.drop_crop;
    }
    
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(world, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
    }

    public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_)
    {
        return p_149650_1_ == 7 ? this.func_149865_P() : this.func_149866_i();
    }
    
    public int quantityDropped(Random rand)
    {
        return 1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iR)
    {
        this.Icon  = new IIcon[7];

        for (int i = 0; i < this.Icon.length; ++i)
        {
            this.Icon[i] = iR.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }
    
    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return this.func_149866_i();
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

        if (metadata >= 7)
        {
            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (world.rand.nextInt(7) <= metadata)
                {
                    ret.add(new ItemStack(this.func_149866_i(), 1, 0));
                }
            }
        }

        return ret;
    }
    
    public boolean isOpaqueCube()
    {
      return false;
    }
    
    public boolean renderAsNormalBlock()
    {
      return false;
    }
    
    public int getRenderType()
    {
      return 1;
    }
    
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
      return EnumPlantType.Crop;
    }
    
    
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
      return world.getBlockMetadata(x, y, z);
    }

}
