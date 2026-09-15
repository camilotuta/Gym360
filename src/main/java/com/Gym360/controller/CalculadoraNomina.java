package main.java.com.Gym360.controller;

import main.java.com.Gym360.model.classes.Empleado;

public class CalculadoraNomina {

    public static double calcularSalarioNeto(Empleado empleado, int horasExtra, double bonificaciones,
            double comisiones) {
        // Obtener el salario base del empleado
        double salarioBase = empleado.getSalario();

        // Calcular valor de horas extra
        double valorHoraNormal = salarioBase / 160; // Asumiendo 160 horas mensuales
        double pagoHorasExtra = horasExtra * valorHoraNormal * 1.5; // 50% adicional

        // Calcular salario bruto
        double salarioBruto = salarioBase + pagoHorasExtra + bonificaciones + comisiones;

        // Calcular deducciones (los porcentajes son ejemplos y varían según la
        // legislación)
        double aporteSalud = salarioBruto * 0.04; // 4% para salud
        double aportePension = salarioBruto * 0.04; // 4% para pensión

        // Cálculo simplificado de impuesto sobre la renta (ejemplo)
        double impuestoRenta = calcularImpuestoRenta(salarioBruto);

        // Calcular total deducciones
        double totalDeducciones = aporteSalud + aportePension + impuestoRenta;

        // Calcular salario neto
        double salarioNeto = salarioBruto - totalDeducciones;

        return salarioNeto;
    }

    public static double calcularImpuestoRenta(double salarioBruto) {
        // Este es un cálculo simplificado del impuesto
        // En la realidad, los impuestos tienen diferentes rangos y tasas
        if (salarioBruto <= 1000000) {
            return 0; // Exento
        } else if (salarioBruto <= 2000000) {
            return (salarioBruto - 1000000) * 0.10; // 10% sobre excedente
        } else if (salarioBruto <= 4000000) {
            return 100000 + (salarioBruto - 2000000) * 0.20; // 20% sobre excedente
        } else {
            return 500000 + (salarioBruto - 4000000) * 0.30; // 30% sobre excedente
        }
    }

    // Método para generar recibo de nómina
    public static String generarReciboNomina(Empleado empleado, double salarioBruto, double totalDeducciones,
            double salarioNeto) {
        StringBuilder recibo = new StringBuilder();
        recibo.append("RECIBO DE NÓMINA\n");
        recibo.append("===============================\n");
        recibo.append("Empleado: ").append(empleado.getNombre()).append(" ").append(empleado.getApellido())
                .append("\n");
        recibo.append("ID: ").append(empleado.getIdEmpleado()).append("\n");
        recibo.append("Cargo: ").append(empleado.getCargo()).append("\n\n");
        recibo.append("INGRESOS\n");
        recibo.append("Salario Base: $").append(String.format("%.2f", empleado.getSalario())).append("\n");
        recibo.append("Total Ingresos: $").append(String.format("%.2f", salarioBruto)).append("\n\n");
        recibo.append("DEDUCCIONES\n");
        recibo.append("Total Deducciones: $").append(String.format("%.2f", totalDeducciones)).append("\n\n");
        recibo.append("SALARIO NETO: $").append(String.format("%.2f", salarioNeto)).append("\n");
        recibo.append("===============================\n");

        return recibo.toString();
    }
}