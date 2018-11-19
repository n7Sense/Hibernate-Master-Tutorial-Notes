how to write hibernate application
===================================

1. Pojo class
2. Mapping File
3. Configuration File
4. Test Class


Pojo Class
===========
	1. contain required no.of proprty
	2. compalsory Default Constructor mandetory
	3. for each property must setter & getters need to provide.
	4. setter and getters accessed shuld be public.
	5. we can have Extra Methods, veriables and Constructor


Mapping File
=============
	Whenever we pass Object to Hibernate, Hibernate need to  store Object data where.? he need to read Object Data, after
	reading, in which table it need to store..? it require Mapping File


	Configuration
=====================

	If we use XML based configuration then we have to use Configuration container i.else {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	}

	If we use Annotation Based based configuration then we have to use AnnotationConfiguration container i.else {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
	}

	But After Hibernate 4.X onwards, for XMl and Annotation
	for both we can use only Single Container i.e Configuration container is inough to process both xml and Annotation.



