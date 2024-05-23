package Banco;

import java.util.Date;

public class CuentaAhorro extends Cuenta {
    private Double tasaInteresMensual;
    private Double saldo;

    public CuentaAhorro(Integer numero, Double tasaInteresMensual, Double saldo) {
        super(numero,new Date().toString(),saldo, "");
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldo = saldo;
    }

    public Double calcularIntereses() {
        return this.saldo * this.tasaInteresMensual;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tasaInteresMensual=" + tasaInteresMensual +
                ", saldo=" + saldo +
                '}';
    }
}
