package org.hibernate.engine.spi;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Metamodel;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Interceptor;
import org.hibernate.LobHelper;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.ScrollMode;
import org.hibernate.Session;
import org.hibernate.Session.LockRequest;
import org.hibernate.SessionEventListener;
import org.hibernate.SharedSessionBuilder;
import org.hibernate.SimpleNaturalIdLoadAccess;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.UnknownProfileException;
import org.hibernate.cache.spi.CacheTransactionSynchronization;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.jdbc.LobCreationContext.Callback;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.spi.HibernateEntityManagerImplementor.QueryOptions;
import org.hibernate.loader.custom.CustomQuery;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.spi.NativeQueryImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class SessionDelegatorBaseImpl
  implements SessionImplementor
{
  protected final SessionImplementor delegate;
  
  @Deprecated
  public SessionDelegatorBaseImpl(SessionImplementor delegate, Session session)
  {
    if (delegate == null) {
      throw new IllegalArgumentException("Unable to create a SessionDelegatorBaseImpl from a null delegate object");
    }
    if (session == null) {
      throw new IllegalArgumentException("Unable to create a SessionDelegatorBaseImpl from a null Session");
    }
    if (delegate != session) {
      throw new IllegalArgumentException("Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references");
    }
    this.delegate = delegate;
  }
  
  public SessionDelegatorBaseImpl(SessionImplementor delegate)
  {
    this(delegate, delegate);
  }
  
  protected SessionImplementor delegate()
  {
    return this.delegate;
  }
  
  public <T> T execute(LobCreationContext.Callback<T> callback)
  {
    return (T)this.delegate.execute(callback);
  }
  
  public String getTenantIdentifier()
  {
    return this.delegate.getTenantIdentifier();
  }
  
  public UUID getSessionIdentifier()
  {
    return this.delegate.getSessionIdentifier();
  }
  
  public JdbcConnectionAccess getJdbcConnectionAccess()
  {
    return this.delegate.getJdbcConnectionAccess();
  }
  
  public EntityKey generateEntityKey(Serializable id, EntityPersister persister)
  {
    return this.delegate.generateEntityKey(id, persister);
  }
  
  public Interceptor getInterceptor()
  {
    return this.delegate.getInterceptor();
  }
  
  public void setAutoClear(boolean enabled)
  {
    this.delegate.setAutoClear(enabled);
  }
  
  public boolean isTransactionInProgress()
  {
    return this.delegate.isTransactionInProgress();
  }
  
  public LockOptions getLockRequest(LockModeType lockModeType, Map<String, Object> properties)
  {
    return this.delegate.getLockRequest(lockModeType, properties);
  }
  
  public LockOptions buildLockOptions(LockModeType lockModeType, Map<String, Object> properties)
  {
    return this.delegate.buildLockOptions(lockModeType, properties);
  }
  
  public <T> QueryImplementor<T> createQuery(String jpaqlString, Class<T> resultClass, Selection selection, HibernateEntityManagerImplementor.QueryOptions queryOptions)
  {
    return this.delegate.createQuery(jpaqlString, resultClass, selection, queryOptions);
  }
  
  public void initializeCollection(PersistentCollection collection, boolean writing)
    throws HibernateException
  {
    this.delegate.initializeCollection(collection, writing);
  }
  
  public Object internalLoad(String entityName, Serializable id, boolean eager, boolean nullable)
    throws HibernateException
  {
    return this.delegate.internalLoad(entityName, id, eager, nullable);
  }
  
  public Object immediateLoad(String entityName, Serializable id)
    throws HibernateException
  {
    return this.delegate.immediateLoad(entityName, id);
  }
  
  public long getTimestamp()
  {
    return this.delegate.getTimestamp();
  }
  
  public SessionFactoryImplementor getFactory()
  {
    return this.delegate.getFactory();
  }
  
  public List list(String query, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.list(query, queryParameters);
  }
  
  public Iterator iterate(String query, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.iterate(query, queryParameters);
  }
  
  public ScrollableResultsImplementor scroll(String query, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.scroll(query, queryParameters);
  }
  
  public ScrollableResultsImplementor scroll(Criteria criteria, ScrollMode scrollMode)
  {
    return this.delegate.scroll(criteria, scrollMode);
  }
  
  public List list(Criteria criteria)
  {
    return this.delegate.list(criteria);
  }
  
  public List listFilter(Object collection, String filter, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.listFilter(collection, filter, queryParameters);
  }
  
  public Iterator iterateFilter(Object collection, String filter, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.iterateFilter(collection, filter, queryParameters);
  }
  
  public EntityPersister getEntityPersister(String entityName, Object object)
    throws HibernateException
  {
    return this.delegate.getEntityPersister(entityName, object);
  }
  
  public Object getEntityUsingInterceptor(EntityKey key)
    throws HibernateException
  {
    return this.delegate.getEntityUsingInterceptor(key);
  }
  
  public Serializable getContextEntityIdentifier(Object object)
  {
    return this.delegate.getContextEntityIdentifier(object);
  }
  
  public String bestGuessEntityName(Object object)
  {
    return this.delegate.bestGuessEntityName(object);
  }
  
  public String guessEntityName(Object entity)
    throws HibernateException
  {
    return this.delegate.guessEntityName(entity);
  }
  
  public Object instantiate(String entityName, Serializable id)
    throws HibernateException
  {
    return this.delegate.instantiate(entityName, id);
  }
  
  public List listCustomQuery(CustomQuery customQuery, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.listCustomQuery(customQuery, queryParameters);
  }
  
  public ScrollableResultsImplementor scrollCustomQuery(CustomQuery customQuery, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.scrollCustomQuery(customQuery, queryParameters);
  }
  
  public List list(NativeSQLQuerySpecification spec, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.list(spec, queryParameters);
  }
  
  public ScrollableResultsImplementor scroll(NativeSQLQuerySpecification spec, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.scroll(spec, queryParameters);
  }
  
  public int getDontFlushFromFind()
  {
    return this.delegate.getDontFlushFromFind();
  }
  
  public PersistenceContext getPersistenceContext()
  {
    return this.delegate.getPersistenceContext();
  }
  
  public int executeUpdate(String query, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.executeUpdate(query, queryParameters);
  }
  
  public int executeNativeUpdate(NativeSQLQuerySpecification specification, QueryParameters queryParameters)
    throws HibernateException
  {
    return this.delegate.executeNativeUpdate(specification, queryParameters);
  }
  
  public CacheMode getCacheMode()
  {
    return this.delegate.getCacheMode();
  }
  
  public void setCacheMode(CacheMode cm)
  {
    this.delegate.setCacheMode(cm);
  }
  
  public boolean isOpen()
  {
    return this.delegate.isOpen();
  }
  
  public boolean isConnected()
  {
    return this.delegate.isConnected();
  }
  
  public void checkOpen(boolean markForRollbackIfClosed)
  {
    this.delegate.checkOpen(markForRollbackIfClosed);
  }
  
  public void markForRollbackOnly()
  {
    this.delegate.markForRollbackOnly();
  }
  
  public long getTransactionStartTimestamp()
  {
    return this.delegate.getTransactionStartTimestamp();
  }
  
  public FlushModeType getFlushMode()
  {
    return this.delegate.getFlushMode();
  }
  
  public void setFlushMode(FlushModeType flushModeType)
  {
    this.delegate.setFlushMode(flushModeType);
  }
  
  public void setHibernateFlushMode(FlushMode flushMode)
  {
    this.delegate.setHibernateFlushMode(flushMode);
  }
  
  public FlushMode getHibernateFlushMode()
  {
    return this.delegate.getHibernateFlushMode();
  }
  
  public void setFlushMode(FlushMode fm)
  {
    this.delegate.setHibernateFlushMode(fm);
  }
  
  public void lock(Object entity, LockModeType lockMode)
  {
    this.delegate.lock(entity, lockMode);
  }
  
  public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties)
  {
    this.delegate.lock(entity, lockMode, properties);
  }
  
  public Connection connection()
  {
    return this.delegate.connection();
  }
  
  public void flush()
  {
    this.delegate.flush();
  }
  
  public boolean isEventSource()
  {
    return this.delegate.isEventSource();
  }
  
  public void afterScrollOperation()
  {
    this.delegate.afterScrollOperation();
  }
  
  public TransactionCoordinator getTransactionCoordinator()
  {
    return this.delegate.getTransactionCoordinator();
  }
  
  public JdbcCoordinator getJdbcCoordinator()
  {
    return this.delegate.getJdbcCoordinator();
  }
  
  public JdbcServices getJdbcServices()
  {
    return this.delegate.getJdbcServices();
  }
  
  public JdbcSessionContext getJdbcSessionContext()
  {
    return this.delegate.getJdbcSessionContext();
  }
  
  public boolean isClosed()
  {
    return this.delegate.isClosed();
  }
  
  public void checkOpen()
  {
    this.delegate.checkOpen();
  }
  
  public boolean isOpenOrWaitingForAutoClose()
  {
    return this.delegate.isOpenOrWaitingForAutoClose();
  }
  
  public boolean shouldAutoClose()
  {
    return this.delegate.shouldAutoClose();
  }
  
  public boolean isAutoCloseSessionEnabled()
  {
    return this.delegate.isAutoCloseSessionEnabled();
  }
  
  public boolean isQueryParametersValidationEnabled()
  {
    return this.delegate.isQueryParametersValidationEnabled();
  }
  
  public boolean shouldAutoJoinTransaction()
  {
    return this.delegate.shouldAutoJoinTransaction();
  }
  
  public LoadQueryInfluencers getLoadQueryInfluencers()
  {
    return this.delegate.getLoadQueryInfluencers();
  }
  
  public ExceptionConverter getExceptionConverter()
  {
    return this.delegate.getExceptionConverter();
  }
  
  public SessionEventListenerManager getEventListenerManager()
  {
    return this.delegate.getEventListenerManager();
  }
  
  public Transaction accessTransaction()
  {
    return this.delegate.accessTransaction();
  }
  
  public Transaction beginTransaction()
  {
    return this.delegate.beginTransaction();
  }
  
  public Transaction getTransaction()
  {
    return this.delegate.getTransaction();
  }
  
  public void startTransactionBoundary()
  {
    this.delegate.startTransactionBoundary();
  }
  
  public CacheTransactionSynchronization getCacheTransactionSynchronization()
  {
    return this.delegate.getCacheTransactionSynchronization();
  }
  
  public void afterTransactionBegin()
  {
    this.delegate.afterTransactionBegin();
  }
  
  public void beforeTransactionCompletion()
  {
    this.delegate.beforeTransactionCompletion();
  }
  
  public void afterTransactionCompletion(boolean successful, boolean delayed)
  {
    this.delegate.afterTransactionCompletion(successful, delayed);
  }
  
  public void flushBeforeTransactionCompletion()
  {
    this.delegate.flushBeforeTransactionCompletion();
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return this.delegate.getFactory();
  }
  
  public CriteriaBuilder getCriteriaBuilder()
  {
    return this.delegate.getCriteriaBuilder();
  }
  
  public Metamodel getMetamodel()
  {
    return this.delegate.getMetamodel();
  }
  
  public <T> EntityGraph<T> createEntityGraph(Class<T> rootType)
  {
    return this.delegate.createEntityGraph(rootType);
  }
  
  public EntityGraph<?> createEntityGraph(String graphName)
  {
    return this.delegate.createEntityGraph(graphName);
  }
  
  public EntityGraph<?> getEntityGraph(String graphName)
  {
    return this.delegate.getEntityGraph(graphName);
  }
  
  public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass)
  {
    return this.delegate.getEntityGraphs(entityClass);
  }
  
  public QueryImplementor getNamedQuery(String name)
  {
    return this.delegate.getNamedQuery(name);
  }
  
  public NativeQueryImplementor getNamedSQLQuery(String name)
  {
    return this.delegate.getNamedSQLQuery(name);
  }
  
  public NativeQueryImplementor getNamedNativeQuery(String name)
  {
    return this.delegate.getNamedNativeQuery(name);
  }
  
  public QueryImplementor createQuery(String queryString)
  {
    return this.delegate.createQuery(queryString);
  }
  
  public <T> QueryImplementor<T> createQuery(String queryString, Class<T> resultType)
  {
    return this.delegate.createQuery(queryString, resultType);
  }
  
  public <T> QueryImplementor<T> createQuery(CriteriaQuery<T> criteriaQuery)
  {
    return this.delegate.createQuery(criteriaQuery);
  }
  
  public QueryImplementor createQuery(CriteriaUpdate updateQuery)
  {
    return this.delegate.createQuery(updateQuery);
  }
  
  public QueryImplementor createQuery(CriteriaDelete deleteQuery)
  {
    return this.delegate.createQuery(deleteQuery);
  }
  
  public QueryImplementor createNamedQuery(String name)
  {
    return this.delegate.createNamedQuery(name);
  }
  
  public <T> QueryImplementor<T> createNamedQuery(String name, Class<T> resultClass)
  {
    return this.delegate.createNamedQuery(name, resultClass);
  }
  
  public NativeQueryImplementor createNativeQuery(String sqlString)
  {
    return this.delegate.createNativeQuery(sqlString);
  }
  
  public NativeQueryImplementor createNativeQuery(String sqlString, Class resultClass)
  {
    return this.delegate.createNativeQuery(sqlString, resultClass);
  }
  
  public NativeQueryImplementor createNativeQuery(String sqlString, String resultSetMapping)
  {
    return this.delegate.createNativeQuery(sqlString, resultSetMapping);
  }
  
  public StoredProcedureQuery createNamedStoredProcedureQuery(String name)
  {
    return this.delegate.createNamedStoredProcedureQuery(name);
  }
  
  public StoredProcedureQuery createStoredProcedureQuery(String procedureName)
  {
    return this.delegate.createNamedStoredProcedureQuery(procedureName);
  }
  
  public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses)
  {
    return this.delegate.createStoredProcedureQuery(procedureName, resultClasses);
  }
  
  public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings)
  {
    return this.delegate.createStoredProcedureQuery(procedureName, resultSetMappings);
  }
  
  public void joinTransaction()
  {
    this.delegate.joinTransaction();
  }
  
  public boolean isJoinedToTransaction()
  {
    return this.delegate.isJoinedToTransaction();
  }
  
  public <T> T unwrap(Class<T> cls)
  {
    return (T)this.delegate.unwrap(cls);
  }
  
  public Object getDelegate()
  {
    return this;
  }
  
  public NativeQueryImplementor createSQLQuery(String queryString)
  {
    return this.delegate.createSQLQuery(queryString);
  }
  
  public ProcedureCall getNamedProcedureCall(String name)
  {
    return this.delegate.getNamedProcedureCall(name);
  }
  
  public ProcedureCall createStoredProcedureCall(String procedureName)
  {
    return this.delegate.createStoredProcedureCall(procedureName);
  }
  
  public ProcedureCall createStoredProcedureCall(String procedureName, Class... resultClasses)
  {
    return this.delegate.createStoredProcedureCall(procedureName, resultClasses);
  }
  
  public ProcedureCall createStoredProcedureCall(String procedureName, String... resultSetMappings)
  {
    return this.delegate.createStoredProcedureCall(procedureName, resultSetMappings);
  }
  
  public Criteria createCriteria(Class persistentClass)
  {
    return this.delegate.createCriteria(persistentClass);
  }
  
  public Criteria createCriteria(Class persistentClass, String alias)
  {
    return this.delegate.createCriteria(persistentClass, alias);
  }
  
  public Criteria createCriteria(String entityName)
  {
    return this.delegate.createCriteria(entityName);
  }
  
  public Criteria createCriteria(String entityName, String alias)
  {
    return this.delegate.createCriteria(entityName, alias);
  }
  
  public SharedSessionBuilder sessionWithOptions()
  {
    return this.delegate.sessionWithOptions();
  }
  
  public SessionFactoryImplementor getSessionFactory()
  {
    return this.delegate.getSessionFactory();
  }
  
  public void close()
    throws HibernateException
  {
    this.delegate.close();
  }
  
  public void cancelQuery()
    throws HibernateException
  {
    this.delegate.cancelQuery();
  }
  
  public boolean isDirty()
    throws HibernateException
  {
    return this.delegate.isDirty();
  }
  
  public boolean isDefaultReadOnly()
  {
    return this.delegate.isDefaultReadOnly();
  }
  
  public void setDefaultReadOnly(boolean readOnly)
  {
    this.delegate.setDefaultReadOnly(readOnly);
  }
  
  public Serializable getIdentifier(Object object)
  {
    return this.delegate.getIdentifier(object);
  }
  
  public boolean contains(String entityName, Object object)
  {
    return this.delegate.contains(entityName, object);
  }
  
  public boolean contains(Object object)
  {
    return this.delegate.contains(object);
  }
  
  public LockModeType getLockMode(Object entity)
  {
    return this.delegate.getLockMode(entity);
  }
  
  public void setProperty(String propertyName, Object value)
  {
    this.delegate.setProperty(propertyName, value);
  }
  
  public Map<String, Object> getProperties()
  {
    return this.delegate.getProperties();
  }
  
  public void evict(Object object)
  {
    this.delegate.evict(object);
  }
  
  public <T> T load(Class<T> theClass, Serializable id, LockMode lockMode)
  {
    return (T)this.delegate.load(theClass, id, lockMode);
  }
  
  public <T> T load(Class<T> theClass, Serializable id, LockOptions lockOptions)
  {
    return (T)this.delegate.load(theClass, id, lockOptions);
  }
  
  public Object load(String entityName, Serializable id, LockMode lockMode)
  {
    return this.delegate.load(entityName, id, lockMode);
  }
  
  public Object load(String entityName, Serializable id, LockOptions lockOptions)
  {
    return this.delegate.load(entityName, id, lockOptions);
  }
  
  public <T> T load(Class<T> theClass, Serializable id)
  {
    return (T)this.delegate.load(theClass, id);
  }
  
  public Object load(String entityName, Serializable id)
  {
    return this.delegate.load(entityName, id);
  }
  
  public void load(Object object, Serializable id)
  {
    this.delegate.load(object, id);
  }
  
  public void replicate(Object object, ReplicationMode replicationMode)
  {
    this.delegate.replicate(object, replicationMode);
  }
  
  public void replicate(String entityName, Object object, ReplicationMode replicationMode)
  {
    this.delegate.replicate(entityName, object, replicationMode);
  }
  
  public Serializable save(Object object)
  {
    return this.delegate.save(object);
  }
  
  public Serializable save(String entityName, Object object)
  {
    return this.delegate.save(entityName, object);
  }
  
  public void saveOrUpdate(Object object)
  {
    this.delegate.saveOrUpdate(object);
  }
  
  public void saveOrUpdate(String entityName, Object object)
  {
    this.delegate.saveOrUpdate(entityName, object);
  }
  
  public void update(Object object)
  {
    this.delegate.update(object);
  }
  
  public void update(String entityName, Object object)
  {
    this.delegate.update(entityName, object);
  }
  
  public Object merge(Object object)
  {
    return this.delegate.merge(object);
  }
  
  public Object merge(String entityName, Object object)
  {
    return this.delegate.merge(entityName, object);
  }
  
  public void persist(Object object)
  {
    this.delegate.persist(object);
  }
  
  public void remove(Object entity)
  {
    this.delegate.remove(entity);
  }
  
  public <T> T find(Class<T> entityClass, Object primaryKey)
  {
    return (T)this.delegate.find(entityClass, primaryKey);
  }
  
  public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties)
  {
    return (T)this.delegate.find(entityClass, primaryKey, properties);
  }
  
  public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode)
  {
    return (T)this.delegate.find(entityClass, primaryKey, lockMode);
  }
  
  public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties)
  {
    return (T)this.delegate.find(entityClass, primaryKey, lockMode, properties);
  }
  
  public <T> T getReference(Class<T> entityClass, Object primaryKey)
  {
    return (T)this.delegate.getReference(entityClass, primaryKey);
  }
  
  public void persist(String entityName, Object object)
  {
    this.delegate.persist(entityName, object);
  }
  
  public void delete(Object object)
  {
    this.delegate.delete(object);
  }
  
  public void delete(String entityName, Object object)
  {
    this.delegate.delete(entityName, object);
  }
  
  public void lock(Object object, LockMode lockMode)
  {
    this.delegate.lock(object, lockMode);
  }
  
  public void lock(String entityName, Object object, LockMode lockMode)
  {
    this.delegate.lock(entityName, object, lockMode);
  }
  
  public Session.LockRequest buildLockRequest(LockOptions lockOptions)
  {
    return this.delegate.buildLockRequest(lockOptions);
  }
  
  public void refresh(Object object)
  {
    this.delegate.refresh(object);
  }
  
  public void refresh(Object entity, Map<String, Object> properties)
  {
    this.delegate.refresh(entity, properties);
  }
  
  public void refresh(Object entity, LockModeType lockMode)
  {
    this.delegate.refresh(entity, lockMode);
  }
  
  public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties)
  {
    this.delegate.refresh(entity, lockMode, properties);
  }
  
  public void refresh(String entityName, Object object)
  {
    this.delegate.refresh(entityName, object);
  }
  
  public void refresh(Object object, LockMode lockMode)
  {
    this.delegate.refresh(object, lockMode);
  }
  
  public void refresh(Object object, LockOptions lockOptions)
  {
    this.delegate.refresh(object, lockOptions);
  }
  
  public void refresh(String entityName, Object object, LockOptions lockOptions)
  {
    this.delegate.refresh(entityName, object, lockOptions);
  }
  
  public LockMode getCurrentLockMode(Object object)
  {
    return this.delegate.getCurrentLockMode(object);
  }
  
  public Query createFilter(Object collection, String queryString)
  {
    return this.delegate.createFilter(collection, queryString);
  }
  
  public void clear()
  {
    this.delegate.clear();
  }
  
  public void detach(Object entity)
  {
    this.delegate.detach(entity);
  }
  
  public <T> T get(Class<T> theClass, Serializable id)
  {
    return (T)this.delegate.get(theClass, id);
  }
  
  public <T> T get(Class<T> theClass, Serializable id, LockMode lockMode)
  {
    return (T)this.delegate.get(theClass, id, lockMode);
  }
  
  public <T> T get(Class<T> theClass, Serializable id, LockOptions lockOptions)
  {
    return (T)this.delegate.get(theClass, id, lockOptions);
  }
  
  public Object get(String entityName, Serializable id)
  {
    return this.delegate.get(entityName, id);
  }
  
  public Object get(String entityName, Serializable id, LockMode lockMode)
  {
    return this.delegate.get(entityName, id, lockMode);
  }
  
  public Object get(String entityName, Serializable id, LockOptions lockOptions)
  {
    return this.delegate.get(entityName, id, lockOptions);
  }
  
  public String getEntityName(Object object)
  {
    return this.delegate.getEntityName(object);
  }
  
  public IdentifierLoadAccess byId(String entityName)
  {
    return this.delegate.byId(entityName);
  }
  
  public <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> entityClass)
  {
    return this.delegate.byMultipleIds(entityClass);
  }
  
  public MultiIdentifierLoadAccess byMultipleIds(String entityName)
  {
    return this.delegate.byMultipleIds(entityName);
  }
  
  public <T> IdentifierLoadAccess<T> byId(Class<T> entityClass)
  {
    return this.delegate.byId(entityClass);
  }
  
  public NaturalIdLoadAccess byNaturalId(String entityName)
  {
    return this.delegate.byNaturalId(entityName);
  }
  
  public <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> entityClass)
  {
    return this.delegate.byNaturalId(entityClass);
  }
  
  public SimpleNaturalIdLoadAccess bySimpleNaturalId(String entityName)
  {
    return this.delegate.bySimpleNaturalId(entityName);
  }
  
  public <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> entityClass)
  {
    return this.delegate.bySimpleNaturalId(entityClass);
  }
  
  public Filter enableFilter(String filterName)
  {
    return this.delegate.enableFilter(filterName);
  }
  
  public Filter getEnabledFilter(String filterName)
  {
    return this.delegate.getEnabledFilter(filterName);
  }
  
  public void disableFilter(String filterName)
  {
    this.delegate.disableFilter(filterName);
  }
  
  public SessionStatistics getStatistics()
  {
    return this.delegate.getStatistics();
  }
  
  public boolean isReadOnly(Object entityOrProxy)
  {
    return this.delegate.isReadOnly(entityOrProxy);
  }
  
  public void setReadOnly(Object entityOrProxy, boolean readOnly)
  {
    this.delegate.setReadOnly(entityOrProxy, readOnly);
  }
  
  public void doWork(Work work)
    throws HibernateException
  {
    this.delegate.doWork(work);
  }
  
  public <T> T doReturningWork(ReturningWork<T> work)
    throws HibernateException
  {
    return (T)this.delegate.doReturningWork(work);
  }
  
  public Connection disconnect()
  {
    return this.delegate.disconnect();
  }
  
  public void reconnect(Connection connection)
  {
    this.delegate.reconnect(connection);
  }
  
  public boolean isFetchProfileEnabled(String name)
    throws UnknownProfileException
  {
    return this.delegate.isFetchProfileEnabled(name);
  }
  
  public void enableFetchProfile(String name)
    throws UnknownProfileException
  {
    this.delegate.enableFetchProfile(name);
  }
  
  public void disableFetchProfile(String name)
    throws UnknownProfileException
  {
    this.delegate.disableFetchProfile(name);
  }
  
  public TypeHelper getTypeHelper()
  {
    return this.delegate.getTypeHelper();
  }
  
  public LobHelper getLobHelper()
  {
    return this.delegate.getLobHelper();
  }
  
  public void addEventListeners(SessionEventListener... listeners)
  {
    this.delegate.addEventListeners(listeners);
  }
  
  public boolean isFlushBeforeCompletionEnabled()
  {
    return this.delegate.isFlushBeforeCompletionEnabled();
  }
  
  public ActionQueue getActionQueue()
  {
    return this.delegate.getActionQueue();
  }
  
  public Object instantiate(EntityPersister persister, Serializable id)
    throws HibernateException
  {
    return this.delegate.instantiate(persister, id);
  }
  
  public void forceFlush(EntityEntry e)
    throws HibernateException
  {
    this.delegate.forceFlush(e);
  }
  
  public void merge(String entityName, Object object, Map copiedAlready)
    throws HibernateException
  {
    this.delegate.merge(entityName, object, copiedAlready);
  }
  
  public void persist(String entityName, Object object, Map createdAlready)
    throws HibernateException
  {
    this.delegate.persist(entityName, object, createdAlready);
  }
  
  public void persistOnFlush(String entityName, Object object, Map copiedAlready)
  {
    this.delegate.persistOnFlush(entityName, object, copiedAlready);
  }
  
  public void refresh(String entityName, Object object, Map refreshedAlready)
    throws HibernateException
  {
    this.delegate.refresh(entityName, object, refreshedAlready);
  }
  
  public void delete(String entityName, Object child, boolean isCascadeDeleteEnabled, Set transientEntities)
  {
    this.delegate.delete(entityName, child, isCascadeDeleteEnabled, transientEntities);
  }
  
  public void removeOrphanBeforeUpdates(String entityName, Object child)
  {
    this.delegate.removeOrphanBeforeUpdates(entityName, child);
  }
  
  public SessionImplementor getSession()
  {
    return this;
  }
  
  public boolean useStreamForLobBinding()
  {
    return this.delegate.useStreamForLobBinding();
  }
  
  public LobCreator getLobCreator()
  {
    return this.delegate.getLobCreator();
  }
  
  public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor)
  {
    return this.delegate.remapSqlTypeDescriptor(sqlTypeDescriptor);
  }
  
  public Integer getJdbcBatchSize()
  {
    return this.delegate.getJdbcBatchSize();
  }
  
  public void setJdbcBatchSize(Integer jdbcBatchSize)
  {
    this.delegate.setJdbcBatchSize(jdbcBatchSize);
  }
  
  public TimeZone getJdbcTimeZone()
  {
    return this.delegate.getJdbcTimeZone();
  }
}
