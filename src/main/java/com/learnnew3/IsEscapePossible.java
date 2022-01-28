package com.learnnew3;

import java.util.HashSet;
import java.util.Set;

/**
 * @describtion: 1036. 逃离大迷宫
 * @author: CaiJm
 * @Date: 2022-01-11 9:13
 */
public class IsEscapePossible {
    Set<Long> forbid=new HashSet<>();
    long max=(long)1e6;
    long from;
    long to;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        from=max*(long)source[0]+(long)source[1];
        to=max*(long)target[0]+(long)target[1];
        for(int i=0;i<blocked.length;i++){forbid.add(max*(long)blocked[i][0]+(long)blocked[i][1]);}
        Set<Long> start=new HashSet<>();
        Set<Long> end=new HashSet<>();
        int maxSize=blocked.length*(blocked.length-1)/2;
        findPath(target[0],target[1],maxSize,end);
        findPath(source[0],source[1],maxSize,start);
        return start.size()>maxSize&&end.size()>maxSize||end.contains(from)||start.contains(to);
    }
    public void findPath(int i,int j,int maxSize,Set<Long> set){
        long p=max*(long)i+(long)j;
        if(forbid.contains(p)||set.contains(p)||i<0||j<0||i==max||j==max){return;}
        set.add(p);
        if(set.size()>maxSize||set.contains(to)&&set.contains(from)){return;}
        findPath(i+1,j,maxSize,set);
        findPath(i-1,j,maxSize,set);
        findPath(i,j+1,maxSize,set);
        findPath(i,j-1,maxSize,set);
    }
}
