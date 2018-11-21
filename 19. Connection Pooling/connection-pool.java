	Connection Object
	===================
	Every day we are getting Connection object, direct we are hitting on Database and we got Connection object but there is an
	performence issue, to overcome this problem we shuld go for Connection pooling (also called as 3rd-Driver)

	Whenever we are using Connection pooling Concept, we can get the Re-Usability Connection Object from Application Server
	here we are not hitting to the Database and we are not getting the connection object,
	we are going to hitting the Middleweare Server, now Middleweare Server is given to Connection object, that connection object
	we called them as Re-Usability Connection Object OR Logical Connection Object(not physical object).

	We have to install Middleweare Server in our local machine
	
	1. Collection of Connection Object is called as POOL.
	2. now configuring Datasource interface.
	3. now configure JNDI (Java Naming Directory Interface)
	this three steps was done by the Admin people we are not responsible.



	Connection-Pool
======================
	
Pool is nothing but a group of resources ready to use, the biggest of advantages of Pool is reusability, performence by default improved
cost of the application will be reduced.

If youwant to communicate with the database multiple times it is ot recommended to create a separate Object, not recommended to destroy the
connection object separately,

then wht we shuld do..?
	we will mentain a POOL of Pre-Defiend connection, already created connection object will be there, which are ready to provide service,
	which are ready to use.
	and then if you want to communicate with the database, you can request the pool to give the connection, once we got the connection 
	we can happly communicate with the database, one the work with connection got completed then insted of destroying the connection
	we can return the connection object into the POOL

	Advantages:

		1. same connection object can be used multiple times, can be reused multiple times so that overall performence of the application will be
		improved, because we are reusing same connection object.
