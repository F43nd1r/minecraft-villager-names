package com.faendir.minecraft.villagernames;


import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
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
                final VillagerEntity villager = (VillagerEntity) entity;
                VillagerData data = villager.getVillagerData();
                VillagerProfession prof = data.getProfession();
                if (!"none".equals(prof.toString())) {
                    String profession = prof.toString();
                    PlayerEntity var7 = e.getPlayer();
                    if (!var7.isCrouching()) {
                        final String name = villager.getName().getString();
                        final String upperProfession = profession.substring(0, 1).toUpperCase() + profession.substring(1);
                        villager.setCustomName(new StringTextComponent(name + " the " + upperProfession));
                        new Thread(() -> {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException ignored) {
                            }
                            villager.setCustomName(new StringTextComponent(name.replace(" the ", "").replace(upperProfession, "")));
                        }).start();
                    }
                }
            }
        }
    }
}
