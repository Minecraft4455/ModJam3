package net.crowifick.molife;

import net.crowifick.molife.client.proxys.CommonProxy;
import net.crowifick.molife.core.info.Info;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = Info.NAME, modid = Info.MODID, version = Info.VERSION)
@NetworkMod(clientSideRequired = Info.CLIENT, serverSideRequired = Info.SERVER)
public class MoLife {
	
	@Instance(Info.MODID)
	public static MoLife instance;
	
	@SidedProxy(clientSide = Info.CLIENTPROXY, serverSide = Info.COMMONPROXY)
	public static CommonProxy proxy;
	
	

}
