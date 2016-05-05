package org.example;


import org.junit.Test;
import org.apache.jackrabbit.commons.JcrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


public class AnonymousLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(AnonymousLoginTest.class);

    @Test
    public void anonymousLogin() throws RepositoryException {

        Session session = null;
        try {
            final Repository repository = JcrUtils.getRepository();
            session = repository.login(new GuestCredentials());
            String user = session.getUserID();
            String name = repository.getDescriptor(Repository.REP_NAME_DESC);
            System.out.println("Logged in as " + user + " to a " + name + " repository.");

        } finally {
            if (session != null) {
                session.logout();
            }
        }
    }


}
