package net.crowifick.molife.blocks;

import java.util.Random;

import net.crowifick.molife.core.info.Info;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class YellowCactus extends Block implements IPlantable {
	
	@SideOnly(Side.CLIENT)
	private Icon cactusTopIcon;
	@SideOnly(Side.CLIENT)
	private Icon cactusBottomIcon;

	protected YellowCactus(int par1) {
		super(par1, Material.cactus);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setHardness(1.9F);
	}

	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if (par1World.isAirBlock(par2, par3 + 1, par4)) {
			int l;

			for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == this.blockID; ++l) {
				;
			}

			if (l < 3) {
				int i1 = par1World.getBlockMetadata(par2, par3, par4);

				if (i1 == 15) {
					par1World.setBlock(par2, par3 + 1, par4, this.blockID);
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
					this.onNeighborBlockChange(par1World, par2, par3 + 1, par4,
							this.blockID);
				} else {
					par1World.setBlockMetadataWithNotify(par2, par3, par4,
							i1 + 1, 4);
				}
			}
		}
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		float f = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB((double) ((float) par2 + f),
				(double) par3, (double) ((float) par4 + f),
				(double) ((float) (par2 + 1) - f),
				(double) ((float) (par3 + 1) - f),
				(double) ((float) (par4 + 1) - f));
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		float f = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB((double) ((float) par2 + f),
				(double) par3, (double) ((float) par4 + f),
				(double) ((float) (par2 + 1) - f), (double) (par3 + 1),
				(double) ((float) (par4 + 1) - f));
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.cactusTopIcon
				: (par1 == 0 ? this.cactusBottomIcon : this.blockIcon);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderType() {
		return 13;
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false
				: this.canBlockStay(par1World, par2, par3, par4);
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
		if (!this.canBlockStay(par1World, par2, par3, par4)) {
			par1World.destroyBlock(par2, par3, par4, true);
		}
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockMaterial(par2 - 1, par3, par4).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2 + 1, par3, par4).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2, par3, par4 - 1).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2, par3, par4 + 1).isSolid()) {
			return false;
		} else {
			int l = par1World.getBlockId(par2, par3 - 1, par4);
			return blocksList[l] != null
					&& blocksList[l].canSustainPlant(par1World, par2, par3 - 1,
							par4, ForgeDirection.UP, this);
		}
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		par5Entity.attackEntityFrom(DamageSource.cactus, 1.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Info.MODID + ":YellowCactusSide");
		this.cactusTopIcon = par1IconRegister.registerIcon(Info.MODID + ":YellowCactusTop");
		this.cactusBottomIcon = par1IconRegister.registerIcon(Info.MODID + ":YellowCactusBottom");
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return EnumPlantType.Desert;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		return blockID;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		return -1;
	}
}
