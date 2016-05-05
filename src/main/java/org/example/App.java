package org.example;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.JcrUtils;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) throws Exception {
        Repository repository = JcrUtils.getRepository();
        Session session = repository.login(new GuestCredentials());
        try {
            String user = session.getUserID();
            String name = repository.getDescriptor(Repository.REP_NAME_DESC);
            System.out.println(
                    "Logged in as " + user + " to a " + name + " repository.");
        } finally {
            session.logout();
        }
    }
}
