import static functions.ReadMe1Functions.*;
import static functions.ReadMe2Functions.getMaxPair;
import static functions.ReadMe2Functions.pairCountAndSingletonsLeft;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println(getUsernames(5));
            System.out.println(getUsernameWithHighestCommentCount());
            System.out.println(getUsernamesSortedByRecordDate(1333104319));

        }catch (Exception e){
            e.printStackTrace();
        }

       int noOfWashes= 10;
       int[] cleanPile = {1, 2, 1, 1};
       int[] dirtyPile= {1, 4, 3, 2, 4};
      System.out.println(getMaxPair(cleanPile,dirtyPile,noOfWashes));
    }

}
