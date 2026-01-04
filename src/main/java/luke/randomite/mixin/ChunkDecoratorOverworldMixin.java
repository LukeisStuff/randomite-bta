package luke.randomite.mixin;

import luke.randomite.BlockLogicOreRandomite;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

//Thanks DEEP mod for code

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public class ChunkDecoratorOverworldMixin {
    @Shadow
    @Final
    private World world;

    @Inject(method = "decorate(Lnet/minecraft/core/world/chunk/Chunk;)V", at = @At(value = "TAIL"))
    public void addCustomOre(Chunk chunk, CallbackInfo ci) {
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        int minY = this.world.getWorldType().getMinY();
        int maxY = this.world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;
        float oreHeightModifier = (float) rangeY / 128.0F;
        Random rand = new Random((long) chunkX * 341873898712L + (long) chunkZ * 132696981241L);
        int x = chunkX * 16;
        int z = chunkZ * 16;

        for (int i4 = 0; (float) i4 < 20.0F * oreHeightModifier; ++i4) {
            int j7 = x + rand.nextInt(16);
            int k10 = minY + rand.nextInt(rangeY);
            int j13 = z + rand.nextInt(16);
            (new WorldFeatureOre(BlockLogicOreRandomite.variantMap, 8)).place(this.world, rand, j7, k10, j13);
        }
    }

}
