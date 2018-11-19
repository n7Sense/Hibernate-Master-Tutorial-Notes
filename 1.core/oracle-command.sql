

	SQL> sqlplus sys/nsense@//localhost:1521/orcl as sysdba
	
	SQL> show con_name;

	SQL> show con_id;

	SQL> select con_id, name from v$pdbs;

	SQL> ALTER PLUGGABLE DATABASE NS_PDB_1 OPEN;

	SQL> ALTER SESSION SET CONTAINER = ns_pdb_1;

	   CREATING PDB
	================

	CREATE PLUGGABLE DATABASE ns_pdb_1
	ADMIN USER ns_user_1 IDENTIFIED BY nsense
	ROLES = (dba)
	DEFAULT TABLESPACE ns_tbs_1
	DATAFILE '/oradata/orcl/pdb1/nspdb01.dbf' SIZE 50M AUTOEXTEND ON
	FILE_NAME_CONVERT=('/oradata/orcl/pdbseed/','/oradata/orcl/ns_pdb_1/','/oradata/orcl2/pdbseed/','/oradata/orcl/ns_pdb_1/');

Connecting to (DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))
Services Summary...
Service "ad134cbdcbb44ef5ae9a7b878bfa07dd" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "DEDICATED" established:18 refused:0 state:ready
         LOCAL SERVER
Service "c32119b784a5440ab4dda8314c17a338" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "DEDICATED" established:18 refused:0 state:ready
         LOCAL SERVER
Service "ns_pdb_1" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "DEDICATED" established:18 refused:0 state:ready
         LOCAL SERVER
Service "orcl" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "DEDICATED" established:18 refused:0 state:ready
         LOCAL SERVER
Service "orclXDB" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "D000" established:1 refused:0 current:0 max:1022 state:ready
         DISPATCHER <machine: DESKTOP-054SSVA, pid: 4356>
         (ADDRESS=(PROTOCOL=tcp)(HOST=DESKTOP-054SSVA)(PORT=63551))
Service "orclpdb" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
    Handler(s):
      "DEDICATED" established:18 refused:0 state:ready
         LOCAL SERVER
The command completed successfully