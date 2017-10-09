/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

/**
 *
 * @author Andre
 */
public final class Placa {

    private String codigo;

    private int ultimoDigito;

    private int dia;

    public Placa(String pCodigo) {
        codigo = pCodigo;
        obtenerDia();
    }

    public void obtenerDia() {
        ultimoDigito = Integer.parseInt(codigo.substring(codigo.length() - 1));
        switch (ultimoDigito) { 
            case 0:
                dia = 5;
                break;
            case 1:
                dia = 1;
                break;
            case 2:
                dia = 1;
                break;
            case 3:
                dia = 2;
                break;
            case 4:
                dia = 2;
                break;
            case 5:
                dia = 3;
                break;
            case 6:
                dia = 3;
                break;
            case 7:
                dia = 4;
                break;
            case 8:
                dia = 4;
                break;
            case 9:
                dia = 5;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getUltimoDigito() {
        return ultimoDigito;
    }

    public void setUltimoDigito(int ultimoDigito) {
        this.ultimoDigito = ultimoDigito;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String toString() {
        return "Su vehículo con placa " + codigo + " con último dígito " + ultimoDigito + " ";
    }

}
