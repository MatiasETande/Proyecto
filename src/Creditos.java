import javax.swing.*;
import java.awt.*;

public class Creditos extends JPanel {



    private JLabel text;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JButton salir;
    private ImageIcon imagenBoton = new ImageIcon("src/imgPoyecto/boton3.png");

    public Creditos(int x, int y, int width, int height){
        super();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        //this.setBackground(Color.ORANGE);
        this.setOpaque(false);

        this.iniciarCreditos();
        this.iniciarBotonSalir();

    }

    //Getters and Setters


    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public JLabel getText1() {
        return text1;
    }

    public void setText1(JLabel text1) {
        this.text1 = text1;
    }

    public JLabel getText2() {
        return text2;
    }

    public void setText2(JLabel text2) {
        this.text2 = text2;
    }

    public JLabel getText3() {
        return text3;
    }

    public void setText3(JLabel text3) {
        this.text3 = text3;
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

    public void iniciarBotonSalir(){
        this.salir = new JButton("  Salir");
        this.inicializarBoton(salir,600-75,500,150,150);
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
        text.setBounds(25,50,150,50);
        text.setForeground(Color.lightGray);

        unBoton.add(text);

    }

    public void iniciarCreditos(){

        this.text=new JLabel("Proyecto realizado por:",SwingConstants.CENTER);
        this.text.setLayout(null);
        this.text.setBounds(350,120,500,100);
        this.text.setFont(new Font("Arial",Font.BOLD,30));
        this.text.setForeground(Color.lightGray);
        this.text.setOpaque(false);
        this.text.setBackground(Color.GREEN);
        this.add(text);

        this.text1=new JLabel("Mazza Bruno",SwingConstants.CENTER);
        this.text1.setLayout(null);
        this.text1.setBounds(350,170,500,100);
        this.text1.setFont(new Font("Arial",Font.BOLD,30));
        this.text1.setForeground(Color.lightGray);
        this.text1.setOpaque(false);
        this.text1.setBackground(Color.GREEN);
        this.add(text1);


        this.text2=new JLabel("Tande Matias",SwingConstants.CENTER);
        this.text2.setLayout(null);
        this.text2.setBounds(350,220,500,100);
        this.text2.setFont(new Font("Arial",Font.BOLD,30));
        this.text2.setForeground(Color.lightGray);
        this.text2.setOpaque(false);
        this.text2.setBackground(Color.GREEN);
        this.add(text2);

        this.text3=new JLabel("Lab. Computacion II 2022",SwingConstants.CENTER);
        this.text3.setLayout(null);
        this.text3.setBounds(350,270,500,100);
        this.text3.setFont(new Font("Arial",Font.BOLD,30));
        this.text3.setForeground(Color.lightGray);
        this.text3.setOpaque(false);
        this.text3.setBackground(Color.GREEN);
        this.add(text3);
    }




}
