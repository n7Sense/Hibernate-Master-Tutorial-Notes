	Named NamedQueries
==========================

In Hibernate, a named query is a JPQL or SQL expression with predefined unchangeable query string.
You can define a named query either in hibernate mapping file or in an entity class.

Annotations @NamedQuery and @NamedQueries are used for HQL or JPQL expression whereas @NamedNativeQuery and @NamedNativeQueries are used
for native SQL expression.

	Why Named Queries
========================
	If there are a lot of queries, then they will cause a code mess because all the queries will be scattered throughout the project.
	That’s why Hibernate provides Named Query that we can define at a central location and use them anywhere in the code.
	We can created named queries for both HQL and Native SQL.
	
	The hibernate named query is way to use any query by some meaningful name. It is like using alias names. The Hibernate framework provides the concept of named queries so that application programmer need not to scatter queries to all the java code.

	There are two ways to define the named query in hibernate:
		by annotation
		by mapping file.


Hibernate Named Query can be defined in Hibernate mapping files or through the use of JPA annotations @NamedQuery and @NamedNativeQuery.
Today we will look into both of them and how to use hibernate named query in a simple application.