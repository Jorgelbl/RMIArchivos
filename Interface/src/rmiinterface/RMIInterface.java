package rmiinterface;

//se importaron las librerias java rmi
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface RMIInterface extends Remote {
    //se implemento un metodo remoto
    public String helloTo(String name) throws RemoteException;
    public ArrayList<String> obtenerArchivos(String ruta) throws RemoteException;
}
