package strategy;

public class TarifaFinDeSemana implements TarifaStrategy {

    @Override
    public double calcular(double horas) {
        return horas * 5.0;
    }
}
