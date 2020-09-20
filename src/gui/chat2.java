package gui;
import servidores.cliente;
import servidores.Servidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class chat2 extends JFrame implements Observer {
    private JPanel Panel_1;
    private JButton btnenviar;
    private JTextArea escribir_texto;
    private JTextArea verTexto;

    public chat2(){

        add(Panel_1);

        setTitle("chat 2");
        setSize(400,500);
        setVisible(true);

        Servidor s = new Servidor(6000);

        s.addObserver(this);

        Thread t = new Thread(s);
        t.start();


        btnenviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = "2: "+escribir_texto.getText() + "\n";

                verTexto.append(mensaje);


                cliente c = new cliente(5000,mensaje);
                Thread t = new Thread(c);
                t.start();
            }
        });
    }


    @Override
    public void update(Observable o, Object arg) {

        this.verTexto.append(((String) arg));

    }

}
