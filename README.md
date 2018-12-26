# springboot

# **AspectjWeavingWthSpringBoot**

As I understand, Spring is a Run Time orchestration system i.e to say that all bean objects that are wired into the application are proxies of the original 
load time classloader's objects.

Hence any method calls in Spring cannot be intercepted without compiling the classes into spring context.So, all the Controller, Model a or View that we 
@RequestHeader, @ModelAttribute etc.

When classes are compiled and loaded they are under full control during the run time, but if we use 3rd party libraries, we still can do some controlling by
using load time wiring. However, Spring relies on JDK and CGLIB jars available in load time to generate the Spring Beans(proxies). Hence at the run time, the 
the JDK or CGLIB packages and classes's public methods are the only things visible for you to use them in your code. This is how spring's policy is framed.

Hence to handle Non compiled classes like JDK jars or 3rd party libraries, for aop, we need them on the Load Time and Compile Time Weaving.

However, in AspectJ based load time weaving in Spring, I was unable to intercept Java, Javax packages which could by definition be weaved at load time. I therefore had the job done with compile time weaving of AspectJ.

I was also unable configure properly to use `call()` method instead of `execution()` in Spring as the method was never working as an aspect in Boot. 

For ref:- [link1](https://stackoverflow.com/questions/9235043/load-time-weaving-of-javax-swing-classes-with-aspectj)
          [link2](http://jexp.ru/index.php?title=Java_Tutorial/Spring/MethodInterceptor&redirect=no)
		  
		  
# **CXFBootStarterSoapWebService**
		  
The project is a demo of configuring CXF based Soap Web Service in Spring Boot. As the SOAP WS comes under JAXWS specification, and CXF provides one such implementation to it, I have used	it here. 

Initially, an XML definition for SOAP elements is decalred and using xjcplugins we develop the corresponding java classes. Now, the service interface is created and its class is coded to use the XSD generated binding classes or beans in our WebService. Having developed the web service, we now provide and end point so that any external client may interact with the web service in getting or posting some data. This end point is configured to the Spring Boot App and WSDL may or may not be deployed as per your wish, which can be seen commented in the POM.xml. Upon building the pom, our web service is ready and can be started. Any client that wishes to interact the service may call the webservice and view a dynamically generated WSDL (as no WSDl is deployed in this example) and can build its web service client.

# **SpringBootWebServiceClient**

This is the client code for our web service. As you can see in the POM.xml, the web service's wsdl is referred and correspondingly the required Java Beans(XML Bindings) are generated using `codegen` plugin. We can then write our own code using these generated java classes to perform our required tasks.


# **SpringBootValidator**

This is  simple demo in Spring Boot how a Bean Validator can be used in html forms by using the JSR 303 based Spring or Hibernate Validator Framework taking the help of various annotations that are provided. This is a highly enriching feature when we need to validate our web forms using html or ajax (like FormBeans in Struts or JSF), which otherwise would required bloated code at Server Side Handler Classes.
