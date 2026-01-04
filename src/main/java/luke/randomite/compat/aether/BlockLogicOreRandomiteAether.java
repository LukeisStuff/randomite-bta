package luke.randomite.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import teamport.aether.item.AetherItems;

public class BlockLogicOreRandomiteAether extends BlockLogic {
    public static WorldFeatureOre.OreMap variantMap = new WorldFeatureOre.OreMap();

    public BlockLogicOreRandomiteAether(Block<?> block, Block<?> parentBlock, Material material) {
        super(block, material);
        variantMap.put(parentBlock.id(), block.id());
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        int roll = world.rand.nextInt(100);

        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
                return new ItemStack[]{new ItemStack(this)};
            case EXPLOSION:
            case PROPER_TOOL:
                if (roll <= 30) return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_BLUE)};
                if (roll <= 50) return new ItemStack[]{new ItemStack(AetherItems.AMBROSIUM)};
                if (roll <= 60) return new ItemStack[]{new ItemStack(AetherItems.ZANITE)};
                if (roll <= 70) return new ItemStack[]{new ItemStack(AetherItems.AMBER)};
                if (roll <= 80) return new ItemStack[]{new ItemStack(AetherItems.PETAL_AECHOR)};
                if (roll <= 90) return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_WHITE)};
                if (roll <= 95) return new ItemStack[]{new ItemStack(AetherItems.ORE_RAW_GRAVITITE)};
                return new ItemStack[]{new ItemStack(AetherItems.EGG_MOA_BLACK)};
            default:
                return null;
        }
    }
}
