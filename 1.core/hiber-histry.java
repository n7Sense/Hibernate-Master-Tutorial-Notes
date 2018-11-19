Hibernate:			ORM Tools
==================	=================
	1. normal meaning of hibernate is, just like in Windows Os, there is some mode like, hibernate, log-Off, sleep mode etc. when we logoff, or sleep after that when we again on the pc, we got on the same session. what evere we opened an application that will
	be opened in same state.

	2. Hibernate simple meaning is sleep mode.


A. Why ORM tools .?  whta it actually do, ? whats it mening .?

	Ans: MVC
		In MVC based application, where actually hibernate will contribute, where actually hibernate help us.

		1. Hibernate is help us under MODEL part.
		2. Model is divided into 3-parts
			i.Business
			ii.DAO
			iii.Services  (extra services for Business)
		3. Hibernate help under DAO 
		4. Hibernate specially designed for Enterprise application. it will help us for standalone application also, Enterprise mean business application.

	EJB
===========
		1. the Gavin King is an envenor of Hibernate.
		2. withoud EJB we cant build MODEL part, in case if we build  it shuld not called Enterprise application.
		3. EJB components are abel to provide business features and Data Access features
		4. Gavin king found some problem with EJB then he invented the Hibernate in 2001
			PROBLEMS:
				a. like we can not migrate DataBase with EJB, it is a DataBase dependent
				b. suppose u submiting the form to the DataBase with EJB you can not directly talk with DAO to DataBase, like in Servlet
					the ServletController can directly talk with DAO to DataBase, bt in EJB first you have talk eith Session Been , the session bean will
					talk to Entity Bean  and later Entity bean process to DataBase.
				c. hence we can say thet EJB having dependency of Session Bean.
				d.the main disadvantages of EJB is it require a Application Server.
		5. to provide the services for business logic we shuld have to buy that all service from third party.
		6. we can buy a services separately from Application Server (i.e WebLogic, Glassfish, JBoss)
		7. EJB entity bin also have the CACHE support
		8. Also support QuerLanguage.
		9

	


