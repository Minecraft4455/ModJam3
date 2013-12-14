package net.crowifick.molife.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.crowifick.molife.core.config.Config;
import net.minecraft.block.Block;

public class MOBlocks {

	public static Block BlackHifle;
	public static Block Fenfero;
	public static Block YellowCactus;
	public static Block YellowCactusBlock;
	
	public static void init() {

		initBlocks();
		registerBlocks();
		addNames();
		
	}

	private static void initBlocks() {
		
		BlackHifle = new BlackHifle(Config.BlackHifleID).setUnlocalizedName("BlackHifle");
		Fenfero = new Fenfero(Config.FenfroID).setUnlocalizedName("Fenfero");
		YellowCactus = new YellowCactus(Config.YellowCactusID).setUnlocalizedName("YellowCactus");
		YellowCactusBlock = new YellowCactusBlock(Config.YellowCactusBlockID).setUnlocalizedName("YellowCactusBlock");
		
	}

	private static void registerBlocks() {

		GameRegistry.registerBlock(BlackHifle, "BlackHifle");
		GameRegistry.registerBlock(Fenfero, "Fenfero");
		GameRegistry.registerBlock(YellowCactus, "YellowCactus");
		GameRegistry.registerBlock(YellowCactusBlock, "YellowCactusBlock");
		
	}

	private static void addNames() {
		
		LanguageRegistry.addName(BlackHifle, "Black Hifle");
		LanguageRegistry.addName(Fenfero, "Fenfero");
		LanguageRegistry.addName(YellowCactus, "Yellow Cactus");
		LanguageRegistry.addName(YellowCactusBlock, "Yellow Cactus Block");
		
	}
	
}
