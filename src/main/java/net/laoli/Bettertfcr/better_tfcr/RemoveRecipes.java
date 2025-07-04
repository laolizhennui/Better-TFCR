package net.laoli.Bettertfcr.better_tfcr;

import net.minecraft.resources.ResourceLocation;

import java.util.Set;

import static net.laoli.Bettertfcr.better_tfcr.util.RemoveRecipe.batchRemoveRecipeById;

public class RemoveRecipes {
    public static void removeSpecifiedRecipe() {
        batchRemoveRecipeById(Set.of(
                new ResourceLocation("create", "crafting/materials/andesite_alloy_from_zinc"),
                new ResourceLocation("create", "milling/charcoal"),
                new ResourceLocation("create", "milling/coal"),
                new ResourceLocation("tfcoreprocessing", "heating/coke_baking"),
                new ResourceLocation("tfc", "crafting/parchment"),
                new ResourceLocation("immersiveengineering", "crafting/paper_from_sawdust"),
                new ResourceLocation("tfc", "scraping/paper"),
                new ResourceLocation("artisanal", "barrel/paper"),
                new ResourceLocation("farmersdelight", "lead_from_straw")
        ));
    }
}
