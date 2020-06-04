package functions;

import org.apache.commons.lang3.ArrayUtils;
import utils.PairSingletonResult;

import java.util.Arrays;

import static org.apache.commons.lang3.math.NumberUtils.min;

public class ReadMe2Functions {

 //Go through The Clean Socks Stack
    // Count out all the pairs leave the singletons
    //While number of wash is not exceeded
        // foreach singleton if corresponding color in dirty pile
            //wash it i.e increase number of pairs remove value clean pile remove match from dirty pile
        // When done with singletons if number of washes left is up to two
            //loop through singletons left in dirty pile and find pairings
            // untill either wash count or index of array is exceeded.

    public static Integer getMaxPair(int[] cleanPile, int[] dirtyPile,int noOfWashes){
        int washed = 0;
        PairSingletonResult result = pairCountAndSingletonsLeft(cleanPile);
        int pairCount = result.getPairs();
        int[] singletonLeft = result.getSingletons();

        for (int color: singletonLeft) {
            if (ArrayUtils.contains(dirtyPile,color)&(washed<noOfWashes)){
                pairCount += 1;
                dirtyPile= ArrayUtils.remove(dirtyPile,ArrayUtils.indexOf(dirtyPile,color));
                washed += 1;
            }
        }
        PairSingletonResult dirtyPairing = pairCountAndSingletonsLeft(dirtyPile);
        int dirtyPairs = dirtyPairing.getPairs();
        int washesLeft = noOfWashes-washed;
        int canWash = min(dirtyPairs,(washesLeft/2));
        pairCount += canWash;

        return pairCount;
    }


    public static PairSingletonResult pairCountAndSingletonsLeft(int[] pile){
        int pairs = 0;
        for (int i = 0; i < pile.length ; i++) {
            for (int j = 0; j < pile.length; j++) {
                if ((i !=j) & (pile[i]==pile[j])){
                    pairs +=1;
                    pile = ArrayUtils.removeAll(pile,i,j);
                }
            }
        }
        return new PairSingletonResult(pairs, pile);

    }


}
