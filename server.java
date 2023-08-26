import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VpnServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("VPN server started. Waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(() -> {
                    try {
                        InputStream clientInput = clientSocket.getInputStream();
                        OutputStream clientOutput = clientSocket.getOutputStream();

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = clientInput.read(buffer)) != -1) {
                            clientOutput.write(buffer, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
