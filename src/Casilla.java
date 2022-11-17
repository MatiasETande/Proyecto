import javax.swing.*;
import java.awt.*;

public class Casilla extends JButton {

    private ImageIcon imagenBotonX = new ImageIcon("src/imgPoyecto/boton1.png");
    private JLabel botonX;
    private JLabel botonO;
    private int numero;

    public Casilla( int numero, int x, int y, int tamano){
        super();
        this.numero=numero;
        //this.setLayout(null);
        this.setBounds(x,y,tamano,tamano);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBackground(Color.darkGray);

        this.diseñarBotones();



    }

    //Getters and Setters


    public ImageIcon getImagenBotonX() {
        return imagenBotonX;
    }

    public void setImagenBotonX(ImageIcon imagenBotonX) {
        this.imagenBotonX = imagenBotonX;
    }

    public JLabel getBotonX() {
        return botonX;
    }

    public void setBotonX(JLabel botonX) {
        this.botonX = botonX;
    }

    public JLabel getBotonO() {
        return botonO;
    }

    public void setBotonO(JLabel botonO) {
        this.botonO = botonO;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Metodos

    public void diseñarBotones(){
        this.botonX = new JLabel("X");
        this.botonX.setFont(new Font("Arial",Font.BOLD,80));
        //this.botonX.setBounds(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        this.botonX.setBounds(20,0,this.getWidth(),this.getHeight());
        this.botonX.setForeground(Color.lightGray);

        this.botonO = new JLabel("O");
        this.botonO.setFont(new Font("Arial",Font.BOLD,80));
        this.botonO.setBounds(20,0,this.getWidth(),this.getHeight());
        this.botonO.setForeground(Color.lightGray);

    }

    public void marcarCasilla(int turnoJugador){
        if(turnoJugador==2){
            ponerX();
        }else {
            ponerO();
        }
    }

    public void ponerX(){
        this.add(botonX);
    }

    public void ponerO(){
        this.add(botonO);
    }

    public void limpiarCasilla(){
        this.removeAll();
    }


}
