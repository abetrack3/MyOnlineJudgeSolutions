import java.util.BitSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        Arrays.stream(nums).forEach(set::add); //cannot use parallel stream since hashSet is not thread safe
        HashSet<Integer> visited = new HashSet<Integer>();
        AtomicInteger max = new AtomicInteger();
        Arrays.stream(nums).forEach(elem -> {
            if (visited.contains(elem)) return;
            visited.add(elem);
            int size = 1;
            int i = elem + 1;
            while (set.contains(i)) {
                size++;
                visited.add(i++);
            }
            i = elem - 1;
            while (set.contains(i)) {
                size++;
                visited.add(i--);
            }
            max.set(Math.max(max.get(), size));
        });
        return max.get();
    }
}