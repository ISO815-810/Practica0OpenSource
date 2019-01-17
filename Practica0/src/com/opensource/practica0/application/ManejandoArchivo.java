package com.opensource.practica0.application;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class ManejandoArchivo {

    public ManejandoArchivo() {

    }

    public File crearArchivo(String vArchivo) {

        try {
            String vRuta = "C://Users/Carlos/Desktop/PROGRAMACION Y DESARROLLO/JAVA/Proyectos JAVA/APAP/web/archivos/" + vArchivo + ".txt";

            File file = new File(vRuta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
