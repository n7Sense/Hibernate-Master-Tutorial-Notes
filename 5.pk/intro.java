	
	Primary Key Generator
============================

1. Assigned
2. Increment
3. Identity
4. Sequence
5. hilo
6. native
7. foregin
8. Custom Generator

NOTE: do not write this all in CAPITAL or CAMEL case letter write in small letter always

1. Assigned:
		User must need to submit the ID for.
		but in real-time it is not god to get ID from User.
		if u read input from user there is chance to enter same ID by multiple user.

the remining other technique user no need to pass ID.

2. Increment:
		Increment help us under Application layer.
		In this Application first it will SELECT MAX (ID) FROM Table then ID will get increment by 1 default.
	
		Hibernate: select max(employee_id) from employees
		Hibernate: insert into employees (first_name, last_name, email, phone_number, hire_date, job_Id, salary, commission, manager_id, department_id, employee_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

3. Identity:
		DB layer is responsible to provide Id.
		Hibernate will read the input but of all column excluding ID, ID will be provided by DB itself 
		Identity is suport by MySQl, DB2 Database. Oracle not support this features.
		internally it defines the constraints i.e "auto_increment"
			
		ORACLE 12c+ NOT support this features.

	create table employees (
	       	employee_id integer not null auto_increment,   <----------------
	        first_name varchar(255),
	        last_name varchar(255),
	        email varchar(255),
	        phone_number varchar(255),
	        hire_date date,
	        job_Id varchar(255),
	        salary double precision,
	        commission float,
	        manager_id integer,
	        department_id integer,
	        primary key (employee_id)
    ) engine=InnoDB

4. Sequence:
		In this DB and Application both layer are responsible to provide Id.
		Internally it will create one hibernate-sequence table into database along with your table.
		by default Sequence start from 1 and increment by 1 only.
		The Application layer 1st, Select the next-value from hibernate-sequence table, at that time DB layer need to take care Sequence increent.
		By: MySQL
			Hibernate: select next_val as id_val from hibernate_sequence for update
			Hibernate: update hibernate_sequence set next_val= ? where next_val=?
			Hibernate: insert into employees (first_name, last_name, email, phone_number, hire_date, job_Id, salary, 
			commission, manager_id, department_id, employee_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		mysql> desc hibernate_sequence;
		+----------+------------+------+-----+---------+-------+
		| Field    | Type       | Null | Key | Default | Extra |
		+----------+------------+------+-----+---------+-------+
		| next_val | bigint(20) | YES  |     | NULL    |       |
		+----------+------------+------+-----+---------+-------+

			NOTE: Sequence is not supportd by MySQL DB, internally it cretae hibernate_sequence table.
		By: ORACLE 12c PDB
			

5. hilo:
		DB layer as well as Application layer.
		hibernate_hilo table will created. along with our table.
		the incrementationorder is increment by 32767 1st time it follows incremenr by one but after that it will increment by 32767
		Deploy 1st time: Next Hi Value = 0
		Insertion Order: 1, 2, 3 ....5
	
		Deploy 2nd time: Next Hi Value = 1
		Insertion Order: 32767, 32768 ...

		Deploy 3rd time: Next Hi Value = 2
		Insertion Order: 65534 .....

		nither support by MySQL and nor Oracle 12c PDB.

6. Native
		it is not have its own special technique internally it uses (increment, Identity, Sequence)
	
	By: Oracle 12c PDB: by default it use Sequence,
		Hibernate: select hibernate_sequence.nextval from dual
		Hibernate: insert into employees (first_name, last_name, email, phone_number, hire_date, job_Id, salary, commission, manager_id, department_id, employee_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
	
	By MySQL DB : By default it uses Identity internally.
		insert into employees (first_name, last_name, email, phone_number, hire_date, job_Id, salary, commission, manager_id, department_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)





		


