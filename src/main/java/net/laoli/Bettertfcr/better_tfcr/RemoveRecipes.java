package net.laoli.Bettertfcr.better_tfcr;

import net.minecraft.resources.ResourceLocation;

import static net.laoli.Bettertfcr.better_tfcr.util.RemoveRecipe.removeRecipeById;

public class RemoveRecipes {
    public static void removeSpecifiedRecipe() {
        removeRecipeById(new ResourceLocation("create", "crafting/materials/andesite_alloy_from_zinc"));
        removeRecipeById(new ResourceLocation("create", "milling/charcoal"));
        removeRecipeById(new ResourceLocation("create", "milling/coal"));
        removeRecipeById(new ResourceLocation("tfcoreprocessing", "heating/coke_baking"));
    }
}
