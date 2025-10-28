package luke.randomite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.io.IOException;

public class RandomiteConfig {
	public static final Logger LOGGER = LoggerFactory.getLogger(RandomiteMod.MOD_ID);

	private static TomlConfigHandler cfg;

	public static final String GeneralCategory = "General";

	private static int BLOCK_ID_STARTING_FROM = 2500;

	public static int currentBlockID;

	static void Setup() {
		LOGGER.info("Initializing config..");

		Toml props = new Toml("Randomite Configs.toml");
		assembleProperties(props);

		cfg = new TomlConfigHandler(RandomiteMod.MOD_ID, props);

		if (cfg.getConfigFile().exists()) cfg.loadConfig();
		else {
			try {
				cfg.getConfigFile().createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			cfg.writeConfig();
		}

		loadProperties();
	}

	private static void loadProperties() {
		currentBlockID = BLOCK_ID_STARTING_FROM = cfgGetValueOrDefault(GeneralCategory + ".BLOCK_ID_STARTING_FROM", BLOCK_ID_STARTING_FROM);
	}

	private static void assembleProperties(Toml properties) {
		properties.addCategory(GeneralCategory)
			.addEntry("cfgVersion", 6)
			.addEntry("BLOCK_ID_STARTING_FROM", BLOCK_ID_STARTING_FROM);
	}

	public static int blockID(String blockName) {
		return currentBlockID++;
	}

	@SuppressWarnings("unchecked")
	static <T> T cfgGetValueOrDefault(String key, T def) {
		T res = null;

		try {
			if (def instanceof String) {
				res = (T) cfg.getString(key);
			} else if (def instanceof Integer) {
				res = (T) Integer.valueOf(cfg.getInt(key));
			} else if (def instanceof Long) {
				res = (T) Long.valueOf(cfg.getLong(key));
			} else if (def instanceof Boolean) {
				res = (T) Boolean.valueOf(cfg.getBoolean(key));
			} else if (def instanceof Double || def instanceof Float) {
				double raw = cfg.getDouble(key);

				if (def instanceof Float) res = (T) Float.valueOf((float) raw);
				else res = (T) Double.valueOf(raw);
			} else {
				throw new RuntimeException("Invalid value type!");
			}

		} catch (NullPointerException ignored) {
		}

		if (res == null) {
			LOGGER.warn("Failed to load \"{}\"! Assuming default...", key);
			return def;
		}

		return res;
	}
}
