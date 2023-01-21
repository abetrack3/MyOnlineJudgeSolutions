class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] characters = string.toCharArray();
            Arrays.parallelSort(characters);
            String key = String.valueOf(characters);

            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }

            map.get(key).add(string);
        }
        List<List<String>> result = new LinkedList<>();
        map.values().forEach(value -> result.add(value));
        return result;
    }
}