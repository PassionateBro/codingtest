package com.maystudy;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-25 13:15
 */
public class EverDay {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int nums = 1;
        int right = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] <= right) {
                right = Math.max(right, ranges[i][1]);
            } else {
                nums++;
                right = ranges[i][1];
            }
        }
        long res = 1;
        long base = 2;
        while (nums != 0) {
            if ((nums & 1) == 1) {
                res = ((res % 1000000007) * (base % 1000000007)) % 1000000007;
            }
            base = ((base % 1000000007) * (base % 1000000007)) % 1000000007;
            nums = nums >> 1;
        }
        return (int) res;
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        // dp[n] - dp[n - 1] = dp[n - 1] -dp[nextVisit[n - 1]] + 2
        long[] dp = new long[nextVisit.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2) % 1000000007;
            if (dp[i] < 0) {
                dp[i] += 1000000007;
            }
        }
        return (int) dp[dp.length - 1];
    }

    public static String finalString(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'i') {
                LinkedList<Character> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    temp.offerLast(queue.pollLast());
                }
                queue = temp;
            } else {
                queue.offerLast(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.pollFirst());
        }

        return res.toString();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n % 2 == 0) return res;
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i <= (n - 1) / 2; i += 2) {//计算左右子树
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root1 = new TreeNode(0);
                    root1.left = l;
                    root1.right = r;
                    res.add(root1);
                    TreeNode root2 = new TreeNode(0);
                    root2.left = r;
                    root2.right = l;
                    if (i != n - 1 - i) {
                        res.add(root2);
                    }
                }
            }
        }
        return res;
    }

    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int lenA = 1;
        int lenB = 1;
        int preA = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preA) {
                lenA++;
                lenB = 1;
            } else if (nums[i] < preA) {
                lenA = 1;
                lenB++;
            } else {
                lenA = 1;
                lenB = 1;
            }
            preA = nums[i];
            max = Math.max(Math.max(lenA, lenB), max);
        }
        return max;
    }

    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] judge = new char[chars.length];
        int left = k;
        for (int i = 0; i < chars.length; i++) {
            judge[i] = chars[i];
            if (chars[i] - 'a' == 0) {
                continue;
            } else {
                if (left > 0) {
                    judge[i] = chars[i];
                    int len = chars[i] - 'a';
                    int move = Math.min(len, 26 - len);
                    if (left >= move) {
                        chars[i] = 'a';
                        left -= move;
                    } else {
                        chars[i] = (char) (chars[i] - left);
                        left = 0;
                    }
                }
            }
        }
        return new String(chars);

    }

    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = len / 2;
        if (nums[mid] == k) {
            return 0;
        }
        long res = 0;
        if (nums[mid] > k) {
            res += nums[mid] - k;
            int i = mid - 1;
            while (i >= 0 && nums[i] > k) {
                res += nums[i] - k;
                i--;
            }
        } else {
            res += k - nums[mid];
            int i = mid + 1;
            while (i < len && nums[i] < k) {
                res += k - nums[i];
                i++;
            }
        }
        return res;
    }

    public static String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int i = 0, j = i + 1;
        while (i < chars.length) {
            if (chars[i] == '0') {
                if (j <= i) {
                    j = i + 1;
                }
                while (j < chars.length && chars[j] == '1') {
                    j++;
                }
                if (j < chars.length && j > i) {
                    chars[i] = '1';
                    chars[j] = '1';
                    chars[i + 1] = '0';
                }
                i++;
                j++;
            } else {
                i++;
                continue;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        maximumBinaryString("000110");
    }

}
