package kClosestsPointsToOrigin;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            int distanceA = (a[0]*a[0]) + (a[1]*a[1]);
            int distanceB = (b[0]*b[0]) + (b[1]*b[1]);

            return distanceB - distanceA;
        });

        for(int [] point: points){
            queue.add(point);
            if(queue.size() > k){
                queue.poll();
            }
        }

        return queue.toArray(new int[][]{});
    }
}
