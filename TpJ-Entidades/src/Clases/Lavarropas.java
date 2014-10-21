package Clases;

public class Lavarropas extends Electrodomestico {
	static final int cargaD=5;
	int carga;
	
	
	// constructor por defecto
	public Lavarropas()

	{
		super();
		this.carga=cargaD;
		
	}
	
	// constructor con precio y peso
	public Lavarropas(int precio,int peso)
	{
		super(precio,peso);
		this.carga=cargaD;
		
	}

	//constructor con carga
	public Lavarropas(int carga,int precio,String color,char consumo,int peso)
	{
		super(precio,color,consumo,peso);
		this.carga=carga;
	}

	public int getCarga() {
		return carga;
	}

public int precioFinal()
{
	int parcial=super.precioFinal();
	if(this.carga>30)
		parcial+=50;
	return parcial;
	}

}
