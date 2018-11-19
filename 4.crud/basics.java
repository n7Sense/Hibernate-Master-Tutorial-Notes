
	Inserting Record
=======================

	persist()
	save()  it return primary key in the form of serializable.
	saveorupdate()


	For Update
=================

	update()
	merge()
	saveorupdate()

	NOTE: sometimes update exception becomes fails in that case if you want to execute at any cost you can go
		through merge() methods,	

		Limitation: Of update()
				*Only non-primary-key column we can update
				*complete record we need to update,it is not possible to update one column must we need to pass complte record.

	WHEN U SHULD GO FOR merge() method.?
		If your Session already contain a persistent object(i.e Entity Object like employee, Student etc.) the same object whenever you try
		to update you can not update by update() methods to update u shuld go through merge() method.



If in current session if we lod the object and that same object if we insert by update() method then it wont throws any exception.
because that object in persistent state. as we know when we call update() method first it will perform SELECT operation the it perform
UPDATE operation, but in this case it just perform SELECT operation. but if we modify any properties of Object then he perform
UPDATE operation also.

		session = sf.openSession();
        transaction = session.beginTransaction();
        Employee emp = session.get(Employee.class, 1);
        session.close();
        transaction = null;
        Session session2 = sf.openSession();
        transaction = session2.beginTransaction();
        Employee emp2  = session2.get(Employee.class, 1);//if comment this line then it run successfully
        session2.update(emp);
        transaction.commit();
        session2.close();


If we update database with that same object in another SESSION, so in another session the previous object becomes DEATACHED
and then if we perform update operation it will throw
Exception in thread "main" org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [model.Employee#1]

When transaction.commit() called internally the session.flush() method is called.
	10.10. Flushing the Session
	-----------------------------
	Sometimes the Session will execute the SQL statements needed to synchronize the JDBC connections state with the state of objects held in memory.
	This process, called flush, occurs by default at the following points:

	before some query executions
	from org.hibernate.Transaction.commit()
	from Session.flush()

	The SQL statements are issued in the following order:

	all entity insertions in the same order the corresponding objects were saved using Session.save()
	all entity updates
	all collection deletions
	all collection element deletions, updates and insertions
	all collection insertions
	all entity deletions in the same order the corresponding objects were deleted using Session.delete()

	An exception is that objects using native ID generation are inserted when they are saved.

	Except when you explicitly flush(), there are absolutely no guarantees about when the Session executes the JDBC calls, only the order in which
	they are executed. However, Hibernate does guarantee that the Query.list(..) will never return stale or incorrect data.

	It is possible to change the default behavior so that flush occurs less frequently. The FlushMode class defines three different modes: only
	flush at commit time when the Hibernate Transaction API is used, flush automatically using the explained routine, or never flush unless
	flush() is called explicitly. The last mode is useful for long running units of work, where a Session is kept open and disconnected for a 
	long time (see Section 11.3.2, “Extended session and automatic versioning”).


 	DELETE operation
 ======================
elete(Object object)
Remove a persistent instance from the datastore.
void	delete(String entityName, Object object)	

1. Deleting a transient instance
		Product product = new Product();
		product.setId(37);
		session.delete(product);


	SELECT Operation
=========================
	
	get()
	load()

	