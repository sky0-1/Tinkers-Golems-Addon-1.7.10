package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;
import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TinkersConfig;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
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
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "seared"));
	}
	
	/** Attack by lighting on fire as well */
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(TinkersConfig.ALLOW_SEARED_SPECIAL)
			{
				entity.setFire(1 + rand.nextInt(2));
			}
			return true;
		}
		return false;
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(8);
		List<ItemStack> list = OreDictionary.doesOreNameExist("ingotSeared") ? OreDictionary.getOres("ingotSeared") : OreDictionary.getOres("brickSeared");
		if(!list.isEmpty()) 
		{
			ItemStack stack = list.get(0);
			stack.stackSize = size;
			GolemBase.addGuaranteedDropEntry(dropList, stack);
		}
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}