Lifecycle Of Hibernate POJO Object
=============================

			

									Transient State
				--------------------------------------------------------
							|							   /\			
							|								|
							|								|
			save()			|								|
			persist()		|								|
			saveOrUpdate()	|								|	delete();
			load()			|								|
			get()			|								|
							|								|
							|								|
							|								|
							|								|
						    \/		Persistent State
				---------------------------------------------------------
							|							   /\
							|								|
							|								|
							|								|
							|								|
							|								|	update()
			session.close()	|								|	merge()
							|								|
							|								|
							|								|
							|								|
							|								|
							\/			Detached State
				-----------------------------------------------------------

