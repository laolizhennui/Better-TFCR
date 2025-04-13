package net.laoli.Bettertfcr.better_tfcr;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

@Mod(Better_tfcr.MODID)
public class Better_tfcr {

    public static final String MODID = "better_tfcr";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final RegistryObject<Item> HIGH_CARBON_WROUGHT_IRON = ITEMS.register("high_carbon_wrought_iron", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLASS_BOTTLE_WITHOUT_STOPPERS = ITEMS.register("glass_bottle_without_stoppers", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLUG = ITEMS.register("plug", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_ASH = ITEMS.register("coal_ash", () -> new Item(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> BETTER_TFCR_TAB = CREATIVE_MODE_TABS.register("better_tfcr_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.better_tfcr.better_tfcr_tab")) // 标签页名称的翻译键
                    .icon(() -> new ItemStack(HIGH_CARBON_WROUGHT_IRON.get()))
                    .build());
    public Better_tfcr() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info("{}{}", Config.magicNumberIntroduction, Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == BETTER_TFCR_TAB.getKey()) {
            event.accept(HIGH_CARBON_WROUGHT_IRON);
            event.accept(GLASS_BOTTLE_WITHOUT_STOPPERS);
            event.accept(PLUG);
            event.accept(COAL_ASH);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}