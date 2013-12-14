package net.crowifick.molife.blocks;

import net.crowifick.molife.core.info.Info;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlueCactusBlock extends Block {

	public BlueCactusBlock(int id) {
		
		super(id, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
	
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		
		blockIcon = icon.registerIcon(Info.MODID + ":BlueCactusBlock");
		
	}
	
}
