package luke.randomite;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

public class RandomiteModels implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {



		dispatcher.addDispatch(new BlockModelStandard<>(RandomiteBlocks.ORE_RANDOMITE_STONE)
			.setAllTextures(0, "randomite:block/randomitestone"));
		dispatcher.addDispatch(new BlockModelStandard<>(RandomiteBlocks.ORE_RANDOMITE_BASALT)
			.setAllTextures(0, "randomite:block/randomitegranite"));
		dispatcher.addDispatch(new BlockModelStandard<>(RandomiteBlocks.ORE_RANDOMITE_LIMESTONE)
			.setAllTextures(0, "randomite:block/randomitelimestone"));
		dispatcher.addDispatch(new BlockModelStandard<>(RandomiteBlocks.ORE_RANDOMITE_GRANITE)
			.setAllTextures(0, "randomite:block/randomitegranite"));
		dispatcher.addDispatch(new BlockModelStandard<>(RandomiteBlocks.ORE_RANDOMITE_PERMAFROST)
			.setAllTextures(0, "randomite:block/randomitepermafrost"));

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {
	}
}
