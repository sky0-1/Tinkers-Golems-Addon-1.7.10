package com.golems_addon_tconstruct.proxies;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.entity.EntityAluminumBrassGolem;
import com.golems_addon_tconstruct.entity.EntityAluminumGolem;
import com.golems_addon_tconstruct.entity.EntityAlumiteGolem;
import com.golems_addon_tconstruct.entity.EntityArditeGolem;
import com.golems_addon_tconstruct.entity.EntityBronzeGolem;
import com.golems_addon_tconstruct.entity.EntityBrownstoneGolem;
import com.golems_addon_tconstruct.entity.EntityCobaltGolem;
import com.golems_addon_tconstruct.entity.EntityCopperGolem;
import com.golems_addon_tconstruct.entity.EntityEnderGolem;
import com.golems_addon_tconstruct.entity.EntityGlueGolem;
import com.golems_addon_tconstruct.entity.EntityHamGolem;
import com.golems_addon_tconstruct.entity.EntityManyullynGolem;
import com.golems_addon_tconstruct.entity.EntitySearedGolem;
import com.golems_addon_tconstruct.entity.EntitySlimeGolem;
import com.golems_addon_tconstruct.entity.EntitySteelGolem;
import com.golems_addon_tconstruct.entity.EntityTinGolem;
import com.golems_addon_tconstruct.main.TCGClientEventHandler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public void registerRenders()
	{		
		register(EntityAluminumBrassGolem.class);
		register(EntityAluminumGolem.class);
		register(EntityAlumiteGolem.class);
		register(EntityArditeGolem.class);
		register(EntityBronzeGolem.class);
		register(EntityBrownstoneGolem.class);
		register(EntityCobaltGolem.class);
		register(EntityCopperGolem.class);
		register(EntityEnderGolem.class);
		register(EntityGlueGolem.class);
		register(EntityHamGolem.class);
		register(EntityManyullynGolem.class);
		register(EntitySearedGolem.class);
		register(EntitySlimeGolem.class);
		register(EntitySteelGolem.class);
		register(EntityTinGolem.class);
	}
	
	@Override
	public void registerEvents()
	{
		MinecraftForge.EVENT_BUS.register(new TCGClientEventHandler());
	}
	
	/**	Registers an entity with the RenderGolem rendering class */
	private void register(Class<? extends GolemBase> golem)
	{
		RenderingRegistry.registerEntityRenderingHandler(golem, new com.golems.renders.RenderGolem());
	}
}
