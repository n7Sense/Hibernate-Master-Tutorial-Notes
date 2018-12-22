Cache Support
==============
	to improve application performence we have to use cache support
	similar like in EJB we have Entity Bean, Container Management, Bean management like cache support we have.

	In Hibernate we have 3-Level cache support we have.
	1. Session Level Cache -- Use-full for One User
	2. Session Factory   --> for All User
	3. Query Cache.	--> for One Instance

	mainly cache support is use for to reduce the Database Call on Database layer.

	1. Session Cache
		it is used for one single User operation.
		at this level , if suppose 2-Admin retrive to get 1000 data

		SessionFactory sf =new Configuration().configure().buildSessionFactory(); // we required Single SessionFactory object for all the user.
		
		if again-and again if 1st admin tried to see the 100 times same 100 Employees data, if i use the same session object without closing the session after the completion of operation
		until doing LogOut if i use the same session object, it will retrive only one time from Database, for the remning all the calls Data will be retrived from 
		session Object itself.
		Session session = sf.openSession(); // for 1st User admin we need to open Session.
			Query query = session.createQuery("from Employees");
			List<Employees> list  = query.list();

		Session session2 = sf.openSession(); // for the 2nd User admin we need to open the session. 
			Query query = session2.createQuery("from Employees");
			List<Employees> list  = query.list();

		1st time it will fetch data from Database, but for 99-call it will fetch from session object, per User if we wnt data then we have to go for Session Level cache.

		Example: After Log-IN into your Gmail if we want to retrive Inbox-Mails, at the 1st time Log-IN it will retrive from Database, after Log-IN
		if we try to refresh, if we dont have new mail, but Data insted of reading from Database, it will load from ur Cache memory itself until doing Log-Out
		it doing only One single Select operation.


	2. SessionFactory Level cache.

		 If the 1-User Admin select the data that same data if we want to available to 2nd-User Admin then we shuld go for SessionFactory Level Cache.
		 at this level one Single SessionFactory object can have opening of Session multipple times but Data will be Stored into SessionFactory Level
		 for any No. Of user it will fetch 1st time only from Database. so Factory level cache is aplicable for entire application, 

		 Hibernate second level cache uses a common cache for all the session object of a session factory. It is useful if you have multiple session objects from a session factory.

		SessionFactory holds the second level cache data. It is global for all the session objects and not enabled by default.

		Different vendors have provided the implementation of Second Level Cache.

		EH Cache
		OS Cache
		Swarm Cache
		JBoss Cache
		Each implementation provides different cache usage functionality. There are four ways to use second level cache.

		read-only: caching will work for read only operation.
		nonstrict-read-write: caching will work for read and write but one at a time.
		read-write: caching will work for read and write, can be used simultaneously.
		transactional: caching will work for transaction.

	3. Query Cache.
			If same query applied 100 of times on database then for 1st time it will fetch from Database after that it will stored into Query Cache and from that 
			Query Cache it will retrive data.

