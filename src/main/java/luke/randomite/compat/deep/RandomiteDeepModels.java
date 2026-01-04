package luke.randomite.compat.deep;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

public class RandomiteDeepModels implements ModelEntrypoint {
    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        dispatcher.addDispatch(new BlockModelStandard<>(RandomiteDeepBlocks.ORE_RANDOMITE_ABYSSALRITE)
            .setAllTextures(0, "randomite:block/ore/randomite/abyssalrite"));
        dispatcher.addDispatch(new BlockModelStandard<>(RandomiteDeepBlocks.ORE_RANDOMITE_PEARLSTONE)
            .setAllTextures(0, "randomite:block/ore/randomite/pearlstone"));
        dispatcher.addDispatch(new BlockModelStandard<>(RandomiteDeepBlocks.ORE_RANDOMITE_PERIDOTITE)
            .setAllTextures(0, "randomite:block/ore/randomite/peridotite"));
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
