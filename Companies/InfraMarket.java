/*
set(k, v) O(1)
get(k) -> v O(1)
takesnapshot() -> sid O(k)
getValue(sid, k) -> v O(1)

Sid, k, v - integer

set(1, 3)
set(2, 4)
{
  1: 3,
  2: 4
}
takesnaphsot() -> 123
set(1, 7)
{
  1: 7,
  2: 4
}
takesnapshot() -> 101

get(1) -> 7
getvalue(123, 1) -> 3
getValue(101, 1) -> 7

HashMap<Integer, HashMap<Integer, Integer>> snapmap O(sk)
HashMap<Integer, Integer> kvmap O(k)

{
  1: {
‘Current’:3,
‘123’:3
},
  2: {
‘current’:4
‘123’:4
}
}

System Design Question. How to debbug latency in system. How to find issue with slowness of DB?

*/
