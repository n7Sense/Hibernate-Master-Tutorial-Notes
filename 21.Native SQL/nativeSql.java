For normal scenarios, Hibernate SQL query is not the recommended approach because we loose benefits related to hibernate association and hibernate
first level cache.

Hibernate provide option to execute native SQL queries through the use of SQLQuery object. Hibernate SQL Query is very handy when we have to execute
database vendor specific queries that are not supported by Hibernate API. For example query hints or the CONNECT keyword in Oracle Database.

I will use MySQL database and same tables and data setup as used in HQL example, so you should check out that first to understand the 
tables and corresponding model classes mapping.

--------------------------
In Hibernate, HQL or criteria queries should be able to let you to execute almost any SQL query you want. However, many developers are complaint about the Hibernate’s generated SQL statement is slow and more prefer to generated their own SQL (native SQL) statement.

Native SQL queries example
Hibernate provide a createSQLQuery method to let you call your native SQL statement directly.

1. In this example, you tell Hibernate to return you a Stock.class, all the select data (*) will match to your Stock.class properties automatically.

Query query = session.createSQLQuery(
"select * from stock s where s.stock_code = :stockCode")
.addEntity(Stock.class)
.setParameter("stockCode", "7277");
List result = query.list();

2. In this example, Hibernate will return you an Object array.

Query query = session.createSQLQuery(
"select s.stock_code from stock s where s.stock_code = :stockCode")
.setParameter("stockCode", "7277");
List result = query.list();

Alternative, you also can use the named query to call your native SQL statement. See Hibernate named query examples 

Hibernate’s generated SQL statement is slow !?
===============================================
I do not agreed on the statement “Hibernate’s generated SQL statement is slow”. Often times, i found out this is because of the developers do not 
understand the table relationship well, and did some wrong table mappings or misuse the fetch strategies. It will cause Hibernate generated some
unnecessary SQL statements or join some unnecessary tables… And developers like to take this excuse and create their own SQL statement to quick
fix the bug, and didn’t aware of the core problem will causing more bugs awaiting.

	Conclusion
===================
I admit sometime the native SQL statement is really more convenient and easy than HQL, but, do think carefully why you need a native SQL statement?
Is this really Hibernate cant do it? If yes, then go ahead ~

P.S In Oracle database, i more prefer to use native SQL statement in many critical performance queries, because i need to put the “hint” to improve
the Oracle query performance.


	From My Openion Mr. nSense
===================================
Hibernate Framework is going to searching the, MetaData of DatabaseTable Column name.
internally use the ResultSetMetaData and DatabaseMetaData to know the META information about the Database Table and column name.
which also cause the performance problem.
***To increase the performance we have to desine the Scalar Queries.


Example.1
	NativeQuery nativeQuery = session.getNamedNativeQuery("findAllNamedData");
        List<Object> list  = nativeQuery.list();
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            Object[] row = (Object[])itr.next();
            System.out.println(row[0]+" : "+row[1]+" : "+row[2]);
        }

 Example.2 By Entity queries
 	    //Also to convert to pojo class object
        //this type of Queries is called Entity Queries
        NativeQuery nativeQuery = session.getNamedNativeQuery("findAllNamedData");
        List<NamedQueryModel> list  = nativeQuery.list();
        for(NamedQueryModel nql: list){
            System.out.println(nql.toString());
        }

Example.3 By Scalar Queries
        //this type of Queries is called Scalar Queries to improve the performence
        NativeQuery nativeQuery3 = session.createNativeQuery("SELECT named_id, name, rashi FROM named WHERE named_id = :nid").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        /*
        NativeQuery nativeQuery4 = session.createNativeQuery("SELECT named_id, name, rashi FROM named").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        NativeQuery nativeQuery5 = session.getNamedNativeQuery("findAllNamedData").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        NativeQuery nativeQuery6 = session.getNamedNativeQuery("findById").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        */

        nativeQuery3.setParameter("nid", new Integer(3));

        List<Object> list3  = nativeQuery3.list();
        System.out.println("************ Named Record By Scalar Query *******************");
        for(Object nql: list3){
            Object[] row3 = (Object[])nql;
            System.out.println(row3[0]+" : "+row3[1]+" : "+row3[2]);
        }
		