
package com.mycompany.contador;

public class Contador implements Runnable {
    private int contador;

    public Contador() {
        this.contador = 0;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Contador: " + contador);
            contador++;
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
                break; // Sale del bucle si se interrumpe el hilo
            }
        }
    }

    public static void main(String[] args) {
        Thread hiloContador = new Thread(new Contador());
        hiloContador.start();

        // El programa seguirá ejecutándose, puedes agregar más lógica aquí
        try {
            Thread.sleep(10000); // Espera 10 segundos antes de finalizar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hiloContador.interrupt(); // Interrumpe el hilo del contador
    }
}

