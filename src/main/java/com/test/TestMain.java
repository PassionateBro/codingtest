package com.test;

import java.io.IOException;

public class TestMain {
    static volatile boolean flag = true;

    public static void main(String[] args) throws IOException {
//        ServerSocketChannel ssc = ServerSocketChannel.open();
//        Selector sel = Selector.open();
//        ssc.configureBlocking(false);
//        ssc.socket().bind(new InetSocketAddress(8080));
//        SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
//        SocketChannel ch = null;
//        while(true) {
//            sel.select();
//            Iterator it = sel.selectedKeys().iterator();
//            while(it.hasNext()) {
//                SelectionKey skey = (SelectionKey)it.next();
//                it.remove();
//                if(skey.isAcceptable()) {
//                    ch = ssc.accept();
//                }
//            }
//

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(new Task() {
//        });
//        Timer timer = new Timer();
        String s = "https://www.cnblogs.com/niunafei/p/13274749.html";
        System.out.println(s.hashCode() % 1000);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = {New.class};
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        //这里需要注意，循环条件
        while (left <= right) {
            //这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        int mid = left + ((right - left) >> 1);
        //没有找到该元素，返回 -1
        return -1;
    }
}
