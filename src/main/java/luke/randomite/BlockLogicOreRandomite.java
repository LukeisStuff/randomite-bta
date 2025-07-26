package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicOreCoal;
import net.minecraft.core.block.BlockLogicOreRedstone;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;

import java.util.Random;

public class BlockLogicOreRandomite extends BlockLogic {
	public static WorldFeatureOre.OreMap variantMap = new WorldFeatureOre.OreMap();

	public BlockLogicOreRandomite(Block<?> block, Block<?> parentBlock, Material material) {
		super(block, material);
		variantMap.put(parentBlock.id(), block.id());
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		Random rand = new Random();
		int random = rand.nextInt(100);
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			case EXPLOSION:
			case PROPER_TOOL:
				if (random <= 30) {
					return new ItemStack[]{new ItemStack(Items.EGG_CHICKEN, 1)};
				} else if (random > 31 && random <= 50) {
					return new ItemStack[]{new ItemStack(Items.COAL, 1)};
				} else if (random > 50 && random <= 60) {
					return new ItemStack[]{new ItemStack(Items.ORE_RAW_IRON, 1)};
				} else if (random > 60 && random <= 70) {
					return new ItemStack[]{new ItemStack(Items.ORE_RAW_GOLD, 1)};
				} else if (random > 70 && random <= 80) {
					return new ItemStack[]{new ItemStack(Items.DYE, 4 + world.rand.nextInt(5), 4)};
				} else if (random > 80 && random <= 90) {
					return new ItemStack[]{new ItemStack(Items.DUST_REDSTONE, 1+ world.rand.nextInt(2))};
				} else if (random > 90 && random <= 95) {
					return new ItemStack[]{new ItemStack(Items.DIAMOND, 1)};
				} else if (random > 95) {
					return new ItemStack[]{new ItemStack(Items.INGOT_STEEL_CRUDE, 1)};
				}
			default:
				return null;
		}
	}
}
