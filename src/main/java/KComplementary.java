import java.util.*;

public class KComplementary {


    /**
     * Saving the values of the array in the hashmap , Key = element, value = needed
     * If the item iterated is not in the map , it will be inserted
     * after being inserted we check if there is saved the complementary where  i + j to count 1
     *
     *
     * In test you can see the efficiency and comparation between both algorithm
     * @param input
     * @param K
     * @return
     */
    public final int getKcomplementaries(int[] input, int K) {
        int npairs = 0;
        Map<Integer, Integer> elements = new HashMap<>();

        for (int i : input) {
            int needed =K - i;
            elements.putIfAbsent(i, needed);

            if(elements.get(needed)!=null){
                npairs++;
            }
        }
        return npairs;
    }


    /**
     * More elegant solution but contains is not direct access as hashmap
     * @param input
     * @param K
     * @return
     */
    public final int getKcomplementariesElegant(int[] input, int K) {
        int npairs = 0;
        Set<Integer> elements = new HashSet<>();

        for (int i : input) {
            int needed = K - i;
            elements.add(i);

            if(elements.contains(needed)){
                npairs++;
            }
        }
        return npairs;
    }
}
