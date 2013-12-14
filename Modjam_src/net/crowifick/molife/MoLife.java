package net.crowifick.molife;

import java.util.logging.Logger;

import net.crowifick.molife.blocks.MOBlocks;
import net.crowifick.molife.client.proxys.CommonProxy;
import net.crowifick.molife.core.config.Config;
import net.crowifick.molife.core.info.Info;
import net.crowifick.molife.recipes.MORecipes;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = Info.NAME, modid = Info.MODID, version = Info.VERSION)
@NetworkMod(clientSideRequired = Info.CLIENT, serverSideRequired = Info.SERVER)
public class MoLife {
	
	@Instance(Info.MODID)
	public static MoLife instance;
	
	@SidedProxy(clientSide = Info.CLIENTPROXY, serverSide = Info.COMMONPROXY)
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		logger = Logger.getLogger(Info.MODID);
		logger.setParent(FMLLog.getLogger());
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		Config.load(config);
		
		MOBlocks.init();
		MORecipes.init();
		
	}
	
	

}
