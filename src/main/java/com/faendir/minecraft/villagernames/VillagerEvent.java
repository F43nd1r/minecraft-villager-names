package com.faendir.minecraft.villagernames;


import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class VillagerEvent {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract e) {
        if (!e.getWorld().isRemote()) {
            Entity entity = e.getTarget();
            if (entity.getClass().equals(VillagerEntity.class)) {
                if (!entity.hasCustomName()) {
                    entity.setCustomName(new StringTextComponent(NameGenerator.generateName()));
                }
            }
        }
    }

}
