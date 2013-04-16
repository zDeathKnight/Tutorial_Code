package tutorial;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class TutorialCrafting 
{
	public static void addRecipes() 
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Tutorial.tutorialBlock), new Object[]{
			new ItemStack(Item.diamond), new ItemStack(Block.stone), new ItemStack(Item.dyePowder, 1, 15)
		});
		
		GameRegistry.addRecipe(new ItemStack(Tutorial.tutorialBlock), new Object[]{
			"XZX",
			"CXC",
			'X', Item.ingotGold, 'C', Block.stone, 'Z', new ItemStack(Item.dyePowder, 1, 15)
		});
		
		ItemStack enchanted = new ItemStack(Item.pickaxeStone);
		enchanted.addEnchantment(Enchantment.sharpness, 2);
		
		GameRegistry.addShapelessRecipe(enchanted, new Object[]{
				new ItemStack(Item.pickaxeStone), new ItemStack(Item.flint), new ItemStack(Tutorial.tutorialBlock)
		});
		
		FurnaceRecipes.smelting().addSmelting(Item.beefCooked.itemID, 0, new ItemStack(Tutorial.tutorialItem), 0.1F);
	}
}
