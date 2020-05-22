/*
Question Link: https://leetcode.com/problems/flatten-nested-list-iterator/
Approach: FIrst Removed all the empty lists in the entire list. And then always fetched the first element available, and checked all its parents if child list is empty, for which it has to be deleted.
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        removeEmptyNests(list);
    }
    
    public void removeEmptyNests(List<NestedInteger> list){
        int i = list.size()-1;
        while(i>=0){
            if(list.get(i).isInteger()){
                i--;
                continue;
            }
            else{
                if(list.get(i).getList().size()==0)
                    list.remove(i);
                else{
                    removeEmptyNests(list.get(i).getList());
                    if(list.get(i).getList().size()==0)
                    list.remove(i);
                }
            }
            i--;
        }
    }

    @Override
    public Integer next() {
        List<NestedInteger> temp1 = list;
        if(temp1.get(0).isInteger()){
            int res = temp1.get(0).getInteger();
            temp1.remove(0);
            return res;
        }
        Stack<List<NestedInteger>> stack = new Stack<>();
        stack.push(list);
        temp1 = temp1.get(0).getList();
        while(!temp1.get(0).isInteger()){
            stack.push(temp1);
            temp1 = temp1.get(0).getList();
        }
        int res = temp1.get(0).getInteger();
        temp1.remove(0);
        stack.push(temp1);
        List<NestedInteger> temp = stack.pop();
        while(!stack.isEmpty()){
            if(temp.size()==0 && !stack.isEmpty()){
                temp = stack.pop();
                temp.remove(0);
            }
            else
                break;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if(list.size()>0)
            return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */