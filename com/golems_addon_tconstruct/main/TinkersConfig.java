package com.golems_addon_tconstruct.main;

import net.minecraftforge.common.config.Configuration;

/** Registers the config settings to adjust aspects of this mod **/
public class TinkersConfig 
{
	public static boolean ALLOW_ALUMINUM;
	public static boolean ALLOW_ALUMINUM_BRASS;
	public static boolean ALLOW_ALUMITE;
	public static boolean ALLOW_ARDITE;
	public static boolean ALLOW_BRONZE;
	public static boolean ALLOW_BROWNSTONE;
	public static boolean ALLOW_COBALT;
	public static boolean ALLOW_COPPER;
	public static boolean ALLOW_ENDER;
	public static boolean ALLOW_GLUE;
	public static boolean ALLOW_HAM;
	public static boolean ALLOW_SLIME;
	public static boolean ALLOW_MANYULLYUM;
	public static boolean ALLOW_SEARED;
	public static boolean ALLOW_STEEL;
	public static boolean ALLOW_TIN;
	
	public static boolean ALLOW_ENDER_SPECIAL;
	public static boolean ALLOW_SLIME_SPECIAL;
	public static boolean ALLOW_SEARED_SPECIAL;
	public static boolean ALLOW_GLUE_SPECIAL;

	public static float TWEAK_SLIME;
	public static float TWEAK_GLUE;
	
	private static final String CATEGORY_SPAWNS = "spawns";
	private static final String CATEGORY_ABILITY = "abilities";
	private static final String CATEGORY_TWEAKS = "tweaks";
	
	public static void mainRegistry(Configuration config)
	{
		config.load();
		
		ALLOW_ALUMINUM = config.getBoolean("Allow Aluminum Golem", CATEGORY_SPAWNS, true, 
				"Whether the Aluminum Golem can be constructed.");
		ALLOW_ALUMINUM_BRASS = config.getBoolean("Allow AluminumBrass Golem", CATEGORY_SPAWNS, true, 
				"Whether the Aluminum Brass Golem can be constructed.");
		ALLOW_ALUMITE = config.getBoolean("Allow Alumite Golem", CATEGORY_SPAWNS, true, 
				"Whether the Alumite Golem can be constructed.");
		ALLOW_ARDITE = config.getBoolean("Allow Ardite Golem", CATEGORY_SPAWNS, true, 
				"Whether the Ardite Golem can be constructed.");
		ALLOW_BRONZE = config.getBoolean("Allow Bronze Golem", CATEGORY_SPAWNS, true, 
				"Whether the Bronze Golem can be constructed.");
		ALLOW_BROWNSTONE = config.getBoolean("Allow Brownstone Golem", CATEGORY_SPAWNS, true, 
				"Whether the Brownstone Golem can be constructed.");
		ALLOW_COBALT = config.getBoolean("Allow Cobalt Golem", CATEGORY_SPAWNS, true, 
				"Whether the Cobalt Golem can be constructed.");
		ALLOW_COPPER = config.getBoolean("Allow Copper Golem", CATEGORY_SPAWNS, true, 
				"Whether the Copper Golem can be constructed.");
		ALLOW_ENDER = config.getBoolean("Allow Ender Golem", CATEGORY_SPAWNS, true, 
				"Whether the Solid Ender Golem can be constructed.");
		ALLOW_GLUE = config.getBoolean("Allow Glue Golem", CATEGORY_SPAWNS, true, 
				"Whether the Glue Block Golem can be constructed.");
		ALLOW_HAM = config.getBoolean("Allow Ham Golem", CATEGORY_SPAWNS, true, 
				"Whether the HamBone Golem can be constructed.");
		ALLOW_SLIME = config.getBoolean("Allow Slime Golem", CATEGORY_SPAWNS, true, 
				"Whether the Congealed Slime Golem can be constructed.");
		ALLOW_MANYULLYUM = config.getBoolean("Allow Manyullyn Golem", CATEGORY_SPAWNS, true, 
				"Whether the Manyullyn Golem can be constructed.");
		ALLOW_SEARED = config.getBoolean("Allow Seared Golem", CATEGORY_SPAWNS, true, 
				"Whether the Seared Brick Golem can be constructed.");
		ALLOW_STEEL = config.getBoolean("Allow Steel Golem", CATEGORY_SPAWNS, true, 
				"Whether the Steel Golem can be constructed.");
		ALLOW_TIN = config.getBoolean("Allow Tin Golem", CATEGORY_SPAWNS, true, 
				"Whether the Tin Golem can be constructed.");
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		ALLOW_SLIME_SPECIAL = config.getBoolean("Allow Enderium Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Enderium Golem can teleport");
		ALLOW_SLIME_SPECIAL = config.getBoolean("Allow Slime Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Congealed Slime Golem can apply extra knockback when attacking");
		ALLOW_SEARED_SPECIAL = config.getBoolean("Allow Seared Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Seared Brick Golem can light creatures on fire");
		ALLOW_GLUE_SPECIAL = config.getBoolean("Allow Glue Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Glue Golem can slow down nearby creatures");;
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		TWEAK_SLIME = config.getFloat("Slime Golem Knockback", CATEGORY_TWEAKS, 2.0012F, 0.001F, 10.0F, 
				"How powerful the Congealed Slime Golem attack is (Higher Value = Further Knockback)");
		TWEAK_GLUE = config.getFloat("Glue Golem AoE", CATEGORY_TWEAKS, 1.65F, 0.001F, 8.0F, 
				"Entities within this distance of the Glue Golem will be slowed down (if enabled)");
		
		config.save();
	}
}
