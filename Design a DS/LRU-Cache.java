/*
Question Link: https://leetcode.com/problems/lru-cache/
Approach: Used a Doubly linked list and 2 hahsmaps
*/
class LRUCache {
    HashMap<Integer, Node> mappings;
    HashMap<Integer, Integer> values;
    int limit;
    Node head;
    Node lastNode;

    public LRUCache(int capacity) {
        mappings = new HashMap<>();
        values = new HashMap<>();
        limit = capacity;
    }
    
    public int get(int key) {
        if(mappings.containsKey(key)){
            Node prevHead = head;
            Node recentlyUsedNode = mappings.get(key);
            if(head==recentlyUsedNode)
                return values.get(head.val);
            head = recentlyUsedNode;
            if(lastNode == recentlyUsedNode && recentlyUsedNode.prevNode!=null)
                lastNode = lastNode.prevNode;
            if(recentlyUsedNode.prevNode!=null)
                recentlyUsedNode.prevNode.nextNode = recentlyUsedNode.nextNode;
            if(recentlyUsedNode.nextNode!=null)
                recentlyUsedNode.nextNode.prevNode = recentlyUsedNode.prevNode;
            recentlyUsedNode.prevNode = null;
            recentlyUsedNode.nextNode = prevHead;
            prevHead.prevNode = recentlyUsedNode;
            return values.get(head.val);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mappings.containsKey(key)){
            get(key);
            values.put(key, value);
        }
        else{
            boolean limitReached = false;
            if(mappings.size()==limit)
                limitReached = true;
            Node newHead = new Node();
            if(head == null){
                newHead.nextNode = null;
                lastNode = newHead;
            }
            else{
                newHead.nextNode = head;
                head.prevNode = newHead;
            }
            newHead.val = key;
            newHead.prevNode = null;
            mappings.put(key, newHead);
            values.put(key, value);
            head = newHead;
            if(limitReached){
                mappings.remove(lastNode.val);
                values.remove(lastNode.val);
                lastNode = lastNode.prevNode;
                if(lastNode!=null)
                    lastNode.nextNode = null;
            }
        }
    }
}

class Node{
    int val;
    Node prevNode;
    Node nextNode;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */