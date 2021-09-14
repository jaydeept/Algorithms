import java.util.Scanner;

public class Fibonacci
{
        /**
     * Slow function as it will compute same value more than once based on number.
     * @param n
     * @return
     */
    private static long calc_fib( int n )
    {
        if ( n <= 1 )
            return n;

        return calc_fib( n - 1 ) + calc_fib( n - 2 );
    }

    /**
     * 1. Store the first and second value as 0 and 1 in array.
     * 2. Keep storing all numbers in array
     * 3. Gets the last one
     * @param n
     * @return
     */
    private static long calc_fib_fast( int n )
    {
        if ( n <= 1 )
            return n;
        long[] a = new long[n + 1];
        a[0] = 0;
        a[1] = 1;
        for ( int i = 2; i <= n; ++i )
        {
            a[i] = a[i - 1] + a[i - 2];
        }

        return a[n];
    }

    /**
     * Almost similar to {@link calc_fib_fast} except this stores the current value directly.
     * @param n
     * @return
     */
    private static long calc_fib_faster( int n )
    {
        long previousValue = 0;
        long currentValue = 1;
        for ( int i = 0; i < n - 1; ++i ) // n-1 was taken as first 0 is ignored
        {
            long temp = previousValue;
            previousValue = currentValue;
            currentValue = temp + previousValue;
        }

        return currentValue;
    }

    public static void main( String args[] )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();

        System.out.println( "Using slow recursive method: " + calc_fib( n ) );
        System.out.println( "Using Array store method " + calc_fib_fast( n ) );
        System.out.println( "Using Current value store method " + calc_fib_faster( n ) );
    }
}
