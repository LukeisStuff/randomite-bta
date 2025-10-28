package luke.randomite.compat.deep;

public class RandomiteDeepBlocks {

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeBlocks();
		}
	}

	public void initializeBlockDetails() {
	}

	public static void initializeBlocks() {
	}
}
