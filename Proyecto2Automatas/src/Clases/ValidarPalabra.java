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

    /**
     * Declaro un ArrayList de tipo Nodo Nodo es una clase creada por mi. El
     * arrayList se llama Estado puesto que acá se guardará el recorrido que
     * hará cuando este validando una palabra.
     *
     * Declaro otros 2 arrayList 1 de tipo entero y el otro de tipo string Estos
     * ArrayList me servirán para poder manejar los arraylist de mi clase nodo
     *
     */
    private final ArrayList<Nodo> Estado;
    private ArrayList<String> comparar;
    private ArrayList<Integer> moverA;

    /**
     * Constructor de la clase Solo inicializa el ArrayList de tipo Nodo.
     */
    public ValidarPalabra() {
        Estado = new ArrayList<>();
    }

    /**
     * Este metodo me sirve para insertar los datos de a donde me quiero mover y
     * con quien lo voy a comparar recibe como parametro un array de tipo char
     *
     * @param array
     */
    public void insertarConParentesis(char[] array) {
        //Inicializo los arraylist declarados anrteriormente
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        /**
         * Agrego un nuevo estado y declaro una variable tipo entero llamada aux
         * este me servirá para cuando encuentre un parentesis saber a que
         * estado se va a dirigir si en el parentesis hay uniones declaro una
         * variable booleana para saber si despues de un parentesis hay otro o
         * un caracter
         */
        Estado.add(new Nodo());
        int aux = 0;
        boolean parentesis = false;
        /**
         * Itero el array con un for
         *      La primera condicion me sirve para agregar un nuevo estado en caso de ser un caracter
         *      llamo a una funcion que recibe como parametro el array e i
         *          Hago otra condicion para saber si ya hubo un parentes antes en caso de que si ya haya ido un
         *          parentesis antes llamo a una funcion que recibe como parametro el tamaño del estado-2
         *          fin condicion
         *      Fin de la condicion
         *      Si no es un caracter pero si es un * (Estrella de kleen)
         *          llamo a una funcion que igual recibe como parametro el arreglo e i
         *      fin condicion
         *      si no es un caracter ni una EK entonces es un parentesis
         *          aumento i
         *          guardo el numero del estado que esta antes del parentesis esto lo hago para
         *          para no perder mi estado que tendrá multiples opciones
         *          Hago un while que ira desde donde esta hasta donde encuentre lo que es el caracter que cierra el parentesis
         *              aumento i en uno para obtener el próximo caracter despues del parentesis de apertura.
         *              saco el listado del estado guardado le agrego la ruta a la que va a ir y el caracte al cual va a ir
         *              lo vuelvo a guardar, aumento i.
         *              Otro while que va hasta encontrar la union y sea diferente al parentesis de cierre
         *                  condicion si es diferente a * (Estrella de Kleen) llama a una funcion para caracteres si no a la condicion para EK fin condicion
         *                  aumento i
         *              fin while
         *              llamo a una funcion
         *          fin while
         *          llamo a una funcion
         *      fin condicion
         *      llamo a una funcion
         * fin iteracion
         * Llamo a una funcion
         *
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*' && array[i] != ')' && array[i] != '(') {
                caractes(array, i);
                if (parentesis) {
                    addEstados(Estado.size() - 2);
                }
            } else if (array[i] == '*') {
                EstrellaK(array, i);
            } else if (array[i] == '(') {
                aux = Estado.size() - 1;
                parentesis = true;
                while (array[i] != ')') {
                    i++;
                    comparar = Estado.get(aux).getCompararCon();
                    moverA = Estado.get(aux).getMoverA();
                    moverA.add(Estado.size());
                    comparar.add("" + array[i]);
                    Estado.get(aux).setCompararCon(comparar);
                    Estado.get(aux).setMoverA(moverA);
                    Estado.add(new Nodo());
                    i++;
                    //ab(cdffff|d)
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
        for (int i = 0; i < Estado.size(); i++) {
            System.out.println("------------------SIZE: " + i + "-------------------");
            moverA = Estado.get(i).getMoverA();
            comparar = Estado.get(i).getCompararCon();
            for (int k = 0; k < moverA.size(); k++) {
                System.out.println("mover a: " + moverA.get(k) + " y comparar con: " + comparar.get(k));
            }
            System.out.println("Aceptado: " + Estado.get(i).isAceptado());
        }
    }

    /**
     * Este metodo es cuando no tiene parentesis Practicamente hace lo mismo que
     * el de arriba solo omitiendo los parentesis y buscando las difurcaciones
     * (uniones)
     *
     * @param array
     */
    public void insertarSinParentesis(char[] array) {
        moverA = new ArrayList<>();
        comparar = new ArrayList<>();
        Estado.add(new Nodo());
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*' && array[i] != '|') {
                caractes(array, i);
            } else if (array[i] == '*') {
                EstrellaK(array, i);
            } else if (array[i] == '|') {
                i++;
                Union(array, i);
            }
            Aceptado(array, i);
        }
        for (int i = 0; i < Estado.size(); i++) {
            System.out.println("------------------SIZE: " + i + "-------------------");
            if (Estado.get(i).getCompararCon().isEmpty()) {
                Estado.get(i).setAceptado(true);
            }
            moverA = Estado.get(i).getMoverA();
            comparar = Estado.get(i).getCompararCon();
            for (int k = 0; k < moverA.size(); k++) {
                System.out.println("mover a: " + moverA.get(k) + " y comparar con: " + comparar.get(k));
            }
            System.out.println("Aceptado: " + Estado.get(i).isAceptado());
        }
    }

    /**
     * Con este metodod valido lo que es la cadena entrante
     * @param palabra
     * @return
     */
    public boolean Buscar(char[] palabra) {
        /**
         * Declaro variables para su posterior uso
         * el tipo booleano me indica si hay alguna de las coinciencias mientrar
         * recorre la cadena ingresada para Validar
         * el tipo entero me indica hacia que estado me muevo
         * los dos arraylist los utilizo para tener un mejor manejo de a donde
         * debo ir o con quien tengo que comparar segun cada estado
         * itero el array ingresado
         *      siempre voy a tener encontrado
         *      obtengo las listas del primer estado que compararé y me indica a donde mover
         *      itero las listas ambos tienen el mismo tamaño por lo tanto no hay problema en los tamaños
         *          comparo si el caracter que entra es igual a alguno de la lista
         *              si es igual guardo la posicion a la cual me debo seguir moviendo indico que si lo encontre
         *          fin condicion
         *      fin iteracion
         *      condicion que me indica que si no lo encotro
         *          si no lo encuentra es porque no hay coincidencia por lo tanto no es valida la palabra
         *      fin condicion
         * fin iteracion
         * condicion si lo encontro
         *      retorna si esa palabra es valido recordar que puede tener casí todos los caracteres pero no cumple 
         * sin condicion
         * si no es encontrado
         *      retorna que no lo encontro
         * fin condicion
         */
        boolean encontrado = false;
        int moverse = 0;
        for (int i = 0; i < palabra.length; i++) {
            encontrado = false;
            comparar = Estado.get(moverse).getCompararCon();
            moverA = Estado.get(moverse).getMoverA();
            for (int j = 0; j < comparar.size(); j++) {
                if (comparar.get(j).charAt(0) == palabra[i]) {
                    moverse = moverA.get(j);
                    encontrado = true;
                }
            }
            //ab     abb
            if (!encontrado) {
                break;
            }
        }
        if (encontrado) {
            return Estado.get(moverse).isAceptado();
        } else {
            return false;
        }
    }
    

    /**
     * Este metodo es para poner que estados son aceptados
     * @param array
     * @param i 
     * 
     * Van a hacer aceptados cuando se el ultimo digito o cuando sea una union simple
     * ab(cd|d)
     */
    private void Aceptado(char[] array, int i) {
        if (i + 1 == array.length) {
            Estado.get(Estado.size() - 1).setAceptado(true);
        } else if (array[i] == '|') {
            Estado.get(Estado.size() - 1).setAceptado(true);
        }
    }
    /**
     * Funcion para esta clase unicamente
     * Y su funcion es darle a los estado anteriores que sean uniones las listas
     * recibe 1 parametros
     * @param aux
     * 
     * for desde 0 hasta aux parametro que entra
     *      condicion donde los estados sean aceptados
     *          si son aceptados tomamos las listas de cada estado le decimos que su estado es no aceptado puesto
     *          que hay mas estados dependientes de ese
     *          guardamos los datos en la lista de a donde moverse y con quien debe compararse
     *          devolvemos las listas
     *      fin condicion
     * fin for
     * ab(cd|f)g
     */
    private void addEstados(int aux) {
        for (int j = 0; j < aux; j++) {
            if (Estado.get(j).isAceptado()) {
                Estado.get(j).setAceptado(false);
                comparar = Estado.get(aux).getCompararCon();
                moverA = Estado.get(aux).getMoverA();
                Estado.get(j).setCompararCon(comparar);
                Estado.get(j).setMoverA(moverA);
            }
        }
    }
    /**
     * Funcion para esta clase unicamente
     * Y su funcion es crear a los estados cuando son union
     * recibe 2 parametros
     * @param array
     * @param i 
     * 
     * Cuando es union sin parentesis obtenemos las listas del estado inicial
     * agregamos el ultimo nodo hasta ese momento agregamos el caracter les regresamos
     * las listas al estado inicial y agregamos un nuevo estado
     * 
     * ab|de|fg
     */
    private void Union(char[] array, int i) {
        comparar = Estado.get(0).getCompararCon();
        moverA = Estado.get(0).getMoverA();
        moverA.add(Estado.size());
        comparar.add("" + array[i]);
        Estado.get(0).setCompararCon(comparar);
        Estado.get(0).setMoverA(moverA);
        Estado.add(new Nodo());
    }
    /**
     * Funcion para esta clase unicamente
     * Y su funcion es crear a los estados cuando son caracteres
     * recibe 2 parametros
     * @param array
     * @param i 
     * 
     * Cuando es un caracter obtenemos las listas del estado final en ese momento
     * agregamos el ultimo nodo hasta ese momento agregamos el caracter les regresamos
     * las listas al estado final en ese momento y agregamos un nuevo estado
     */
    private void caractes(char[] array, int i) {
        comparar = Estado.get(Estado.size() - 1).getCompararCon();
        moverA = Estado.get(Estado.size() - 1).getMoverA();
        moverA.add(Estado.size());
        comparar.add("" + array[i]);
        Estado.get(Estado.size() - 1).setCompararCon(comparar);
        Estado.get(Estado.size() - 1).setMoverA(moverA);
        Estado.add(new Nodo());
    }
    /**
     * Funcion para esta clase unicamente
     * Y es para validar las EK
     * recibe 2 parametros
     * @param array
     * @param i 
     * 
     * Lo que hace esta funcion es:
     * tomar las listas del ultimo estado hasta ese momento
     * decirle que se va a mover a el mismo cuando este buscando
     * guardo el caracter anterio ya que el actual es un * EK
     * eso se guarda en la lista del ultimo nodo hasta ese momento
     * y le devuelvo las listas  al ultimo nodo.
     * a*
     */
    private void EstrellaK(char[] array, int i) {
        comparar = Estado.get(Estado.size() - 1).getCompararCon();
        moverA = Estado.get(Estado.size() - 1).getMoverA();
        moverA.add(Estado.size() - 1);
        comparar.add("" + array[i - 1]);
        Estado.get(Estado.size() - 1).setCompararCon(comparar);
        Estado.get(Estado.size() - 1).setMoverA(moverA);
    }
}
