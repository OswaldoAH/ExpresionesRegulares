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
public class ValidarPalabra {

    private String palabra;
    private ArrayList<Nodo> grafo;

    public ValidarPalabra() {
        grafo = new ArrayList<>();
    }

    public void insertar(char[] array) {
        ArrayList<Integer> moverA = new ArrayList<>();
        ArrayList<String> comparar = new ArrayList<>();
        int cont = 0;
        grafo.add(new Nodo());
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*' && array[i] != ')' && array[i] != '(' && array[i] != '|') {
                comparar = grafo.get(grafo.size() - 1).getCompararCon();
                moverA = grafo.get(grafo.size() - 1).getMoverA();
                moverA.add(grafo.size());
                comparar.add("" + array[i]);
                grafo.get(grafo.size() - 1).setCompararCon(comparar);
                grafo.get(grafo.size() - 1).setMoverA(moverA);
                grafo.add(new Nodo());
            } else if (array[i] == '*') {
                comparar = grafo.get(grafo.size() - 1).getCompararCon();
                moverA = grafo.get(grafo.size() - 1).getMoverA();
                moverA.add(grafo.size() - 1);
                comparar.add("" + array[i - 1]);
                grafo.get(grafo.size() - 1).setCompararCon(comparar);
                grafo.get(grafo.size() - 1).setMoverA(moverA);
            } else if (array[i] == '(') {
                i++;
                comparar = grafo.get(grafo.size() - 1).getCompararCon();
                moverA = grafo.get(grafo.size() - 1).getMoverA();
                moverA.add(grafo.size());
                comparar.add("" + array[i]);
                grafo.get(grafo.size() - 1).setCompararCon(comparar);
                grafo.get(grafo.size() - 1).setMoverA(moverA);
                grafo.add(new Nodo());
            } else if (array[i] == '|') {
                i++;
                comparar = grafo.get(grafo.size() - 2).getCompararCon();
                moverA = grafo.get(grafo.size() - 2).getMoverA();
                moverA.add(grafo.size() - 1);
                comparar.add("" + array[i]);
                grafo.get(grafo.size() - 2).setCompararCon(comparar);
                grafo.get(grafo.size() - 2).setMoverA(moverA);
            }
            if (i + 1 == array.length) {
                grafo.get(grafo.size() - 1).setAceptado(true);
            }
        }
        for (int i = 0; i < grafo.size(); i++) {
            System.out.println("------------------SIZE: " + i + "-------------------");
            moverA = grafo.get(i).getMoverA();
            comparar = grafo.get(i).getCompararCon();
            for (int j = 0; j < moverA.size(); j++) {
                System.out.println("mover a: " + moverA.get(j) + " y comparar con: " + comparar.get(j));
            }
            System.out.println("Aceptado: " + grafo.get(i).isAceptado());
        }
    }

    public boolean Buscar(char[] palabra) {
        boolean encontrado=false;
        int moverse = 0;
        ArrayList<Integer> moverA = new ArrayList<>();
        ArrayList<String> comparar = new ArrayList<>();
        for (int i = 0; i < palabra.length; i++) {
            encontrado = false;
            comparar = grafo.get(moverse).getCompararCon();
            moverA = grafo.get(moverse).getMoverA();
            for (int j = 0; j < comparar.size(); j++) {
                if (comparar.get(j).charAt(0)==palabra[i]) {
                    moverse = moverA.get(j);
                    encontrado = true;
                }
            }
            if(!encontrado){
                break;
            }
        }
        if(encontrado){
            return grafo.get(moverse).isAceptado();
        }else{
            return false;
        }
    }

}
