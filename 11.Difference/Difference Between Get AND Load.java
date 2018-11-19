	Difference Between Get AND Load
========================================

GET
========
	1. while retriving the record if record in NOT FOUND then it will throw NullPointerException.
		not understandable formate.

	2. It is Early Loading. means All the record are going to loaded at a time
		e.g: if 2-Tables i.e Parent table and Child table is there Parent table having 2-record that record pointing
			to Child record, whne we use this method, first of all it is going to load to the all the Parents along with
			the Parents all Child also going to be loaded at a time.

  3. retriving single record of Users with Table-Per-Class Strategy
      Hibernate: 
            select
                user0_.user_id as user_id1_0_0_,
                user0_.user_name as user_nam3_0_0_,
                user0_.user_email as user_ema4_0_0_,
                user0_.created_user as created_5_0_0_,
                user0_.job_assigned as job_assi6_0_0_,
                user0_.projects as projects7_0_0_,
                user0_.user_type as user_typ2_0_0_ 
        Nov 19, 2018 3:02:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
        INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/nsense]
            from
                users user0_ 
            where
                user0_.user_id=?
        ***************************
        User{userId=1, userName='Rahul', userEmail='rahul@gmail.com'}

        Process finished with exit code 0

Load
======
	1. If record not found then it will throws ObjectNotFoundException
		Understandable manner.

	2. It is Lazy loading. meanse in this, 1-st it is going to be loading to the Parent, after loading Parent related
	to child are going to loaded, then 2nd-Parent going to loaded related child going to be loaded.
	Relation concept is there by default Hibernate support Lazy Loading.
  
  3. retriving single record of Users with Table-Per-Class Strategy
      Hibernate: 
            select
                user0_.user_id as user_id1_0_0_,
                user0_.user_name as user_nam3_0_0_,
                user0_.user_email as user_ema4_0_0_,
                user0_.created_user as created_5_0_0_,
                user0_.job_assigned as job_assi6_0_0_,
                user0_.projects as projects7_0_0_,
                user0_.user_type as user_typ2_0_0_ 
        Nov 19, 2018 3:02:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
        INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/nsense]
            from
                users user0_ 
            where
                user0_.user_id=?
        ***************************
        User{userId=1, userName='Rahul', userEmail='rahul@gmail.com'}

        Process finished with exit code 0
	

Session.get()
===============
 public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable);
  
  public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract Object get(String paramString, Serializable paramSerializable);
  
  public abstract Object get(String paramString, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract Object get(String paramString, Serializable paramSerializable, LockOptions paramLockOptions);


  Session.load()
  ==============

  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract Object load(String paramString, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract Object load(String paramString, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable);
  
  public abstract Object load(String paramString, Serializable paramSerializable);
  
  public abstract void load(Object paramObject, Serializable paramSerializable);