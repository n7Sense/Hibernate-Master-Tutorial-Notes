	Methods Of Session
==========================

1. 	public abstract Serializable save(Object paramObject)
	public abstract Serializable save(String paramString, Object paramObject)
		 Persist the given transient instance, first assigning a generated identifier. 
		 (Or using the current value of the identifier property if the assigned generator is used.)
		 This operation cascades to associated instances if the association is mapped with cascade="save-update"


2.	public void saveOrUpdate(Object object)
	public void saveOrUpdate(String entityName, Object object)

		Either save(Object) or update(Object) the given instance, depending upon resolution of the unsaved-value
		checks (see the manual for discussion of unsaved-value checking).
		This operation cascades to associated instances if the association is mapped with cascade="save-update". 
		

3.  public abstract void update(Object paramObject)
  	public abstract void update(String paramString, Object paramObject)

		Update the persistent instance with the identifier of the given detached instance. If there is a persistent
		instance with the same identifier, an exception is thrown. This operation cascades to associated instances
		if the association is mapped with cascade="save-update".
		
		NOTE: sometimes update exception becomes fails in that case if you want to execute at any cost you can goto
				through merge() methods,



4.  public abstract Object merge(Object paramObject);
  	public abstract Object merge(String paramString, Object paramObject)

  		Copy the state of the given object onto the persistent object with the same identifier. If there is no
  		persistent instance currently associated with the session, it will be loaded. Return the persistent instance.
  		If the given instance is unsaved, save a copy of and return it as a newly persistent instance.
  		The given instance does not become associated with the session. This operation cascades to associated
  		instances if the association is mapped with cascade="merge".
		The semantics of this method are defined by JSR-220.
		
		NOTE: if there is a chance to get Exception to update object, we can go through merge() methods.


5.  public abstract void persist(Object paramObject)
 	public abstract void persist(String paramString, Object paramObject)

 		Make a transient instance persistent. This operation cascades to associated instances if the association is
 		mapped with cascade="persist".
		The semantics of this method are defined by JSR-220.
	

6.	public abstract void delete(Object paramObject);
  	public abstract void delete(String paramString, Object paramObject);

  		Remove a persistent instance from the datastore. The object argument may be an instance associated with the
  		receiving Session or a transient instance with an identifier associated with existing persistent state.
  		This operation cascades to associated instances if the association is mapped with cascade="delete".


7.  public abstract void lock(Object paramObject, LockMode paramLockMode);
  	public abstract void lock(String paramString, Object paramObject, LockMode paramLockMode);	

  		Obtain the specified lock level upon the given object. This may be used to perform a version check
  		(LockMode.READ), to upgrade to a pessimistic lock (LockMode.PESSIMISTIC_WRITE), or to simply reassociate a
  		transient instance with a session (LockMode.NONE). This operation cascades to associated instances if the association
  		is mapped with cascade="lock".
		Parameters:
		object - a persistent or transient instance
		lockMode - the lock level

8.	public abstract LockRequest buildLockRequest(LockOptions paramLockOptions);
		Build a LockRequest that specifies the LockMode, pessimistic lock timeout and lock scope. timeout and scope is ignored for
		optimistic locking. After building the LockRequest, call LockRequest.lock to perform the requested locking.
		Use: session.buildLockRequest(). setLockMode(LockMode.PESSIMISTIC_WRITE).setTimeOut(1000 * 60).lock(entity);

 
9.	public abstract void refresh(Object paramObject);
		Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement long-running
		sessions that span many business tasks. This method is, however, useful in certain special circumstances. For example
			where a database trigger alters the object state upon insert or update
			after executing direct SQL (eg. a mass update) in the same session
			after inserting a Blob or Clob

10.	public abstract void refresh(String paramString, Object paramObject)
11.	public abstract void refresh(Object paramObject, LockMode paramLockMode);
12.	public abstract void refresh(Object paramObject, LockOptions paramLockOptions)
13.	public abstract void refresh(String paramString, Object paramObject, LockOptions paramLockOptions);
	 
14.	public abstract LockMode getCurrentLockMode(Object paramObject);
		Determine the current lock mode of the given object.

15. public abstract void clear();
		Completely clear the session. Evict all loaded instances and cancel all pending saves, updates and deletions.
		Do not close open iterators or instances of ScrollableResults.

16.
