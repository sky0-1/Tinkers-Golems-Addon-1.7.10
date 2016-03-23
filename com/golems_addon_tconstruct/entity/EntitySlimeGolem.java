package com.golems_addon_tconstruct.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemMultiTextured;
import com.golems_addon_tconstruct.main.TinkersConfig;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntitySlimeGolem extends GolemMultiTextured
{
	private static final String[] textures = {"green","blue","purple"};
	
	public EntitySlimeGolem(World world) 
	{
		super(world, 2.5F, textures);
		// only enable these for 1.8
		//this.getNavigator().setAvoidsWater(false); 
		//this.tasks.addTask(0, new EntityAISwimming(this));
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(TinkersConfig.ALLOW_SLIME_SPECIAL)
			{
				knockbackTarget(entity, TinkersConfig.TWEAK_SLIME);
			}
			return true;
		}
		return false;
	}

	@Override
	protected void damageEntity(DamageSource source, float amount) 
	{
		if (!this.isEntityInvulnerable())
		{
			super.damageEntity(source, amount);
			if(source.getEntity() != null && TinkersConfig.ALLOW_SLIME_SPECIAL)
			{
				knockbackTarget(source.getEntity(), TinkersConfig.TWEAK_SLIME * 3 / 5);
			}
		}
	}
	
	private void knockbackTarget(Entity entity, final double KNOCKBACK_FACTOR)
	{
		double dX = (entity.posX - this.posX) * KNOCKBACK_FACTOR;
		double dZ = (entity.posZ - this.posZ) * KNOCKBACK_FACTOR;
		entity.addVelocity(dX, KNOCKBACK_FACTOR / 4, dZ);
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 0.1F);
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.18D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		for(int i = 0; i < 3; i++)
		{
			GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.slime_ball, 4 + rand.nextInt(8)));
		}
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGrass.soundName;
	}

	@Override
	public String getTexturePrefix() 
	{
		return "slime";
	}

	@Override
	public String getModId() 
	{
		return TinkersGolems.MODID;
	}
}