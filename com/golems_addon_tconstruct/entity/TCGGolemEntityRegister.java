package com.golems_addon_tconstruct.entity;

import com.golems_addon_tconstruct.main.TinkersGolems;

import cpw.mods.fml.common.registry.EntityRegistry;

public class TCGGolemEntityRegister 
{
	private static int tcgGolemEntityID;

	public static void mainRegistry() 
	{
		tcgGolemEntityID = 0;
		register(EntityAluminumBrassGolem.class, "golem_alumbrass");
		register(EntityAluminumGolem.class, "golem_alum");
		register(EntityAlumiteGolem.class, "golem_alumite");
		register(EntityArditeGolem.class, "golem_ardite");
		register(EntityBronzeGolem.class, "golem_bronze");
		register(EntityBrownstoneGolem.class, "golem_brownstone");
		register(EntityCobaltGolem.class, "golem_cobalt");
		register(EntityCopperGolem.class, "golem_copper");
		register(EntityEnderGolem.class, "golem_ender");
		register(EntityGlueGolem.class, "golem_glue");
		register(EntityHamGolem.class, "golem_hambone");
		register(EntityManyullyumGolem.class, "golem_manyullyum");
		register(EntitySearedGolem.class, "golem_seared");
		register(EntitySlimeGolem.class, "golem_slime");
		register(EntitySteelGolem.class, "golem_steel");
		register(EntityTinGolem.class, "golem_tin");
	}

	private static void register(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, ++tcgGolemEntityID, TinkersGolems.instance, 48, 3, true);
	}

}
