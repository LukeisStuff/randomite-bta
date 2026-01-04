package luke.randomite.compat.deep;

import net.minecraft.core.data.registry.Registries;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteDeepRecipes implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {

    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);

        Registries.ITEM_GROUPS.getItem("randomite:randomite_ores").add(RandomiteDeepBlocks.ORE_RANDOMITE_ABYSSALRITE.getDefaultStack());
        Registries.ITEM_GROUPS.getItem("randomite:randomite_ores").add(RandomiteDeepBlocks.ORE_RANDOMITE_PEARLSTONE.getDefaultStack());
        Registries.ITEM_GROUPS.getItem("randomite:randomite_ores").add(RandomiteDeepBlocks.ORE_RANDOMITE_PERIDOTITE.getDefaultStack());
    }
}
