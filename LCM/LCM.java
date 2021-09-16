import java.util.*;

public class LCM
{
    private static long lcm_naive( long a, long b )
    {
        for ( long l = 1; l <= (long) a * b; ++l )
        {
            if ( l % a == 0 && l % b == 0 )
            {
                return l;
            }
        }

        return (long) a * b;
    }

    /**
     * Uses following formula. a x b = LCM(a, b) * GCD (a, b) Hence, LCM(a, b) = (a x b) / GCD(a, b) To find GCD Refer
     * {@link https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/} for finding GCD
     * @param a
     * @param b
     * @return
     */
    private static long lcm_efficient( long a, long b )
    {
        long gcd = euclid_gcd( a, b );
        long multiplication = a * b;
        return multiplication / gcd;
    }

    private static long euclid_gcd( long a, long b )
    {
        if ( b == 0 )
            return a;
        long remainder = a % b;
        return euclid_gcd( b, remainder );
    }

    public static void main( String args[] )
    {
        Scanner scanner = new Scanner( System.in );
        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.println( lcm_efficient( a, b ) );
    }
}
