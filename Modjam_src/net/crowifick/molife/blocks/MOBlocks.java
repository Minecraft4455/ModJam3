package net.crowifick.molife.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.crowifick.molife.core.config.Config;
import net.minecraft.block.Block;

public class MOBlocks {

	public static Block BlackHifle;
	public static Block Fenfero;
	
	public static void init() {

		initBlocks();
		registerBlocks();
		addNames();
		
	}

	private static void initBlocks() {
		
		BlackHifle = new BlackHifle(Config.BlackHifleID).setUnlocalizedName("BlackHifle");
		Fenfero = new Fenfero(Config.FenfroID).setUnlocalizedName("Fenfero");
		
	}

	private static void registerBlocks() {

		GameRegistry.registerBlock(BlackHifle, "BlackHifle");
		GameRegistry.registerBlock(Fenfero, "Fenfero");
		
	}

	private static void addNames() {
		
		LanguageRegistry.addName(BlackHifle, "Black Hifle");
		LanguageRegistry.addName(Fenfero, "Fenfero");
		
	}
	
}
