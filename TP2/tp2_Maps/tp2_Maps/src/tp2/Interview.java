package tp2;

import java.util.*;

public class Interview {
    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){
        //Variables initialisation
        Collection<MatchingPair> collection=new LinkedList<>();
        Map<Integer,Integer> valueCount=new HashMap<>();

        //Map creation
        for(Integer value:values){
            Integer count = valueCount.containsKey(value) ? valueCount.get(value) : 0;
            valueCount.put(value, count + 1);
        }

        //O(n) operations
        for(Integer val:valueCount.keySet()) {
            int complement = targetSum - val;
            if (valueCount.containsKey(complement) && complement != val) {
                Integer countOfComplement = valueCount.get(complement);
                Integer countOfValue = valueCount.get(val);
                for (int i = 0; i < countOfComplement; i++) { //nested for loops only for
                    for (int j = 0; j < countOfValue; j++) { //the duplicates, doesn't
                        collection.add(new MatchingPair(complement, val)); //affect O(n)
                    }
                }
                valueCount.replace(val,0);
                valueCount.replace(complement,0);
            }
        }
        return collection;
    }
}

