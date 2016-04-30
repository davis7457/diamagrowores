package com.D1g1Byt3.diamamod.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import com.D1g1Byt3.diamamod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GeodeBlockStem extends BlockStem implements IGrowable {

	private Block block;
	
	@SideOnly(Side.CLIENT)
	private IIcon Icon;

	protected GeodeBlockStem(Block block) {
		super(block);
		this.block = block;
		this.setTickRandomly(true);
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}
	
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        if (world.getBlockLightValue(x, y + 1, z) >= 9)
        {
            float f = this.func_149875_n(world, x, y, z);

            if (rand.nextInt((int)(25.0F / f) + 1) == 0)
            {
                int l = world.getBlockMetadata(x, y, z);

                if (l < 7)
                {
                    ++l;
                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
                else
                {
                    if (world.getBlock(x - 1, y, z) == this.block)
                    {
                        return;
                    }

                    if (world.getBlock(x + 1, y, z) == this.block)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z - 1) == this.block)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z + 1) == this.block)
                    {
                        return;
                    }

                    int i1 = rand.nextInt(4);
                    int j1 = x;
                    int k1 = z;

                    if (i1 == 0)
                    {
                        j1 = x - 1;
                    }

                    if (i1 == 1)
                    {
                        ++j1;
                    }

                    if (i1 == 2)
                    {
                        k1 = z - 1;
                    }

                    if (i1 == 3)
                    {
                        ++k1;
                    }

                    Block block = world.getBlock(j1, y - 1, k1);

                    if (world.isAirBlock(j1, y, k1) && (block.canSustainPlant(world, j1, y - 1, k1, UP, this) || block == Blocks.dirt || block == Blocks.grass))
                    {
                        world.setBlock(j1, y, k1, this.block);
                    }
                }
            }
        }
    }
	
//	private float getGrowthModifier(World world, int x, int y, int z)
//	{
//		float var4 = 1.0f;
//		int var5 = world.getBlock(x, y, z - 1);
//		
//		
//		return var4;
//	
//	}
	
	private float func_149875_n(World world, int x, int y, int z)
    {
        float f = 1.0F;
        Block block = world.getBlock(x, y, z - 1);
        Block block1 = world.getBlock(x, y, z + 1);
        Block block2 = world.getBlock(x - 1, y, z);
        Block block3 = world.getBlock(x + 1, y, z);
        Block block4 = world.getBlock(x - 1, y, z - 1);
        Block block5 = world.getBlock(x + 1, y, z - 1);
        Block block6 = world.getBlock(x + 1, y, z + 1);
        Block block7 = world.getBlock(x - 1, y, z + 1);
        Block block9 = world.getBlock(x + 1, y, z - 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this || block9 == this;

        for (int l = x - 1; l <= x + 1; ++l)
        {
            for (int i1 = z - 1; i1 <= z + 1; ++i1)
            {
                Block block8 = world.getBlock(l, y - 1, i1);
                float f1 = 0.0F;

                if (block8.canSustainPlant(world, l, y - 1, i1, UP, this))
                {
                    f1 = 1.0F;

                    if (block8.isFertile(world, l, y - 1, i1))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l != x || i1 != z)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }
	
	@SideOnly(Side.CLIENT)
    public int getState(IBlockAccess iBA, int x, int y, int z)
    {
        int l = iBA.getBlockMetadata(x, y, z);
        return l < 7 ? -1 : (iBA.getBlock(x - 1, y, z) == this.block ? 0 : (iBA.getBlock(x + 1, y, z) == this.block ? 1 : (iBA.getBlock(x, y, z - 1) == this.block ? 2 : (iBA.getBlock(x, y, z + 1) == this.block ? 3 : -1))));
    }
	
	 /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    @SuppressWarnings("unused")
    public void dropBlockAsItemWithChance(World world, int par1, int par2, int par3, int par4, float f, int par5)
    {
        super.dropBlockAsItemWithChance(world, par1, par2, par3, par4, f, par5);

        if (false && !world.isRemote)
        {
            Item item = null;

            if (this.block == ModBlocks.blockGeoOre)
            {
                item = ModItems.seedsGeo;
            }

            for (int j1 = 0; j1 < 3; ++j1)
            {
                if (world.rand.nextInt(15) <= par4)
                {
                    this.dropBlockAsItem(world, par1, par2, par3, new ItemStack(item));
                }
            }
        }
    }
    
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iR)
    {
        this.blockIcon = iR.registerIcon(this.getTextureName() + "_disconnected");
        this.Icon = iR.registerIcon(this.getTextureName() + "_connected");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getStemIcon()
    {
        return this.Icon;
    }

}
