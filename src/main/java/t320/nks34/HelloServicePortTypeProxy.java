package t320.nks34;

public class HelloServicePortTypeProxy implements t320.nks34.HelloServicePortType {
  private String _endpoint = null;
  private t320.nks34.HelloServicePortType helloServicePortType = null;
  
  public HelloServicePortTypeProxy() {
    _initHelloServicePortTypeProxy();
  }
  
  public HelloServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloServicePortTypeProxy();
  }
  
  private void _initHelloServicePortTypeProxy() {
    try {
      helloServicePortType = (new t320.nks34.HelloServiceLocator()).getHelloServiceSOAP11port_http1();
      if (helloServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloServicePortType != null)
      ((javax.xml.rpc.Stub)helloServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public t320.nks34.HelloServicePortType getHelloServicePortType() {
    if (helloServicePortType == null)
      _initHelloServicePortTypeProxy();
    return helloServicePortType;
  }
  
  public java.lang.String helloName(java.lang.String name) throws java.rmi.RemoteException{
    if (helloServicePortType == null)
      _initHelloServicePortTypeProxy();
    return helloServicePortType.helloName(name);
  }
  
  
}