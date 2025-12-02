package strategy;

public class TarifaNocturna implements TarifaStrategy {

    @Override
    public double calcular(double horas) {
        return horas * 3.0;
    }
}
