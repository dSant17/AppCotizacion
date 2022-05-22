package com.example.appcotizacion;

public class Cotizacion {
    private int numCotizacion;
    private String descripcion;
    private float precio;
    private int porcentajePagoIn;
    private int plazo;

    // Constructor vacío
    public Cotizacion(){
        this.numCotizacion = 0;
        this.descripcion = "";
        this.precio = 0.0f;
        this.porcentajePagoIn = 0;
        this.plazo = 0;
    }

    //Constructor de parámetros
    public Cotizacion(int numCotizacion, String descripcion, float precio, int porcentajePagoIn, int plazo){
        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porcentajePagoIn = porcentajePagoIn;
        this.plazo = plazo;
    }

    // Constructor de copia
    public Cotizacion(Cotizacion cot){
        this.numCotizacion = cot.numCotizacion;
        this.descripcion = cot.descripcion;
        this.precio = cot.precio;
        this.porcentajePagoIn = cot.porcentajePagoIn;
        this.plazo = cot.plazo;
    }

    //Métodos de propiedades | Encapsulamiento

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPorcentajePagoIn() {
        return porcentajePagoIn;
    }

    public void setPorcentajePagoIn(int porcentajePagoIn) {
        this.porcentajePagoIn = porcentajePagoIn;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    // Métodos de comportamiento

    public float calcularPagoIn(){
        float PagoIn = this.precio * ((float) this.porcentajePagoIn / 100);
        return PagoIn;
    }

    public float calcularTotalFin(){
        float TotalFin = this.precio - calcularPagoIn();
        return TotalFin;
    }

    public float calcularPagoMen(){
        float PagoMen = calcularTotalFin() / this.plazo;
        return PagoMen;
    }

    public String imprimirCotizacion(){
        String cotizacion = "";
        cotizacion = "--------------------------------------------" + "\n" +
                "No. COTIZACIÓN: " + this.numCotizacion + "\n" +
                "DESCRIPCIÓN: " + this.descripcion + "\n" +
                "PRECIO: $" + this.precio + "\n" +
                "PORCENTAJE DE PAGO INICIAL: " + this.porcentajePagoIn + "%\n" +
                "PLAZO: " + this.plazo + " meses\n\n" +
                "PAGO INICIAL: $" + calcularPagoIn() + "\n" +
                "TOTAL A FINANCIAR: $" + calcularTotalFin() + "\n" +
                "PAGO MENSUAL: $" + calcularPagoMen() + "\n" +
                "---------------------------------------------";

        return cotizacion;
    }
}