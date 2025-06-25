package net.laoli.Bettertfcr.better_tfcr;

import net.laoli.Bettertfcr.better_tfcr.Register.RegisterItem;
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

    public static final RegistryObject<CreativeModeTab> BETTER_TFCR_TAB = CREATIVE_MODE_TABS
            .register("better_tfcr_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.better_tfcr.better_tfcr_tab"))
                    .icon(() -> new ItemStack(RegisterItem.Items.HIGH_CARBON_WROUGHT_IRON.get())).build());
}
