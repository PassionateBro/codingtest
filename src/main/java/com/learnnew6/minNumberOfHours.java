package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-22 9:56
 */
public class minNumberOfHours {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hour = 0;
        for(int i = 0;i< energy.length;i++) {
            if (energy[i] >= initialEnergy) {
                int grow =  energy[i] - initialEnergy + 1;
                hour += grow;
                initialEnergy+= grow;
            }
            if (experience[i] >= initialExperience) {
                int growe = experience[i] - initialExperience + 1;
                hour += growe;
                initialExperience+=growe;
            }
            initialEnergy -= energy[i];
            initialExperience+= experience[i];
        }
        return hour;
    }

    public static void main(String[] args) {
        minNumberOfHours(5,3,new int[]{1,4},new int[]{2,5});
    }
}
