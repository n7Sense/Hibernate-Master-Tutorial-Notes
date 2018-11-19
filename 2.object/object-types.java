Object-Types
============
	
	if we want to perform any CRUD operation we have to persist Object into Hibernate.
	there are have 3-types of object in Hibernate

	1. transient
	2. persistent
	3. detached


1.	when we creating an Entity object and initializing the object by setter() or constructor() methods the state of that object is 
	transient state.

2. Configuration Object:
	
	1. Configuration is a class 
	2. Configuration class is a container class for Hibernate.
	3. this class load the hibernate.cfg.xml file, e.g: 

		Configuration cfg = new Configuration();
		cfg.configure("/cnf/hibernate.cfg.xml");
		after loading the Configuration xml file.

		














	