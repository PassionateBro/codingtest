package com.learn;

import java.util.HashMap;

/**
 * @describtion: 205. 同构字符串
 * @author: CaiJm
 * @Date: 2021-10-09 10:05
 */
public class IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        int len=s.length();
        char[] arr1=new char[128];
        char[] arr2=new char[128];

        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        for(int i=0;i<len;i++){
            char a=sArr[i];
            char b=tArr[i];
            if(arr1[a]==0 && arr2[b]==0){
                arr1[a]=b;
                arr2[b]=a;
            }else{
                if(arr1[a]!=b){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("abcdefghijklmnopqrstuvwxyzva",
                "abcdefghijklmnopqrstuvwxyzck");
    }
}
