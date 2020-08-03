package com.panda.webservice.test;

import com.panda.webservice.vo.QueryCreditReportRequest;
import com.panda.webservice.vo.QueryCreditReportResponse;
import com.panda.webservice.vo.QueryinfoParam;
import org.apache.axis.Constants;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class MyTest {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        javax.xml.rpc.Call call = service.createCall();
        call.setTargetEndpointAddress("http://localhost:8080/froad_crbank_web_simulator_war/services/HelloService?wsdl");
        String namespace = "http://webService.crbank.froad.com";
        String methodName = "sayHello";
        QName action = new QName(namespace, methodName);
        call.setOperationName(action);
        call.addParameter("name", Constants.XSD_STRING, ParameterMode.IN);
//        call.addParameter("queryCreditReportRequest", Constants.XSD_ANY, ParameterMode.IN);
        call.setReturnType(action, QueryCreditReportResponse.class);

        QueryCreditReportRequest request = new QueryCreditReportRequest();
        QueryinfoParam queryinfoParam = new QueryinfoParam();
        queryinfoParam.setAccount("11111");
        request.setQueryinfoParam(queryinfoParam);

        call.invoke(new Object[]{"123"});

    }
}
