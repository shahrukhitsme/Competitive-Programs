/* Round 1 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    
    public static void main (String[] args) throws java.lang.Exception{
        String[] usernames = new String[]{"a","b", "c", "d","e"};
        List<User> users = new ArrayList<User>();
        for(int i=0; i<usernames.length; i++)
            users.add(new User(usernames[i]));
        List<User> newFriends = AddFriendship(users.get(0), users.get(1));
        newFriends = AddFriendship(users.get(0), users.get(2));
        newFriends = AddFriendship(users.get(1), users.get(2));
        newFriends = AddFriendship(users.get(1), users.get(3));
        showFriends(users.get(0));
        showFriends(users.get(1));
        List<User> mutuals = MutualFriends(users.get(0), users.get(1));
        System.out.print("Mutual friends of "+users.get(0).name+" and "+users.get(1).name+" : ");
        for(User u: mutuals)
            System.out.print(u.name+" ");
        System.out.println();
        showUsers("Suggested", GetSuggestedFriends(users.get(0)));
    }
    
    public static void showFriends(User user){
        System.out.print("Friends of "+user.name+" : ");
        for(User u: user.friends)
            System.out.print(u.name+" ");
        System.out.println();
    }
    
    public static void showUsers(String relation, HashSet<User> users){
        System.out.print(relation+" friends "+" : ");
        for(User u: users)
            System.out.print(u.name+" ");
        System.out.println();
    }
    

    public static List<User> AddFriendship(User u1, User u2){
        u1.friends.add(u2);
        u2.friends.add(u1);
        List<User> newFriends = new ArrayList<User>();
        newFriends.add(u1);
        newFriends.add(u2);
        return newFriends;
    }

    public static List<User> MutualFriends(User u1, User u2){
        List<User> mutuals = new ArrayList<User>();
        HashSet<User> friends = u1.friends;
        for(User u: friends){
            if(isFriend(u, u2))
                mutuals.add(u);
        }
        return mutuals;
    }

    public static boolean isFriend(User u1, User u2){
        return u1.friends.contains(u2);
    }

    public static HashSet<User> GetSuggestedFriends(User u1){
        HashSet<User> suggestedFriends = new HashSet<User>();
        for(User u: u1.friends){
            HashSet<User> fsof = u.friends;
            for(User fof: fsof){
                if(!u1.friends.contains(fof))
                    suggestedFriends.add(fof);
            }
        }
        suggestedFriends.remove(u1);
        return suggestedFriends;
    }
}

class User{
    public User(String name){
        this.name = name;
        friends = new HashSet<User>();

    }

    public String name;
    public HashSet<User> friends;
}