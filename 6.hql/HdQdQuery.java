package org.hibernate.query;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Incubating;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BigIntegerType;
import org.hibernate.type.BinaryType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.ByteType;
import org.hibernate.type.CharacterType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocaleType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TextType;
import org.hibernate.type.TimeType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;

@Incubating
public abstract interface Query<R>
  extends TypedQuery<R>, org.hibernate.Query<R>, CommonQueryContract
{
  static
  {
    if (1.$assertionsDisabled) {}
  }
  
  public List<R> getResultList()
  {
    return list();
  }
  
  public R getSingleResult()
  {
    return (R)uniqueResult();
  }
  
  @Deprecated
  public Query<R> setFlushMode(FlushMode flushMode)
  {
    setHibernateFlushMode(flushMode);
    return this;
  }
  
  @Deprecated
  public Query<R> setString(int position, String val)
  {
    setParameter(position, val, StringType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCharacter(int position, char val)
  {
    setParameter(position, Character.valueOf(val), CharacterType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBoolean(int position, boolean val)
  {
    setParameter(position, Boolean.valueOf(val), determineProperBooleanType(position, Boolean.valueOf(val), BooleanType.INSTANCE));
    return this;
  }
  
  @Deprecated
  public Query<R> setByte(int position, byte val)
  {
    setParameter(position, Byte.valueOf(val), ByteType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setShort(int position, short val)
  {
    setParameter(position, Short.valueOf(val), ShortType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setInteger(int position, int val)
  {
    setParameter(position, Integer.valueOf(val), IntegerType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setLong(int position, long val)
  {
    setParameter(position, Long.valueOf(val), LongType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setFloat(int position, float val)
  {
    setParameter(position, Float.valueOf(val), FloatType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setDouble(int position, double val)
  {
    setParameter(position, Double.valueOf(val), DoubleType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBinary(int position, byte[] val)
  {
    setParameter(position, val, BinaryType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setText(int position, String val)
  {
    setParameter(position, val, TextType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setSerializable(int position, Serializable val)
  {
    setParameter(position, val);
    return this;
  }
  
  @Deprecated
  public Query<R> setLocale(int position, Locale val)
  {
    setParameter(position, val, LocaleType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBigDecimal(int position, BigDecimal val)
  {
    setParameter(position, val, BigDecimalType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBigInteger(int position, BigInteger val)
  {
    setParameter(position, val, BigIntegerType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setDate(int position, Date val)
  {
    setParameter(position, val, DateType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setTime(int position, Date val)
  {
    setParameter(position, val, TimeType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setTimestamp(int position, Date val)
  {
    setParameter(position, val, TimestampType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCalendar(int position, Calendar val)
  {
    setParameter(position, val, TimestampType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCalendarDate(int position, Calendar val)
  {
    setParameter(position, val, DateType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setString(String name, String val)
  {
    setParameter(name, val, StringType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCharacter(String name, char val)
  {
    setParameter(name, Character.valueOf(val), CharacterType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBoolean(String name, boolean val)
  {
    setParameter(name, Boolean.valueOf(val), determineProperBooleanType(name, Boolean.valueOf(val), BooleanType.INSTANCE));
    return this;
  }
  
  @Deprecated
  public Query<R> setByte(String name, byte val)
  {
    setParameter(name, Byte.valueOf(val), ByteType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setShort(String name, short val)
  {
    setParameter(name, Short.valueOf(val), ShortType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setInteger(String name, int val)
  {
    setParameter(name, Integer.valueOf(val), IntegerType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setLong(String name, long val)
  {
    setParameter(name, Long.valueOf(val), LongType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setFloat(String name, float val)
  {
    setParameter(name, Float.valueOf(val), FloatType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setDouble(String name, double val)
  {
    setParameter(name, Double.valueOf(val), DoubleType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBinary(String name, byte[] val)
  {
    setParameter(name, val, BinaryType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setText(String name, String val)
  {
    setParameter(name, val, TextType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setSerializable(String name, Serializable val)
  {
    setParameter(name, val);
    return this;
  }
  
  @Deprecated
  public Query<R> setLocale(String name, Locale val)
  {
    setParameter(name, val, TextType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBigDecimal(String name, BigDecimal val)
  {
    setParameter(name, val, BigDecimalType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setBigInteger(String name, BigInteger val)
  {
    setParameter(name, val, BigIntegerType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setDate(String name, Date val)
  {
    setParameter(name, val, DateType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setTime(String name, Date val)
  {
    setParameter(name, val, TimeType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setTimestamp(String name, Date value)
  {
    setParameter(name, value, TimestampType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCalendar(String name, Calendar value)
  {
    setParameter(name, value, TimestampType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setCalendarDate(String name, Calendar value)
  {
    setParameter(name, value, DateType.INSTANCE);
    return this;
  }
  
  @Deprecated
  public Query<R> setParameters(Object[] values, Type[] types)
  {
    if ((!1.$assertionsDisabled) && (values.length != types.length)) {
      throw new AssertionError();
    }
    for (int i = 0; i < values.length; i++) {
      setParameter(i, values[i], types[i]);
    }
    return this;
  }
  
  public Stream<R> getResultStream()
  {
    return stream();
  }
  
  public abstract QueryProducer getProducer();
  
  public abstract Optional<R> uniqueResultOptional();
  
  public abstract Stream<R> stream();
  
  public abstract Query<R> setParameter(Parameter<Instant> paramParameter, Instant paramInstant, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(Parameter<LocalDateTime> paramParameter, LocalDateTime paramLocalDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(Parameter<ZonedDateTime> paramParameter, ZonedDateTime paramZonedDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(Parameter<OffsetDateTime> paramParameter, OffsetDateTime paramOffsetDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, Instant paramInstant, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, LocalDateTime paramLocalDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, ZonedDateTime paramZonedDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, OffsetDateTime paramOffsetDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, Instant paramInstant, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, LocalDateTime paramLocalDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, ZonedDateTime paramZonedDateTime, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, OffsetDateTime paramOffsetDateTime, TemporalType paramTemporalType);
  
  public abstract ScrollableResults scroll();
  
  public abstract ScrollableResults scroll(ScrollMode paramScrollMode);
  
  public abstract List<R> list();
  
  public abstract R uniqueResult();
  
  public abstract FlushMode getHibernateFlushMode();
  
  public abstract CacheMode getCacheMode();
  
  public abstract String getCacheRegion();
  
  public abstract Integer getFetchSize();
  
  public abstract LockOptions getLockOptions();
  
  public abstract String getComment();
  
  public abstract String getQueryString();
  
  public abstract ParameterMetadata getParameterMetadata();
  
  public abstract Query<R> setMaxResults(int paramInt);
  
  public abstract Query<R> setFirstResult(int paramInt);
  
  public abstract Query<R> setHint(String paramString, Object paramObject);
  
  public abstract <T> Query<R> setParameter(Parameter<T> paramParameter, T paramT);
  
  public abstract Query<R> setParameter(Parameter<Calendar> paramParameter, Calendar paramCalendar, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(Parameter<Date> paramParameter, Date paramDate, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, Object paramObject);
  
  public abstract Query<R> setParameter(String paramString, Object paramObject, Type paramType);
  
  public abstract Query<R> setParameter(String paramString, Calendar paramCalendar, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(String paramString, Date paramDate, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, Object paramObject);
  
  public abstract Query<R> setParameter(int paramInt, Calendar paramCalendar, TemporalType paramTemporalType);
  
  public abstract Query<R> setParameter(int paramInt, Date paramDate, TemporalType paramTemporalType);
  
  public abstract <T> Query<R> setParameter(QueryParameter<T> paramQueryParameter, T paramT);
  
  public abstract <P> Query<R> setParameter(int paramInt, P paramP, TemporalType paramTemporalType);
  
  public abstract <P> Query<R> setParameter(QueryParameter<P> paramQueryParameter, P paramP, Type paramType);
  
  public abstract Query<R> setParameter(int paramInt, Object paramObject, Type paramType);
  
  public abstract <P> Query<R> setParameter(QueryParameter<P> paramQueryParameter, P paramP, TemporalType paramTemporalType);
  
  public abstract <P> Query<R> setParameter(String paramString, P paramP, TemporalType paramTemporalType);
  
  public abstract Query<R> setFlushMode(FlushModeType paramFlushModeType);
  
  public abstract Query<R> setLockMode(LockModeType paramLockModeType);
  
  public abstract Query<R> setReadOnly(boolean paramBoolean);
  
  public abstract Query<R> setHibernateFlushMode(FlushMode paramFlushMode);
  
  public abstract Query<R> setCacheMode(CacheMode paramCacheMode);
  
  public abstract Query<R> setCacheable(boolean paramBoolean);
  
  public abstract Query<R> setCacheRegion(String paramString);
  
  public abstract Query<R> setTimeout(int paramInt);
  
  public abstract Query<R> setFetchSize(int paramInt);
  
  public abstract Query<R> setLockOptions(LockOptions paramLockOptions);
  
  public abstract Query<R> setLockMode(String paramString, LockMode paramLockMode);
  
  public abstract Query<R> setComment(String paramString);
  
  public abstract Query<R> addQueryHint(String paramString);
  
  public abstract <P> Query<R> setParameterList(QueryParameter<P> paramQueryParameter, Collection<P> paramCollection);
  
  public abstract Query<R> setParameterList(String paramString, Collection paramCollection);
  
  public abstract Query<R> setParameterList(String paramString, Collection paramCollection, Type paramType);
  
  public abstract Query<R> setParameterList(String paramString, Object[] paramArrayOfObject, Type paramType);
  
  public abstract Query<R> setParameterList(String paramString, Object[] paramArrayOfObject);
  
  public abstract Query<R> setProperties(Object paramObject);
  
  public abstract Query<R> setProperties(Map paramMap);
  
  @Deprecated
  public abstract Query<R> setEntity(int paramInt, Object paramObject);
  
  @Deprecated
  public abstract Query<R> setEntity(String paramString, Object paramObject);
  
  @Deprecated
  public abstract Query<R> setResultTransformer(ResultTransformer paramResultTransformer);
}
