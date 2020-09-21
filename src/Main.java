import gui.chat;
public class Main {

    public static void main(String[] main) {


        /**
         *
         * El programa consiste en un mini chat que se ejecutará en la misma
         * computadora, donde el o los usuarios pueden insertar un puerto, al cual
         * quieren mandar un mensaje, insertar el mensaje y dicho mensaje se mandará
         * al puerto que el usuario indicó.
         *
         * @Autor Luis David Richmond
         * @Version 1.0. 21/0/2020
         *
         * Esta es la clase main, donde se llama al resto del código.
         *
         */



        chat MiVentana = new chat();
        MiVentana.setVisible(true);

    }
}
