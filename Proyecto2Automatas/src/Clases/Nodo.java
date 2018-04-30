/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 * Clase nodo que contiene todos mis atributos para mis estados
 * @author mynor
 */
public class Nodo {
    //Declaración del los atributos de mis estados
    private ArrayList<Integer> MoverA;
    private ArrayList<String> CompararCon;
    private boolean Aceptado;
    /**
     * Constructos inicializa los atributos de los estados
     */
    public Nodo() {
        MoverA = new ArrayList<>();
        CompararCon = new ArrayList<>();
        Aceptado = false;
    }
    //De acá para abajo son Getters y Setters
    public ArrayList<Integer> getMoverA() {
        return MoverA;
    }

    public void setMoverA(ArrayList<Integer> MoverA) {
        this.MoverA = MoverA;
    }

    public ArrayList<String> getCompararCon() {
        return CompararCon;
    }

    public void setCompararCon(ArrayList<String> CompararCon) {
        this.CompararCon = CompararCon;
    }

    public boolean isAceptado() {
        return Aceptado;
    }

    public void setAceptado(boolean Aceptado) {
        this.Aceptado = Aceptado;
    }

}
