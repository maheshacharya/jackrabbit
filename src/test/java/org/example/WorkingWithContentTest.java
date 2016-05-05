package org.example;

import org.apache.jackrabbit.commons.JcrUtils;
import org.junit.Test;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;


public class WorkingWithContentTest {

    @Test
    public  void workingWithContent() throws Exception {
        Repository repository = JcrUtils.getRepository();
        Session session = repository.login(
                new SimpleCredentials("admin", "admin".toCharArray()));
        try {
            Node root = session.getRootNode();

            // Store content
            Node hello = root.addNode("hello");
            Node world = hello.addNode("world");
            world.setProperty("message", "Hello, World!");
            session.save();

            // Retrieve content
            Node node = root.getNode("hello/world");
            System.out.println(node.getPath());
            System.out.println(node.getProperty("message").getString());

            // Remove content
            root.getNode("hello").remove();
            session.save();
        } finally {
            session.logout();
        }
    }
}
