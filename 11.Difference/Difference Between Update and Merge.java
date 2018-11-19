Update
=========

	1. Update method is related to a particular Session Object. it is not related to 2  or 3 Session Object.
	2. If we load object after that we modify Object and close the connection.
		if we use same object loaded into another Session object, in this case whenever we use Update method doesent
			work. 

	Merge
============
	
	1. Merge method is related to multiple Session object.
	2. Where as whenever we are using Merge method it going to merge previous Session object with current Session
		and merge operation will successful.


		Employee emp = session.get(Employee.class, 145);
        emp.setFirstName("Keshav KN Narayan");
        session.close();

        Session session2 = sf.openSession();
        Transaction transaction2 = session2.beginTransaction();
        Employee emp2 = session2.get(Employee.class, 145);
        session2.merge(emp);
        transaction2.commit();
        session2.close();
        sf.close();