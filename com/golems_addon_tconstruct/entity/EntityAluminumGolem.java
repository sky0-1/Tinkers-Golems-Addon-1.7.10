package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityAluminumGolem extends GolemBase
{
	public EntityAluminumGolem(World world) 
	{
		super(world, 5.0F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "aluminum"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotAluminum");
		if(!list.isEmpty()) 
		{
			ItemStack ret = list.get(0);
			ret.stackSize = size;
			return ret;
		}
		else return null;
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}