	Session
===============

	1.	this Session is similar like our JDBC connection object.
		using the Session we can pass or attach our Entity object with this Session.
		
	2.	session.save(emp1); this state is called Parsistent state.

	3.	from this persistent state to move to database, we need to apply transaction
		session.beginTransaction();
		session.getTransaction().commit();

	4.	when we apply commit(), the hibernate internally read the Entity object, and this data will pass to table,
		this state is called as Permanent state or Database state.

	5.	It holds a first-level cache (mandatory) of data. T
		The org.hibernate.Session interface provides methods to insert, update and delete the object. It also provides factory methods
		for Transaction, Query and Criteria.

	6.	A Session is used to get a physical connection with a database. The Session object is lightweight and designed to be instantiated
		each time an interaction is needed with the database. Persistent objects are saved and retrieved through a Session object.

	7.	The session objects should not be kept open for a long time because they are not usually thread safe and they should be created
		and destroyed them as needed. The main function of the Session is to offer, create, read, and delete operations for instances of
		mapped entity classes.

	8. Session use the Cashed memory to store the Object.
	NOTE:
		In the persistent state or when we attach our Entity Object to session, int the persistent state we can keep our Object
		into any no.of hours, Garbage Collector will not remove

		when appliying the commit() the Object is moved to permanent state but still that object present in persistent state
		to destroy , to allocate that object to Garbage Collector we have to call  
		public void evict(Object object) methods
		after calling this methods, the state of that object is called DEATACHED.
		