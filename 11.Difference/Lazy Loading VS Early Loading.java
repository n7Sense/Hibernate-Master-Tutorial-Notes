	Lazy Loading VS Early Loading
=====================================

1. Lazy Loading
	
	a. by default Hibernate support Lazy Loading.
	b.  meanse in this, 1-st it is going to be loading to the Parent, after loading Parent related
	to child are going to loaded, then 2nd-Parent going to loaded related child going to be loaded.
	Relation concept is there by default Hibernate support Lazy Loading.

	Example:	<lazy= "true">
				Object o = session.load(Author.class, new Integer(1));
			    Author au = (Author)o;
			    System.out.println("******************* The Parent Record ********************");
			    System.out.println(au.getAuthorId()+" : "+au.getAuthorName());
			    System.out.println("******************* The Parent Related Child Record *****************");
			    Set<Books> bookSet = au.getBooks();
			    for(Books book: bookSet){
			        System.out.println(book.getBookId()+" : "+book.getBookName());
			    }
	OutPut:		
				******************* The Parent Record ********************
				Hibernate: 
				    select
				        author0_.author_id as author_i1_0_0_,
				        author0_.author_name as author_n2_0_0_ 
				    from
				        Author author0_ 
				    where
				        author0_.author_id=?
				1 : nSense
				******************* The Parent Related Child Record *****************
				Hibernate: 
				    select
				        books0_.author_id as author_i3_1_0_,
				        books0_.book_id as book_id1_1_0_,
				        books0_.book_id as book_id1_1_1_,
				        books0_.book_name as book_nam2_1_1_ 
				    from
				        books books0_ 
				    where
				        books0_.author_id=?
				1 : Feeling About Yogeshwar
				2 : Java Is Thing
				3 : AI Concepts


2. Early Loading

	means All the record are going to loaded at a time
		e.g: if 2-Tables i.e Parent table and Child table is there Parent table having 2-record that record pointing
			to Child record, when we use this method, first of all it is going to load to the all the Parents along with
			the Parents all Child also going to be loaded at a time.


    OutPut: <lazy= "false">
    		******************* The Parent Record ********************
			Hibernate: 
			    select
			        author0_.author_id as author_i1_0_0_,
			        author0_.author_name as author_n2_0_0_ 
			    from
			        Author author0_ 
			    where
			        author0_.author_id=?
			Hibernate: 
			    select
			        books0_.author_id as author_i3_1_0_,
			        books0_.book_id as book_id1_1_0_,
			        books0_.book_id as book_id1_1_1_,
			        books0_.book_name as book_nam2_1_1_ 
			    from
			        books books0_ 
			    where
			        books0_.author_id=?
			1 : nSense
			******************* The Parent Related Child Record *****************
			1 : Feeling About Yogeshwar
			2 : Java Is Thing
			3 : AI Concepts

	you can see first time retrivation it load all the object.