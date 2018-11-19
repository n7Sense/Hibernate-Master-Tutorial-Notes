	Inheritence
==================

	The Inheritence is used for reusability purpose.
	Common fields in a single tables;


	2- Table-Per-Sub Class startegy

		in this strategy the common field data will store in Parent table and other fields are stored into it Child table
		like
		Employee{
			empId;
			empName;
			salary;
		}

		ProductManager extends Employee{
			managerType;
			managerArea;
		}

		InventoryManager{
			inventoryType;
			state;
		}

		 in this startegy 3-tables created but in Child table 1-field is common i.e foregin key(empId) relation added to all
		 its Child table AS PRIMARY KEY.
		 NOTE: Child table does not have its own prodId as primary key, because one table can not have more than one primary key.