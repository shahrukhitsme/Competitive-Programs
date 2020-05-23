/*
Question Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
Approach: Create a list, and a HashMap having the mappings of numbers with their index position on the list. On removal, put the last position of the list in the position of element to 
be removed, and remove the last element, and update the HashMap accordingly.
*/
class RandomizedSet {
    HashMap<Integer, Integer> mappings;
    List<Integer> entries;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        mappings = new HashMap<>();
        entries = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(mappings.containsKey(val))
            return false;
        entries.add(val);
        mappings.put(val, entries.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!mappings.containsKey(val))
            return false;
        int index = mappings.get(val);
        entries.set(index, entries.get(entries.size()-1));
        mappings.put(entries.get(index), index);
        entries.remove(entries.size()-1);
        mappings.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random(); 
        int r = rand.nextInt(entries.size());
        return entries.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */