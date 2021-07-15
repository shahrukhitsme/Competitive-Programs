/*
Question Link: https://leetcode.com/problems/car-fleet-ii/
Approach: Start from the right and maintain a min_till_now, if a speed is lesser than min_till_now, then no car on the left of it would ever be able to meet a car on the right of it, and then update min_till_now to current speed which is the new lowest. Then if the current speed is greater than the next and the next is the min_till_now, then just calculate the time and update the res array. Also maintain another array in which we would store the index of the car to which the current car actually merged into. Now if the current car speed is more than the min_till_now, we then find the first car on the right whose speed is lesser than the current car. The current car may directly merge into that, or if it takes more time that that next car to merge into next and change it speed, then it might merge into that next, but then again if that also takes more time, this chain goes on until we find a car which is not going to merge into any next, or the total time taken till now is less that of the the queried car time to merge into its next. Thus we update the time and mergedInto arrays for the current car.
*/
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int len = cars.length;
        double[] times = new double[len];
        int[] mergedInto = new int[len];
        int last_min_speed_index = len-1;
        int last_min_speed = cars[len-1][1];
        int last_min_dist = cars[len-1][0];
        times[len-1] = (double)(-1);
        mergedInto[len-1] = -1;
        for(int i=cars.length-2; i>=0; i--){
            int curr_speed = cars[i][1];
            int next_speed = cars[i+1][1];
            double curr_dist = (double)cars[i][0];
            if(curr_speed<=next_speed && curr_speed<=last_min_speed){
                last_min_speed_index = i;
                last_min_speed = curr_speed;
                last_min_dist = cars[i][0];
                times[i] = (double)(-1);
                mergedInto[i] = -1;
            } else if(curr_speed>next_speed && next_speed==last_min_speed) {
                int net_speed = curr_speed - last_min_speed;
                double net_dist = (double)cars[i+1][0] - curr_dist;
                times[i] = net_dist/(double)net_speed;
                mergedInto[i] = i+1;
            } else {
                int next_lower_index = i+1;
                while(curr_speed<=cars[next_lower_index][1]){
                    if(mergedInto[next_lower_index]==-1)
                        break;
                    next_lower_index = mergedInto[next_lower_index];
                }
                double time = (double)0;
                double next_lower_dist = (double)cars[next_lower_index][0];
                int next_lower_speed = cars[next_lower_index][1];
                while(true){       
                    double t = (double)(next_lower_dist - curr_dist)/(double)(curr_speed-next_lower_speed);
                    if(mergedInto[next_lower_index]==-1){
                        time += t;
                        mergedInto[i] = next_lower_index;
                        break;
                    } else {
                        double time_by_next_lower = times[next_lower_index];
                        if(time_by_next_lower>=time+t){
                            time += t;
                            mergedInto[i] = next_lower_index;
                            break;
                        } else {
                            time += time_by_next_lower;
                            curr_dist += curr_speed * time_by_next_lower;
                            next_lower_speed = cars[mergedInto[next_lower_index]][1];
                            next_lower_dist = (double)cars[mergedInto[next_lower_index]][0] + next_lower_speed*time;
                            next_lower_index = mergedInto[next_lower_index];
                        }
                    }
                }
                times[i] = time;
            }
        }
        return times;
    }
    
}