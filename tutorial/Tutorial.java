package tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Tutorial.modid, name = "Mod Name", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Tutorial 
{
	public static final String modid = "YourName_ModName";
	
	public static Block tutorialBlock;
	
	public static Item tutorialItem;
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		tutorialBlock = new BlockTutorialBlock(500, Material.rock).setUnlocalizedName("tutorialBlock");
		
		GameRegistry.registerBlock(tutorialBlock, ItemTutorialBlock.class, modid + (tutorialBlock.getUnlocalizedName().substring(5)));
		
		LanguageRegistry.addName(new ItemStack(tutorialBlock, 1, 0), "Tutorial Block");
		LanguageRegistry.addName(new ItemStack(tutorialBlock, 1, 1), "Nether Tutorial Block");
		
		tutorialItem = new ItemTutorial(5000).setUnlocalizedName("tutorialItem");
		
		LanguageRegistry.addName(tutorialItem, "Tutorial Item");
		
		TutorialCrafting.addRecipes();
	}
}