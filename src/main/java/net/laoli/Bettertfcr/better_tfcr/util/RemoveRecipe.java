package net.laoli.Bettertfcr.better_tfcr.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.Map;
import java.util.Set;

public class RemoveRecipe {
    public static void removeRecipeById(ResourceLocation recipeId) {
        // 获取当前服务器的配方管理器
        final RecipeManager manager = ServerLifecycleHooks.getCurrentServer().getRecipeManager();

        // 通过反射获取配方映射
        final Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes = ObfuscationReflectionHelper.getPrivateValue(
                RecipeManager.class,
                manager,
                "f_44007_"
        );

        if (recipes != null) {
            // 遍历所有配方类型
            recipes.values().forEach(map -> map.remove(recipeId));
            // 触发配方重新加载
            manager.replaceRecipes(manager.getRecipes());
        }
    }

    public static void batchRemoveRecipeById(Set<ResourceLocation> recipeIds) {
        final RecipeManager manager = ServerLifecycleHooks.getCurrentServer().getRecipeManager();
        final Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes = ObfuscationReflectionHelper.getPrivateValue(
                RecipeManager.class,
                manager,
                "f_44007_"
        );

        if (recipes != null) {
            recipeIds.forEach(id ->
                    recipes.values().forEach(map -> map.remove(id))
            );
            // 保持单次配方更新调用
            manager.replaceRecipes(manager.getRecipes());
        }
    }
}