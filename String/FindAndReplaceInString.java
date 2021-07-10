/*
Question Link: https://leetcode.com/problems/find-and-replace-in-string/
Approach: The main thing here to note is that if we replace a substring, then the indexing of remaining original charaters to the right of that replacement would change, and hence any future operation to the right of the substring won't point to the correct index.
So, what can we do? We can do the operation from right to left. In this way no future operations will be affected by current change. So we first store the source and target based on indices in hashmaps and sort the indices array. Then from right to left we traverse the indices array and make replacement in the original string if necessary.
*/
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> sourceIndex = new HashMap<>();
        HashMap<Integer, String> targetIndex = new HashMap<>();
        for(int i=0; i<indices.length; i++){
            sourceIndex.put(indices[i], sources[i]);
            targetIndex.put(indices[i], targets[i]);
        }
        Arrays.sort(indices);
        StringBuilder str = new StringBuilder(s);
        for(int i=indices.length-1; i>=0; i--){
            int index = indices[i];
            String source = sourceIndex.get(index);
            StringBuilder target = new StringBuilder(targetIndex.get(index));
            if(str.substring(index, index+source.length()).toString().equals(source)){
                str = new StringBuilder(str.substring(0, index)).append(target).append(new StringBuilder(str.substring(index+source.length())));
            }
        }
        return str.toString();
    }
}