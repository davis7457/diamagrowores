package com.D1g1Byt3.diamamod.biome.features;

import java.util.List;
import java.util.Random;

import com.D1g1Byt3.diamamod.block.ModBlocks;
import com.D1g1Byt3.diamamod.core.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DMSapling extends BlockSapling {
	
	public static final String[] saplings = new String[] {"Coconut", "Maple", "Cherry", "Plum", "Apricot"};
    private static final IIcon[] iconLength = new IIcon[saplings.length];

    public DMSapling()
    {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, p_149674_3_, p_149674_4_, p_149674_5_);

            if (world.getBlockLightValue(x, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0)
            {
                this.func_149879_c(world, x, p_149674_3_, p_149674_4_, p_149674_5_);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        meta &= 7;
        return iconLength[MathHelper.clamp_int(meta, 0, 5)];
    }

    
    //MarkorGrowMarked
    public void func_149879_c(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.func_149878_d(world, x, y, z, random);
        }
    }

    @Override
    public void func_149878_d(World world, int x, int y, int z, Random random)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (l)
        {
            case 0:
            	object = new WorldGenCoconutTree();
                break;
            case 1:
            	object = new WorldGenMapleTree(ModBlocks.blockLog, ModBlocks.blockLeaf, 1, 1, false, 10, 15, false);
                break;
            case 2:
                break;
            case 3:
            	break;
            case 4:
            	break;
            case 5:
                break;
            default:
                break;
        }

        Block block = Blocks.air;

        if (flag)
        {
            world.setBlock(x + i1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, random, x + i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x + i1, y, z + j1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
                world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
            }
            else
            {
                world.setBlock(x, y, z, this, l, 4);
            }
        }
    }

    public boolean func_149880_a(World world, int x, int y, int z, int var1)
    {
        return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == var1;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        return MathHelper.clamp_int(var1 & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < saplings.length; i++)
    	{
    		list.add(new ItemStack(item, 1 ,i));
    	}
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iR)
    {
        for (int i = 0; i < iconLength.length; ++i)
        {
            iconLength[i] = iR.registerIcon(Main.MODID + ":" + this.getUnlocalizedName().substring(5) + saplings[i]);
        }
    }

    public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
    {
        return true;
    }

    public boolean func_149852_a(World world, Random random, int x, int y, int z)
    {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        this.func_149879_c(world, x, y, z, random);
    }
	
	

}
