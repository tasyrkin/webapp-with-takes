package com.tasyrkin.takessample;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerMain {

    private static final Logger LOG = LogManager.getLogger(ServerMain.class);

    public static void main(final String[] args) throws Exception {
        final int port = 8080;
        final ServerSocket serverSocket = new ServerSocket(port);

        LOG.info("Started listening on port " + port);

        while (true) {

            try(final Socket socket = serverSocket.accept()) {
                LOG.info("Accepted connection on port " + socket);

                final String body = String.format("<html><body>Hello world!@%s</body></html>", new Date());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                bufferedWriter.write("HTTP/1.1 200 OK" + System.lineSeparator());
                bufferedWriter.write("Content-type: text/html;charset=UTF-8" + System.lineSeparator());
                bufferedWriter.write("Content-Length: " + body.length() + System.lineSeparator());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(body);
                bufferedWriter.flush();
            }

        }
    }
}
