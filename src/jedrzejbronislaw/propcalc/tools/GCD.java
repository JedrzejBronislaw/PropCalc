package jedrzejbronislaw.propcalc.tools;

import java.util.stream.IntStream;

public class GCD {
	
	public static int gcd(int a, int b) {
		if (a < 0) a = -a;
		if (b < 0) b = -b;
		
		return euclid(a, b);
	}
	
	public static int gcd(int... nums) {
		if (nums==null ||nums.length == 0) throw new IllegalArgumentException("Lenght of nums have to be greater than 0.");
		
		nums = IntStream.of(nums).map(Math::abs).toArray();
		nums = delZero(nums);
		if (nums.length == 0) return 0;
		
		int min;
		
		while (nums.length > 1) {
			min = min(nums);
			
			for(int i=0; i<nums.length; i++)
				if (nums[i] != min)
					nums[i] %= min;
			
			nums = delZero(nums);
			nums = delDuplicate(nums);
		}
		
		return nums[0];
	}

	private static int euclid(int a, int b) {
		while(true) {
			if (a == 0) return b;
			if (b == 0) return a;
			
			if (a > b)
				a %= b; else
				b %= a;
		}
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
