package net.crowifick.molife.world;

import cpw.mods.fml.common.registry.GameRegistry;

public class MOGeneration {

	public static void init() {
		
		GameRegistry.registerWorldGenerator(new WorldGen());
		
	}
	
}
