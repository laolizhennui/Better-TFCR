package net.laoli.Bettertfcr.better_tfcr.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static net.laoli.Bettertfcr.better_tfcr.ModRegister.ITEMS;

public class RegisterItem {
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
        public static final RegistryObject<Item> THERMOMETER = ITEMS.register("thermometer", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> EMPTY_THERMOMETER = ITEMS.register("empty_thermometer", () -> new Item(new Item.Properties()));
    }
}
