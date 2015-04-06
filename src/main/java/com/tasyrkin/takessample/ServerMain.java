package com.tasyrkin.takessample;

import java.net.ServerSocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerMain {

    private static final Logger LOG = LogManager.getLogger(ServerMain.class);

    public static void main(final String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8080);

        LOG.info("Started listening on port 8080");

        while (true) {
            Thread.sleep(1000);
        }
    }
}
