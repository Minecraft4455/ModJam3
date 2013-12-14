package net.crowifick.molife.blocks;

import java.util.Random;

import net.crowifick.molife.core.info.Info;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Fenfero extends BlockFlower {

	protected Fenfero(int id) {

		super(id, Material.plants);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F,
				0.5F + f);

	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {

		return super.canPlaceBlockAt(par1World, par2, par3, par4)
				&& canBlockStay(par1World, par2, par3, par4);

	}

	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
		return par1 == Block.grass.blockID || par1 == Block.dirt.blockID;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		this.checkFlowerChange(par1World, par2, par3, par4);
	}

	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		this.checkFlowerChange(par1World, par2, par3, par4);
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
		return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World
				.canBlockSeeTheSky(par2, par3, par4))
				&& (soil != null && soil.canSustainPlant(par1World, par2,
						par3 - 1, par4, ForgeDirection.UP, this));
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 1;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		
		blockIcon = icon.registerIcon(Info.MODID + ":Fenfero");
		
	}

}
