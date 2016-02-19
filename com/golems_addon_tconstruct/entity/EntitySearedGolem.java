package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TCGConfig;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntitySearedGolem extends GolemBase
{
	public EntitySearedGolem(World world) 
	{
		super(world, 5.5F);
		this.isImmuneToFire = true;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "seared"));
	}
	
	/** Attack by lighting on fire as well */
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(TCGConfig.ALLOW_SEARED_SPECIAL)
			{
				entity.setFire(1 + rand.nextInt(2));
			}
			return true;
		}
		return false;
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotSeared");
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