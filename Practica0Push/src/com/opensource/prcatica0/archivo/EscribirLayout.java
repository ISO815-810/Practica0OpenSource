package com.opensource.prcatica0.archivo;

import com.opensource.practica0.application.ManejandoArchivo;
import static com.opensource.practica0.conexion.Consultas.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class EscribirLayout {

    static ManejandoArchivo manejandoArchivo = new ManejandoArchivo();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        System.out.println("Sr. Usuario escriba la ruta del archivo!");
//        String vRuta = sc.next();
        System.out.println("Sr. Usuario escriba el nombre del archivo!");
        String vNombreArchivo = sc.next();

        System.out.println("Sr. Usuario, Ingrese la fecha de nomina");
        String vFechaCorte = sc.next();

        System.out.println("Generando Archivo...\n");

        try {

            BufferedWriter vBW = new BufferedWriter(new FileWriter(manejandoArchivo
                    .crearArchivo(vNombreArchivo)));

            List<String> encabezado = getEncabezado(vFechaCorte);
            List<String> detalles = getDetalles(vFechaCorte);
            List<String> sumarios = getSumario(vFechaCorte);

            for (int i = 0; i < encabezado.size(); i++) {
                vBW.write(encabezado.get(i));
                vBW.newLine();
            }
            for (int i = 0; i < detalles.size(); i++) {
                vBW.write(detalles.get(i));
                vBW.newLine();
            }
            for (int i = 0; i < sumarios.size(); i++) {
                vBW.write(sumarios.get(i));
                vBW.newLine();
            }

            vBW.close();
            System.out.println("\nArchivo Generado con exito!!!");
        } catch (IOException e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

    }
}
