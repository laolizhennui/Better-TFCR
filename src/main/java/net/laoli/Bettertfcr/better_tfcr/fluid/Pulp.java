package net.laoli.Bettertfcr.better_tfcr.Fluid;

import net.laoli.Bettertfcr.better_tfcr.Better_tfcr;
import net.laoli.Bettertfcr.better_tfcr.Register.RegisterBlock;
import net.laoli.Bettertfcr.better_tfcr.Register.RegisterItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class Pulp {
    private static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    private static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    private static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    private static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Better_tfcr.MODID);

    private static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Better_tfcr.MODID);

    public static final RegistryObject<FluidType> FLUID_TYPE = FLUID_TYPES.register("pulp_type",
            () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xFFFFFF,
                    new Vector3f(1.0f, 1.0f, 1.0f),
                    net.laoli.Bettertfcr.better_tfcr.util.Fluid.waterLike().canConvertToSource(false)));

    public static final RegistryObject<FlowingFluid> SOURCE = FLUIDS.register("pulp",
            () -> new ForgeFlowingFluid.Source(Pulp.FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING = FLUIDS.register("pulp_flowing",
            () -> new ForgeFlowingFluid.Flowing(Pulp.FLUID_PROPERTIES));

    private static final ForgeFlowingFluid.Properties FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            FLUID_TYPE, SOURCE, FLOWING)
            .block(RegisterBlock.Blocks.PULP_BLOCK)
            .bucket(RegisterItem.Items.PULP_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
