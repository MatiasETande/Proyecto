import javax.swing.*;
import java.awt.*;

public class Fondo extends JPanel {

    private ImageIcon iconImagenDeFondo;
    private JLabel labelImagenDeFondo;

    public Fondo(int x, int y, int width, int height){
        super();
        this.setLayout(null);
        this.setBounds(0,0,width,height);
        this.setBackground(Color.BLACK);

        this.inicializarimagenDeFondo("src/imgPoyecto/fondoPizarra3.jpg");

        this.add(this.labelImagenDeFondo);

    }

    //Getters and Setters

    //Metodos

    public void inicializarimagenDeFondo(String root){

        this.iconImagenDeFondo= new ImageIcon(root);
        this.labelImagenDeFondo= new JLabel();
        this.labelImagenDeFondo.setBounds(0,0,this.getWidth(),this.getHeight());
        this.labelImagenDeFondo.setIcon(new ImageIcon(
                                        this.iconImagenDeFondo.getImage().
                                        getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH)));



    }



}
