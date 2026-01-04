package luke.randomite.compat.deep;

import luke.randomite.BlockLogicOreRandomite;
import luke.randomite.RandomiteConfig;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import silveon22.deep.block.DEEPBlocks;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteDeepBlocks {

    public static Block<?> ORE_RANDOMITE_ABYSSALRITE;
    public static Block<?> ORE_RANDOMITE_PEARLSTONE;
    public static Block<?> ORE_RANDOMITE_PERIDOTITE;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeBlocks();
        }
    }

    public void initializeBlockDetails() {
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_ABYSSALRITE, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_PEARLSTONE, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_PERIDOTITE, 1);
    }

    public static void initializeBlocks() {

        BlockBuilder ore = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
            .setHardness(3.0f)
            .setResistance(5.0f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CHAINLINK_FENCES_CONNECT);

        // Randomite Ores
        ORE_RANDOMITE_ABYSSALRITE = ore
            .build("ore.randomite.abyssalrite", "ore_randomite_abyssalrite", RandomiteConfig.blockID("ORE_RANDOMITE_ABYSSALRITE"), block -> new BlockLogicOreRandomite(block, DEEPBlocks.abyssalrite, Material.basalt));
        ORE_RANDOMITE_PEARLSTONE = ore
            .build("ore.randomite.pearlstone", "ore_randomite_pearlstone", RandomiteConfig.blockID("ORE_RANDOMITE_PEARLSTONE"), block -> new BlockLogicOreRandomite(block, DEEPBlocks.pearlstone, Material.basalt));
        ORE_RANDOMITE_PERIDOTITE = ore
            .build("ore.randomite.peridotite", "ore_randomite_peridotite", RandomiteConfig.blockID("ORE_RANDOMITE_PERIDOTITE"), block -> new BlockLogicOreRandomite(block, DEEPBlocks.peridotite, Material.limestone));
    }
}
