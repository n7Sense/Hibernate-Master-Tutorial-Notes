	Oracle 12 Multitanent Architecture
==============================================


CDB
======

CDB$ROOT
	 Every CDB Database has one and only one Root Container. 
	 The Root Container is named CDB$Root and has a container ID of one inside our CDB Database. 
	 It is the core of the CDB and contains all of the Oracle supplied metadata during installation.

	 Metadata like packages, core dictionary objects, as well as common users. 
	 An example for Oracle supplied metadata is the source code for PL/Sequel packages which pre-created inside the Oracle database.
	 The Root Container also stores all common users for that CDB.
	 A common user is a database user known in every container inside the CDB.

	 In addition, the Root Container is the only container inside the CDB Database that has Redo Logs, Archieved Logs, Control Files,
	 Flashback Logs, and the UNDO table space. 
	 These are physical database objects which are shared between all of the different containers inside the CDB Database but exclusively
	 belong to the Root Container.

	 Other containers inside the CDB, which we'll learn about later on in this chapter, such as BDB's, don not have their own Redo Logs,
	 UNDO table space, on or a Control File. But instead use the ones which belong to the Root Container.


PDB
	Other containers inside the CDB, which we'll learn about later on in this chapter, such as BDB's, don not have their own Redo Logs,
	UNDO table space, on or a Control File. But instead use the ones which belong to the Root Container.

	These PDBs are where the magic happens when it comes to the consolidation capabilities of Oracle's 12c's multitenant architecture.
	PDBs allow applications to connect to a dedicated and separate logical database inside your Oracle 12c multitenant CDB database.
	You can create new PDBs inside your CDB easily and on the fly.
	PDBs allows for logical separation of different applications inside our big CDB database.

	Each PDB contains the tables and objects which are specific to that application. For example, a CRM application might connect to the CRM PDB while an ERP application might connect to the ERP PDB. Both these PDBs reside inside the same super CDB database but they contain different tables, different users, different objects and different permissions, thus creating logical separation inside the same physical Oracle database.

	Each PDB contains the tables and objects which are specific to that application. For example, a CRM application might connect to the CRM PDB while an ERP application might connect to the ERP PDB. Both these PDBs reside inside the same super CDB database but they contain different tables, different users, different objects and different permissions, thus creating logical separation inside the same physical Oracle database.

	From an Oracle Instance perspective, each PDB will have its own Server Processes associated with it because a server process usually
	represents a user session. When it comes to the Oracle SGA or System Global Area itself, components inside the SGA are now PDB aware.
	Take for example the Buffer Cache. Multiple PDBs will share the same buffer cache but the buffer cache will now keep track of each
	block and which PDB it belongs to.

	Same is true for cursors in the shared pool. The bottom line is that with the CDB architecture of Oracle 12c, PDBs do not have their
	own dedicated Oracle Instances, the PDBs are all residents of one CDB and share a single Oracle Instance. This reduces overhead
	considerably, allowing many PDBs to share server and system resources, yet provide logical separation for connecting applications.

	Note that each PDB has its own SYSTEM, SYSAUX and TEMP table spaces in addition to any application-centric table spaces.
	So PDB_1 which serves our CRM application, will have table spaces that contain CRM tables and CRM data, while PDB_2 which serves our
	ERP application, will have table spaces that contain ERP data and ERP table. So another way of looking at PDB specific table spaces
	is that the CRM PDB will have one or more table spaces to store customer data, while the ERP PDB will have one or more table spaces
	to store sales or inventory data.

	These application specific table spaces belong to one and only one PDB serving that application. And once more, its important to
	note that PDBs do not have their own redo logs, control files or undo table spaces as these belong only to the root container,
	however all PDBs in our CDB will use them during normal database operations.

PDB$SEED
=========
	
		- Inside every CDB database, there is always one special PDB called the Seed PDB or PDB$SEED internally.
		This PDB has a container ID of 2. This is a special PDB and is only used for cloning new PDBs or new databases inside our CDB.
		It does not serve any application facing function. You can create new PDBs easily by cloning the Seed PDB database.

		- Inside every CDB database, there is always one special PDB called the Seed PDB or PDB$SEED internally.
		This PDB has a container ID of 2. This is a special PDB and is only used for cloning new PDBs or new databases inside our CDB.
		It does not serve any application facing function. You can create new PDBs easily by cloning the Seed PDB database.

		 The Seed PDB contains its own SYSTEM, SYSAUX, and TEMP tablespaces. Any PDBs created will also contain their own SYSTEM, SYSAUX,
		 and TEMP tablespaces; plus, any tablespaces required for connecting applications tablespaces which hold application data.