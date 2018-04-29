/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author mynor
 */
public class Nodo {

    private ArrayList<Integer> MoverA;
    private ArrayList<String> CompararCon;
    private boolean Aceptado;

    public Nodo() {
        MoverA = new ArrayList<>();
        CompararCon = new ArrayList<>();
        Aceptado = false;
    }

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
