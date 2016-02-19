package com.golems_addon_tconstruct.main;

import java.util.ArrayList;

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
import com.golems_addon_tconstruct.entity.EntityManyullyumGolem;
import com.golems_addon_tconstruct.entity.EntitySearedGolem;
import com.golems_addon_tconstruct.entity.EntitySlimeGolem;
import com.golems_addon_tconstruct.entity.EntitySteelGolem;
import com.golems_addon_tconstruct.entity.EntityTinGolem;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
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
		if(event.isGolemNull())
		{	
			// TINKERS' CONSTRUCT
			if(name.equalsIgnoreCase("tile.tconstruct.metalblock"))
			{
				if(event.areBlocksSameMeta)
				{
					switch(event.blockMeta)
					{
					case 0:	event.setGolem(new EntityCobaltGolem(event.worldObj), TCGConfig.ALLOW_COBALT);
					break;
					case 1: event.setGolem(new EntityArditeGolem(event.worldObj), TCGConfig.ALLOW_ARDITE);
					break;
					case 2: event.setGolem(new EntityManyullyumGolem(event.worldObj), TCGConfig.ALLOW_MANYULLYUM);
					break;
					case 3: event.setGolem(new EntityCopperGolem(event.worldObj), TCGConfig.ALLOW_COPPER);
					break;
					case 4: event.setGolem(new EntityBronzeGolem(event.worldObj), TCGConfig.ALLOW_BRONZE);
					break;
					case 5: event.setGolem(new EntityTinGolem(event.worldObj), TCGConfig.ALLOW_TIN);
					break;
					case 6: event.setGolem(new EntityAluminumGolem(event.worldObj), TCGConfig.ALLOW_ALUMINUM);
					break;
					case 7: event.setGolem(new EntityAluminumBrassGolem(event.worldObj), TCGConfig.ALLOW_ALUMINUM_BRASS);
					break;
					case 8: event.setGolem(new EntityAlumiteGolem(event.worldObj), TCGConfig.ALLOW_ALUMITE);
					break;
					case 9: event.setGolem(new EntitySteelGolem(event.worldObj), TCGConfig.ALLOW_STEEL);
					break;
					case 10: event.setGolem(new EntityEnderGolem(event.worldObj), TCGConfig.ALLOW_ENDER);
					break;
					}
				}
			}
			else if(name.equalsIgnoreCase("tile.Smeltery"))
			{
				// check if any of the blocks are smeltery control (meta=0) or lava tank (meta=1)
				int metaBelow2 = event.worldObj.getBlockMetadata(event.headX, event.headY - 2, event.headZ);	
				int metaArm1 = event.isXAligned ? event.worldObj.getBlockMetadata(event.headX - 1, event.headY - 1, event.headZ) : event.worldObj.getBlockMetadata(event.headX, event.headY - 1, event.headZ - 1);
				int metaArm2 = event.isXAligned ? event.worldObj.getBlockMetadata(event.headX + 1, event.headY - 1, event.headZ) : event.worldObj.getBlockMetadata(event.headX, event.headY - 1, event.headZ + 1);
				if(event.blockMeta > 1 && metaBelow2 > 1 && metaArm1 > 1 && metaArm2 > 1)
				{
					event.setGolem(new EntitySearedGolem(event.worldObj), TCGConfig.ALLOW_SEARED);
				}
			}
			else if(name.equalsIgnoreCase("tile.SpeedBlock"))
			{
				event.setGolem(new EntityBrownstoneGolem(event.worldObj), TCGConfig.ALLOW_BROWNSTONE);
			}
			else if(name.equalsIgnoreCase("tile.slime.gel"))
			{
				event.setGolem(new EntitySlimeGolem(event.worldObj), TCGConfig.ALLOW_SLIME);
			}
			else if(name.equalsIgnoreCase("tile.tconstruct.meatblock"))
			{
				event.setGolem(new EntityHamGolem(event.worldObj), TCGConfig.ALLOW_HAM);
			}
			else if(name.equalsIgnoreCase("tile.GlueBlock"))
			{
				event.setGolem(new EntityGlueGolem(event.worldObj), TCGConfig.ALLOW_GLUE);
			}		
			// THERMAL FOUNDATION
			else if(name.equalsIgnoreCase("tile.thermalfoundation.storage"))
			{
				if(event.areBlocksSameMeta)
				{
					// if blockBelow is thermal foundation metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TCGConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), TCGConfig.ALLOW_TIN);
					break;
					case 9:		event.setGolem(new EntityBronzeGolem(event.worldObj), TCGConfig.ALLOW_BRONZE);
					break;
					}
				}
			}
			// INDUSTRIALCRAFT 2
			else if(name.equalsIgnoreCase("blockMetal"))
			{
				if(event.areBlocksSameMeta)
				{
					// if blockBelow is IC2 metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TCGConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), TCGConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntityBronzeGolem(event.worldObj), TCGConfig.ALLOW_BRONZE);
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
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), TCGConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityAluminumGolem(event.worldObj), TCGConfig.ALLOW_ALUMINUM);
					break;
					case 7:		event.setGolem(new EntitySteelGolem(event.worldObj), TCGConfig.ALLOW_STEEL);
					break;
					}
				}
			}
		}
	}

	public static boolean matchesOreDict(Block block, String toCheck)
	{
		ItemStack oreStack = new ItemStack(Item.getItemFromBlock(block));
		ArrayList<ItemStack> stackCheck = OreDictionary.getOres(toCheck);	
		return !stackCheck.isEmpty() && oreStack.equals(stackCheck.get(0));
	}

}
