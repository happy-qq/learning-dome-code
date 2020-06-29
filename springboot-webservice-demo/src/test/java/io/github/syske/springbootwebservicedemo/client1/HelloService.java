package io.github.syske.springbootwebservicedemo.client1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.1
 * 2020-04-28T16:54:24.962+08:00
 * Generated source version: 3.3.1
 *
 */
@WebService(targetNamespace = "http://service.ws.sample/", name = "HelloService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HelloService {

    @WebMethod(action = "urn:SayHello")
    @WebResult(name = "hello", targetNamespace = "http://service.ws.sample/", partName = "parameters")
    public Hello sayHello(
            @WebParam(partName = "parameters", name = "name", targetNamespace = "http://service.ws.sample/")
                    Name parameters
    );
}
