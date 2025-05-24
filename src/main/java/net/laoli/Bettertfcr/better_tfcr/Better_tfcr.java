package net.laoli.Bettertfcr.better_tfcr;

import com.mojang.logging.LogUtils;
import net.laoli.Bettertfcr.better_tfcr.Item.RegisterItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static net.laoli.Bettertfcr.better_tfcr.ModRegister.*;
import static net.laoli.Bettertfcr.better_tfcr.RemoveRecipes.removeSpecifiedRecipe;
import static net.laoli.Bettertfcr.better_tfcr.addCreative.addCreatives;

import org.slf4j.Logger;

@Mod(Better_tfcr.MODID)
public class Better_tfcr {

    public static final String MODID = "better_tfcr";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Better_tfcr() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new RegisterItem.Items());
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        addCreatives(event);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Start deleting recipes");
        removeSpecifiedRecipe(); // 删除特定的配方
        LOGGER.info("Recipe deleted.");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}