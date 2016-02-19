package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityBrownstoneGolem extends GolemBase
{
	public EntityBrownstoneGolem(World world) 
	{
		super(world, 5.0F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "brownstone"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.59D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 2 + rand.nextInt(3);
		return new ItemStack(Blocks.gravel, size);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}