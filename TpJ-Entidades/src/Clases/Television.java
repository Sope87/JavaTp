package Clases;

public class Television extends Electrodomestico {

	static final int pulgadasD=20;
	static final Boolean sintonizadorD=false;
	
	int pulgadas;
	Boolean sintonizador;

	// constructor por defecto
		public Television()

		{
			super();
			this.pulgadas=pulgadasD;
			this.sintonizador=sintonizadorD;
			
		}
		
		// constructor con precio y peso
		public Television(int precio,int peso)
		{
			super(precio,peso);
			this.pulgadas=pulgadasD;
			this.sintonizador=sintonizadorD;
		}

	
		//constructor con carga
		public Television(int pulgadas,Boolean sintonizador,int precio,String color,char consumo,int peso)
		{
			super(precio,color,consumo,peso);
			this.pulgadas=pulgadas;
			this.sintonizador=sintonizador;
		}
		
		public int getPulgadas() {
			return pulgadas;
		}

		public Boolean getSintonizador() {
			return sintonizador;
		}
		
		public int precioFinal()
		{
			int parcial=super.precioFinal();
			if(this.pulgadas>40)
				parcial*=0.3;
			if(this.sintonizador )
				parcial+=50;
			return parcial;
			}

}
