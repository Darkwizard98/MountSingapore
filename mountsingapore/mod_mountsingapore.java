package net.mountsingapore;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.mountsingapore.Common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;




@Mod(modid ="MountSingapore", name = "School Project", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_mountsingapore {
		public static Block Block1;
		public static Item EPickAxe;
		public static Item ThePunisher;
		public static Item EAxe;
		public static Item PunHilt;
		public static Item PunBlade;
		public static Item LavaAxe;
		public static Item LAAxe;
		public static Item LAStick;
		
		int Block1ID, EPickAxeID, ThePunisherID, EAxeID, PunHiltID, PunBladeID
		, LavaAxeID, LAAxeID, LAStickID;
		
		@SidedProxy(clientSide="net.mountsingapore.Client.ClientProxy", serverSide="net.mountsingapore.common.ClientProxy")
		public static CommonProxy proxy;
		static EnumToolMaterial EnumEmerald= EnumHelper.addToolMaterial("Emerald", 2, 400, 6.0F, 6, 15);
		static EnumToolMaterial EnumLava= EnumHelper.addToolMaterial("Lava", 2, 400, 6.0F, 6, 15);
		
		@PreInit
		public void PreLoad(FMLPreInitializationEvent event){
			
			Configuration config = new Configuration(event.getSuggestedConfigurationFile());
			
			config.load();
			//Block id Range: 1551-1998
			//Item Id Range: 5001-6899
			
			//Blocks
			Block1ID= config.getBlock("Block1ID", 1551).getInt();
			
			//Items
			EPickAxeID= config.getItem("EPickAxeID", 5001).getInt();
			ThePunisherID= config.getItem("ThePuniserID", 5002).getInt();
			EAxeID= config.getItem("EAxeID", 5003).getInt();
			PunHiltID= config.getItem("PunHiltID", 5004).getInt();
			PunBladeID= config.getItem("PunBladeID", 5005).getInt();
			LavaAxeID= config.getItem("LavaAxeID", 5006).getInt();
			LAAxeID= config.getItem("LLAxeID", 5007).getInt();
			LAStickID= config.getItem("LAStickID", 5008).getInt();
			
			
		}
@Init
public void load(FMLInitializationEvent event){
	
	//Blocks
	Block1 = new Block1(Block1ID,0).setHardness(3F).setResistance(1.0F).setBlockName("TestBlock");
	
	
	//Items
	EPickAxe= new EPickAxe(EPickAxeID, EnumEmerald).setItemName("Emerald PickAxe").setIconIndex(11);
	
	
	////The Punisher
	ThePunisher = new ThePunisher(ThePunisherID, EnumEmerald).setItemName("The Punisher").setIconIndex(13);
	PunHilt = new PunHilt(PunHiltID).setItemName("Broken Punisher Hilt").setIconIndex(1);
	PunBlade = new PunBlade(PunBladeID).setItemName("Broken Punisher Blade").setIconIndex(1);
	
	////Lava Axe
	LavaAxe= new LavaAxe(LavaAxeID, EnumLava).setItemName("Lava Axe").setIconIndex(28);
	LAAxe= new LLAxe(LAAxeID).setItemName("Broken Unknown Blade").setIconIndex(1);
	LAStick= new LAStick(LAStickID).setItemName("Broken Unknown Stick").setIconIndex(1);
	
	EAxe= new EAxe(EAxeID, EnumEmerald).setItemName("Emerald Axe").setIconIndex(12);
	GameRegistry.registerBlock(Block1);
	
	//Blocks
	LanguageRegistry.addName(Block1, "TempName");
	
	//Items
	LanguageRegistry.addName(EPickAxe, "Emerald PickAxe");
	
	
	//// The Punisher
	LanguageRegistry.addName(ThePunisher, "The Punisher");
	LanguageRegistry.addName(PunHilt, "Broken Punisher Hilt");
	LanguageRegistry.addName(PunBlade, "Broken Punisher Blade");
	
	//// Tools
	LanguageRegistry.addName(EAxe, "Emerald Axe");
	
	proxy.registerRenderThings();
}
}
