package luke.randomite.compat.aether.mixin;

import net.minecraft.core.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import teamport.aether.item.item_tool.ItemToolPickaxeAether;

import java.util.Map;

@Mixin(value = ItemToolPickaxeAether.class, remap = false)
public interface AetherPickaxeAccessor {
    @Accessor("MINING_LEVELS")
    static Map<Block<?>, Integer> getMiningLevels() {
        throw new AssertionError("Mixin not applied!");
    }
}

