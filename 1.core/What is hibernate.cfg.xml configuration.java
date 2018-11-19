What is hibernate.cfg.xml configuration.?

One of the most required configuration file in Hibernate is hibernate.cfg.xml file. By default, it is placed under src/main/resource folder.
hibernate.cfg.xml file contains database related configurations and session related configurations.

Database configuration includes jdbc connection url, DB user credentials, driver class and hibernate dialect.

Here is the simple configuration file example for your reference:

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC 
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
	"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/java2novice</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">root</property>
		<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
		<property name="show_sql">false</property>
	</session-factory>
</hibernate-configuration>