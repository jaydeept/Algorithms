import java.util.*;

public class GCD
{
    private static int gcd_naive( int a, int b )
    {
        int current_gcd = 1;
        for ( int d = 2; d <= a && d <= b; ++d )
        {
            if ( a % d == 0 && b % d == 0 )
            {
                if ( d > current_gcd )
                {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    /**
     * The Euclid formula to calculate greatest common denominator uses the prime number approach.
     * @param a
     * @param b
     * @return
     */
    private static int euclid_gcd( int a, int b )
    {
        if ( b == 0 )
            return a;
        int remainder = a % b;
        return euclid_gcd( b, remainder );
    }

    public static void main( String args[] )
    {
        Scanner scanner = new Scanner( System.in );
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println( "Using slow Naive mathod: " + gcd_naive( a, b ) );
        System.out.println( "Using Euclid fast mathod: " + euclid_gcd( a, b ) );
    }
}
