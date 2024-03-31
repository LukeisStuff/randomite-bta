package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteBlocks {

	private int blockID(String blockName) {
		return RandomiteConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block oreRandomiteStone;
	public static Block oreRandomiteBasalt;
	public static Block oreRandomiteLimestone;
	public static Block oreRandomiteGranite;

	private void initializeBlockDetails() {
		ItemToolPickaxe.miningLevels.put(oreRandomiteStone, 1);
		ItemToolPickaxe.miningLevels.put(oreRandomiteBasalt, 1);
		ItemToolPickaxe.miningLevels.put(oreRandomiteLimestone, 1);
		ItemToolPickaxe.miningLevels.put(oreRandomiteGranite, 1);

		CreativeHelper.setParent(oreRandomiteStone, Block.oreCoalGranite);
		CreativeHelper.setParent(oreRandomiteBasalt, Block.oreCoalGranite);
		CreativeHelper.setParent(oreRandomiteLimestone, Block.oreCoalGranite);
		CreativeHelper.setParent(oreRandomiteGranite, Block.oreCoalGranite);

		Registries.ITEM_GROUPS.register("randomite:randomite_ores", Registries.stackListOf(oreRandomiteStone, oreRandomiteBasalt, oreRandomiteLimestone, oreRandomiteGranite));

	}

	public void initializeBlocks() {

		BlockBuilder ore = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(3.0f)
			.setResistance(5.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		// Randomite Ores
		oreRandomiteStone = ore
			.setTextures("randomitestone.png")
			.build(new BlockOreRandomite("ore.randomiteore.stone", blockID("oreRandomiteStone")));
		oreRandomiteBasalt = ore
			.setTextures("randomitebasalt.png")
			.build(new BlockOreRandomite("ore.randomiteore.basalt", blockID("oreRandomiteBasalt")));
		oreRandomiteLimestone = ore
			.setTextures("randomitelimestone.png")
			.build(new BlockOreRandomite("ore.randomiteore.limestone", blockID("oreRandomiteLimestone")));
		oreRandomiteGranite = ore
			.setTextures("randomitegranite.png")
			.build(new BlockOreRandomite("ore.randomiteore.granite", blockID("oreRandomiteGranite")));


		initializeBlockDetails();
	}
}
