package Clases;

public class VehiculoJoel {
    public String color ="azul";
    public String Placa="12345678";
    public String modelo="Lamborgini";
    public VehiculoJoel(){
    }
    public VehiculoJoel(String ObtenerColor, String ObtenerPlaca,String ObtenerModelo){
  
  color=ObtenerColor;
  Placa=ObtenerPlaca;
  modelo=ObtenerModelo;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the Placa
     */
    public String getPlaca() {
        return Placa;
    }

    /**
     * @param Placa the Placa to set
     */
    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    /**
     * @return the modelo
     */
    private String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
