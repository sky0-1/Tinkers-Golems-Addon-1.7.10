package com.golems_addon_tconstruct.main;

import com.golems.events.GolemPaperAddInfoEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class TCGClientEventHandler 
{
	@SubscribeEvent
	public void onAddInfo(GolemPaperAddInfoEvent event)
	{
		String loreIntro = new ChatComponentTranslation(
				EnumChatFormatting.WHITE + trans("tooltip.tconstruct_materials") + ":").getFormattedText();
		event.infoList.add(loreIntro);
		event.infoList.add(trans("StorageMetals.AlBrass.name") + ", " + trans("StorageMetals.Aluminum.name") + ",");
		event.infoList.add(trans("StorageMetals.Alumite.name") + ", " + trans("StorageMetals.Ardite.name"));
		event.infoList.add(trans("StorageMetals.Bronze.name") + ", " + trans("block.brownstone.smooth.name") + ",");
		event.infoList.add(trans("StorageMetals.Cobalt.name") + ", " + trans("StorageMetals.Copper.name") + ",");
		event.infoList.add(trans("StorageMetals.Ender.name") + ", " + trans("tile.GlueBlock.name") + ",");
		event.infoList.add(trans("tile.tconstruct.meatblock.name") + ", " + trans("StorageMetals.Manyullyn.name") + ",");
		event.infoList.add(trans("material.seared_block_any") + ", " + trans("material.slime_block") + ",");
		event.infoList.add(trans("StorageMetals.Steel.name") + ", " + trans("StorageMetals.Tin.name") + ",");
	}
	
	private String trans(String s)
	{
		return StatCollector.translateToLocal(s);
	}
}
