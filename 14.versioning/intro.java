Versioning
===============

how many times our record is get Updated to know the no.of time our record get Updated we shuld go for
Versioning concept.

The Version Configuration is given following 

<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping>

    <class name="model.Version" table="version">

        <id name="employeeId" type="int"> <column name="employee_id"/> <generator class="increment"/> </id>

        <version name="version" column="version"/>

        <property name="firstName" type="java.lang.String"> <column name="first_name"/> </property>

        <property name="lastName" type="java.lang.String">
            <column name="last_name"/>
        </property>

    </class>

</hibernate-mapping>

NOTE: the <version> element must be after <id> element. otherwise will throws 

Exception in thread "main" org.hibernate.boot.InvalidMappingException: Could not parse mapping document: /entityXml/version.hbm.xml (RESOURCE)
    at org.hibernate.boot.jaxb.internal.InputStreamXmlSource.doBind(InputStreamXmlSource.java:46)
    at org.hibernate.boot.jaxb.internal.UrlXmlSource.doBind(UrlXmlSource.java:36)
    at org.hibernate.boot.spi.XmlMappingBinderAccess.bind(XmlMappingBinderAccess.java:59)
    at org.hibernate.boot.MetadataSources.addResource(MetadataSources.java:275)
    at org.hibernate.boot.cfgxml.spi.MappingReference.apply(MappingReference.java:70)
    at org.hibernate.boot.internal.MetadataBuilderImpl.build(MetadataBuilderImpl.java:469)
    at org.hibernate.boot.internal.MetadataBuilderImpl.build(MetadataBuilderImpl.java:85)
    at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:689)
    at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:724)
    at ns.nSense.main(nSense.java:19)
Caused by: org.hibernate.boot.MappingException: Unable to perform unmarshalling at line number 15 and column 51. Message: cvc-complex-type.2.4.a: Invalid content was found starting with element 'version'. One of '{"http://www.hibernate.org/xsd/orm/hbm":idbag, "http://www.hibernate.org/xsd/orm/hbm":property, "http://www.hibernate.org/xsd/orm/hbm":many-to-one, "http://www.hibernate.org/xsd/orm/hbm":one-to-one, "http://www.hibernate.org/xsd/orm/hbm":component, "http://www.hibernate.org/xsd/orm/hbm":dynamic-component, "http://www.hibernate.org/xsd/orm/hbm":properties, "http://www.hibernate.org/xsd/orm/hbm":any, "http://www.hibernate.org/xsd/orm/hbm":map, "http://www.hibernate.org/xsd/orm/hbm":set, "http://www.hibernate.org/xsd/orm/hbm":list, "http://www.hibernate.org/xsd/orm/hbm":bag, "http://www.hibernate.org/xsd/orm/hbm":array, "http://www.hibernate.org/xsd/orm/hbm":primitive-array, "http://www.hibernate.org/xsd/orm/hbm":join, "http://www.hibernate.org/xsd/orm/hbm":subclass, "http://www.hibernate.org/xsd/orm/hbm":joined-subclass, "http://www.hibernate.org/xsd/orm/hbm":union-subclass, "http://www.hibernate.org/xsd/orm/hbm":loader, "http://www.hibernate.org/xsd/orm/hbm":sql-insert, "http://www.hibernate.org/xsd/orm/hbm":sql-update, "http://www.hibernate.org/xsd/orm/hbm":sql-delete, "http://www.hibernate.org/xsd/orm/hbm":filter, "http://www.hibernate.org/xsd/orm/hbm":fetch-profile, "http://www.hibernate.org/xsd/orm/hbm":resultset, "http://www.hibernate.org/xsd/orm/hbm":query, "http://www.hibernate.org/xsd/orm/hbm":sql-query}' is expected. : origin(/entityXml/version.hbm.xml)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.jaxb(AbstractBinder.java:177)
    at org.hibernate.boot.jaxb.internal.MappingBinder.doBind(MappingBinder.java:62)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.doBind(AbstractBinder.java:102)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.bind(AbstractBinder.java:57)
    at org.hibernate.boot.jaxb.internal.InputStreamXmlSource.doBind(InputStreamXmlSource.java:43)
    ... 9 more
Caused by: javax.xml.bind.UnmarshalException
 - with linked exception:
[org.xml.sax.SAXParseException; lineNumber: 15; columnNumber: 51; cvc-complex-type.2.4.a: Invalid content was found starting with element 'version'. One of '{"http://www.hibernate.org/xsd/orm/hbm":idbag, "http://www.hibernate.org/xsd/orm/hbm":property, "http://www.hibernate.org/xsd/orm/hbm":many-to-one, "http://www.hibernate.org/xsd/orm/hbm":one-to-one, "http://www.hibernate.org/xsd/orm/hbm":component, "http://www.hibernate.org/xsd/orm/hbm":dynamic-component, "http://www.hibernate.org/xsd/orm/hbm":properties, "http://www.hibernate.org/xsd/orm/hbm":any, "http://www.hibernate.org/xsd/orm/hbm":map, "http://www.hibernate.org/xsd/orm/hbm":set, "http://www.hibernate.org/xsd/orm/hbm":list, "http://www.hibernate.org/xsd/orm/hbm":bag, "http://www.hibernate.org/xsd/orm/hbm":array, "http://www.hibernate.org/xsd/orm/hbm":primitive-array, "http://www.hibernate.org/xsd/orm/hbm":join, "http://www.hibernate.org/xsd/orm/hbm":subclass, "http://www.hibernate.org/xsd/orm/hbm":joined-subclass, "http://www.hibernate.org/xsd/orm/hbm":union-subclass, "http://www.hibernate.org/xsd/orm/hbm":loader, "http://www.hibernate.org/xsd/orm/hbm":sql-insert, "http://www.hibernate.org/xsd/orm/hbm":sql-update, "http://www.hibernate.org/xsd/orm/hbm":sql-delete, "http://www.hibernate.org/xsd/orm/hbm":filter, "http://www.hibernate.org/xsd/orm/hbm":fetch-profile, "http://www.hibernate.org/xsd/orm/hbm":resultset, "http://www.hibernate.org/xsd/orm/hbm":query, "http://www.hibernate.org/xsd/orm/hbm":sql-query}' is expected.]
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.handleStreamException(UnmarshallerImpl.java:468)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.unmarshal0(UnmarshallerImpl.java:448)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.unmarshal(UnmarshallerImpl.java:420)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.jaxb(AbstractBinder.java:171)
    ... 13 more
Caused by: org.xml.sax.SAXParseException; lineNumber: 15; columnNumber: 51; cvc-complex-type.2.4.a: Invalid content was found starting with element 'version'. One of '{"http://www.hibernate.org/xsd/orm/hbm":idbag, "http://www.hibernate.org/xsd/orm/hbm":property, "http://www.hibernate.org/xsd/orm/hbm":many-to-one, "http://www.hibernate.org/xsd/orm/hbm":one-to-one, "http://www.hibernate.org/xsd/orm/hbm":component, "http://www.hibernate.org/xsd/orm/hbm":dynamic-component, "http://www.hibernate.org/xsd/orm/hbm":properties, "http://www.hibernate.org/xsd/orm/hbm":any, "http://www.hibernate.org/xsd/orm/hbm":map, "http://www.hibernate.org/xsd/orm/hbm":set, "http://www.hibernate.org/xsd/orm/hbm":list, "http://www.hibernate.org/xsd/orm/hbm":bag, "http://www.hibernate.org/xsd/orm/hbm":array, "http://www.hibernate.org/xsd/orm/hbm":primitive-array, "http://www.hibernate.org/xsd/orm/hbm":join, "http://www.hibernate.org/xsd/orm/hbm":subclass, "http://www.hibernate.org/xsd/orm/hbm":joined-subclass, "http://www.hibernate.org/xsd/orm/hbm":union-subclass, "http://www.hibernate.org/xsd/orm/hbm":loader, "http://www.hibernate.org/xsd/orm/hbm":sql-insert, "http://www.hibernate.org/xsd/orm/hbm":sql-update, "http://www.hibernate.org/xsd/orm/hbm":sql-delete, "http://www.hibernate.org/xsd/orm/hbm":filter, "http://www.hibernate.org/xsd/orm/hbm":fetch-profile, "http://www.hibernate.org/xsd/orm/hbm":resultset, "http://www.hibernate.org/xsd/orm/hbm":query, "http://www.hibernate.org/xsd/orm/hbm":sql-query}' is expected.
