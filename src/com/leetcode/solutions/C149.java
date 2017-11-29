package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class C149 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    // the first generation of solution using the concept of 'vertical', 'duplicate' and use a Map of <Double,
    // Integer> to track the points on a line with same slope, see link of https://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
    // however there is a problem with the round up/down problem for double
    /**
     *
     Point p1 = new C149.Point(0, 0);
     Point p2 = new C149.Point(94911151,94911150);
     Point p3 = new C149.Point(94911152,94911151);
     Point[] points = new C149.Point[]{p1, p2, p3};
     */

    // correction solution from https://discuss.leetcode.com/topic/2979/a-java-solution-with-notes
    public int maxPoints(Point[] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;

        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result=0;
        for (int i=0;i<points.length;i++){
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                if (x==0&&y==0){
                    overlap++;
                    continue;
                }

                int gcd=generateGCD(x,y);
                x/=gcd;
                y/=gcd;

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer,Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1);// +1 because as long as there is a overlap, it won't be 1, but 2
        }
        return result;


    }

    private int generateGCD(int a,int b){
        if (b==0) return a;
        else return generateGCD(b,a%b);

    }

    public static void main(String[] strings) {
        C149 c = new C149();
        Point p1 = new C149.Point(0, 0);
        Point p2 = new C149.Point(94911151,94911150);
        Point p3 = new C149.Point(94911152,94911151);
        Point[] points = new C149.Point[]{p1, p2, p3};
        System.out.println(c.maxPoints(points));
    }

}
