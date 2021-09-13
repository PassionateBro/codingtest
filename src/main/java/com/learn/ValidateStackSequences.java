package com.learn;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;

/**
 * @describtion: 946. 验证栈序列
 * @author: CaiJm
 * @Date: 2021-09-01 10:44
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayList<Integer> objects = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            objects.add(pushed[i]);
            while (!objects.isEmpty() && (int) objects.get(i - j) == popped[j]) {
                objects.remove(i - j);
                j++;
            }
        }
        return objects.isEmpty();
    }

    public static void premain(String[] args, Instrumentation instrumentation) {
        System.out.println("premain执行=============");
    }

    public static void main(String[] args) {
//        VirtualMachine vm = VirtualMachine.attach("pid(进程号)");
//        vm.loadAgent("java-agent路径/lab-custom-agent-1.0-SNAPSHOT-jar-with-dependencies.jar");

        System.out.println("aaa");
    }

    /**
     * 动态 attach 方式启动，运行此方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("agentmain");
    }


}
