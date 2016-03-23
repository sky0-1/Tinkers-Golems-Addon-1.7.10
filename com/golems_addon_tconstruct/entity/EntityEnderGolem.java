package com.golems_addon_tconstruct.entity;

import java.util.List;

import com.golems.entity.EntityEndstoneGolem;
import com.golems.entity.GolemBase;
import com.golems_addon_tconstruct.main.TinkersConfig;
import com.golems_addon_tconstruct.main.TinkersGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityEnderGolem extends EntityEndstoneGolem
{
	public EntityEnderGolem(World world) 
	{
		super(world, 9.0F, 32.0D, TinkersConfig.ALLOW_ENDER_SPECIAL, true);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(TinkersGolems.MODID, "ender"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(95.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.26D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 39; // 8 + rand.nextInt(8 + lootingLevel * 4);
		while(size > 0)
		{
			GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.ender_pearl, size % 16));
			size -= 16;
		}
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}