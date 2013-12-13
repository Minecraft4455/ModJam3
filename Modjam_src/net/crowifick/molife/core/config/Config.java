package net.crowifick.molife.core.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import net.minecraftforge.common.Configuration;

public class Config {

	@Retention(RetentionPolicy.RUNTIME)
	public static @interface CfgBool {
		
		
		
	}
	
	@Retention(RetentionPolicy.RUNTIME) 
	public static @interface CfgID{
		
		public boolean block() default false;
		
	}
	
	public static void load(Configuration config) {
		
		try {
			
			config.load();
			final Field[] fields Config.class.getField();
			for (final Field field : fields) {
				
				
				
			}
			
		}
		
	}
	
}
