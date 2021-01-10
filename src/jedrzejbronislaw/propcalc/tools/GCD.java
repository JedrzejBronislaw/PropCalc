package jedrzejbronislaw.propcalc.tools;

import java.util.stream.LongStream;

public class GCD {
	
	public static long gcd(long a, long b) {
		if (a < 0) a = -a;
		if (b < 0) b = -b;
		
		return euclid(a, b);
	}
	
	public static long gcd(long... nums) {
		if (nums==null ||nums.length == 0) throw new IllegalArgumentException("Lenght of nums have to be greater than 0.");
		
		nums = LongStream.of(nums).map(Math::abs).toArray();
		nums = delZero(nums);
		if (nums.length == 0) return 0L;
		
		long min;
		
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

	private static long euclid(long a, long b) {
		while(true) {
			if (a == 0) return b;
			if (b == 0) return a;
			
			if (a > b)
				a %= b; else
				b %= a;
		}
	}
	
	private static long[] delZero(long[] tab) {
		return LongStream.of(tab).filter(i -> i!=0).toArray();
	}

	private static long[] delDuplicate(long[] tab) {
		return LongStream.of(tab).distinct().toArray();
	}

	private static long min(long[] tab) {
		return LongStream.of(tab).min().getAsLong();
	}
}
