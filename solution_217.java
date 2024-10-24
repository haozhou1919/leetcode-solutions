import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
class solution_217 {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Map<Integer, Integer> num = new HashMap<>();
        for(int i : nums){
            num.put(i, 0);
        }
        for(int i : nums){
            num.put(i, num.get(i)+1);
            if(num.get(i)>1) flag = true;
        }
        return flag;
    }
    // possible better: becaue only one for loop
    public boolean containsDuplicate_2(int[] nums) {
      HashMap<Integer, Integer> seen = new HashMap<>();
      for (int num : nums) {
          if (seen.containsKey(num) && seen.get(num) >= 1)
              return true;
          // getOrDefault is either the value to the key num or 0
          seen.put(num, seen.getOrDefault(num, 0) + 1);
      }
      return false;
  }
  // quickest 
  public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            if (hs.contains(n)) return true;
            else hs.add(n);
        }
        return false;
    }
}