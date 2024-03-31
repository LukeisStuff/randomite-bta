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
		int random = rand.nextInt(50);
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			case EXPLOSION:
			case PROPER_TOOL:
				if (random > 0 && random < 18) {
					return new ItemStack[]{new ItemStack(Item.eggChicken, 1)};
				} else if (random > 18 && random < 31) {
					return new ItemStack[]{new ItemStack(Item.coal, 1)};
				} else if (random > 31 && random < 38) {
					return new ItemStack[]{new ItemStack(Item.oreRawIron, 1)};
				} else if (random > 38 && random < 45) {
					return new ItemStack[]{new ItemStack(Item.oreRawGold, 1)};
				} else {
					return new ItemStack[]{new ItemStack(Item.diamond, 1)};
				}
			default:
				return null;
		}
	}
}
