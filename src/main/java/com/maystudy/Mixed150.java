package com.maystudy;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-13 9:58
 */
public class Mixed150 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1 = nums2;
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, right = nums.length - 1;
        while (i < nums.length && i < right) {
            if (nums[i] == val) {
                nums[i] = nums[right];
                nums[right] = 0;
                right--;
            } else {
                i++;
            }
        }
        if (nums[i] == val) {
            nums[i] = 0;
        } else {
            i++;
        }
        return i;
    }

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    public static int removeDuplicates2(int[] nums) {
        int p = 0, q = p + 2;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 2] = nums[q];
                p++;
            }
            q++;
        }
        return p + 2;
    }

    public static int majorityElement(int[] nums) {
        int a = 0;
        Integer ca = null;
        for (int num : nums) {
            if (a == 0) {
                ca = num;
            }
            a = a + ((num == ca) ? 1 : -1);
        }
        return ca;
    }

    public static void rotate(int[] nums, int k) {
        int d = k % nums.length;
        int all = 0;
        for (int i = 0; i <= 1000; i++) {
            if (all == nums.length) break;
            int stop = i + d;
            int j = i + d;
            if (j >= nums.length) {
                j = j - nums.length;
            }
            int temp = nums[i];
            while (true) {
                int x = nums[j];
                nums[j] = temp;
                all++;
                temp = x;
                j += d;
                if (j >= nums.length) {
                    j = j - nums.length;
                }
                if (j == stop) break;
            }
        }
    }

    public static int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(prices[i], minValue);
            if (prices[i] > minValue) {
                max = Math.max(max, prices[i] - minValue);
            }
        }
        return max;
    }

    public static int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return dp[nums.length - 1] > 0;
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0, far = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, nums[i] + i);
            if (i == end) {
                res++;
                end = far;
            }
        }
        return res;
    }

    public int hIndex(int[] citations) {
        int[] res = new int[1001];
        for (int i = 0; i < citations.length; i++) {
            res[citations[i]] += 1;
        }
        int num = 0;
        for (int i = 1000; i >= 0; i--) {
            num += res[i];
            if (num >= i) {
                return i;
            }
        }
        return 0;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        int[] back = new int[nums.length];
        back[nums.length - 1] = nums[nums.length - 1];
        int[] answer = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i];
        }
        answer[0] = back[1];
        answer[nums.length - 1] = pre[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            answer[i] = pre[i - 1] * back[i + 1];
        }
        return answer;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public static int candy(int[] ratings) {
        int sum = 1;
        int temp = 1;
        int i = 1;
        while (i < ratings.length) {
            if (ratings[i] > ratings[i - 1]) {
                temp++;
                sum += temp;
                i++;
            } else if (ratings[i] == ratings[i - 1]) {
                temp = 1;
                sum += temp;
                i++;
            } else {
                int begin = i - 1;
                while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                    i++;
                }
                int totalNum = 0;
                if (i - begin > temp) {
                    totalNum = ((i - begin) * (1 + i - begin)) >> 1;
                    sum = sum + totalNum - temp;
                } else {
                    totalNum = ((i - begin - 1) * (1 + i - begin - 1)) >> 1;
                    sum = sum + totalNum;
                }
                temp = 1;
            }
        }
        return sum;

    }


    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int res = 0, i = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length - 1) {
            String d = chars[i] + "" + chars[i + 1];
            Integer num = map.get(d);
            if (num == null) {
                res += map.getOrDefault(String.valueOf(chars[i]), 0);
                i++;
            } else {
                res += num;
                i += 2;
            }
        }
        if (i == chars.length - 1) {
            res += map.getOrDefault(String.valueOf(chars[i]), 0);
        }
        return res;
    }

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int temp1 = deal(num, 1000, res, "M", 900, "CM");
        int temp2 = deal(temp1, 500, res, "D", 400, "CD");
        int temp3 = deal(temp2, 100, res, "C", 90, "XC");
        int temp4 = deal(temp3, 50, res, "L", 40, "XL");
        int temp5 = deal(temp4, 10, res, "X", 9, "IX");
        int temp6 = deal(temp5, 5, res, "V", 4, "IV");
        deal(temp6, 1, res, "I", 4000, "IV");
        return res.toString();
    }

    private static int deal(int num, int v1, StringBuilder res, String s1, int v2, String s2) {
        if (num >= v1) {
            int temp = num / v1;
            for (int i = 0; i < temp; i++) {
                res.append(s1);
            }
            num = num % v1;
        }
        if (num >= v2) {
            res.append(s2);
            num -= v2;
        }
        return num;
    }

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public static String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        int len = chars.length - 1;
        for (int i = 1; i < strs.length; i++) {
            char[] chars1 = strs[i].toCharArray();
            int temp = -1;
            for (int j = 0; j < Math.min(chars1.length, chars.length); j++) {
                if (chars[j] == chars1[j]) {
                    temp = j;
                    continue;
                } else {
                    temp = j - 1;
                    break;
                }
            }
            if (temp < len) {
                len = temp;
            }
            if (temp < 0) {
                break;
            }
        }
        if (len < 0) {
            return "";
        }
        return new String(chars).substring(0, len + 1);
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() == 0) continue;
            res.append(s1[i]).append(" ");
        }
        return res.toString().substring(0, res.length() - 1);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        String res = "";
        for (int i = 1; i <= numRows; i++) {
            int index = i - 1;
            StringBuilder sub = new StringBuilder();
            while (index < len) {
                if ((index + 1) % (numRows - 1) == 1 || numRows == 2) {
                    sub.append(s.charAt(index));
                } else {
                    sub.append(s.charAt(index));
                    if (index + 2 * (numRows - i) < len && numRows != i) {
                        sub.append(s.charAt(index + 2 * (numRows - i)));
                    }
                }
                index = index + 2 * (numRows - 1);
            }
            res += sub.toString();
        }
        return res;
    }

    public int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        int idx = 0;
        char[] judge = needle.toCharArray();
        while (idx < chars.length) {
            if (chars[idx] == judge[0]) {
                // 开启匹配 idx
                int begin = idx, j = 0, first = -1;
                while (idx < chars.length && j < judge.length && chars[idx] == judge[j]) {
                    if (first == -1 && j != 0 && chars[begin] == chars[idx]) {
                        first = idx;
                    }
                    idx++;
                    j++;
                }
                if (j == judge.length) {
                    return begin;
                } else {
                    if (first > 0) {
                        idx = first;
                    }
                }
            } else {
                idx++;
            }
        }
        return -1;
    }

    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int beginWords = i, endsWords = i, len = 0;
            while (i < words.length && words[i].length() + len <= maxWidth) {
                endsWords = i;
                len += words[i].length() + 1;
                i++;
            }
            int wordsSpace = endsWords - beginWords;
            // 非最后一行，空格均匀
            if (endsWords != words.length - 1) {
                int spaceNum = 1;
                // 非单个单词进行空格计算
                if (endsWords > beginWords) {
                    spaceNum += (maxWidth - len + 1) / wordsSpace;
                }
                StringBuilder space = new StringBuilder();
                for (int j = 0; j < spaceNum; j++) {
                    space.append(" ");
                }
                // 计算冗余空格数
                int last = maxWidth - (len - wordsSpace - 1 + (wordsSpace * space.length()));
                StringBuilder temp = new StringBuilder();
                for (int j = beginWords; j <= endsWords; j++) {
                    temp.append(words[j]);
                    if (j != endsWords) {
                        temp.append(space);
                    }
                    if (last > 0) {
                        temp.append(" ");
                        last--;
                    }
                }
                for (int j = 0, spaceLast = maxWidth - temp.length(); j < spaceLast; j++) {
                    temp.append(" ");
                }
                list.add(temp.toString());
            } else {
                StringBuilder temp = new StringBuilder();
                for (int j = beginWords; j <= endsWords; j++) {
                    temp.append(words[j]);
                    if (j != endsWords) {
                        temp.append(" ");
                    }
                }
                for (int j = 0, lastSpace = maxWidth - temp.length(); j < lastSpace; j++) {
                    temp.append(" ");
                }
                list.add(temp.toString());
            }
        }
        return list;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;

    }

    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        int a = 0, b = 0;
        int res = 0;
        while (a < chars.length && b < chars1.length) {
            if (chars[a] == chars1[b]) {
                a++;
                b++;
                res++;
            } else {
                b++;
            }
        }
        return res == chars1.length;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int a = 0, b = numbers.length - 1;
        int temp = 0;
        while (a < b && b < numbers.length) {
            temp = numbers[a] + numbers[b];
            if (temp < target) {
                a++;
            }
            if (temp == target) {
                break;
            }
            if (temp > target) {
                b--;
            }
        }
        return new int[]{a + 1, b + 1};
    }


    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int min = Math.min(height[left], height[right]);
        int res = 0;
        while (left < right) {
            res = Math.max((right - left) * min, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            min = Math.min(height[left], height[right]);
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            int b = i + 1, c = nums.length - 1;
            while (b < c && c < nums.length) {
                int temp = nums[i] + nums[b] + nums[c];
                if (temp == 0) {
                    // 去重
                    if (c + 1 >= nums.length || nums[b] != nums[b - 1] || nums[c] != nums[c + 1]) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[b]);
                        tempList.add(nums[c]);
                        list.add(tempList);
                    }
                    b++;
                    c--;
                } else if (temp < 0) {
                    b++;
                } else {
                    c--;
                }
            }
        }
        return list;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int tempLen = 1;
        int tempSum = nums[0];
        int left = 0, right = 0;
        while (left <= right && right < nums.length) {
            if (tempSum < target) {
                right++;
                if (right < nums.length) {
                    tempSum += nums[right];
                    tempLen++;
                }
            } else if (tempSum >= target) {
                len = Math.min(tempLen, len);
                tempSum -= nums[left];
                left++;
                tempLen--;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] temp = new int[1000];
        int dupNum = 0;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int res = 0;
        int tempLen = 1;
        temp[chars[0]]++;
        while (left <= right && right < chars.length) {
            if (dupNum == 0) {
                res = Math.max(tempLen, res);
                right++;
                tempLen++;
                if (right < chars.length) {
                    temp[chars[right]]++;
                    if (temp[chars[right]] > 1) {
                        dupNum++;
                    }
                }
            } else {
                temp[chars[left]]--;
                if (temp[chars[left]] == 1) {
                    dupNum--;
                }
                left++;
                tempLen--;
            }
        }
        return res;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;

    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int judgeNum = t.length();
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int nums = 0;
        int left = 0, right = 0;
        int resL = 0, resR = 0;
        char first = s.charAt(0);
        int res = Integer.MAX_VALUE;
        if (map.containsKey(first)) {
            nums++;
            tempMap.put(first, 1);
        }
        while (left <= right && right < s.length()) {
            if (nums == judgeNum) {
                if (right - left + 1 < res) {
                    res = right - left + 1;
                    resL = left;
                    resR = right + 1;
                }
                char del = s.charAt(left);
                Integer integer = tempMap.get(del);
                if (integer != null) {
                    tempMap.put(del, integer - 1);
                    if (integer - 1 < map.get(del)) {
                        nums--;
                    }
                }
                left++;
            } else {
                right++;
                if (right < s.length()) {
                    char temp = s.charAt(right);
                    if (map.containsKey(temp)) {
                        tempMap.put(temp, tempMap.getOrDefault(temp, 0) + 1);
                        if (tempMap.get(temp) <= map.get(temp)) {
                            nums++;
                        }
                    }
                }
            }
        }
        return s.substring(resL, resR);
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] sq = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0' - 1;
                if (num < 0) continue;
                if (++line[i][num] > 1) {
                    return false;
                }
                if (++col[j][num] > 1) {
                    return false;
                }
                if (++sq[i / 3][j / 3][num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] mark = new int[matrix.length][matrix[0].length];
        int a = 0, b = 0;
        list.add(matrix[0][0]);
        mark[0][0] = 1;
        int total = matrix.length * matrix[0].length;
        while (list.size() < total) {
            while (b + 1 < matrix[0].length && mark[a][b + 1] == 0) {
                mark[a][b + 1] = 1;
                list.add(matrix[a][b + 1]);
                b++;
            }
            while (b - 1 >= 0 && mark[a][b - 1] == 0) {
                mark[a][b - 1] = 1;
                list.add(matrix[a][b - 1]);
                b--;
            }
            while (a + 1 < matrix.length && mark[a + 1][b] == 0) {
                mark[a + 1][b] = 1;
                list.add(matrix[a + 1][b]);
                a++;
            }
            while (a - 1 >= 0 && mark[a - 1][b] == 0) {
                mark[a - 1][b] = 1;
                list.add(matrix[a - 1][b]);
                a--;
            }
        }
        return list;
    }

    public void rotate(int[][] matrix) {

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(a);
    }
}
