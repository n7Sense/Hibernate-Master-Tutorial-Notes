	Spring Solution Over EJB and Hibernate
==============================================

	Suppose you have an Application like Banking Application, in that there is a 2000 process which reflect the Database,
	 suppose 1000 process require some Services (Messaging, Mail, Security etc) and 1000 process not require any services.

	so we can run 1000 process with EJB and 1000 process with hibernate, but in that we have to buy services from Application Serer.
	So our Servlet can directly talk with hibernate, for some business cases if u require servicesn then wecan go through EJB session Boolean

	Still EJB have dependency in Model part, to build Model part EJB required for to provide services.

	so How these dependencies we can reduce, by using Spring we can reduce this all problem.

	Spring
	=======
		1. Insted of using EJB if we go through Spring, for Spring we no need to make any EAR file and no need to use any application server
		2. to buy  any services,
		3. Spring itself provide all the services
		4. Spring itself a framework, in that framework they given Services implemntation Classes.
		5. For require Services we can freely aspect Services for business Component from Spring and Spring acn talk with Hibernate,
		6. For Hibernate also we dont require any special platform, JRE is inough

	Q.1.Where we can RUN Spring.? 
		To run Spring we require Spring library and JRE
 
	Q.2.Where we can RUN Hibernate.?
		To run Hibernate we require Hibernate library and JRE

	AND for Controller part execution environment like for Servlet Controller we cn use Tomcat Server.
	we can build any Enterprise Application by using Spring-Hibernate combination.

	Q.3. Hibernate support.?
		Hibernate specially provide support for DAO part.

	Q.4 Spring Support.
		Spring provide support for business Component, not only business part, Spring will provide support for DAO and Controller part also.
		that is a concept of spring



