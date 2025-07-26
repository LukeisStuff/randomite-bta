package luke.randomite;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteBlocks {

	public static int blockID =  RandomiteConfig.blockIDs;

	public static int blockID(String blockName) {
		try {
			return RandomiteConfig.cfg.getInt(RandomiteConfig.BlockIDs + "." + blockName);
		} catch (NullPointerException e) {
			RandomiteConfig.properties.addEntry(RandomiteConfig.BlockIDs + "." + blockName, blockID);
			return blockID++;
		}
	}

	public static Block<?> ORE_RANDOMITE_STONE;
	public static Block<?> ORE_RANDOMITE_BASALT;
	public static Block<?> ORE_RANDOMITE_LIMESTONE;
	public static Block<?> ORE_RANDOMITE_GRANITE;
	public static Block<?> ORE_RANDOMITE_PERMAFROST;

	public void initializeBlockDetails() {
		ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_STONE, 1);
		ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_BASALT, 1);
		ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_LIMESTONE, 1);
		ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_GRANITE, 1);
		ItemToolPickaxe.miningLevels.put(ORE_RANDOMITE_PERMAFROST, 1);

		Registries.ITEM_GROUPS.register("randomite:randomite_ores", Registries.stackListOf(ORE_RANDOMITE_STONE, ORE_RANDOMITE_BASALT, ORE_RANDOMITE_LIMESTONE, ORE_RANDOMITE_GRANITE, ORE_RANDOMITE_PERMAFROST));

	}

	public void initializeBlocks() {

		BlockBuilder ore = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(3.0f)
			.setResistance(5.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		// Randomite Ores
		ORE_RANDOMITE_STONE = ore
			.build("ore.randomiteore.stone", "ore_randomite_stone", blockID("ORE_RANDOMITE_STONE"), block -> new BlockLogicOreRandomite(block, Blocks.STONE, Material.stone));
		ORE_RANDOMITE_BASALT = ore
			.build("ore.randomiteore.basalt", "ore_randomite_basalt", blockID("ORE_RANDOMITE_BASALT"), block -> new BlockLogicOreRandomite(block, Blocks.BASALT, Material.basalt));
		ORE_RANDOMITE_LIMESTONE = ore
			.build("ore.randomiteore.limestone", "ore_randomite_limestone", blockID("ORE_RANDOMITE_LIMESTONE"), block -> new BlockLogicOreRandomite(block, Blocks.LIMESTONE, Material.limestone));
		ORE_RANDOMITE_GRANITE = ore
			.build("ore.randomiteore.granite", "ore_randomite_granite", blockID("ORE_RANDOMITE_GRANITE"), block -> new BlockLogicOreRandomite(block, Blocks.GRANITE, Material.granite));
		ORE_RANDOMITE_PERMAFROST = ore
			.setBlockSound(BlockSounds.PERMAFROST)
			.build("ore.randomiteore.permafrost", "ore_randomite_permafrost", blockID("ORE_RANDOMITE_PERMAFROST"), block -> new BlockLogicOreRandomite(block, Blocks.PERMAFROST, Material.permafrost));

	}
}
