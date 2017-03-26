package server;

import javafx.application.Platform;
import javafx.scene.control.ListView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Никита on 15.03.2017.
 */

//TODO: test with deleted extends
public class Worker extends Thread {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private ListView<String> listView;
    private Socket clientSocket;
    private Integer clientNumber;

    public Worker(Socket clientSocket, ListView<String> listView, Integer clientNumber){
        this.listView = listView;
        this.clientSocket = clientSocket;
        this.clientNumber = clientNumber;
    }

    public void work(){
        listView.getItems().add(ServerConstants.STARTED_WORKER_MESSAGE);
        listView.getItems().add(ServerConstants.CONNECTED_MESSAGE);
        listView.getItems().add(ServerConstants.CLIENT_NUMBER_MESSAGE + clientNumber);

        DataInputStream clientInfo = null;
        DataOutputStream response = null;

        try {
            clientInfo = new DataInputStream(clientSocket.getInputStream());
            listView.getItems().add(clientInfo.readUTF());
        } catch (IOException e) {
            listView.getItems().add(ServerConstants.FAIL_CONNECTED_MESSAGE);
        }

        try {
            response = new DataOutputStream(clientSocket.getOutputStream());
            response.writeUTF("\nHello from server\n");
            response.flush();
        } catch (IOException e) {
            listView.getItems().add(ServerConstants.FAIL_CONNECTED_MESSAGE);
        }
    }

    public void execute(){
        Platform.runLater(new Runnable() {
            public void run() {
                work();
            }
        });
    }
}
