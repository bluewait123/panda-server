package com.panda.demo.webservice.service.impl;

import com.panda.demo.webservice.service.HelloService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "HelloService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.lli.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.panda.demo.webservice.service.HelloService"// 接口地址
)
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String param) {
        return "hei body" + param;
    }

    @Override
    public String getUser(String param) {
        return "test" + param;
    }
}
