package luke.randomite.ModContainer.TerrainApi;

import luke.randomite.RandomiteBlocks;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

import static luke.randomite.RandomiteMod.MOD_ID;

public class TerrainApiPlugin implements TerrainAPI {
	@Override
	public String getModID() {
		return MOD_ID;
	}

	public static final OverworldConfig overworldConfig = ChunkDecoratorOverworldAPI.overworldConfig;

	@Override
	public void onInitialize() {

		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(getModID(), RandomiteBlocks.oreRandomiteStone, 8, 32, 0.0f, 1.0f, true);

	}
}
