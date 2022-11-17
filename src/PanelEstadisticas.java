import javax.swing.*;
import java.awt.*;

public class PanelEstadisticas extends JPanel {

    private JLabel barraJ1;
    private JLabel barraJ2;
    private JLabel barraEmpates;
    private JLabel barraJ1Pintado;
    private JLabel barraJ2Pintado;
    private JLabel barraEmpatesPintado;
    private ImageIcon barraPintada = new ImageIcon("src/imgPoyecto/barraPintado2.png");
    private ImageIcon barraSinPintar = new ImageIcon("src/imgPoyecto/barraSinPintar2.png");
    private JLabel textJ1;
    private JLabel textJ2;
    private JLabel textEmpate;
    private JButton salir;
    private ImageIcon imagenBoton = new ImageIcon("src/imgPoyecto/boton3.png");

    public PanelEstadisticas(int x, int y, int width, int height){
        super();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setBackground(Color.ORANGE);
        this.setOpaque(false);
        //this.setBackground(Color.orange);

        this.inicializarBarras();
        //this.actualizarPorcentajes(20,0,80);
        this.cargartexto();
        this.iniciarBotonSalir();

    }

    //Getters and Setters


    public JLabel getBarraJ1() {
        return barraJ1;
    }

    public void setBarraJ1(JLabel barraJ1) {
        this.barraJ1 = barraJ1;
    }

    public JLabel getBarraJ2() {
        return barraJ2;
    }

    public void setBarraJ2(JLabel barraJ2) {
        this.barraJ2 = barraJ2;
    }

    public JLabel getBarraEmpates() {
        return barraEmpates;
    }

    public void setBarraEmpates(JLabel barraEmpates) {
        this.barraEmpates = barraEmpates;
    }

    public JLabel getBarraJ1Pintado() {
        return barraJ1Pintado;
    }

    public void setBarraJ1Pintado(JLabel barraJ1Pintado) {
        this.barraJ1Pintado = barraJ1Pintado;
    }

    public JLabel getBarraJ2Pintado() {
        return barraJ2Pintado;
    }

    public void setBarraJ2Pintado(JLabel barraJ2Pintado) {
        this.barraJ2Pintado = barraJ2Pintado;
    }

    public JLabel getBarraEmpatesPintado() {
        return barraEmpatesPintado;
    }

    public void setBarraEmpatesPintado(JLabel barraEmpatesPintado) {
        this.barraEmpatesPintado = barraEmpatesPintado;
    }

    public ImageIcon getBarraPintada() {
        return barraPintada;
    }

    public void setBarraPintada(ImageIcon barraPintada) {
        this.barraPintada = barraPintada;
    }

    public ImageIcon getBarraSinPintar() {
        return barraSinPintar;
    }

    public void setBarraSinPintar(ImageIcon barraSinPintar) {
        this.barraSinPintar = barraSinPintar;
    }

    public JLabel getTextJ1() {
        return textJ1;
    }

    public void setTextJ1(JLabel textJ1) {
        this.textJ1 = textJ1;
    }

    public JLabel getTextJ2() {
        return textJ2;
    }

    public void setTextJ2(JLabel textJ2) {
        this.textJ2 = textJ2;
    }

    public JLabel getTextEmpate() {
        return textEmpate;
    }

    public void setTextEmpate(JLabel textEmpate) {
        this.textEmpate = textEmpate;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public ImageIcon getImagenBoton() {
        return imagenBoton;
    }

    public void setImagenBoton(ImageIcon imagenBoton) {
        this.imagenBoton = imagenBoton;
    }

    public void cargartexto(){

        this.textJ1 = new JLabel("J1");
        textJ1.setFont(new Font("Arial",Font.BOLD,30));
        textJ1.setBounds(180,200,150,50);
        textJ1.setForeground(Color.lightGray);
        this.add(textJ1);

        this.textJ2 = new JLabel("J2");
        textJ2.setFont(new Font("Arial",Font.BOLD,30));
        textJ2.setBounds(180,300,150,50);
        textJ2.setForeground(Color.lightGray);
        this.add(textJ2);

        this.textEmpate = new JLabel("Empate");
        textEmpate.setFont(new Font("Arial",Font.BOLD,30));
        textEmpate.setBounds(180,400,200,50);
        textEmpate.setForeground(Color.lightGray);
        this.add(textEmpate);

    }
    public void cargarBotonSalir(){

    }

    public void iniciarBotonSalir(){
        this.salir = new JButton("  Salir");
        this.inicializarBoton(salir,550,500,170,170);
        this.add(this.salir);
    }

    private void inicializarBoton(JButton unBoton, int x, int y, int width, int height){

        unBoton.setBounds(x,y,width,height);
        unBoton.setLayout(null);

        unBoton.setIcon(new ImageIcon(this.imagenBoton.getImage().getScaledInstance(unBoton.getWidth(),unBoton.getHeight(), Image.SCALE_SMOOTH)));
        unBoton.setOpaque(false);
        unBoton.setContentAreaFilled(false);
        unBoton.setBorderPainted(false);

        JLabel text = new JLabel(unBoton.getText());
        text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(35,60,150,50);
        text.setForeground(Color.lightGray);

        unBoton.add(text);

    }

    public void actualizarPorcentajes(int porcentajeJ1, int porcentajeJ2, int porcentajeEmpate){
        int equivalencia= 600/100;
        this.barraJ1Pintado.setBounds(400,200,equivalencia*porcentajeJ1,50);
        this.barraJ1Pintado.setForeground(Color.GREEN);
        //this.barraJ1Pintado.setLayout(null);
        this.barraJ1Pintado.setFont(new Font("Arial",Font.BOLD,30));
        this.barraJ1Pintado.setText(porcentajeJ1+"%");


        this.barraJ2Pintado.setBounds(400,300,equivalencia*porcentajeJ2,50);
        this.barraJ2Pintado.setText(porcentajeJ2+"%");

        this.barraEmpatesPintado.setBounds(400,400,equivalencia*porcentajeEmpate,50);
        this.barraEmpatesPintado.setText(porcentajeEmpate+"%");

        this.textJ1.setText("J1: "+porcentajeJ1+"%");
        this.textJ2.setText("J2: "+porcentajeJ2+"%");
        this.textEmpate.setText("Empate: "+porcentajeEmpate+"%");

    }

    public void inicializarBarras(){

        //barras sin pintar
        this.barraJ1=new JLabel();
        this.barraJ1.setBounds(400,200,600,50);
        this.barraJ1.setIcon(new ImageIcon(this.barraSinPintar.getImage().getScaledInstance(this.barraJ1.getWidth(),this.barraJ1.getHeight(), Image.SCALE_SMOOTH)));
        this.barraJ1.setBackground(Color.lightGray);
        this.add(this.barraJ1);

        this.barraJ2=new JLabel();
        this.barraJ2.setBounds(400,300,600,50);
        this.barraJ2.setIcon(new ImageIcon(this.barraSinPintar.getImage().getScaledInstance(this.barraJ2.getWidth(),this.barraJ2.getHeight(), Image.SCALE_SMOOTH)));
        this.barraJ2.setBackground(Color.lightGray);
        this.add(this.barraJ2);


        this.barraEmpates=new JLabel();
        this.barraEmpates.setBounds(400,400,600,50);
        this.barraEmpates.setIcon(new ImageIcon(this.barraSinPintar.getImage().getScaledInstance(this.barraEmpates.getWidth(),this.barraEmpates.getHeight(), Image.SCALE_SMOOTH)));
        this.barraEmpates.setBackground(Color.lightGray);
        this.add(this.barraEmpates);

        //barras pintadas
        this.barraJ1Pintado=new JLabel();
        this.barraJ1Pintado.setBounds(400,200,50,50);
        this.barraJ1Pintado.setIcon(new ImageIcon(this.barraPintada.getImage().getScaledInstance(this.barraJ1.getWidth(),this.barraJ1.getHeight(), Image.SCALE_SMOOTH)));
        this.barraJ1Pintado.setBackground(Color.lightGray);
        this.add(this.barraJ1Pintado);

        this.barraJ2Pintado=new JLabel();
        this.barraJ2Pintado.setBounds(400,300,150,50);
        this.barraJ2Pintado.setIcon(new ImageIcon(this.barraPintada.getImage().getScaledInstance(this.barraEmpates.getWidth(),this.barraEmpates.getHeight(), Image.SCALE_SMOOTH)));
        this.barraJ2Pintado.setBackground(Color.lightGray);
        this.add(this.barraJ2Pintado);

        this.barraEmpatesPintado=new JLabel();
        this.barraEmpatesPintado.setBounds(400,400,300,50);
        this.barraEmpatesPintado.setIcon(new ImageIcon(this.barraPintada.getImage().getScaledInstance(this.barraEmpates.getWidth(),this.barraEmpates.getHeight(), Image.SCALE_SMOOTH)));
        this.barraEmpatesPintado.setBackground(Color.lightGray);
        this.add(this.barraEmpatesPintado);
    }


}
