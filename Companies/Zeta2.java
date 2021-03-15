/*
Rearrange the strgin such that no two consecutive elements are same.
Input: aaabc 
Output: abaca
*/
public String process(String str){
    int[] counts = new int[26];

    for(int i=0; i<str.length(); i++)
        counts[str.charAt(i)-'a']++;

    int maxCount = counts[0];
    int maxCountIndex = 0;
    for(int i=1; i<counts.length; i++){
        if(counts[i]>maxCount){
            maxCount=counts[i];
            maxCountIndex=i;
        }
    }

    StringBuilder sb = new StringBuilder();
    while(counts[maxCountIndex]-->0)
        str.append((char)(maxCountIndex+97));

    boolean skewed = false;
    if(sb.length()>1)
        skewed=true;

    for(int i=0; i<counts.length; i++){
        char curr = (char)(i+97);
        int count = counts[i];
        if(count==0)
            continue;
        if(skewed){
            skewed = insertInSkewed(sb, curr, count);
        }
        else addAlternate(sb, curr, count, 1);
    }

    return sb.toString();
}

public StringBuilder addAlternate(StringBuilder sb, char c, int count, int pos){
    if(count==0)
        return;
    sb.insert(pos, c);
    addAlternate(sb, c, count-1, pos+2);
}

public boolean insertInSkewed(StringBuilder sb, char c, int count){
    if(count==0){
        if(pos>=sb.length() || sb.charAt(pos)!=sb.charAt(pos-1))
            return false; //no more skewed
        return true; //still skewed
    }

    //Rest to the logic. From the position the array is skewed call addAlternate with the check that pos does not exceed string length. If it does, then add the remaining from pos=0, again using addAlternate
}