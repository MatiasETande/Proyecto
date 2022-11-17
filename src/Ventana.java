import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    private Fondo fondo;
    private Menu miMenu;
    private Juego miJuego;
    private PanelEstadisticas mipanelEstadisticas;
    private Creditos miscreditos;

    public Ventana(){
        super();

        this.setSize(1200,800);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Tres en Raya");
        this.setLocationRelativeTo(null);

        //Cargo el fondo de la pantalla
        this.fondo= new Fondo(0,0,this.getWidth(),this.getHeight());

        miMenu = new Menu(this.fondo.getWidth()/2-85,this.fondo.getHeight()/4-75);
        this.cargarMenu();

        //Probando barras
        this.mipanelEstadisticas=new PanelEstadisticas(0,0,this.getWidth(),this.getHeight());
        this.mipanelEstadisticas.getSalir().addActionListener(this);
        //this.fondo.add(mipanelEstadisticas,0);
        //this.fondo.updateUI();

        this.miscreditos=new Creditos(0,0,this.getWidth(),this.getHeight());
        this.miscreditos.getSalir().addActionListener(this);
        //this.fondo.add(miscreditos,0);

        this.getContentPane().add(fondo);
        this.fondo.updateUI();

        //juego
        miJuego = new Juego(0,0,this.fondo.getWidth(),this.fondo.getHeight());
        this.miMenu.getJugar().addActionListener(this);
        this.miMenu.getEstadisticas().addActionListener(this);
        this.miMenu.getCreditos().addActionListener(this);
        this.miMenu.getSalir().addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    //Getters and Setters


    public PanelEstadisticas getMipanelEstadisticas() {
        return mipanelEstadisticas;
    }

    public void setMipanelEstadisticas(PanelEstadisticas mipanelEstadisticas) {
        this.mipanelEstadisticas = mipanelEstadisticas;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    public Menu getMiMenu() {
        return miMenu;
    }

    public void setMiMenu(Menu miMenu) {
        this.miMenu = miMenu;
    }

    public Juego getMiJuego() {
        return miJuego;
    }

    public void setMiJuego(Juego miJuego) {
        this.miJuego = miJuego;
    }

    public void cargarMenu(){
       this.fondo.add(miMenu,0);
       this.fondo.updateUI();
   }

    public void jugar(){
        this.miJuego.limpiarTabla();
        this.fondo.add(miJuego,0);
        this.getMiJuego().borrarMarcador();
        this.getMiJuego().inicializarMarcador();
        this.fondo.updateUI();
    }

    public void reinicio(){
        this.fondo.remove(miMenu);
        this.jugar();
        this.getContentPane().add(fondo);
        this.getMiJuego().volverACargar();
        this.getMiJuego().volverACargarTabla();
        this.getMiJuego().cargarSalir();
        this.fondo.updateUI();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Object unBotonDelMenu = e.getSource();

        if (this.miMenu.getJugar().equals(unBotonDelMenu)) {
            System.out.println("Estoy aca");
            this.reinicio();
            this.getMiJuego().inicializarMarcador();
        } else if (this.miMenu.getEstadisticas().equals(unBotonDelMenu)) {
            //Probando barras
            this.fondo.remove(miMenu);
            this.fondo.add(mipanelEstadisticas,0);
            this.fondo.updateUI();

        } else if (this.miMenu.getCreditos().equals(unBotonDelMenu)) {
            this.fondo.remove(miMenu);
            this.fondo.add(miscreditos,0);
            this.fondo.updateUI();
        } else if (this.miMenu.getSalir().equals(unBotonDelMenu)) {
            System.exit(0);
        }else if (this.mipanelEstadisticas.getSalir().equals(unBotonDelMenu)){
            this.fondo.remove(this.mipanelEstadisticas);
            this.cargarMenu();

        }else if (this.miscreditos.getSalir().equals(unBotonDelMenu)){
            System.out.println("Estoy en menu se cargo bien de creditos");
            this.fondo.remove(this.miscreditos);
            this.cargarMenu();
        }




    }
}
