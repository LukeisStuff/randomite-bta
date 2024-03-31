package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockOreRandomite extends Block {
	public BlockOreRandomite(String key, int id) {
		super(key, id, Material.stone);
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
				if (random > 0 && random < 30) {
					return new ItemStack[]{new ItemStack(Item.eggChicken, 1)};
				} else if (random > 30 && random < 50) {
					return new ItemStack[]{new ItemStack(Item.coal, 1)};
				} else if (random > 50 && random < 60) {
					return new ItemStack[]{new ItemStack(Item.oreRawIron, 1)};
				} else if (random > 60 && random < 70) {
					return new ItemStack[]{new ItemStack(Item.oreRawGold, 1)};
				} else if (random > 70 && random < 80) {
					return new ItemStack[]{new ItemStack(Item.dye, 4 + world.rand.nextInt(5), 4)};
				} else if (random > 80 && random < 90) {
					return new ItemStack[]{new ItemStack(Item.dustRedstone, 1+ world.rand.nextInt(2))};
				} else if (random > 90 && random < 95) {
					return new ItemStack[]{new ItemStack(Item.diamond, 1)};
				} else if (random > 95 && random < 99) {
					return new ItemStack[]{new ItemStack(Item.ingotSteelCrude, 1)};
				}
			default:
				return null;
		}
	}
}
