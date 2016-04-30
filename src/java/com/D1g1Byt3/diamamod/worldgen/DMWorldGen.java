package com.D1g1Byt3.diamamod.worldgen;

import java.util.Random;

import com.D1g1Byt3.diamamod.block.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DMWorldGen implements IWorldGenerator {

	private WorldGenerator Gen_Copper_Ore;
	private WorldGenerator Gen_Tin_Ore;
	
	
	public static final void init()
	{
		GameRegistry.registerWorldGenerator(new DMWorldGen(), 0);
	}
	
	
	public DMWorldGen()
	{
		this.Gen_Copper_Ore = new WorldGenMinable(ModBlocks.blockCopperOre, 8);
		this.Gen_Tin_Ore = new WorldGenMinable(ModBlocks.blockTinOre, 8);
		
	}
	

	
	public void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			gen.generate(world, rand, x, y ,z);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider gen,IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId)
		{
		case -1:
			//generateInNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
		    this.runGenerator(this.Gen_Copper_Ore, world, random, chunkX, chunkZ, 20, 0, 64);
		    this.runGenerator(this.Gen_Tin_Ore, world, random, chunkX, chunkZ, 20, 0, 64);
		    break;
		case 1:
			//generateInEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}

    }
}
