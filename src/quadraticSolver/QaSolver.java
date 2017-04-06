package quadraticSolver;

import java.math.BigDecimal;

class QaSolver {
	/**
	 * class containing methods for solving quadratic equation
	 */
BigDecimal rootFirst, rootSecond, Dicmnt, a, b, c, z;

	public Double[] qaSolver(BigDecimal a, BigDecimal b, BigDecimal c) {
		//b * b - 4 * a * c;
		BigDecimal b_qu = b.multiply(b);
		BigDecimal four_a_c = (a.multiply(c)).multiply(new BigDecimal(4));
		Dicmnt = b_qu.subtract(four_a_c);
		//System.out.println("Dicmnt:" + Dicmnt);
        z = new BigDecimal(0);
		int res = Dicmnt.compareTo(z);
		int res_a = a.compareTo(z);
		//int res_b = b.compareTo(z);
		//int res_c = c.compareTo(z);
		BigDecimal d_a = a.multiply(new BigDecimal(2));
		BigDecimal SqDicmnt = sqrt(Dicmnt);
		BigDecimal b_neg = b.negate();
		BigDecimal c_neg = c.negate();
		
		if (res_a == 0) {
			rootFirst = c_neg.divide(b);
			Double [] array = {rootFirst.doubleValue()};
			return array;		
		}
		else if (res == 1) {// discriminant is greater than zero ==> two roots of quadratic equation
			//( - b + Math.sqrt(Dicmnt))/(2*a)
			rootFirst = (b_neg.add(SqDicmnt)).divide(d_a, 15, BigDecimal.ROUND_DOWN);
			//( - b - Math.sqrt(Dicmnt))/(2*a)
			rootSecond = (b_neg.subtract(SqDicmnt)).divide(d_a, 15, BigDecimal.ROUND_DOWN);
			Double [] array = {rootFirst.doubleValue(), rootSecond.doubleValue()};
			return array;
		}
		else if (res == 0) {//discriminant is equals zero ==> one roots of quadratic equation
			rootFirst = (b_neg.add(SqDicmnt)).divide(d_a, 15, BigDecimal.ROUND_DOWN);
			Double [] array = {rootFirst.doubleValue()};
			return array;
		}		
		else {//discriminant is less than zero ==> no real roots of quadratic equation
			rootFirst = null;
			return null;
		}
	}

public static BigDecimal sqrt(BigDecimal n) {// Method to find root of discriminant
	BigDecimal TWO = BigDecimal.valueOf(2);

	// Obtain the first approximation
	BigDecimal x = n.divide(BigDecimal.valueOf(3), 2000, BigDecimal.ROUND_DOWN);
	BigDecimal lastX = BigDecimal.valueOf(0);

	// Proceed through 50 iterations
	for (int i = 0; i < 1000; i++) {
		x = n.add(x.multiply(x)).divide(x.multiply(TWO), 2000, BigDecimal.ROUND_DOWN);
		if (x.compareTo(lastX) == 0)
			break;
		lastX = x;
	}
	return x;
}
}