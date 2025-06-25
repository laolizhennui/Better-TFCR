package net.laoli.Bettertfcr.better_tfcr.Register;

import net.laoli.Bettertfcr.better_tfcr.Fluid.Pulp;
import net.minecraftforge.eventbus.api.IEventBus;

public class RegisterAnyFluid {
    public static void registerAnyFluid(IEventBus modEventBus) {
        Pulp.register(modEventBus);
    }
}
