package net.laoli.Bettertfcr.better_tfcr.Register;

import net.laoli.Bettertfcr.better_tfcr.Fluid.Pulp;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

 import static net.laoli.Bettertfcr.better_tfcr.ModRegister.BLOCKS;

public class RegisterBlock {
    @SuppressWarnings("unused")
    public static class Blocks {
        public static final RegistryObject<LiquidBlock> PULP_BLOCK = BLOCKS.register("pulp_block",
                () -> new LiquidBlock(Pulp.SOURCE, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WATER).noLootTable()));
    }
}
