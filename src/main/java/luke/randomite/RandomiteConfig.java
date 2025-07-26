package luke.randomite;

import net.minecraft.core.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static luke.randomite.RandomiteMod.MOD_ID;

public class RandomiteConfig {
	public static final Toml properties = new Toml("Randomite Configs.toml \n[!] Be careful with IDs. Changes can affect your existing worlds.");
	public static TomlConfigHandler cfg;

	public static int blockIDs = 2500;

	public static String BlockIDs = "Block IDs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	static void Setup() {
		LOGGER.info("Initializing config..");

		properties.addCategory("General")
			.addEntry("cfgVersion", 6);

		//BLOCK ID
		properties.addCategory(BlockIDs);
		properties.addEntry(BlockIDs+".startingFrom", blockIDs);
		List<Field> blockFields = Arrays.stream(RandomiteBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry(BlockIDs + "." + blockField.getName(), blockIDs++);
		}

		cfg = new TomlConfigHandler(MOD_ID, properties);

		if (cfg.getConfigFile().exists()) {
			cfg.loadConfig();
		} else {
			try {cfg.getConfigFile().createNewFile();} catch (IOException e) {throw new RuntimeException(e);}
			cfg.writeConfig();
		}

	}
}
