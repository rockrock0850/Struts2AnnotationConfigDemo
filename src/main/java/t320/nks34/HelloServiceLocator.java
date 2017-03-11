/**
 * HelloServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package t320.nks34;

public class HelloServiceLocator extends org.apache.axis.client.Service implements t320.nks34.HelloService {

    public HelloServiceLocator() {
    }


    public HelloServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloServiceSOAP11port_http1
    private java.lang.String HelloServiceSOAP11port_http1_address = "http://t320webservices.open.ac.uk:80/t320/services/HelloService";

    public java.lang.String getHelloServiceSOAP11port_http1Address() {
        return HelloServiceSOAP11port_http1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloServiceSOAP11port_http1WSDDServiceName = "HelloServiceSOAP11port_http1";

    public java.lang.String getHelloServiceSOAP11port_http1WSDDServiceName() {
        return HelloServiceSOAP11port_http1WSDDServiceName;
    }

    public void setHelloServiceSOAP11port_http1WSDDServiceName(java.lang.String name) {
        HelloServiceSOAP11port_http1WSDDServiceName = name;
    }

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_http1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServiceSOAP11port_http1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServiceSOAP11port_http1(endpoint);
    }

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_http1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            t320.nks34.HelloServiceSOAP11BindingStub _stub = new t320.nks34.HelloServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getHelloServiceSOAP11port_http1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServiceSOAP11port_http1EndpointAddress(java.lang.String address) {
        HelloServiceSOAP11port_http1_address = address;
    }


    // Use to get a proxy class for HelloServiceSOAP11port_https
    private java.lang.String HelloServiceSOAP11port_https_address = "https://t320webservices.open.ac.uk:80/t320/services/HelloService";

    public java.lang.String getHelloServiceSOAP11port_httpsAddress() {
        return HelloServiceSOAP11port_https_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloServiceSOAP11port_httpsWSDDServiceName = "HelloServiceSOAP11port_https";

    public java.lang.String getHelloServiceSOAP11port_httpsWSDDServiceName() {
        return HelloServiceSOAP11port_httpsWSDDServiceName;
    }

    public void setHelloServiceSOAP11port_httpsWSDDServiceName(java.lang.String name) {
        HelloServiceSOAP11port_httpsWSDDServiceName = name;
    }

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_https() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServiceSOAP11port_https_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServiceSOAP11port_https(endpoint);
    }

    public t320.nks34.HelloServicePortType getHelloServiceSOAP11port_https(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            t320.nks34.HelloServiceSOAP11BindingStub _stub = new t320.nks34.HelloServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getHelloServiceSOAP11port_httpsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServiceSOAP11port_httpsEndpointAddress(java.lang.String address) {
        HelloServiceSOAP11port_https_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (t320.nks34.HelloServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                t320.nks34.HelloServiceSOAP11BindingStub _stub = new t320.nks34.HelloServiceSOAP11BindingStub(new java.net.URL(HelloServiceSOAP11port_http1_address), this);
                _stub.setPortName(getHelloServiceSOAP11port_http1WSDDServiceName());
                return _stub;
            }
            if (t320.nks34.HelloServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                t320.nks34.HelloServiceSOAP11BindingStub _stub = new t320.nks34.HelloServiceSOAP11BindingStub(new java.net.URL(HelloServiceSOAP11port_https_address), this);
                _stub.setPortName(getHelloServiceSOAP11port_httpsWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloServiceSOAP11port_http1".equals(inputPortName)) {
            return getHelloServiceSOAP11port_http1();
        }
        else if ("HelloServiceSOAP11port_https".equals(inputPortName)) {
            return getHelloServiceSOAP11port_https();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://nks34.t320", "HelloService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://nks34.t320", "HelloServiceSOAP11port_http1"));
            ports.add(new javax.xml.namespace.QName("http://nks34.t320", "HelloServiceSOAP11port_https"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloServiceSOAP11port_http1".equals(portName)) {
            setHelloServiceSOAP11port_http1EndpointAddress(address);
        }
        else 
if ("HelloServiceSOAP11port_https".equals(portName)) {
            setHelloServiceSOAP11port_httpsEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
