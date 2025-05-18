package net.laoli.Bettertfcr.better_tfcr;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.laoli.Bettertfcr.better_tfcr.Better_tfcr.MODID;

public class ModRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    @SuppressWarnings("unused")
    public static class Items {
        public static final RegistryObject<Item> HIGH_CARBON_WROUGHT_IRON = ITEMS.register("high_carbon_wrought_iron", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GLASS_BOTTLE_WITHOUT_STOPPERS = ITEMS.register("glass_bottle_without_stoppers", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PLUG = ITEMS.register("plug", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COAL_ASH = ITEMS.register("coal_ash", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> DRIED_BEET_RESIDUE = ITEMS.register("dried_beet_residue", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COARSE_FIBER = ITEMS.register("coarse_fiber", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> FIBER = ITEMS.register("fiber", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PAPERMAKING_WIRE = ITEMS.register("papermaking_wire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> WITH_PAPERMAKING_WIRE_INSIDE = ITEMS.register("with_papermaking_wire_inside", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CLEAN_FIBER = ITEMS.register("clean_fiber", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ALKALINE_FIBER = ITEMS.register("alkaline_fiber", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CLEAN_ALKALINE_FIBER = ITEMS.register("clean_alkaline_fiber", () -> new Item(new Item.Properties()));
    }
    public static final RegistryObject<CreativeModeTab> BETTER_TFCR_TAB = CREATIVE_MODE_TABS
            .register("better_tfcr_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.better_tfcr.better_tfcr_tab"))
                    .icon(() -> new ItemStack(Items.HIGH_CARBON_WROUGHT_IRON.get())).build());
}
