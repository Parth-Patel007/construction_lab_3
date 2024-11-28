package solid3;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public interface IPower {
	int toPower(int n, int pow);
}

 class PowerSimple implements IPower {
	@Override
	public int toPower(int n, int pow) {
		if (pow == 0) {
			return 1;
		}

		int res = 1;
		// adding brackets
			for (int i = 0; i < pow; i++) {
				res *= n;
			}
		return res;
	}
}

class PowerCached  implements IPower {
	private static final Map<Integer, Map<Integer, Integer>> __cache = new ConcurrentHashMap<>();

	@Override
	public int toPower(int n, int pow) {
			Map<Integer, Integer> entry = __cache.get(n);

		if (entry == null) {
			// qualifier fix using hmap
			   entry = new HashMap<>();
			 __cache.put(n, entry);
		}
		return toCachedPower(entry, n, pow);
	}


	private int toCachedPower(Map<Integer, Integer> e, int n, int pow) {
		Integer res;
		if (pow == 0) {
			res = 1;
		} else {
			res = e.get(pow);
			if (res == null) {
					res = n * toCachedPower(e, n, pow - 1) ;

				// saving result in cache.

				e.put(pow, res);
			}
		}
		return res;
	}
}
