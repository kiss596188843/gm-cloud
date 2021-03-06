package com.cetiti.ribbon;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2017-08-19
 */
@SuppressWarnings("unused")
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/normal")
    public ResponseEntity<String> test() {
        return restTemplate.getForEntity("http://localhost:8080/test", String.class);
    }

    /**
     * 打出provider的 jar ，启动两个服务
     */
    @GetMapping("/loadbalancer")
    public String test1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PROVIDER-SERVICE");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/test";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/ribbon")
    public String test2() {
        String url = "http://PROVIDER-SERVICE/test";
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "fallback")//超时时间 进入fallback
    public String test3() {
        String url = "http://GM-AI-MS/api/robots/";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String fallback() {
        return "FALLBACK";
    }
}
