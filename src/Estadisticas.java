import java.io.Serializable;

public class Estadisticas implements Serializable {

    private int ganoJugador1;
    private int ganoJugador2;
    private int empate;

    public Estadisticas(){
        this.ganoJugador1=0;
        this.ganoJugador2=0;
        this.empate=0;
    }

    //Getters and Setters

    public int getGanoJugador1() {
        return ganoJugador1;
    }

    public void setGanoJugador1(int ganoJugador1) {
        this.ganoJugador1 = ganoJugador1;
    }

    public int getGanoJugador2() {
        return ganoJugador2;
    }

    public void setGanoJugador2(int ganoJugador2) {
        this.ganoJugador2 = ganoJugador2;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }


    //Metodos

    public void actualizar(int j1, int j2, int empate){

        this.empate+=empate;
        this.ganoJugador1+=j1;
        this.ganoJugador2+=j2;

    }


    @Override
    public String toString() {
        return "ganoJugador1=" + ganoJugador1 +
               ", ganoJugador2=" + ganoJugador2 +
               ", empate=" + empate;
    }

    public int totalPartidas(){
        return (this.empate+this.ganoJugador1+this.ganoJugador2);
    }

    public int porcentajeEmpate(){
        if(this.totalPartidas()==0){
            return 0;
        }else {
            return  (int)((100.0/this.totalPartidas())*this.empate);
        }
    }

    public int porcentajeGanoJugador1(){
        if(this.totalPartidas()==0){
            return 0;
        }else {
            return  (int) ((100.0/this.totalPartidas())*this.ganoJugador1);
        }
    }

    public int porcentajeGanoJugador2(){
        if(this.totalPartidas()==0){
            return 0;
        }else {
            return  (int)((100.0/this.totalPartidas())*this.ganoJugador2);
        }
    }


}
