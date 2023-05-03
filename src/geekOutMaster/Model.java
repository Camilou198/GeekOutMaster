package geekOutMaster;

import javax.swing.*;

/**
 * ModelCraps apply craps rules.
 * estado = 1 Natural winner
 * estado = 2 Craps looser
 * estado = 3 Establish point
 * estado = 4 Point winner
 * estado = 5 Point looser
 * @author David Camilo Ordoñez marin 2226057
 * @version v.1.0.0 date 18/04/2022
 */

public class Model {
    private Dado dado1,dado2;
    private int tiro,caraDado,contador,acumulador;
    private int punto;
    private int estado;
    private int flag;
    private int posicion;
    private String[] estadoToString;
    private int[] caras;

    /**
     * Class Constructor
     */
    public Model(){
        dado1 = new Dado();
        caras = new int[10];
        estadoToString = new String[2];
        flag = 0;
    }

    /**
     * Establish the value according to each dice
     */
    public void calcularTiro(){
        for(tiro = 0;tiro < 7; tiro++){
            caras[tiro]=dado1.getCara();;
        };
    }

    /**
     * Establish game state according to state attribute value.
     * states 1 to 3*/

    public void determinarJuego(){
            contador = 0;
            acumulador = 0;
            for(caraDado = 0;caraDado < 7; caraDado++){
                if(caras[caraDado] == 1){
                    estado = 1;
                    contador++;
                    if (contador == 0 ){
                        acumulador = 0;
                    }
                    if(contador == 1){
                        acumulador = contador;
                    }
                    if(contador == 2){
                        acumulador = contador + 1;
                    }
                    if(contador == 3){
                        acumulador = contador * 2;
                    }
                    if(contador == 4){
                        acumulador = contador * 2 + 2;
                    }
                    if(contador == 5){
                        acumulador = contador * 3;
                    }
                    if(contador == 6){
                        acumulador = contador * 3 + 3;
                    }
                    if(contador == 7){
                        acumulador = contador * 4;
                    }
                    if(contador == 8){
                        acumulador = contador * 4 + 4;
                    }
                    if(contador == 9){
                        acumulador = contador * 5;
                    }
                    if(contador == 10){
                        acumulador = contador * 5 + 5;
                    }
                }
            }
    }



    /**
     * Establish game state according to state attribute value.
     * state 4 and 5
     */
    private void rondaPunto() {
        contador = 0;
        for(caraDado = 0;caraDado < 7; caraDado++){
            if(caras[caraDado] == 1){
                estado = 1;
                contador++;
                if(contador == 2){
                    acumulador = contador + 1 ;
                }
                if(contador == 3){
                    acumulador = contador * 2;
                }
                if(contador == 4){
                    acumulador = contador * 2 + 2;
                }
                if(contador == 5){
                    acumulador = contador * 3;
                }
                if(contador == 6){
                    acumulador = contador * 3 + 3;
                }
                if(contador == 7){
                    acumulador = contador * 4;
                }
                if(contador == 8){
                    acumulador = contador * 4 + 4;
                }
                if(contador == 9){
                    acumulador = contador * 5;
                }
                if(contador == 10){
                    acumulador = contador * 5 + 5;
                }
            }
        };
    }

    /**
     * Establish messages game state according to state attribute value
     * @return Messages for the View class
     */
    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    public String[] getEstadoToString() {
        switch (estado){
            case 1: estadoToString[flag] = "Cara 42 = "+ contador + ", obtines "+acumulador+" puntos \n";
                break;
            case 2: estadoToString[0] = "Cohete";
                break;
            case 3: estadoToString[0] = "Corazón";
                break;
            case 4: estadoToString[0] = "Dragon";
                break;
            case 5: estadoToString[0] = "Heroe";
                break;
            case 6: estadoToString[0] = "Meeple";
                break;
        }
        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}
