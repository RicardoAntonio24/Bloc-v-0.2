/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewBloc;
import models.ModelBloc;
import controllers.ControllerBloc;

/**
 *
 * @author Ricardo - VAIO
 */
public class Main {
    private static ViewBloc viewBloc;
    private static ModelBloc modelBloc;
    private static ControllerBloc controllerBloc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewBloc viewBloc = new ViewBloc();
        ModelBloc modelBloc = new ModelBloc();
        ControllerBloc controllerBloc = new ControllerBloc(viewBloc, modelBloc);  
    }  
}
