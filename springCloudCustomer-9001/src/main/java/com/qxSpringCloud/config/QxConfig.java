package com.qxSpringCloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class QxConfig {
    /**
     * 注入RestTemplate 并实现LoadBalanced 负载
     * 使用默认的负载均衡，轮询执行 1-2-3-1-2-3...
     * 如果声明自己的负载算法，则使用声明的算法
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 1:RoundRobinRole 轮询
     * 2:RandomRule   随机
     * 3:AvailabilityFilteringRule  过滤掉多次访问故障处于跳闸状态的服务，还有超过访问阙值的服务
     * 4:WeightedResponseTimeRule   根据平均响应时间，响应时间越快，被访问的权重就越大，刚启动统计信息不足，则使用轮询，之后切换到此状态。
     * 5:RetryRule  按照轮询获取服务，如果在指定是时间内访问失败则进行重试，获取可用的服务
     * 6:BestAvailableRule  过滤掉由于多次访问故障处于跳闸状态的服务，选中一个并发量最小的服务
     * 7:ZoneAvoidDanceRule 默认规则，符合判断server所在区域的性能和service的可用性选择服务器
     * 8:自定义负载规则
     */

//    @Bean
//    public IRule rule(){
//        /* 声明随机负载规则 */
//        /* return new RandomRule();  */
//        /* 声明失败跳过负载规则 */
//        return new RetryRule();
//    }

}
