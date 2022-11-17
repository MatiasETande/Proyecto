import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TresEnRaya implements ActionListener {

    private int[][] tabla = new int[3][3];
    private Ventana unaVentana;
    private int turno;
    private int ganador=-1;
    private int j1=0;
    private int j2=0;
    private int empate=0;
    private Serializacion serializacion;
    private Estadisticas estadisticas;


    public TresEnRaya(){
        this.serializacion=new Serializacion();
        unaVentana=new Ventana();
        this.inicializandoTabla();
        cargarActionListenerBotones();
        this.unaVentana.getMiJuego().getSalir().addActionListener(this);
        this.unaVentana.getMiJuego().getVolverAJugar().addActionListener(this);

        //Archivos
        //this.serializacion.escribir(estadisticas);
        this.estadisticas=this.serializacion.leer();

        System.out.println("J1: "+this.estadisticas.getGanoJugador1());
        System.out.println("J1: "+this.estadisticas.getGanoJugador2());
        System.out.println("Empate: "+this.estadisticas.getEmpate());

        //ocupar esto en esatadisticas
        this.unaVentana.getMiMenu().getEstadisticas().addActionListener(this);
        //this.actualizarEstadisticas(this.estadisticas.porcentajeGanoJugador1(),this.estadisticas.porcentajeGanoJugador2(),this.estadisticas.porcentajeEmpate());

        //System.out.println("J1: "+this.serializacion.leer().getGanoJugador1());

    }

    public void actualizarEstadisticas(int j1, int j2, int empates){
        this.unaVentana.getMipanelEstadisticas().actualizarPorcentajes(j1, j2, empates);
    }

    public void actualizarFichero(int j1, int j2, int empate){
        this.estadisticas.actualizar(j1,j2,empate);
        this.serializacion.escribir(this.estadisticas);
        this.estadisticas=this.serializacion.leer();
    }

    public void cargarActionListenerBotones(){

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                this.unaVentana.getMiJuego().getTabla()[i][j].addActionListener(this);
            }
        }
    }


    public void inicializandoTabla(){
        this.turno=1;
        this.ganador=-1;
        this.unaVentana.getMiJuego().borrarMarcador();
        this.unaVentana.getMiJuego().cargarMarcador(j1,j2);
        this.unaVentana.getFondo().updateUI();
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                this.tabla[i][j]=1+(i+1)*2+(j+1)*3;
            }

        }
    }

    public void mostrarTabla(){
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print("\t"+this.tabla[i][j]);;
            }
            System.out.println("\n");
        }
    }

    public boolean comprobarLinea(int x){

        if (this.tabla[x][0] == this.tabla[x][1] && this.tabla[x][0] == this.tabla[x][2] ){
            this.ganador=this.tabla[x][0];
            return true;
        }else {
            return false;
        }
    }

    public boolean comprobarLineas(){

        if (comprobarLinea(0) || comprobarLinea(1) || comprobarLinea(2) ){
            return true;
        }else {
            return false;
        }


    }

    public boolean comprobarColumna(int y){

        if (this.tabla[0][y] == this.tabla[1][y] && this.tabla[0][y] == this.tabla[2][y] ){
            this.ganador=this.tabla[0][y];
            return true;
        }else {
            return false;
        }
    }

    public boolean comprobarColumnas(){

        if (comprobarColumna(0) || comprobarColumna(1) || comprobarColumna(2) ){
            return true;
        }else {
            return false;
        }


    }

    public boolean comprobarDiagonales(){
        if ((this.tabla[0][0] == this.tabla[1][1] && this.tabla[0][0] == this.tabla[2][2])
                || (this.tabla[2][0] == this.tabla[1][1] && this.tabla[2][0] == this.tabla[0][2]) ){
            this.ganador=this.tabla[1][1];
            return true;
        }else {
            return false;
        }

    }

    public boolean comprobarTresEnRaya(){

        if (this.comprobarColumnas() || this.comprobarLineas() || this.comprobarDiagonales()){
            return true;
        }else {
            return false;
        }
    }


    public void comprobarEstado(int x, int y, Casilla botonPulsado){
        if ((this.turno % 2 ==0) && (this.tabla[x][y]!=2) && (this.tabla[x][y]!=1) ){
            this.tabla[x][y]=2;
            System.out.println("soy la casilla numero: "+botonPulsado.getNumero());
            this.mostrarTabla();
            this.unaVentana.getMiJuego().getTabla()[x][y].marcarCasilla(2);
            turno+=1;
        }else{
            if((this.turno % 2 !=0) && (this.tabla[x][y]!=2) && (this.tabla[x][y]!=1)){
                this.tabla[x][y] = 1;
                System.out.println("soy la casilla numero: " + botonPulsado.getNumero());
                this.mostrarTabla();
                this.unaVentana.getMiJuego().getTabla()[x][y].marcarCasilla(1);
                turno+=1;
            }
        }
    }

    public void comprobarEmpate(){
        if (this.turno==10 && !this.comprobarTresEnRaya() && this.ganador==-1){
            this.ganador=0;
            this.empate+=1;
            this.unaVentana.getMiJuego().cargarVolverAJugar();
            this.unaVentana.getMiJuego().borrarMarcador();
            this.unaVentana.getMiJuego().cargarMarcador(j1,j2);
            this.unaVentana.getFondo().updateUI();
            this.actualizarFichero(0,0,1);
            System.out.println("EMPATE SEÑORES: "+this.empate);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        Object unBoton= e.getSource();
        System.out.println("ATurno:"+this.turno);

        if(unBoton.equals(this.unaVentana.getMiMenu().getEstadisticas())) {
            System.out.println("Estoy en el if de estadisticas dentro de la tresRaya");
            this.actualizarEstadisticas(this.estadisticas.porcentajeGanoJugador1(),this.estadisticas.porcentajeGanoJugador2(),this.estadisticas.porcentajeEmpate());

            System.out.println("j1: "+this.estadisticas.porcentajeGanoJugador1());
            System.out.println("j2: "+this.estadisticas.porcentajeGanoJugador2());
            System.out.println("empates: "+this.estadisticas.porcentajeEmpate());
            System.out.println("j1: "+this.estadisticas.getGanoJugador1());
            System.out.println("j2: "+this.estadisticas.getGanoJugador2());
            System.out.println("empates: "+this.estadisticas.getEmpate());
        }else{
            if (unBoton.equals(this.unaVentana.getMiJuego().getSalir())) {
                //System.exit(0);
                this.turno = 0;
                this.inicializandoTabla();
                this.unaVentana.getMiJuego().limpiarJuego();
                this.unaVentana.remove(this.unaVentana.getMiJuego());
                this.unaVentana.cargarMenu();
                this.unaVentana.getFondo().updateUI();
                this.j1 = 0;
                this.j2 = 0;
                this.empate = 0;
            } else {

                if (unBoton.equals(this.unaVentana.getMiJuego().getVolverAJugar())) {
                    this.inicializandoTabla();
                    this.unaVentana.getMiJuego().limpiarJuego();
                    this.unaVentana.remove(this.unaVentana.getMiJuego());
                    this.unaVentana.reinicio();
                    this.unaVentana.getMiJuego().borrarMarcador();
                    this.unaVentana.getMiJuego().cargarMarcador(j1, j2);
                    this.unaVentana.getFondo().updateUI();
                } else {

                    if (!this.comprobarTresEnRaya()) {

                        Casilla botonPulsado = (Casilla) e.getSource();
                        System.out.println("Estamos aqui TresEnRaya");

                        switch (botonPulsado.getNumero()) {

                            case 0: {
                                comprobarEstado(0, 0, botonPulsado);
                                break;

                            }
                            case 1: {
                                comprobarEstado(0, 1, botonPulsado);
                                break;
                            }

                            case 2: {
                                comprobarEstado(0, 2, botonPulsado);
                                break;
                            }
                            case 3: {
                                comprobarEstado(1, 0, botonPulsado);
                                break;
                            }

                            case 4: {
                                comprobarEstado(1, 1, botonPulsado);
                                break;
                            }
                            case 5: {
                                comprobarEstado(1, 2, botonPulsado);
                                break;
                            }
                            case 6: {
                                comprobarEstado(2, 0, botonPulsado);
                                break;
                            }
                            case 7: {
                                comprobarEstado(2, 1, botonPulsado);
                                break;
                            }
                            case 8: {
                                comprobarEstado(2, 2, botonPulsado);
                                break;
                            }
                            default:
                                System.out.println("Nose que paso");
                                break;

                        }
                        if (this.comprobarTresEnRaya()) {
                            this.unaVentana.getMiJuego().cargarVolverAJugar();

                            if (this.ganador == 1) {
                                System.out.println("Gano el jugador numero 1 ");
                                this.j1 += 1;
                                this.actualizarFichero(1, 0, 0);
                            } else {
                                System.out.println("Gano el jugador numero 2 ");
                                this.j2 += 1;
                                this.actualizarFichero(0, 1, 0);
                            }
                            this.unaVentana.getMiJuego().borrarMarcador();
                            this.unaVentana.getMiJuego().cargarMarcador(j1, j2);
                            this.unaVentana.getFondo().updateUI();
                        }

                    } else {

                        this.mostrarTabla();


                    }
                }
            }
        }

        System.out.println("ATurno:"+this.turno);
        this.comprobarEmpate();
        System.out.println("J1: "+this.estadisticas.getGanoJugador1());
        System.out.println("J1: "+this.estadisticas.getGanoJugador2());
        System.out.println("Empate: "+this.estadisticas.getEmpate());
    }





}