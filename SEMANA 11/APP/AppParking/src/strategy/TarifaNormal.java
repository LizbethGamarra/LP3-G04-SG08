package strategy;

public class TarifaNormal implements TarifaStrategy {

    @Override
    public double calcular(double horas) {
        return horas * 2.0;
    }
}
