	Criteria
================

	Used only for SELECT operation 

	Criteria give more performence as compared to the HQL

	we can PUT more condition on SELECT Data

	Hibernaet 1.x 2.x in this we can SELECT complete object (complete ROW), whereas 4.x we can SELECT the PARTIAL (particular Column or SELECTED Column) record also
	PARTIAL means we can retrive multiple column from table
	Example:
	
	1. For Single Column:
			Projection projection = Projections.property("firstName");
        	criteria.setProjection(projection);
        	 List<String> emp = criteria.list();

    2. For Multiple Column.
    		ProjectionList projectionList  = Projections.projectionList();
	        projectionList.add(Projections.property("employeeId"));
	        projectionList.add(Projections.property("firstName"));
	        projectionList.add(Projections.property("lastName"));
	        projectionList.add(Projections.property("salary"));
	        criteria.setProjection(projection);
	         List<Object> emp = criteria.list();

	 NOTE: When we use PROJECTIONS for Single or Multiple column we must have to use Obect class, Object of Object class can handle any type of data.
	 so if there is Single record then directly

	It is also one type Object Oriented Sql.

	