package server;

import java.io.File;
//se importaron las librerias java rmi
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//se importo la libreria RMInterface
import rmiinterface.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {
    //se implemento un metodo remoto
    protected ServerOperation() throws RemoteException {
        super();
    }
//se implemento el metodo helloTo
    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }
    @Override
    public ArrayList<String> obtenerArchivos(String ruta) throws RemoteException {
        //Carpeta del usuario
        String sCarpAct = ruta;
        //String sCarpAct = "C:\\Proyectos\\";
        System.err.println("Carpeta del usuario = " + sCarpAct);

        ArrayList<String> directorios  = new ArrayList<String>();

        File carpeta = new File(sCarpAct);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            directorios.add("No hay elementos dentro de la carpeta actual");
        }
        else {
            for (int i=0; i< listado.length; i++) {
                directorios.add(listado[i]);
            }
        }
        return directorios;
    }

//se implemento una clase principal
    public static void main(String[] args) {

//se coloco un Try-catch para devolver valores
        try {
            Naming.rebind("//85.187.158.121:1099/MyServer", new ServerOperation());
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
