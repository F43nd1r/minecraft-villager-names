package com.faendir.minecraft.villagernames;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("villager-names")
public class VillagerNames
{
    public VillagerNames() {
        MinecraftForge.EVENT_BUS.register(new VillagerEvent());
    }
}
