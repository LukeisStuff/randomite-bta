package luke.randomite.compat.aether;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

public class RandomiteAetherModels implements ModelEntrypoint {

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        dispatcher.addDispatch(new BlockModelStandard<>(RandomiteAetherBlocks.ORE_RANDOMITE_HOLYSTONE)
            .setAllTextures(0, "randomite:block/ore/randomite/holystone")
            .setAllTextures(2, "randomite:block/ore/randomite/holystone_retro"));
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
