package luke.randomite.compat.aether;

import net.minecraft.core.data.registry.Registries;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteAetherRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

		Registries.ITEM_GROUPS.getItem("randomite:randomite_ores").add(RandomiteAetherBlocks.ORE_RANDOMITE_HOLYSTONE.getDefaultStack());
	}
}
