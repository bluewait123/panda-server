package com.panda.demo.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {
    @WebMethod
    String sayHello(@WebParam(name = "param") String param);

    @WebMethod
    String getUser(@WebParam(name = "param") String param);
}
