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

    private final ArrayList<Nodo> grafo;
    private ArrayList<String> comparar;
    private ArrayList<Integer> moverA;

    public ValidarPalabra() {
        grafo = new ArrayList<>();
    }

    public void insertarConParentesis(char[] array) {
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        grafo.add(new Nodo());
        int aux = 0;
        boolean parentesis = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*' && array[i] != ')' && array[i] != '(') {
                caractes(array, i);
                if (parentesis) {
                    addEstados(grafo.size() - 2);
                }
            } else if (array[i] == '*') {
                EstrellaK(array, i);
            } else if (array[i] == '(') {
                aux = grafo.size() - 1;
                parentesis = true;
                while (array[i] != ')') {
                    i++;
                    comparar = grafo.get(aux).getCompararCon();
                    moverA = grafo.get(aux).getMoverA();
                    moverA.add(grafo.size());
                    comparar.add("" + array[i]);
                    grafo.get(aux).setCompararCon(comparar);
                    grafo.get(aux).setMoverA(moverA);
                    grafo.add(new Nodo());
                    i++;
                    while (array[i] != '|' && array[i] != ')') {
                        if (array[i] != '*') {
                            caractes(array, i);
                        } else {
                            EstrellaK(array, i);
                        }
                        i++;
                    }
                    Aceptado(array, i);
                }
                addEstados(aux);
            }
            Aceptado(array, i);
        }
        for (int i = 0; i < grafo.size(); i++) {
            System.out.println("------------------SIZE: " + i + "-------------------");
            moverA = grafo.get(i).getMoverA();
            comparar = grafo.get(i).getCompararCon();
            for (int k = 0; k < moverA.size(); k++) {
                System.out.println("mover a: " + moverA.get(k) + " y comparar con: " + comparar.get(k));
            }
            System.out.println("Aceptado: " + grafo.get(i).isAceptado());
        }
    }

    public void insertarSinParentesis(char[] array) {
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        grafo.add(new Nodo());
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*' && array[i] != '|') {
                caractes(array, i);
            } else if (array[i] == '*') {
                EstrellaK(array, i);
            } else if(array[i]=='|'){
                i++;
                moverA = new ArrayList<>();
                comparar = new ArrayList<>();
                comparar = grafo.get(0).getCompararCon();
                moverA = grafo.get(0).getMoverA();
                moverA.add(grafo.size());
                comparar.add("" + array[i]);
                grafo.get(0).setCompararCon(comparar);
                grafo.get(0).setMoverA(moverA);
                grafo.add(new Nodo());
            }
            Aceptado(array, i);
        }
        for (int j = 0; j < grafo.size(); j++) {
            if(grafo.get(j).getCompararCon().isEmpty()){
                grafo.get(j).setAceptado(true);
            }
        }
        for (int i = 0; i < grafo.size(); i++) {
            System.out.println("------------------SIZE: " + i + "-------------------");
            moverA = grafo.get(i).getMoverA();
            comparar = grafo.get(i).getCompararCon();
            for (int k = 0; k < moverA.size(); k++) {
                System.out.println("mover a: " + moverA.get(k) + " y comparar con: " + comparar.get(k));
            }
            System.out.println("Aceptado: " + grafo.get(i).isAceptado());
        }
    }

    private void caractes(char[] array, int i) {
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        comparar = grafo.get(grafo.size() - 1).getCompararCon();
        moverA = grafo.get(grafo.size() - 1).getMoverA();
        moverA.add(grafo.size());
        comparar.add("" + array[i]);
        grafo.get(grafo.size() - 1).setCompararCon(comparar);
        grafo.get(grafo.size() - 1).setMoverA(moverA);
        grafo.add(new Nodo());
    }

    public boolean Buscar(char[] palabra) {
        boolean encontrado = false;
        int moverse = 0;
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        for (int i = 0; i < palabra.length; i++) {
            encontrado = false;
            comparar = grafo.get(moverse).getCompararCon();
            moverA = grafo.get(moverse).getMoverA();
            for (int j = 0; j < comparar.size(); j++) {
                if (comparar.get(j).charAt(0) == palabra[i]) {
                    moverse = moverA.get(j);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                break;
            }
        }
        if (encontrado) {
            return grafo.get(moverse).isAceptado();
        } else {
            return false;
        }
    }

    private void EstrellaK(char[] array, int i) {
        comparar = grafo.get(grafo.size() - 1).getCompararCon();
        moverA = grafo.get(grafo.size() - 1).getMoverA();
        moverA.add(grafo.size() - 1);
        comparar.add("" + array[i - 1]);
        grafo.get(grafo.size() - 1).setCompararCon(comparar);
        grafo.get(grafo.size() - 1).setMoverA(moverA);
    }

    private void Aceptado(char[] array, int i) {
        if (i + 1 == array.length) {
            grafo.get(grafo.size() - 1).setAceptado(true);
        } else if (array[i] == '|') {
            grafo.get(grafo.size() - 1).setAceptado(true);
        }
    }

    private void addEstados(int aux) {
        for (int j = 0; j < aux; j++) {
            if (grafo.get(j).isAceptado()) {
                System.out.println("size: " + j);
                grafo.get(j).setAceptado(false);
                comparar = grafo.get(aux).getCompararCon();
                moverA = grafo.get(aux).getMoverA();
                grafo.get(j).setCompararCon(comparar);
                grafo.get(j).setMoverA(moverA);
            }
        }
    }

}
