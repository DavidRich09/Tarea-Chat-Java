package gui;
import servidores.cliente;
import servidores.Servidor;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class chat extends JFrame implements Observer {
    private JPanel Panel_1;
    private JButton btnenviar;
    private JTextArea escribir_texto;
    private JTextArea verTexto;
    private JTextField num_puerto;
    private JLabel puerto_actual;
    private JLabel label_puerto;
    private String usario;

    public chat(){

        Servidor s = new Servidor(5000);

        s.addObserver(this);

        Thread t = new Thread(s);
        t.start();

        add(Panel_1);

        setTitle("Chat");
        setSize(400,500);
        setVisible(true);

        label_puerto.setText((String.valueOf(s.getLabel_puerto())));

        usario = JOptionPane.showInputDialog("Ingresa tu nombre");

        btnenviar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String mensaje = usario+": "+escribir_texto.getText() + "\n";

                verTexto.append(mensaje);

                escribir_texto.setText("");

                int Puerto;
                String texto = num_puerto.getText();

                Puerto = Integer.parseInt(texto);

                cliente c = new cliente(Puerto,mensaje);
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

