import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    /**
     * The logic works in following way:
     * 1. Gets the maximum number index from array by iterating through all values.
     * 2. Gets the second maximum number index from array - skip the first max index
     * 3. Multiply value from both index
     * @param numbers
     * @return
     */
	static long getMaxPairwiseProduct( long[] numbers )
    {
        int index_of_first_max_no = 0;
        for ( int i = index_of_first_max_no + 1; i < numbers.length; ++i )
        {
            if ( numbers[index_of_first_max_no] < numbers[i] )
            {
                index_of_first_max_no = i;
            }
        }

        int index_of_second_max_no = index_of_first_max_no == 0 ? 1 : 0;
        for ( int i = index_of_second_max_no + 1; i < numbers.length; ++i )
        {
            if ( i != index_of_first_max_no && numbers[index_of_second_max_no] < numbers[i] )
            {
                index_of_second_max_no = i;
            }
        }
        
        return numbers[index_of_first_max_no] * numbers[index_of_second_max_no];

    }

    public static void main( String[] args )
    {
        FastScanner scanner = new FastScanner( System.in );
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for ( int i = 0; i < n; i++ )
        {
            numbers[i] = scanner.nextInt();
        }
        System.out.println( getMaxPairwiseProduct( numbers ) );
    }

    static class FastScanner
    {
        BufferedReader br;

        StringTokenizer st;

        FastScanner( InputStream stream )
        {
            try
            {
                br = new BufferedReader( new InputStreamReader( stream ) );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }

        String next()
        {
            while ( st == null || !st.hasMoreTokens() )
            {
                try
                {
                    st = new StringTokenizer( br.readLine() );
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt( next() );
        }
    }


}
