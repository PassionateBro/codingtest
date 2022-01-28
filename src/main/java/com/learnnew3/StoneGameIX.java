package com.learnnew3;

/**
 * @describtion: 2029. 石子游戏 IX
 * @author: CaiJm
 * @Date: 2022-01-20 9:26
 */
public class StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int[] tab = new int[3];

        for(int stone:stones){
            tab[stone%3]++;       //把所有数字取余到0到2，三种情况
        }

        if(tab[1]==0 && tab[2]==0){
            return false;             //没1没2，开局必死
        }
        if(tab[0]%2==0){
            return tab[1]>0 && tab[2]>0;   //有1有2，alice总能逮着机会凑3
        }else{
            return tab[1]-tab[2]>2 || tab[2] -tab[1]>2;    //大佬们说是模拟法，我就不懂怎么模拟了
        }
    }
}
