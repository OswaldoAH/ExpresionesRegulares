/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mynor
 */
public class Generar_Grafica {

    public boolean SetER(String expresion) {
        try {
            File ar = new File("Automata.jpg");
            if (ar.exists()) {
                ar.delete();
            }
            FileOutputStream archivo;
            archivo = new FileOutputStream("Automata.txt");
            RegExp r = new RegExp(expresion);
            Automaton a = r.toAutomaton();
            byte[] array = a.toDot().getBytes();
            try (DataOutputStream stream = new DataOutputStream(archivo)) {
                stream.write(array);
            }
            archivo.close();
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "Automata.txt";
            String fileOutputPath = "Automata.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generar_Grafica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Generar_Grafica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
