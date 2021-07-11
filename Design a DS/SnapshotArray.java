/*
Question Link: https://leetcode.com/problems/snapshot-array/
Approach: Create a list of lists. The first list will have the original items, default 0. And the value in list will be an object having the snap id and the value. For each snap we just maintain snap id, so we just increment that variable. While setting a value, we check what was the latest snap in for that index, and if it is outdated, we add a new object with the updated snap. Finally while getting we search the snap id at that index and return the value.
*/
class SnapshotArray {
    List<List<SnapVal>> arr;
    int lastSnap;
    public SnapshotArray(int length) {
        arr = new ArrayList<>(length);
        for(int i=0; i<length; i++){
            SnapVal obj = new SnapVal();
            obj.snap_id = -1;
            obj.val = 0;
            List<SnapVal> temp = new ArrayList<>();
            temp.add(obj);
            arr.add(temp);
        }
        lastSnap = -1;
    }
    
    public void set(int index, int val) {
        List<SnapVal> temp = arr.get(index);
        int len = temp.size();
        SnapVal lastObj = temp.get(len-1);
        if(lastObj.snap_id == lastSnap+1){
            lastObj.val = val;
        }
        else{
            SnapVal newObj = new SnapVal();
            newObj.snap_id = lastSnap+1;
            newObj.val = val;
            temp.add(newObj);
        }
    }
    
    public int snap() {
        return ++lastSnap;
    }
    
    public int get(int index, int snap_id) {
        List<SnapVal> snaps = arr.get(index);
        for(int i=0; i<snaps.size()-1; i++){
            int currId = snaps.get(i).snap_id;
            if(currId==snap_id || (currId<snap_id && snap_id<snaps.get(i+1).snap_id))
                return snaps.get(i).val;
        }
        return snaps.get(snaps.size()-1).val;
    }
}

class SnapVal{
    int snap_id;
    int val;
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);                                        14
 */