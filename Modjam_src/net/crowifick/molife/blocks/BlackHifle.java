package net.crowifick.molife.blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlackHifle extends BlockFlower {

	protected BlackHifle(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabDecorations);
        float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
        
	}
	
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		
		return super.canPlaceBlockAt(par1World, par2, par3, par4)&& canBlockStay(par1World, par2, par3, par4);
	
	}


}
