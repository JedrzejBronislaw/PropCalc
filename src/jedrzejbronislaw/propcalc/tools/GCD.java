package jedrzejbronislaw.propcalc.tools;

import java.util.stream.IntStream;

public class GCD {
	
	public static int gcd(int a, int b) {
		
		while(a != b) {
			if (a > b)
				a -= b; else
				b -= a;
		}
		
		return a;
	}
	
	public static int gcd(int[] nums) {
		nums = delZero(nums);
		
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
