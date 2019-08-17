package TheaterApplication;

/**
 *Author Fromssa Olana
 * An interface class that will implemented by some classes.
 * @param <K> key Type
 */
public interface Matchable<K> {
	/**
	 * Checks whether an item's key matches the given key.
	 * 
	 * @param key
	 *            the key value
	 * @return true iff the item's key matches the given key
	 */
	public boolean matches(K key);
}
