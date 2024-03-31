package luke.randomite;

import net.minecraft.core.block.Block;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RandomiteConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	private static final Toml properties = new Toml("Randomite TOML Config");
	public static TomlConfigHandler cfg;

	private static int blockIDs = 2500;


	static {
		properties.addCategory("Randomite")
			.addEntry("cfgVersion", 5);

		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", 2500);


		List<Field> blockFields = Arrays.stream(RandomiteBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}

		cfg = new TomlConfigHandler(updater, RandomiteMod.MOD_ID, properties);

	}
}
