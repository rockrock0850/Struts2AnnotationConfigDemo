/**
 * HelloService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package t320.nks34;

public interface HelloService extends javax.xml.rpc.Service {
    public java.lang.String getHelloServiceSOAP11port_http1Address();

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_http1() throws javax.xml.rpc.ServiceException;

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_http1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getHelloServiceSOAP11port_httpsAddress();

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_https() throws javax.xml.rpc.ServiceException;

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_https(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
