	HQL
============
	Limitation:
	For INSERT only the limitation is we can Dump One table into another table, we cant insert data given by User.

	But for UPDATE, DELETE, SELECT we can do by USER also.

	1. It is related to Hibernate, we need to write query on Object
	2. HQL queries are object query
	3. e.g Usinf Class we need to Select column
	4. it Database Independent.
	5. you can update primary Key also,	and one SINGLE column also we can update which is not possible in session.update() method.
		Query q= session.createQuery(sql2);
	    int i = q.executeUpdate();

	 7.SELECT OPEration:
	 		we can apply any kind of SELECT OPErationlike single record, complete, JOIN, aggregate function
	 		Query contain methodthat helpto perform OPEration on Table;
	 		like:
	 			1. executeUpdate 			for DML
	 			2. uniqueResult				for DRL and to get One record
	 			3. list() 					for DRL ad toget multiple record



	8. If you want insert bulk of record then only we have to go for HQL, if we want to insert SINGLE record then manually we can use session.save() method
	9.

	
	SQl
========
	1. It is related to Hibernate
	2. HQL queries are object query
	3. e.g Usinf Class we need to Select column
	4. it is Database dependent
