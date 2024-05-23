package Banco;

import java.util.Date;

public class CuentaCheque extends Cuenta{
    private Double costoManejoMensual;
    private Integer numero;
    private Double saldo;

    public CuentaCheque(Integer numero, Double costoManejoMensual, Double saldo) {
        super(numero, new Date().toString(), saldo, "");
        this.costoManejoMensual = costoManejoMensual;
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCheque{" +
                "costoManejoMensual=" + costoManejoMensual +
                '}';
    }
}
