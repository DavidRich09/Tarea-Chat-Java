package servidores;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Observable implements Runnable{

    private int puerto;

    public Servidor(int puerto) {

        this.puerto = puerto;
    }


    @Override
    public void run() {
        ServerSocket servidor = null;

        Socket sc = null;
        DataInputStream in;
        DataOutput out;

        try{
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            while (true){

                sc = servidor.accept();

                System.out.println("cliente contectado");
                in = new DataInputStream(sc.getInputStream());

                String mensaje = in.readUTF();

                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                sc.close();
                System.out.println("Cliente Desconectado");

            }
        } catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
