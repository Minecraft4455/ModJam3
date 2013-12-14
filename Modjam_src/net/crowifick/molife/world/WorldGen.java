package net.crowifick.molife.world;

import java.util.Random;

import net.crowifick.molife.world.gen.WorldBlueCactus;
import net.crowifick.molife.world.gen.WorldRedCactus;
import net.crowifick.molife.world.gen.WorldYellowCactus;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		
		switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
		}
		
	}



	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int i, int j) {

		BiomeGenBase b = world.getBiomeGenForCoords(i, j);

		if (b.biomeName.equals("Desert")) {

			for (int k = 0; k < 10; k++) {
				int firstBlockXCoord = i + random.nextInt(16);
				int firstBlockYCoord = random.nextInt(200);
				int firstBlockZCoord = j + random.nextInt(16);

				new WorldYellowCactus().generate(world, random,firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

			}
			
			for (int k = 0; k < 10; k++) {
				int firstBlockXCoord = i + random.nextInt(16);
				int firstBlockYCoord = random.nextInt(200);
				int firstBlockZCoord = j + random.nextInt(16);

				new WorldBlueCactus().generate(world, random,firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

			}
			
			for (int k = 0; k < 10; k++) {
				int firstBlockXCoord = i + random.nextInt(16);
				int firstBlockYCoord = random.nextInt(200);
				int firstBlockZCoord = j + random.nextInt(16);

				new WorldRedCactus().generate(world, random,firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

			}

			
		}
		
	}
}