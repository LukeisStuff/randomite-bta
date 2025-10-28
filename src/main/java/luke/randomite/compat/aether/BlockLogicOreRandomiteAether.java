package luke.randomite.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import teamport.aether.items.AetherItems;
import teamport.aether.world.feature.terrain.WorldFeatureAetherOre;

import java.util.Random;

public class BlockLogicOreRandomiteAether extends BlockLogic {
	public static WorldFeatureAetherOre.OreMap variantMap = new WorldFeatureAetherOre.OreMap();

	public BlockLogicOreRandomiteAether(Block<?> block, Block<?> parentBlock, Material material) {
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
					return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_BLUE, 1)};
				} else if (random > 31 && random <= 50) {
					return new ItemStack[]{new ItemStack(AetherItems.AMBROSIUM, 1)};
				} else if (random > 50 && random <= 60) {
					return new ItemStack[]{new ItemStack(AetherItems.ZANITE, 1)};
				} else if (random > 60 && random <= 70) {
					return new ItemStack[]{new ItemStack(AetherItems.AMBER, 1)};
				} else if (random > 70 && random <= 80) {
					return new ItemStack[]{new ItemStack(AetherItems.PETAL_AECHOR, 1)};
				} else if (random > 80 && random <= 90) {
					return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_WHITE, 1)};
				} else if (random > 90 && random <= 95) {
					return new ItemStack[]{new ItemStack(AetherItems.ORE_RAW_GRAVITITE, 1)};
				} else if (random > 95) {
					return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_BLACK, 1)};
				}
			default:
				return null;
		}
	}
}
