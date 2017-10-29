import java.math.BigInteger;

//This program is an implementation of the p minus one factoring
//algorithm in lecture 7.  It factors a number n into two primes
//p and q.
public class Main {

    public static void main(String[] args) {
        BigInteger N = new BigInteger("190248273382547686244479775579416295505415044511");
        BigInteger g = new BigInteger("2");
        BigInteger r = new BigInteger("2");
        BigInteger h;
        BigInteger k = new BigInteger("37");
        boolean pass = false;

        while (!pass) {
            g = g.modPow(r, N);
            h = g.subtract(BigInteger.ONE).gcd(N);

            if (h.compareTo(BigInteger.ONE) == 1 && h.compareTo(N) == -1) {
                System.out.println("p = " + h);
                BigInteger q = N.divide(h);
                System.out.println("q = "+q);
                if (h.isProbablePrime(100)){
                    System.out.println("p is prime");
                }
                if (q.isProbablePrime(100)){
                    System.out.println("q is prime");
                }
                System.out.println("p * q = " + h.multiply(q));

                break;
            } else {
                r = r.add(BigInteger.ONE);
                if (r.compareTo(k) < 1) {
                    pass = false;
                } else {
                    pass = true;
                }
            }
        }
    }
}
