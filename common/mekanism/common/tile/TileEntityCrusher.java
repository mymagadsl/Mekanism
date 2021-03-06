package mekanism.common.tile;

import java.util.EnumSet;
import java.util.Map;

import mekanism.common.Mekanism;
import mekanism.common.block.BlockMachine.MachineType;
import mekanism.common.recipe.RecipeHandler.Recipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityCrusher extends TileEntityElectricMachine
{
	public float crushMatrix = 0;
	
	public TileEntityCrusher()
	{
		super("Crusher.ogg", "Crusher", new ResourceLocation("mekanism", "gui/GuiCrusher.png"), Mekanism.crusherUsage, 200, MachineType.CRUSHER.baseEnergy);
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(worldObj.isRemote)
		{
			if(crushMatrix < 6)
			{
				crushMatrix+=0.2F;
			}
			else {
				crushMatrix = 0;
			}
		}
	}
	
	public float getMatrix()
	{
		float matrix = 0;

		if(crushMatrix <= 3)
		{
			return crushMatrix;
		}
		else {
			return 3 - (crushMatrix-3);
		}
	}
	
	@Override
	public Map getRecipes()
	{
		return Recipe.CRUSHER.get();
	}
	
	@Override
	public float getVolumeMultiplier()
	{
		return 0.5F;
	}
}
