package com.golems_addon_tconstruct.entity;

import java.util.ArrayList;
import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemLightProvider;
import com.golems_addon_tconstruct.main.TCGConfig;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityGlueGolem extends GolemBase
{	
	public EntityGlueGolem(World world) 
	{
		super(world, 1.0F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "glue"));
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			glueTarget(entity);
			return true;
		}
		return false;
	}
	 
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		final double EXPAND = TCGConfig.TWEAK_GLUE;
		List<Entity> entityList = worldObj.getEntitiesWithinAABB(Entity.class, this.boundingBox.expand(EXPAND, 1.3D, EXPAND));
		for (int i = 0, j = entityList.size(); i < j; ++i)
		{
			glueTarget((Entity)entityList.get(i));
		}
	}

	private void glueTarget(Entity entity)
	{
		if(TCGConfig.ALLOW_GLUE_SPECIAL)
		{
			entity.motionX /= 2;
			entity.motionZ /= 2;
			if(motionY > 0)
			{
				motionY /= 4;
			}
			if(entity instanceof EntityLivingBase)
			{
				((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 2));
			}
		}
	}

	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.14D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("glueball");
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
		return Block.soundTypeGrass.soundName;
	}
}