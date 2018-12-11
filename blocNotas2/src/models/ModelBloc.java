/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.ViewBloc;

/**
 *variables
 * @author Ricardo - VAIO
 */
public class ModelBloc {
    ViewBloc viewbloc;
    private String path;
    private String mensage = "";
    boolean condicion = false;

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }
    
    /**
     * lee el archivo por la ruta que se especifique
     */
    public void leer(){
        try{
            String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        mensage = mensage + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        }catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operation" + ex.getMessage());
        }
    }
    /**
     * escribe en el archivo
     */
    public void escribir(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter (file,condicion);
            try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                printWriter.print(mensage);
                printWriter.close();
            }
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
    /**
     * abre el archivo
     */
    public void abrir(){
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        choose.showOpenDialog(viewbloc);
        File archivo = choose.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewbloc, "File not found: ");
        }
        else
            path = archivo.getAbsolutePath();
    }

}
