package servidores;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente implements Runnable{

    private int puerto;
    private String mensaje;

    public cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        final String HOST = "127.0.0.1";

        DataOutput out;

        try {

            Socket sc = new Socket(HOST,puerto);

            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

            sc.close();

        }catch (IOException ex){
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
