package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;
import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityHamGolem extends GolemBase
{
	public EntityHamGolem(World world) 
	{
		super(world, 2.5F);
		this.getNavigator().setAvoidsWater(false); 
		this.tasks.addTask(0, new EntityAISwimming(this));
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "hambone"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(16) + 6 * lootingLevel;
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.porkchop, size));
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}