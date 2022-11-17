import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JPanel /*implements ActionListener*/ {

    private ImageIcon imageIconimagenTabla;
    private ImageIcon imagenBoton = new ImageIcon("src/imgPoyecto/boton2.png");
    private ImageIcon imagenBoton2 = new ImageIcon("src/imgPoyecto/boton3.png");
    private JLabel labelimagenTabla;
    private Casilla[][] tabla;
    private JButton salir;
    private JButton volverAJugar;
    private JLabel jugador1;
    private JLabel jugador2;

    public Juego(int x, int y, int width, int height){
        super();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.setBackground(Color.orange);

        this.inicializarimagenTabla("src/imgPoyecto/tabla1.png");
        this.add(labelimagenTabla);

        //this.cargarMarcador();

        this.inicializarSalir();
        this.inicializarVolverAJugar();
        this.inicializarMarcador();
        this.cargarTabla();

    }


    //Getters and Setters


    public JLabel getJugador1() {
        return jugador1;
    }

    public void setJugador1(JLabel jugador1) {
        this.jugador1 = jugador1;
    }

    public JLabel getJugador2() {
        return jugador2;
    }

    public void setJugador2(JLabel jugador2) {
        this.jugador2 = jugador2;
    }

    public ImageIcon getImagenBoton() {
        return imagenBoton;
    }

    public void setImagenBoton(ImageIcon imagenBoton) {
        this.imagenBoton = imagenBoton;
    }

    public ImageIcon getImagenBoton2() {
        return imagenBoton2;
    }

    public void setImagenBoton2(ImageIcon imagenBoton2) {
        this.imagenBoton2 = imagenBoton2;
    }





    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public JButton getVolverAJugar() {
        return volverAJugar;
    }

    public void setVolverAJugar(JButton volverAJugar) {
        this.volverAJugar = volverAJugar;
    }

    public ImageIcon getImageIconimagenTabla() {
        return imageIconimagenTabla;
    }

    public void setImageIconimagenTabla(ImageIcon imageIconimagenTabla) {
        this.imageIconimagenTabla = imageIconimagenTabla;
    }

    public JLabel getLabelimagenTabla() {
        return labelimagenTabla;
    }

    public void setLabelimagenTabla(JLabel labelimagenTabla) {
        this.labelimagenTabla = labelimagenTabla;
    }

    public Casilla[][] getTabla() {
        return tabla;
    }

    public void setTabla(Casilla[][] tabla) {
        this.tabla = tabla;
    }


    //Metodos

    public void volverACargar(){
        this.add(labelimagenTabla);
    }

    public void limpiarJuego(){
        this.removeAll();
    }

    public void cargarSalir(){
        this.add(this.salir);
    }

    public void cargarVolverAJugar(){
        this.add(this.volverAJugar);
    }


    public void inicializarSalir(){
        this.salir= new JButton(" Salir");
        inicializarBoton(this.salir,150,440,200,200);
        this.salir.setIcon(new ImageIcon(this.imagenBoton2.getImage().getScaledInstance(this.salir.getWidth(),this.salir.getHeight(), Image.SCALE_SMOOTH)));

    }

    public void inicializarVolverAJugar(){
        this.volverAJugar= new JButton("Otra");
        inicializarBoton(this.volverAJugar,850,440,200,200);
        this.volverAJugar.setIcon(new ImageIcon(this.imagenBoton.getImage().getScaledInstance(this.volverAJugar.getWidth(),this.volverAJugar.getHeight(), Image.SCALE_SMOOTH)));
    }

    private void inicializarBoton(JButton unBoton, int x, int y, int width, int height){

        unBoton.setBounds(x,y,width,height);
        unBoton.setLayout(null);

        //unBoton.setIcon(new ImageIcon(this.imagenBoton2.getImage().getScaledInstance(unBoton.getWidth(),unBoton.getHeight(), Image.SCALE_SMOOTH)));
        unBoton.setOpaque(false);
        unBoton.setContentAreaFilled(false);
        unBoton.setBorderPainted(false);

        JLabel text = new JLabel(unBoton.getText());
        text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(60,75,150,50);
        text.setForeground(Color.lightGray);

        /*unBoton.addActionListener(this);*/

        unBoton.add(text);

    }

    public void inicializarimagenTabla(String root){
        this.imageIconimagenTabla= new ImageIcon(root);
        this.labelimagenTabla= new JLabel();
        //this.labelimagenTabla.setBackground(Color.orange);
        this.labelimagenTabla.setBounds(this.getWidth()/2-250,this.getHeight()/4-55,500,500);
        this.labelimagenTabla.setIcon(new ImageIcon(
                this.imageIconimagenTabla.getImage().
                        getScaledInstance(500,500,Image.SCALE_SMOOTH)));



    }

    public void limpiarTabla(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.println("Limpiando casilla numero: "+this.tabla[i][j].getNumero());
                this.tabla[i][j].limpiarCasilla();

            }
        }

    }
    public void volverACargarTabla(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.println("Volviendo a cargar casilla numero: "+this.tabla[i][j].getNumero());
                this.add(tabla[i][j],0);

            }
        }

    }

    public void cargarTabla(){

        tabla= new Casilla[3][3];

        int contador=0;
        int x=this.getWidth()/2-250;
        int y=this.getHeight()/4-55;
        int tamano = 120;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.println("Cargando la casilla numero: "+contador);
                this.tabla[i][j] = new Casilla(contador,x+20,y+20,tamano);
                this.add(tabla[i][j],0);
                System.out.println("Contenido numero: "+this.tabla[i][j].getNumero());
                x+=tamano+50;
                contador+=1;
            }
            y+=tamano+50;
            x=this.getWidth()/2-250;

        }
    }

    public void inicializarMarcador(){
        this.jugador1 = new JLabel("Jugador 1:");
        jugador1.setFont(new Font("Arial",Font.BOLD,30));
        jugador1.setBounds(50,20,200,50);
        jugador1.setForeground(Color.WHITE);
        this.add(jugador1,0);

        this.jugador2 = new JLabel("Jugador 2:");
        jugador2.setFont(new Font("Arial",Font.BOLD,30));
        jugador2.setBounds(900,20,200,50);
        jugador2.setForeground(Color.WHITE);
        this.add(jugador2,0);

    }

    public void cargarMarcador(int j1, int j2){
        this.jugador1.setText("Jugador 1:"+j1);
        this.add(jugador1,0);

        this.jugador2.setText("Jugador 2:"+j2);
        this.add(jugador2,0);

        this.updateUI();
    }

    public void borrarMarcador(){
        this.remove(jugador1);
        this.remove(jugador2);
    }



}
