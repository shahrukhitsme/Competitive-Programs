

Given an array find a pair such that it sums to a given number.

Array: [4,8,2,6,2,5]
Num: 10

Output: [[4,6],[2,8]]

ArrayList<Integer> findPairs(ArrayList<Integer> input, int targetSum){
HashMap<Integer, Integer> counts = new HashMap<>();
for(int i=0; i<input.size(); i++)
counts.put(input.get(i), counts.getOrDefault(input.get(i), 0)+1);
List<List<Integer>> result = new ArrayList<>();
for(int i=0; i<input.size(); i++){
	Int num1 = input.get(i);
	Int num2 = targetSum - num1;
	if(num1==num2){
		if(count.get(num1)>=2)
			addPair(num1, num1, result, counts);
} else {
	if(count.get(num1)>=1 && count.get(num2)>=1){
		addPair(num1, num2, result, counts);
}
}
}
return result;
}


void addPair(int num1, int num2, ArrayList<ArrayList<Integer>> parentList, HashMap<Integer, Integer> counts){
List<Integer> temp = new ArrayList<>();
	temp.add(num1);
	temp.add(num2);
	parentLIst.add(temp);
counts.put(num1, counts.get(num1)-1);
counts.put(num2, counts.get(num2)-1);
}






40000, 1
0-40000
2345
5432
65432


_ 2 _

ArrayList<Integer> get nums(int end, int diff){
	Int numOfDigits = 0;
	Int temp = end;
	while(temp!=0){
		temp=temp/10;
		numOfDigits++;
}
List<Integer> result = new ArrayList<>();
for(int j=1, j<=9; j++)
getNumbers(result, end, diff, j);
}

Void getNumbers( List<Integer> result, int end, int diff,  int curr){
	if(curr>end)
		Return;
	if(curr/10!=0)
		result.add(curr);
Int nextNum1 = curr+diff;
Int nextNum2 = curr-diff;
if(nextNum1>9 || nextNum2<0)
	Return;
if(nextNum1<=9)
getNumbers(result, end, diff, curr*10+(nextNum1));
if(nextNum2>=0)
getNumbers(result, end, diff, curr*10+(nextNum2));
}
