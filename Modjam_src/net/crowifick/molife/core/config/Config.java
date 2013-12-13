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
			final Field[] fields = Config.class.getFields();
			for (final Field field : fields) {

				final CfgID annotation = field.getAnnotation(CfgID.class);
				if (annotation != null) {

					int id = field.getInt(null);
					if (annotation.block())
						id = config.getBlock(field.getName(), id).getInt();
					else
						id = config.getItem(field.getName(), id).getInt();

					field.setInt(null, id);
				}

				else if (field.isAnnotationPresent(CfgBool.class)) {

					boolean bool = field.getBoolean(null);
					bool = config.get(Configuration.CATEGORY_GENERAL,
							field.getName(), bool).getBoolean(bool);
					field.setBoolean(null, bool);

				}

			}

		} catch (final Exception e) {

		} finally {

			config.save();
		}

	}

}
