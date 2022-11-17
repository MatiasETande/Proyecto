import java.io.*;

public class Serializacion {

    private ObjectOutputStream escFichero;
    private ObjectInputStream lecFichero;

    public Serializacion(){

    }

    public void inicializandoEscFichero(){
        try {
            this.escFichero= new ObjectOutputStream(new FileOutputStream("src/ficherosProyecto/datos.dat"));

        }catch (IOException e){
            //error al intentar Escribir el fichero
            //e.printStackTrace();
        }
    }

    public void escribir(Estadisticas estadisticas){
        this.inicializandoEscFichero();
        try {
            this.escFichero.writeObject(estadisticas);
            this.escFichero.close();
        } catch (IOException e) {
            System.out.println("Error al intentar escribir");
            //e.printStackTrace();
        }
    }

    public void inicializandoLecFichero(){
        try {
            this.lecFichero= new ObjectInputStream(new FileInputStream("src/ficherosProyecto/datos.dat"));

        }catch (IOException e){
            //error al intentar leer el fichero
            System.out.println("Error al leer el archivo");
            this.escribir(new Estadisticas());
            this.inicializandoLecFichero();
            //e.printStackTrace();
        }
    }

    public Estadisticas leer(){
        this.inicializandoLecFichero();
        Estadisticas unaEstadistica = new Estadisticas();
        try {
            unaEstadistica=(Estadisticas) this.lecFichero.readObject();
            this.lecFichero.close();
            return unaEstadistica;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al intentar leer");
            //e.printStackTrace();
        }

        return unaEstadistica;
    }






}
