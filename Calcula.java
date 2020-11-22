import java.math.BigDecimal;

public class Calcula {
	
	public static void main (String args[]) {
		int x = 3;
		System.out.println("sen(" + x + ") = " + Sen(x));
		System.out.println("cos(" + x + ") = " + Cos(x));
	}

	private static BigDecimal calculaFatorial(int i){
		BigDecimal fatorial = BigDecimal.ONE;
		for (int j = 1; j <= i; j++) {
			fatorial = fatorial.multiply(new BigDecimal(j));
		}
		return fatorial;
	}
	
	@SuppressWarnings("deprecation")
	public static BigDecimal Sen (int n) {
		BigDecimal x = BigDecimal.valueOf(n);
		BigDecimal seno = BigDecimal.ZERO;
		int scale = 50;
		for (int i = 0; i < 1000; i++) {
			int k = 2*i + 1;
			BigDecimal xk = x.pow(k);
			BigDecimal fatk = calculaFatorial(k);
			BigDecimal sinal = BigDecimal.valueOf(-1).pow(i);
			seno = seno.add(sinal.divide(fatk, scale, BigDecimal.ROUND_HALF_EVEN).multiply(xk));
		}
		return seno;
	}
	
	@SuppressWarnings("deprecation")
	public static BigDecimal Cos (int n) {
		BigDecimal x = BigDecimal.valueOf(n);
		BigDecimal cosseno = BigDecimal.ZERO;
		int scale = 50;
		for (int i = 0; i < 1000; i++) {
			int k = 2*i;
			BigDecimal xk = x.pow(k);
			BigDecimal fatk = calculaFatorial(k);
			BigDecimal sinal = BigDecimal.valueOf(-1).pow(i);
			cosseno = cosseno.add(sinal.divide(fatk, scale, BigDecimal.ROUND_HALF_EVEN).multiply(xk));
		}
		return cosseno;
	}
}


