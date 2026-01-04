package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import silveon22.deep.item.DEEPItems;

import static luke.randomite.compat.deep.RandomiteDeepCompatibility.IS_DEEP_LOADED;

public class BlockLogicOreRandomite extends BlockLogic {
    public static WorldFeatureOre.OreMap variantMap = new WorldFeatureOre.OreMap();

    public BlockLogicOreRandomite(Block<?> block, Block<?> parentBlock, Material material) {
        super(block, material);
        variantMap.put(parentBlock.id(), block.id());
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        if (IS_DEEP_LOADED) {
            int roll = world.rand.nextInt(100);

            switch (dropCause) {
                case SILK_TOUCH:
                case PICK_BLOCK:
                    return new ItemStack[]{new ItemStack(this)};
                case EXPLOSION:
                case PROPER_TOOL:
                    if (roll <= 30) return new ItemStack[]{new ItemStack(Items.EGG_CHICKEN)};
                    if (roll <= 50) return new ItemStack[]{new ItemStack(Items.COAL)};

                    if (roll <= 55) return new ItemStack[]{new ItemStack(Items.ORE_RAW_IRON)};
                    if (roll <= 60) return new ItemStack[]{new ItemStack(Items.ORE_RAW_GOLD)};

                    if (roll <= 65) return new ItemStack[]{new ItemStack(DEEPItems.rawLead)};
                    if (roll <= 70) return new ItemStack[]{new ItemStack(DEEPItems.rawSilver)};

                    if (roll <= 75) return new ItemStack[]{new ItemStack(Items.DYE, 4 + world.rand.nextInt(5), 4)};
                    if (roll <= 80) return new ItemStack[]{new ItemStack(Items.DUST_REDSTONE, 1 + world.rand.nextInt(2))};

                    if (roll <= 85) return new ItemStack[]{new ItemStack(DEEPItems.rhodonite)};
                    if (roll <= 90) return new ItemStack[]{new ItemStack(DEEPItems.uranium)};

                    if (roll <= 93) return new ItemStack[]{new ItemStack(Items.DIAMOND)};

                    if (roll <= 97) return new ItemStack[]{new ItemStack(DEEPItems.amethyst)};

                    return new ItemStack[]{new ItemStack(Items.INGOT_STEEL_CRUDE)};
                default:
                    return null;
            }
        }

        int roll = world.rand.nextInt(100);

        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
                return new ItemStack[]{new ItemStack(this)};
            case EXPLOSION:
            case PROPER_TOOL:
                if (roll <= 30) return new ItemStack[]{new ItemStack(Items.EGG_CHICKEN)};
                if (roll <= 50) return new ItemStack[]{new ItemStack(Items.COAL)};
                if (roll <= 60) return new ItemStack[]{new ItemStack(Items.ORE_RAW_IRON)};
                if (roll <= 70) return new ItemStack[]{new ItemStack(Items.ORE_RAW_GOLD)};
                if (roll <= 80) return new ItemStack[]{new ItemStack(Items.DYE, 4 + world.rand.nextInt(5), 4)};
                if (roll <= 90) return new ItemStack[]{new ItemStack(Items.DUST_REDSTONE, 1 + world.rand.nextInt(2))};
                if (roll <= 95) return new ItemStack[]{new ItemStack(Items.DIAMOND)};
                return new ItemStack[]{new ItemStack(Items.INGOT_STEEL_CRUDE)};
            default:
                return null;
        }
    }
}
