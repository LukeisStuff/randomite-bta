package luke.randomite;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class RandomiteMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "randomite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Randomite initialized.");
    }

    @Override
    public void beforeGameStart() {
        RandomiteBlocks.init();
    }

    @Override
    public void afterGameStart() {
        new RandomiteBlocks().initializeBlockDetails();
    }

    @Override
    public void onRecipesReady() {

    }

    @Override
    public void initNamespaces() {

    }
}
