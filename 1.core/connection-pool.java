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
