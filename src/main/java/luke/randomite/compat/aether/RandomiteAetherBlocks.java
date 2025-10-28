package luke.randomite.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import teamport.aether.AetherMod;
import teamport.aether.blocks.AetherBlockTags;
import teamport.aether.blocks.AetherBlocks;
import teamport.aether.items.itemtool.ItemToolPickaxeAether;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.randomite.RandomiteConfig.blockID;

public class RandomiteAetherBlocks {

	public static Block<?> ORE_RANDOMITE_HOLYSTONE;

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeBlocks();
		}
	}

	public void initializeBlockDetails() {
		ItemToolPickaxeAether.miningLevels.put(ORE_RANDOMITE_HOLYSTONE, 1);
	}

	public static void initializeBlocks() {

		BlockBuilder ore = new BlockBuilder(AetherMod.MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(0.5f)
			.setTags(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE, BlockTags.CHAINLINK_FENCES_CONNECT);

		// Aether Randomite Ores
		ORE_RANDOMITE_HOLYSTONE = ore
			.build("ore.randomite.holystone", "ore_randomite_holystone", blockID("ORE_RANDOMITE_HOLYSTONE"), block -> new BlockLogicOreRandomiteAether(block, AetherBlocks.HOLYSTONE, Material.marble));

	}
}
