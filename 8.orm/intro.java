
	ORM
==========

1. Relation
--------------
	
	If suppose there is an UserTable and UserDataTable heare is Parent-Chield relationship is there is called Is-A Relationship.
	If suppose there is an Employee and Department, if employee contain department because Employee belongs to department
	therefore Employee  have foregin key for Department table, such type of relation is called HAS-A Relationship.

	To establish this both-Relationship in hibernate, we can provide

	1. Inheritance Support (for IS-A relation)
		i. Table-Per-Class
			1-Table Create with all Fields of Parent and Child CLass

		ii. Table-Per-SubClass
			2.	Specific Table create for each Parent and Child class
				We can perform JOIN operation to get record
				We have to prefer this. 

		iii. Table-Per-GenerateClass OR  Table-Per-Concrete Class
			3.	Only Child class Table will be generated.

	
	2. Association Support (for HAS-A relation) 
		i. 		One-To-One
					One table Primary Key used as other Table to primary key we have to ue Foregin Generator
		ii. 	One-To-Many
		iii.	Many-To-One
		iv. 	Many-To-Many
