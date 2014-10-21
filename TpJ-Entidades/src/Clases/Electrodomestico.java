package Clases;

public class Electrodomestico {
	static final String colorD="Blanco";
	static final int precio_baseD=100;
	static final int pesoD=5;
	static final char consumo_energeticoD='F';
	int precio_base;
	String color;
	//char consumo_energetico;
	int peso;
	//String colores[]={"blanco","negro","rojo","azul","gris"};
	public Color colores;
	public Consumo ConsumoEnergetico;
	String Descripcion;
	String Tipo;
	int codElectrodomestico;
	
	
public int getCodElectrodomestico() {
		return codElectrodomestico;
	}







	public void setCodElectrodomestico(int codElectrodomestico) {
		this.codElectrodomestico = codElectrodomestico;
	}







public String getTipo() {
		return Tipo;
	}







	public void setTipo(String tipo) {
		Tipo = tipo;
	}







public int getPrecio_base() {
	return precio_base;
}







public int getPeso() {
	return peso;
}

public String getDescripcion() {
	return Descripcion;
}


public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}


//constructor por default
public Electrodomestico()
{
	colores= new Color();
	colores.setDescripcionColor(colorD );
	
	ConsumoEnergetico = new Consumo();
	ConsumoEnergetico.setDescripcionConsumo(consumo_energeticoD);
	this.precio_base=precio_baseD;
	this.peso=pesoD;
	
}
// constructor con precio y peso
public Electrodomestico(int precio,int peso)
{
	this.precio_base=precio;
	this.peso=peso;
	colores= new Color();
	colores.setDescripcionColor(colorD );
	
	ConsumoEnergetico = new Consumo();
	ConsumoEnergetico.setDescripcionConsumo(consumo_energeticoD);
}
// constructor con todos los atributos
public Electrodomestico(int precio,String color,char consumo,int peso)
{

	
	this.precio_base=precio;
	this.peso=peso;
	
	// validar consumo
	colores= new Color();
	colores.setDescripcionColor(color );
	
	ConsumoEnergetico = new Consumo();
	ConsumoEnergetico.setDescripcionConsumo(consumo);
		
	
	
	}

//	protected boolean comprobarConsumoEnergetico(char letra)
//	{
//		boolean rta=false;
//		for(char i='A';i<'G';i++)
//		{  
//			if(letra==i)
//			{
//				rta=true;
//			break;
//			}
//			
//		}
//		return rta;
//	}
	
//	protected boolean comprobarColor(String color)
//	{
//		boolean rta=false;
//		for(int i=0;i<5;i++)
//		{
//			if(colores[i]==color.toLowerCase())
//				rta=true;
//		}
//	return rta;
//	}

public int precioFinal()

{
	int total=0;
	switch(this.ConsumoEnergetico.getDescripcionConsumo() )
	{
	case('A'):
		total=100;
	case('B'):
		total=80;
	case('C'):
		total=60;
	case('D'):
		total=50;
	case('E'):
		total=30;
	case('F'):
		total=10;
	}
	if(this.peso>0 && this.peso<=19)
	 total+=10;
	if(this.peso>19 && this.peso<=49)
		 total+=50;
	if(this.peso>49 && this.peso<=79)
		 total+=80;
	if(this.peso>=80)
		 total+=100;
	
	
	
	
return total;	
}
}

