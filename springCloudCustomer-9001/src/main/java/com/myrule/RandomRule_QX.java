package com.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义负载
 */
public class RandomRule_QX extends AbstractLoadBalancerRule {
    // total = 0 当total = 5 后，我们的指针才能往下走。
    // index = 0 当前提供的服务器地址
    // total 需要重新设置为0，但是已经到达5，我们的index = 1
    // 我们现在有3台机器，三台可以，total 超过三就会出现问题
    private int total  = 0;
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                /* 可用server */
                List<Server> upList = lb.getReachableServers();
                /* 全部server */
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                /* 原随机算法 */
//                int index = this.rand.nextInt(serverCount);
//                server = upList.get(index);

                /* 新自定义算法 每台轮询5次 */
                if (total < 5){
                    server = upList.get(currentIndex);
                    total ++;
                }else{
                    total = 0;
                    currentIndex ++;
                    if (currentIndex >= upList.size()){
                        currentIndex = 0;
                    }
                }

                /* 为空则休息一会，下一轮再来 */
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}