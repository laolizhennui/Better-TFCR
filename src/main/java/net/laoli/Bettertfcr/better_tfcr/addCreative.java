package net.laoli.Bettertfcr.better_tfcr;

import net.laoli.Bettertfcr.better_tfcr.Register.RegisterItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;

import static net.laoli.Bettertfcr.better_tfcr.ModRegister.BETTER_TFCR_TAB;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.world.item.Item;

public class addCreative {
    public static void addCreatives(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == BETTER_TFCR_TAB.getKey()) {
            try {
                // 反射遍历Items类的所有静态字段
                for (Field field : RegisterItem.Items.class.getDeclaredFields()) {
                    // 筛选符合要求的RegistryObject<Item>类型字段
                    if (Modifier.isStatic(field.getModifiers())
                            && RegistryObject.class.isAssignableFrom(field.getType())) {
                        RegistryObject<Item> registryObject = (RegistryObject<Item>) field.get(null);
                        event.accept(registryObject.get());
                    }
                }
            } catch (IllegalAccessException e) {
                Better_tfcr.LOGGER.error("无法访问Items类字段", e);
            }
        }
    }
}
