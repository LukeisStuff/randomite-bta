package luke.randomite.compat.deep;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.ModelEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class RandomiteDeepCompatibility implements PreLaunchEntrypoint, GameStartEntrypoint, ModelEntrypoint, RecipeEntrypoint {

	public static boolean IS_DEEP_LOADED = false;

	public static ModelEntrypoint modelEntryPointDelegate;
	public static RecipeEntrypoint recipeEntrypointDelegate;


	@Override
	public void onPreLaunch() {
		FabricLoader loader = FabricLoader.getInstance();

		IS_DEEP_LOADED = loader.isModLoaded("deep");

		if (IS_DEEP_LOADED) {

			try {
				modelEntryPointDelegate = (ModelEntrypoint) Class
					.forName("luke.randomite.compat.deep.RandomiteDeepModels")
					.getConstructor()
					.newInstance();

				recipeEntrypointDelegate = (RecipeEntrypoint) Class
					.forName("luke.randomite.compat.deep.RandomiteDeepRecipes")
					.getConstructor()
					.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static void callInit(String classPath, String methodName) {
		try {
			Class.forName(classPath).getMethod(methodName).invoke(null);
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void beforeGameStart() {
		if (IS_DEEP_LOADED) {
			callInit("luke.randomite.compat.deep.RandomiteDeepBlocks", "init");
		}
	}

	@Override
	public void afterGameStart() {
	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {
		if (IS_DEEP_LOADED) modelEntryPointDelegate.initBlockColors(dispatcher);
	}

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		if (IS_DEEP_LOADED) modelEntryPointDelegate.initBlockModels(dispatcher);
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		if (IS_DEEP_LOADED) modelEntryPointDelegate.initItemModels(dispatcher);
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
		if (IS_DEEP_LOADED) modelEntryPointDelegate.initEntityModels(dispatcher);
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
		if (IS_DEEP_LOADED) modelEntryPointDelegate.initTileEntityModels(dispatcher);
	}

	@Override
	public void onRecipesReady() {
		if (IS_DEEP_LOADED) recipeEntrypointDelegate.onRecipesReady();
	}

	@Override
	public void initNamespaces() {
		if (IS_DEEP_LOADED) recipeEntrypointDelegate.initNamespaces();
	}
}
