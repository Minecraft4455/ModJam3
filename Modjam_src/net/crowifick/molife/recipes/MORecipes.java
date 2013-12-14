package net.crowifick.molife.recipes;

import net.crowifick.molife.blocks.MOBlocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MORecipes {

	public static void init() {
		
		shapelessRecipes();
		
	}

	private static void shapelessRecipes() {

		GameRegistry.addShapelessRecipe(new ItemStack(MOBlocks.YellowCactusBlock, 4), MOBlocks.YellowCactus);
		
	}
	
}
