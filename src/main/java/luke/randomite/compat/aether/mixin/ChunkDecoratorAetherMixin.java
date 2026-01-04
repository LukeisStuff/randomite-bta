package luke.randomite.compat.aether.mixin;

import luke.randomite.compat.aether.BlockLogicOreRandomiteAether;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.aether.world.chunk.ChunkDecoratorAether;
import teamport.aether.world.feature.terrain.WorldFeatureAetherOre;

import java.util.Random;

@Mixin(value = ChunkDecoratorAether.class, remap = false)
public class ChunkDecoratorAetherMixin {

    @Shadow
    @Final
    private World world;

    @Unique
    private static final WorldFeatureAetherOre ORE_RANDOMITE;

    @Inject(method = "decorateWithOres(Ljava/util/Random;IIII)V", at = @At(value = "TAIL"), remap = false)
    public void addCustomOre(Random rand, int minY, int maxY, int worldX, int worldZ, CallbackInfo ci) {
        int rangeY = maxY + 1 - minY;
        float oreHeightModifier = (float) rangeY / 128.0F;

        for (int generateChance = 0; generateChance < 17.5F * oreHeightModifier; ++generateChance) {
            int y = rand.nextInt(rangeY);
            int x = worldX + rand.nextInt(16);
            int z = worldZ + rand.nextInt(16);
            ORE_RANDOMITE.place(this.world, rand, x, y, z);
        }
    }

    static {
        ORE_RANDOMITE = new WorldFeatureAetherOre(BlockLogicOreRandomiteAether.variantMap, 8);
    }

}
