Second Level Cache
=====================

Q.1 What is current_session_context_class in hibernate configuration xml.? meaning and need for the current_session_context_class


When you create a hibernate session using any of the sessionFactory.openSession(...) methods the session factory will 'bind' the session
to the current context. The default context is 'thread' which means the sesion factory will bind the session to the thread from which
openSession(...) is called. 

This is useful because you can later call sessionFactory.getCurrentSession() which will return the session that is bound to the currently
running thread. 

You can use other predefined current_session_context_class values such as 'jta' which will bind the session to the currently running
JTA transaction (if you are running in an application server that supports JTA this is really useful).
Or you can write your own implementation of org.hibernate.context.CurrentSessionContext and use that implementation to manage the current
session context (not really advisable unless you absolutely need to). 