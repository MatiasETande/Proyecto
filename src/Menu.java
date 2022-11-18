import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {

    private ImageIcon imagenBoton = new ImageIcon("src/imgPoyecto/boton1.png");
    private JButton jugar;
    private JButton estadisticas;
    private JButton creditos;
    private JButton salir;

    public Menu(int x, int y){
        super();

        this.inicializandoBotones();
        this.setLayout(null);
        this.setBounds(x,y,300,800);
        this.setBackground(Color.orange);
        this.setOpaque(false);

        this.add(jugar);
        this.add(estadisticas);
        this.add(creditos);
        this.add(salir);



    }

    //Getters and Setters

    public JButton getJugar() {
        return jugar;
    }

    public void setJugar(JButton jugar) {
        this.jugar = jugar;
    }

    public JButton getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(JButton estadisticas) {
        this.estadisticas = estadisticas;
    }

    public JButton getCreditos() {
        return creditos;
    }

    public void setCreditos(JButton creditos) {
        this.creditos = creditos;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }


    //Metodos

    private void inicializandoBotones(){

        int width=200;
        int height=125;

        this.jugar = new JButton(" Jugar");
        this.inicializarBoton(jugar,0,0,width,height);


        this.estadisticas = new JButton(" Estad.");
        this.inicializarBoton(estadisticas,0,height+20,width,height);

        this.creditos = new JButton("Creditos");
        this.inicializarBoton(creditos,0,(height+20)*2,width,height);

        this.salir = new JButton("  Salir");
        this.inicializarBoton(salir,0,(height+20)*3,width,height);


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
        text.setBounds(35,35,150,50);
        text.setForeground(Color.lightGray);

        unBoton.add(text);

    }


   
}
