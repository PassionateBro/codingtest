package com.lerannew7;

import java.util.HashMap;
import java.util.Map;

/**
 * @describtion: 1797. 设计一个验证系统
 * @author: CaiJm
 * @Date: 2023-02-09 14:18
 */
public class AuthenticationManager {

    private HashMap<String, Integer> map = new HashMap<>();

    private int liveTime;

    public AuthenticationManager(int timeToLive) {
        this.liveTime = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + liveTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            Integer time = map.get(tokenId);
            if (time > currentTime) {
                map.put(tokenId, currentTime + liveTime);
            } else {
                map.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > currentTime) {
                res++;
            }
        }
        return res;
    }


}
