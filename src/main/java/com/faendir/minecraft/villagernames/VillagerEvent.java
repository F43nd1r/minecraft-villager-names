package com.faendir.minecraft.villagernames;


import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class VillagerEvent {
    public VillagerEvent() {
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract e) {
        if (!e.getWorld().isRemote()) {
            Entity entity = e.getTarget();
            if (entity.getClass().equals(VillagerEntity.class)) {
                if (!entity.hasCustomName()) {
                    entity.setCustomName(new StringTextComponent(NameGenerator.generateName()));
                }
                final VillagerEntity villager = (VillagerEntity)entity;
                VillagerData data = villager.getVillagerData();
                VillagerProfession prof = data.getProfession();
                if (!"none".equals(prof.toString())) {
                    ResourceLocation location = prof.getRegistryName();
                    String profession = I18n.format("entity.minecraft.villager." +
                            (!"minecraft".equals(location.getNamespace()) ? location.getNamespace() + "." : "") + location.getPath());
                    PlayerEntity var7 = e.getPlayer();
                    if (!var7.isCrouching()) {
                        final String name = villager.getName().getString();
                        villager.setCustomName(new StringTextComponent(name + " the " + profession));
                        new Thread(() -> {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ignored) {
                            }
                            villager.setCustomName(new StringTextComponent(name.replace(" the ", "").replace(profession, "")));
                        }).start();
                    }
                }
            }
        }
    }
}
