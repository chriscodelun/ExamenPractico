import javax.swing.JOptionPane;

/**
 * Electrodomestico
 */
public class Electrodomestico {

    private double precioBase;
    private String color;
    private String consumoEnergetico;
    private double peso;
    private String col="";
    
    public Electrodomestico() {
        color=JOptionPane.showInputDialog("Ingrese el color del electrodomestico").toUpperCase();
        consumoEnergetico=(JOptionPane.showInputDialog("Ingrese la letra del consumo dele electrodomestico")).toUpperCase();
        peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del electrodomestico"));
    }
    public Electrodomestico(double precioBase, double peso) {
        this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = peso;
		this.precioBase = precioBase;
    }
 
    public Electrodomestico(double precioBase, String color, String consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color=color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }
    public void comprobarConsumoEnergetico(String letra)
    {
        boolean ban=false;
        switch (letra.toUpperCase()) {
            case "A":
                ban=true;
                precioBase=100;
                break;
            case "B":
                ban=true;
                precioBase=80;
                break;
            case "C":
                ban=true;
                precioBase=60;
                break;
            case "D":
                ban=true;
                precioBase=50;
                break;
            case "E":
                ban=true;
                precioBase=30;
                break;
            case "F":
                ban=true;
                precioBase=10;
                break;
            
            default: 
                precioBase=10;
                break;
        }
    }
    public String comprobarColor(String color)
    {
        String vec []={"BLANCO","NEGRO","ROJO","AZUL"};
        for(int i=0;i<vec.length;i++)
        {
            if(color.equalsIgnoreCase(vec[i]))
            {
                return color;
            }
            
        }
        color="BLANCO";
        return color;
    }
    public double precioFinal()
    {
        double pesoPorPrecio=0;
        comprobarConsumoEnergetico(consumoEnergetico);
        if(this.peso >= 0 && this.peso <= 19) {
			pesoPorPrecio = 10;
		} else if(this.peso >= 20 && this.peso <= 49) {
			pesoPorPrecio = 50;
		} else if(this.peso >= 50 && this.peso <= 79) {
			pesoPorPrecio = 80;
		}	else {
			pesoPorPrecio = 100;
		}
		this.precioBase += pesoPorPrecio;
        return this.precioBase;

    }
    public void mostrarElectrodomesticos()
    {
        col=comprobarColor(color);
        JOptionPane.showMessageDialog(null,"Datos"+"\n"+precioFinal()+"\n"+col+"\n"+consumoEnergetico+"\n"+peso);
    }



    public double getPrecioBase() {
        return precioBase;
    }
    public String getColor() {
        return color;
    }
    public String getConsumoEnergetico() {
        return consumoEnergetico;
    }
    public double getPeso() {
        return peso;
    }


}