when we call new Configuration().configure().buildSessionFactory();, according to <property name="hbm2ddl.auto">update</property>
		it will autometically perform DDL operation.

		CREATE
		UPDATE 
		VALIDATE
		Create-Drop

		1. CREATE 
			drop table if exist and the it will re create the table.

		2.VALIDATE: 
			mapping 	columns must be there in tables columns
			mapping columns count shuld be <=table count.
			if column-count >= table column then it will throws RE: ColumnNotFoundException

		3. create-drop: 
				(drop-create-drop) drop the existing table and then create according to xml file and after that when we call
				session.close() it will drop the table.

				When we shuld go for this aproach..?
					when our application is in testing, once we deploy our application it will create all the tables and when we call
					session.class(); will drop the tables.
