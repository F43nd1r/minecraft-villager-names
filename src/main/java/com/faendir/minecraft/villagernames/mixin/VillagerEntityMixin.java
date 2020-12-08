package com.faendir.minecraft.villagernames.mixin;

import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {
    private final ITextComponent the = new StringTextComponent(" the ");

    @Redirect(method = "displayMerchantGui",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/merchant/villager/VillagerEntity;getDisplayName()Lnet/minecraft/util/text/ITextComponent;"))
    private ITextComponent hookDisplayMerchantGui(VillagerEntity entity) {
        if (entity.hasCustomName()) {
            VillagerProfession prof = entity.getVillagerData().getProfession();
            if (!"none".equals(prof.toString())) {
                ResourceLocation location = prof.getRegistryName();
                TranslationTextComponent profession = new TranslationTextComponent("entity.minecraft.villager." +
                        (!"minecraft".equals(location.getNamespace()) ? location.getNamespace() + "." : "") + location.getPath());
                return entity.getCustomName().deepCopy().append(the).append(profession);
            }
        }
        return entity.getDisplayName();

    }
}
