package luke.randomite;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

		RecipeBuilder.Furnace(MOD_ID)
			.setInput("randomite:randomite_ores")
			.create("randomite_ores_to_egg", Items.EGG_CHICKEN.getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput("randomite:randomite_ores")
			.create("randomite_ores_to_egg", Items.EGG_CHICKEN.getDefaultStack());

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

		Registries.ITEM_GROUPS.register("randomite:randomite_ores", Registries.stackListOf(
			RandomiteBlocks.ORE_RANDOMITE_STONE,
			RandomiteBlocks.ORE_RANDOMITE_BASALT,
			RandomiteBlocks.ORE_RANDOMITE_LIMESTONE,
			RandomiteBlocks.ORE_RANDOMITE_GRANITE,
			RandomiteBlocks.ORE_RANDOMITE_PERMAFROST));

	}
}
