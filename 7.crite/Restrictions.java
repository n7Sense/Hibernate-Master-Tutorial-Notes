package org.hibernate.criterion;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import org.hibernate.type.Type;

public class Restrictions
{
  public static Criterion idEq(Object value)
  {
    return new IdentifierEqExpression(value);
  }
  
  public static SimpleExpression eq(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, "=");
  }
  
  public static Criterion eqOrIsNull(String propertyName, Object value)
  {
    return value == null ? 
      isNull(propertyName) : 
      eq(propertyName, value);
  }
  
  public static SimpleExpression ne(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, "<>");
  }
  
  public static Criterion neOrIsNotNull(String propertyName, Object value)
  {
    return value == null ? 
      isNotNull(propertyName) : 
      ne(propertyName, value);
  }
  
  public static SimpleExpression like(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, " like ");
  }
  
  public static SimpleExpression like(String propertyName, String value, MatchMode matchMode)
  {
    return new SimpleExpression(propertyName, matchMode.toMatchString(value), " like ");
  }
  
  public static Criterion ilike(String propertyName, Object value)
  {
    if (value == null) {
      throw new IllegalArgumentException("Comparison value passed to ilike cannot be null");
    }
    return ilike(propertyName, value.toString(), MatchMode.EXACT);
  }
  
  public static Criterion ilike(String propertyName, String value, MatchMode matchMode)
  {
    if (value == null) {
      throw new IllegalArgumentException("Comparison value passed to ilike cannot be null");
    }
    return new LikeExpression(propertyName, value, matchMode, null, true);
  }
  
  public static SimpleExpression gt(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, ">");
  }
  
  public static SimpleExpression lt(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, "<");
  }
  
  public static SimpleExpression le(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, "<=");
  }
  
  public static SimpleExpression ge(String propertyName, Object value)
  {
    return new SimpleExpression(propertyName, value, ">=");
  }
  
  public static Criterion between(String propertyName, Object low, Object high)
  {
    return new BetweenExpression(propertyName, low, high);
  }
  
  public static Criterion in(String propertyName, Object... values)
  {
    return new InExpression(propertyName, values);
  }
  
  public static Criterion in(String propertyName, Collection values)
  {
    return new InExpression(propertyName, values.toArray());
  }
  
  public static Criterion isNull(String propertyName)
  {
    return new NullExpression(propertyName);
  }
  
  public static Criterion isNotNull(String propertyName)
  {
    return new NotNullExpression(propertyName);
  }
  
  public static PropertyExpression eqProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, "=");
  }
  
  public static PropertyExpression neProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, "<>");
  }
  
  public static PropertyExpression ltProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, "<");
  }
  
  public static PropertyExpression leProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, "<=");
  }
  
  public static PropertyExpression gtProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, ">");
  }
  
  public static PropertyExpression geProperty(String propertyName, String otherPropertyName)
  {
    return new PropertyExpression(propertyName, otherPropertyName, ">=");
  }
  
  public static LogicalExpression and(Criterion lhs, Criterion rhs)
  {
    return new LogicalExpression(lhs, rhs, "and");
  }
  
  public static Conjunction and(Criterion... predicates)
  {
    return conjunction(predicates);
  }
  
  public static LogicalExpression or(Criterion lhs, Criterion rhs)
  {
    return new LogicalExpression(lhs, rhs, "or");
  }
  
  public static Disjunction or(Criterion... predicates)
  {
    return disjunction(predicates);
  }
  
  public static Criterion not(Criterion expression)
  {
    return new NotExpression(expression);
  }
  
  public static Criterion sqlRestriction(String sql, Object[] values, Type[] types)
  {
    return new SQLCriterion(sql, values, types);
  }
  
  public static Criterion sqlRestriction(String sql, Object value, Type type)
  {
    return new SQLCriterion(sql, value, type);
  }
  
  public static Criterion sqlRestriction(String sql)
  {
    return new SQLCriterion(sql);
  }
  
  public static Conjunction conjunction()
  {
    return new Conjunction();
  }
  
  public static Conjunction conjunction(Criterion... conditions)
  {
    return new Conjunction(conditions);
  }
  
  public static Disjunction disjunction()
  {
    return new Disjunction();
  }
  
  public static Disjunction disjunction(Criterion... conditions)
  {
    return new Disjunction(conditions);
  }
  
  public static Criterion allEq(Map<String, ?> propertyNameValues)
  {
    Conjunction conj = conjunction();
    for (Map.Entry<String, ?> entry : propertyNameValues.entrySet()) {
      conj.add(eq((String)entry.getKey(), entry.getValue()));
    }
    return conj;
  }
  
  public static Criterion isEmpty(String propertyName)
  {
    return new EmptyExpression(propertyName);
  }
  
  public static Criterion isNotEmpty(String propertyName)
  {
    return new NotEmptyExpression(propertyName);
  }
  
  public static Criterion sizeEq(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, "=");
  }
  
  public static Criterion sizeNe(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, "<>");
  }
  
  public static Criterion sizeGt(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, "<");
  }
  
  public static Criterion sizeLt(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, ">");
  }
  
  public static Criterion sizeGe(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, "<=");
  }
  
  public static Criterion sizeLe(String propertyName, int size)
  {
    return new SizeExpression(propertyName, size, ">=");
  }
  
  public static NaturalIdentifier naturalId()
  {
    return new NaturalIdentifier();
  }
}
