package observer;

import java.util.HashMap;

import strategy.TarifaStrategy;

public class ParkingLot extends Subject {

    private int capacity;
    private int occupied;

    private HashMap<String, TarifaStrategy> registros = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupied = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    public void registrarEntrada(String placa, TarifaStrategy tarifa) {

        if (occupied < capacity) {
            registros.put(placa, tarifa);
            occupied++;
            checkStatus();
        } else {
            notifyAllObservers(" Intento de entrada pero parking lleno");
        }
    }

    public double registrarSalida(String placa, double horas) {

        if (!registros.containsKey(placa)) {
            return -1;
        }

        TarifaStrategy tarifa = registros.get(placa);
        double total = tarifa.calcular(horas);

        registros.remove(placa);
        occupied--;
        checkStatus();

        return total;
    }

    private void checkStatus() {
        int free = capacity - occupied;

        if (free == 0) {
            notifyAllObservers(" Parking lleno");
        } else if (free <= 3) {
            notifyAllObservers(" Quedan pocos espacios: " + free);
        }
    }
    
    public HashMap<String, TarifaStrategy> getRegistros() {
        return registros;
    }

}

