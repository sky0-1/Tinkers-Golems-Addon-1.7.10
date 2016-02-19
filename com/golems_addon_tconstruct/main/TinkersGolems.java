package com.golems_addon_tconstruct.main;

import com.golems_addon_tconstruct.entity.TCGGolemEntityRegister;
import com.golems_addon_tconstruct.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = TinkersGolems.MODID, name = TinkersGolems.NAME, version = TinkersGolems.VERSION, dependencies = "required-after:" + TinkersGolems.DEPENDENCY_MODID, acceptedMinecraftVersions = TinkersGolems.MCVERSION)
public class TinkersGolems 
{
	public static final String MODID = "golems_addon_tconstruct";
	public static final String DEPENDENCY_MODID = "golems";
	public static final String NAME = "Tinkers' Golems Addon";
	public static final String VERSION = "1.07";
	public static final String MCVERSION = "1.7.10";
	public static final String CLIENT = "com." + MODID + ".proxies.ClientProxy";
	public static final String SERVER = "com." + MODID + ".proxies.CommonProxy";
	
	@Instance(TinkersGolems.MODID)
	public static TinkersGolems instance;
	
	@SidedProxy(clientSide = TinkersGolems.CLIENT, serverSide = TinkersGolems.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		TCGConfig.mainRegistry(new Configuration(event.getSuggestedConfigurationFile()));
		TCGGolemEntityRegister.mainRegistry();
		proxy.registerRenders();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new TCGCommonEventHandler());
		proxy.registerEvents();
	}
}

