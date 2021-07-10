/*
Question Link: https://leetcode.com/problems/accounts-merge/
Approach: Here we need to group all email under one hood together. So we created edges between first email to rest of emails, and vice versa which were under a name. We created edges by defining relation between 2 emails using HashMap<String, List<String>>. Them after creating all the relations, we just traversed through the emails and did a DFS recursively, also maintaining a seen hashset to avoid infinite loop, and adding all emails which are connected thus. Then sorting them, and adding the name in the start which we had stored in a hashmap in the start mapped from email to name.
*/
class Solution {
    HashMap<String, List<String>> relations;
    HashSet<String> seen;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap<>();
        relations = new HashMap<>();
        for(int i=0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            if(!relations.containsKey(account.get(0)))
                relations.put(account.get(0), new ArrayList<>());
            for(int j=1; j<account.size(); j++){
                emailToName.put(account.get(j), account.get(0));
                if(!relations.containsKey(account.get(j)))
                    relations.put(account.get(j), new ArrayList<>());
                relations.get(account.get(1)).add(account.get(j));
                relations.get(account.get(j)).add(account.get(1));
            }
        }
        List<List<String>> res = new ArrayList<>();
        seen = new HashSet<>();
        for(String email: emailToName.keySet()){
            if(!seen.contains(email)){
                seen.add(email);
                List<String> groupedMails = crawl(email);
                Collections.sort(groupedMails);
                groupedMails.add(0, emailToName.get(email));
                res.add(groupedMails);
            }
        }
        return res;
    }
    
    public List<String> crawl(String email){
        List<String> res = new ArrayList<>();
        res.add(email);
        List<String> relatedEmails = relations.get(email);
        for(int i=0; i<relatedEmails.size(); i++){
            String relatedEmail = relatedEmails.get(i);
            if(!seen.contains(relatedEmail)){
                seen.add(relatedEmail);
                res.addAll(crawl(relatedEmail));
            }
        }
        return res;
    }
}