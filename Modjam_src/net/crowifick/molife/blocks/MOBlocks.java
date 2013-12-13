package net.crowifick.molife.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.crowifick.molife.core.config.Config;
import net.minecraft.block.Block;

public class MOBlocks {

	public static Block BlackHifle;
	
	public static void init() {

		initBlocks();
		registerBlocks();
		addNames();
		
	}

	private static void initBlocks() {
		
		BlackHifle = new BlackHifle(Config.BlackHifleID).setUnlocalizedName("BlackHifle");
		
	}

	private static void registerBlocks() {

		GameRegistry.registerBlock(BlackHifle, "BlackHifle");
		
	}

	private static void addNames() {
		
		LanguageRegistry.addName(BlackHifle, "Black Hifle");
		
	}
	
}
