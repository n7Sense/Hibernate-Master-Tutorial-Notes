package org.hibernate;

import java.io.Closeable;
import java.io.Serializable;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.NativeQuery;
import org.hibernate.stat.SessionStatistics;

public abstract interface Session extends SharedSessionContract, EntityManager, HibernateEntityManager, AutoCloseable, Closeable
{
  public abstract SharedSessionBuilder sessionWithOptions();
  
  public abstract void flush()
    throws HibernateException;
  
  @Deprecated
  public abstract void setFlushMode(FlushMode paramFlushMode);
  
  public abstract FlushModeType getFlushMode();
  
  public abstract void setHibernateFlushMode(FlushMode paramFlushMode);
  
  public abstract FlushMode getHibernateFlushMode();
  
  public abstract void setCacheMode(CacheMode paramCacheMode);
  
  public abstract CacheMode getCacheMode();
  
  public abstract SessionFactory getSessionFactory();
  
  public abstract void cancelQuery()
    throws HibernateException;
  
  public abstract boolean isDirty()
    throws HibernateException;
  
  public abstract boolean isDefaultReadOnly();
  
  public abstract void setDefaultReadOnly(boolean paramBoolean);
  
  public abstract Serializable getIdentifier(Object paramObject);
  
  public abstract boolean contains(String paramString, Object paramObject);
  
  public abstract void evict(Object paramObject);
  
  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract Object load(String paramString, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract Object load(String paramString, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract <T> T load(Class<T> paramClass, Serializable paramSerializable);
  
  public abstract Object load(String paramString, Serializable paramSerializable);
  
  public abstract void load(Object paramObject, Serializable paramSerializable);
  
  public abstract void replicate(Object paramObject, ReplicationMode paramReplicationMode);
  
  public abstract void replicate(String paramString, Object paramObject, ReplicationMode paramReplicationMode);
  
  public abstract Serializable save(Object paramObject);
  
  public abstract Serializable save(String paramString, Object paramObject);
  
  public abstract void saveOrUpdate(Object paramObject);
  
  public abstract void saveOrUpdate(String paramString, Object paramObject);
  
  public abstract void update(Object paramObject);
  
  public abstract void update(String paramString, Object paramObject);
  
  public abstract Object merge(Object paramObject);
  
  public abstract Object merge(String paramString, Object paramObject);
  
  public abstract void persist(Object paramObject);
  
  public abstract void persist(String paramString, Object paramObject);
  
  public abstract void delete(Object paramObject);
  
  public abstract void delete(String paramString, Object paramObject);
  
  public abstract void lock(Object paramObject, LockMode paramLockMode);
  
  public abstract void lock(String paramString, Object paramObject, LockMode paramLockMode);
  
  public abstract LockRequest buildLockRequest(LockOptions paramLockOptions);
  
  public abstract void refresh(Object paramObject);
  
  public abstract void refresh(String paramString, Object paramObject);
  
  public abstract void refresh(Object paramObject, LockMode paramLockMode);
  
  public abstract void refresh(Object paramObject, LockOptions paramLockOptions);
  
  public abstract void refresh(String paramString, Object paramObject, LockOptions paramLockOptions);
  
  public abstract LockMode getCurrentLockMode(Object paramObject);
  
  @Deprecated
  public abstract Query createFilter(Object paramObject, String paramString);
  
  public abstract void clear();
  
  public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable);
  
  public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract Object get(String paramString, Serializable paramSerializable);
  
  public abstract Object get(String paramString, Serializable paramSerializable, LockMode paramLockMode);
  
  public abstract Object get(String paramString, Serializable paramSerializable, LockOptions paramLockOptions);
  
  public abstract String getEntityName(Object paramObject);
  
  public abstract IdentifierLoadAccess byId(String paramString);
  
  public abstract <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> paramClass);
  
  public abstract MultiIdentifierLoadAccess byMultipleIds(String paramString);
  
  public abstract <T> IdentifierLoadAccess<T> byId(Class<T> paramClass);
  
  public abstract NaturalIdLoadAccess byNaturalId(String paramString);
  
  public abstract <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> paramClass);
  
  public abstract SimpleNaturalIdLoadAccess bySimpleNaturalId(String paramString);
  
  public abstract <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> paramClass);
  
  public abstract Filter enableFilter(String paramString);
  
  public abstract Filter getEnabledFilter(String paramString);
  
  public abstract void disableFilter(String paramString);
  
  public abstract SessionStatistics getStatistics();
  
  public abstract boolean isReadOnly(Object paramObject);
  
  public abstract void setReadOnly(Object paramObject, boolean paramBoolean);
  
  public abstract void doWork(Work paramWork)
    throws HibernateException;
  
  public abstract <T> T doReturningWork(ReturningWork<T> paramReturningWork)
    throws HibernateException;
  
  public abstract Connection disconnect();
  
  public abstract void reconnect(Connection paramConnection);
  
  public abstract boolean isFetchProfileEnabled(String paramString)
    throws UnknownProfileException;
  
  public abstract void enableFetchProfile(String paramString)
    throws UnknownProfileException;
  
  public abstract void disableFetchProfile(String paramString)
    throws UnknownProfileException;
  
  public abstract TypeHelper getTypeHelper();
  
  public abstract LobHelper getLobHelper();
  
  public abstract void addEventListeners(SessionEventListener... paramVarArgs);
  
  public abstract org.hibernate.query.Query createQuery(String paramString);
  
  public abstract <T> org.hibernate.query.Query<T> createQuery(String paramString, Class<T> paramClass);
  
  public abstract <T> org.hibernate.query.Query<T> createQuery(CriteriaQuery<T> paramCriteriaQuery);
  
  public abstract org.hibernate.query.Query createQuery(CriteriaUpdate paramCriteriaUpdate);
  
  public abstract org.hibernate.query.Query createQuery(CriteriaDelete paramCriteriaDelete);
  
  public abstract org.hibernate.query.Query getNamedQuery(String paramString);
  
  public abstract <T> org.hibernate.query.Query<T> createNamedQuery(String paramString, Class<T> paramClass);
  
  public abstract NativeQuery createSQLQuery(String paramString);
  
  public static abstract interface LockRequest
  {
    public static final int PESSIMISTIC_NO_WAIT = 0;
    public static final int PESSIMISTIC_WAIT_FOREVER = -1;
    
    public abstract LockMode getLockMode();
    
    public abstract LockRequest setLockMode(LockMode paramLockMode);
    
    public abstract int getTimeOut();
    
    public abstract LockRequest setTimeOut(int paramInt);
    
    public abstract boolean getScope();
    
    public abstract LockRequest setScope(boolean paramBoolean);
    
    public abstract void lock(String paramString, Object paramObject);
    
    public abstract void lock(Object paramObject);
  }
}
