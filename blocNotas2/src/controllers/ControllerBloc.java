/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewBloc;
import models.ModelBloc;
/**
 *
 * @author Ricardo - VAIO
 */
public class ControllerBloc implements ActionListener {
    ModelBloc modelBloc;
    ViewBloc viewCBloc;
    public ControllerBloc(ViewBloc viewCBloc, ModelBloc modelBloc){
        this.viewCBloc = viewCBloc;
        this.modelBloc = modelBloc;
        this.viewCBloc.jmi_guardar.addActionListener(this);
        this.viewCBloc.jmi_abrir.addActionListener(this);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCBloc.jmi_abrir){
            abrir();
        } 
        else if(e.getSource() == viewCBloc.jmi_guardar){
            guardar();
        }
    }
    /**
     * lee el archivo
     */
    public void leer(){
        modelBloc.leer();
        viewCBloc.jta_texto.setText(modelBloc.getMensage());
    }
    /**
     * escrive los cambios en el archivo y los guarda
     */
    public void guardar(){
        modelBloc.setMensage(viewCBloc.jta_texto.getText());
        modelBloc.escribir();
    }
    private void initComponents(){
        viewCBloc.setVisible(true);
    }
    /**
     * abre un panel de navegacion en archivos
     */
    public void abrir(){
        modelBloc.abrir();
        leer();
    }
}