package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteBlocks {

    public static Block<?> ORE_RANDOMITE_STONE;
    public static Block<?> ORE_RANDOMITE_BASALT;
    public static Block<?> ORE_RANDOMITE_LIMESTONE;
    public static Block<?> ORE_RANDOMITE_GRANITE;
    public static Block<?> ORE_RANDOMITE_PERMAFROST;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeBlocks();
        }
    }

    public void initializeBlockDetails() {
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_STONE, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_BASALT, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_LIMESTONE, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_GRANITE, 1);
        ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_PERMAFROST, 1);
    }

    public static void initializeBlocks() {

        BlockBuilder ore = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
            .setHardness(3.0f)
            .setResistance(5.0f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CHAINLINK_FENCES_CONNECT);

        // Randomite Ores
        ORE_RANDOMITE_STONE = ore
            .build("ore.randomite.stone", "ore_randomite_stone", RandomiteConfig.blockID("ORE_RANDOMITE_STONE"), block -> new BlockLogicOreRandomite(block, Blocks.STONE, Material.stone));
        ORE_RANDOMITE_BASALT = ore
            .build("ore.randomite.basalt", "ore_randomite_basalt", RandomiteConfig.blockID("ORE_RANDOMITE_BASALT"), block -> new BlockLogicOreRandomite(block, Blocks.BASALT, Material.basalt));
        ORE_RANDOMITE_LIMESTONE = ore
            .build("ore.randomite.limestone", "ore_randomite_limestone", RandomiteConfig.blockID("ORE_RANDOMITE_LIMESTONE"), block -> new BlockLogicOreRandomite(block, Blocks.LIMESTONE, Material.limestone));
        ORE_RANDOMITE_GRANITE = ore
            .build("ore.randomite.granite", "ore_randomite_granite", RandomiteConfig.blockID("ORE_RANDOMITE_GRANITE"), block -> new BlockLogicOreRandomite(block, Blocks.GRANITE, Material.granite));
        ORE_RANDOMITE_PERMAFROST = ore
            .setBlockSound(BlockSounds.PERMAFROST)
            .build("ore.randomite.permafrost", "ore_randomite_permafrost", RandomiteConfig.blockID("ORE_RANDOMITE_PERMAFROST"), block -> new BlockLogicOreRandomite(block, Blocks.PERMAFROST, Material.permafrost));

    }
}
