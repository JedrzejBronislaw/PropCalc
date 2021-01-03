package jedrzejbronislaw.propcalc.tools;

import java.util.stream.IntStream;

public class GCD {
	
	public static int gcd(int a, int b) {

		if (a==0) return b;
		if (b==0) return a;
		
		if (a < 0) a = -a;
		if (b < 0) b = -b;
		
		return euclid(a, b);
	}
	
	public static int gcd(int... nums) {
		if (nums==null ||nums.length == 0) throw new IllegalArgumentException("Lenght of nums have to be greater than 0.");
		
		nums = IntStream.of(nums).map(Math::abs).toArray();
		nums = delZero(nums);
		if (nums.length == 0) return 0;
		
		int[] tab = nums;
		int min;
		
		
		while (tab.length > 1) {
			min = min(tab);
			
			for(int i=0; i<tab.length; i++)
				if (tab[i] != min) tab[i] -= min;
			
			tab = delDuplicate(tab);
		}
		
		return tab[0];
	}

	private static int euclid(int a, int b) {
		while(a != b) {
			if (a > b)
				a -= b; else
				b -= a;
		}
		return a;
	}
	
	private static int[] delZero(int[] tab) {
		return IntStream.of(tab).filter(i -> i!=0).toArray();
	}

	private static int[] delDuplicate(int[] tab) {
		return IntStream.of(tab).distinct().toArray();
	}

	private static int min(int[] tab) {
		return IntStream.of(tab).min().getAsInt();
	}
}
