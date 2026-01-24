package luke.randomite.compat.aether;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.spongepowered.asm.mixin.Mixins;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class RandomiteAetherMod implements PreLaunchEntrypoint, GameStartEntrypoint, RecipeEntrypoint {

    public static boolean IS_AETHER_LOADED = false;

    public static RecipeEntrypoint recipeEntrypointDelegate;


    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();

        IS_AETHER_LOADED = loader.isModLoaded("aether");

        if (IS_AETHER_LOADED) {
            Mixins.addConfiguration("compat/randomite/aether/aether.mixins.json");

            try {

                recipeEntrypointDelegate = (RecipeEntrypoint) Class
                    .forName("luke.randomite.compat.aether.RandomiteAetherRecipes")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void beforeGameStart() {
        if (IS_AETHER_LOADED) {
            RandomiteAetherBlocks.init();
        }
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void onRecipesReady() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.onRecipesReady();
    }

    @Override
    public void initNamespaces() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.initNamespaces();
    }
}
