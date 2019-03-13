package com.qxSpringCloud.service;

import com.qxSpringCloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 要被扫描
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> queryList() {
                return null;
            }

            @Override
            public Dept query(Integer id) {
                Dept dept = new Dept();
                dept.setId(id);
                dept.setName("当前使用id：" + id + ";无此数据。");
                return dept;
            }
        };
    }
}
