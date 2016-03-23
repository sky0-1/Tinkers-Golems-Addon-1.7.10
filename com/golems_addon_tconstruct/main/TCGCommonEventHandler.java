package com.golems_addon_tconstruct.main;

import java.util.List;

import com.golems.events.GolemBuildEvent;
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

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class TCGCommonEventHandler 
{
	@SubscribeEvent
	public void onBuildGolem(GolemBuildEvent event)
	{
		String name = event.blockBelow.getUnlocalizedName();	
		// debug:
		//FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().sendChatMsg(new ChatComponentText("Unlocalized Name = '" + name + "' - meta = " + event.blockMeta));		
		// if it has not already been set
		if(event.isGolemNull() || Loader.isModLoaded("golems_addon_metals"))
		{	
			// TINKERS' CONSTRUCT
			if(name.equalsIgnoreCase("tile.tconstruct.metalblock"))
			{
				if(event.areBlocksSameMeta)
				{
					switch(event.blockMeta)
					{
					case 0:	event.setGolem(new EntityCobaltGolem(event.worldObj), TinkersConfig.ALLOW_COBALT);
					break;
					case 1: event.setGolem(new EntityArditeGolem(event.worldObj), TinkersConfig.ALLOW_ARDITE);
					break;
					case 2: event.setGolem(new EntityManyullynGolem(event.worldObj), TinkersConfig.ALLOW_MANYULLYUM);
					break;
					case 3: event.setGolem(new EntityCopperGolem(event.worldObj), TinkersConfig.ALLOW_COPPER);
					break;
					case 4: event.setGolem(new EntityBronzeGolem(event.worldObj), TinkersConfig.ALLOW_BRONZE);
					break;
					case 5: event.setGolem(new EntityTinGolem(event.worldObj), TinkersConfig.ALLOW_TIN);
					break;
					case 6: event.setGolem(new EntityAluminumGolem(event.worldObj), TinkersConfig.ALLOW_ALUMINUM);
					break;
					case 7: event.setGolem(new EntityAluminumBrassGolem(event.worldObj), TinkersConfig.ALLOW_ALUMINUM_BRASS);
					break;
					case 8: event.setGolem(new EntityAlumiteGolem(event.worldObj), TinkersConfig.ALLOW_ALUMITE);
					break;
					case 9: event.setGolem(new EntitySteelGolem(event.worldObj), TinkersConfig.ALLOW_STEEL);
					break;
					case 10: event.setGolem(new EntityEnderGolem(event.worldObj), TinkersConfig.ALLOW_ENDER);
					break;
					}
				}
			}
			else if(name.equalsIgnoreCase("tile.Smeltery") && event.areBlocksSameMeta && event.blockMeta > 1)
			{
				event.setGolem(new EntitySearedGolem(event.worldObj), TinkersConfig.ALLOW_SEARED);
			}
			else if(name.equalsIgnoreCase("tile.SpeedBlock"))
			{
				event.setGolem(new EntityBrownstoneGolem(event.worldObj), TinkersConfig.ALLOW_BROWNSTONE);
			}
			else if(name.equalsIgnoreCase("tile.slime.gel"))
			{
				event.setGolem(new EntitySlimeGolem(event.worldObj), TinkersConfig.ALLOW_SLIME);
			}
			else if(name.equalsIgnoreCase("tile.tconstruct.meatblock"))
			{
				event.setGolem(new EntityHamGolem(event.worldObj), TinkersConfig.ALLOW_HAM);
			}
			else if(name.equalsIgnoreCase("tile.GlueBlock"))
			{
				event.setGolem(new EntityGlueGolem(event.worldObj), TinkersConfig.ALLOW_GLUE);
			}		
			// THERMAL FOUNDATION
			else if(name.equalsIgnoreCase("tile.thermalfoundation.storage"))
			{
				if(event.areBlocksSameMeta)
				{
					// if blockBelow is thermal foundation metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TinkersConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), TinkersConfig.ALLOW_TIN);
					break;
					case 9:		event.setGolem(new EntityBronzeGolem(event.worldObj), TinkersConfig.ALLOW_BRONZE);
					break;
					}
				}
			}
			// INDUSTRIALCRAFT 2
			else if(name.equalsIgnoreCase("blockMetal") && Loader.isModLoaded("ic2"))
			{
				if(event.areBlocksSameMeta)
				{
					// if blockBelow is IC2 metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TinkersConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), TinkersConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntityBronzeGolem(event.worldObj), TinkersConfig.ALLOW_BRONZE);
					break;
					}
				}
			}
			// IMMERSIVE ENGINEERING
			else if(name.equalsIgnoreCase("tile.ImmersiveEngineering.storage"))
			{
				if(event.areBlocksSameMeta)
				{
					// if blockBelow is IE metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TinkersConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityAluminumGolem(event.worldObj), TinkersConfig.ALLOW_ALUMINUM);
					break;
					case 7:		event.setGolem(new EntitySteelGolem(event.worldObj), TinkersConfig.ALLOW_STEEL);
					break;
					}
				}
			}
		}
	}

	public static boolean matchesOreDict(Block block, String toCheck)
	{
		if(OreDictionary.doesOreNameExist(toCheck)) 
		{
			ItemStack passedBlock = new ItemStack(block);
			List<ItemStack> matches = OreDictionary.getOres(toCheck);
			return matches.isEmpty() ? false : OreDictionary.itemMatches(passedBlock, matches.get(0), true);
		}
		else return false;
	}

}
