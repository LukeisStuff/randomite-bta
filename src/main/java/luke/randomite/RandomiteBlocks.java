package luke.randomite;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

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
			.build(new BlockOreRandomite("ore.randomite.stone", blockID("oreCopperStone")));
		oreRandomiteBasalt = ore
			.setTextures("randomitebasalt.png")
			.build(new BlockOreRandomite("ore.randomite.basalt", blockID("oreCopperBasalt")));
		oreRandomiteLimestone = ore
			.setTextures("randomitelimestone.png")
			.build(new BlockOreRandomite("ore.randomite.limestone", blockID("oreCopperLimestone")));
		oreRandomiteGranite = ore
			.setTextures("randomitegranite.png")
			.build(new BlockOreRandomite("ore.randomite.granite", blockID("oreCopperGranite")));


		initializeBlockDetails();
	}
}
