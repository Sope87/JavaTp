package Controlador;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Clases.Electrodomestico;
import Clases.Lavarropas;
import Clases.Television;
import Datos.*;
 
 


public class ControladorElectrodomestico {
	public void AltaModificacion(String tipo,String desc,String peso,String consumo,String carga,String color,String pulgadas,String precioBase,boolean tdt,Boolean esModificacion,int codEle)
	{
		if (tipo=="Lavarropas")
		{
			Lavarropas lav=null;
			if(peso.isEmpty() && consumo.isEmpty() && carga.isEmpty() && color.isEmpty()  && precioBase.isEmpty())
			{
				lav=new Lavarropas();
			
			}
			if(!peso.isEmpty() && consumo.isEmpty() && carga.isEmpty() && color.isEmpty()  && !precioBase.isEmpty())
			{
				lav=new Lavarropas(Integer.parseInt(precioBase),Integer.parseInt(peso));
			
			}
			if(!peso.isEmpty() && !consumo.isEmpty() && !carga.isEmpty() && !color.isEmpty()  && !precioBase.isEmpty())
			{
				lav=new Lavarropas(Integer.parseInt(carga),Integer.parseInt(precioBase),color,consumo.charAt(0),Integer.parseInt(peso));
			
			}
			lav.setDescripcion(desc);
			lav.setTipo(tipo);
			if(esModificacion)
			{
				lav.setCodElectrodomestico(codEle);
				fachadaPersistencia.modificarLavarropa(lav);
			}
			else
				fachadaPersistencia.nuevoLavarropa(lav);
		}
		if (tipo=="Television")
		{
			Television Tel=null;
			if(peso.isEmpty() && consumo.isEmpty() && pulgadas.isEmpty() && color.isEmpty()  && precioBase.isEmpty())
			{
				Tel=new Television();
			
			}
			if(!peso.isEmpty() && consumo.isEmpty() && pulgadas.isEmpty() && color.isEmpty()  && !precioBase.isEmpty())
			{
				Tel=new Television(Integer.parseInt(precioBase),Integer.parseInt(peso));
			
			}
			if(!peso.isEmpty() && !consumo.isEmpty() && !pulgadas.isEmpty() && !color.isEmpty()  && !precioBase.isEmpty())
			{
				Tel=new Television(Integer.parseInt(pulgadas),tdt,Integer.parseInt(precioBase),color,consumo.charAt(0),Integer.parseInt(peso));
			
			}
			Tel.setTipo(tipo);
			Tel.setDescripcion(desc);
			if(esModificacion)
			{
				Tel.setCodElectrodomestico(codEle);
				fachadaPersistencia.modificarTelevision(Tel);
				
			}
			else
				fachadaPersistencia.nuevoTelevisor(Tel);
		}
		
	}
	public DefaultTableModel getModelElectrodomestico(int montoMin,int montoMax,char consumo)

{//TODO Se podria usar como clase Electrodomesticos y dsp castearlos segun el tipo.
//	ArrayList<Lavarropas> colLavarropas=fachadaPersistencia.getAllLavarropas(montoMin, montoMax, consumo);
//	ArrayList<Television> colTelevision= fachadaPersistencia.getAllTelevision(montoMin, montoMax, consumo);
		ArrayList<Electrodomestico> colElectrodomestico= fachadaPersistencia.getAllElectrodomestico(montoMin, montoMax, consumo);
	String columnName[]={"Id Electrodomestico","Descripcion","Peso","Color","Consumo","Precio Base","Pulgadas","TDT","Carga"};
	DefaultTableModel modelTable= new DefaultTableModel();
	modelTable.setColumnIdentifiers(columnName);
	for(Electrodomestico ele: colElectrodomestico)
	{
		if(ele.getTipo().equals("Lavarropas"))
		{
			Lavarropas lav=(Lavarropas)ele;
			Object data[]={lav.getCodElectrodomestico(),lav.getDescripcion(),lav.getPeso(),lav.colores.getDescripcionColor(),lav.ConsumoEnergetico.getDescripcionConsumo(),lav.getPrecio_base(),null,null,lav.getCarga()};
			modelTable.addRow(data);
		}
		else
		{
			Television tel= (Television)ele;
			Object data[]={tel.getCodElectrodomestico(),tel.getDescripcion(),tel.getPeso(),tel.colores.getDescripcionColor(),tel.ConsumoEnergetico.getDescripcionConsumo(),tel.getPrecio_base(),tel.getPulgadas(),tel.getSintonizador(),null};
			modelTable.addRow(data);
		}
		
	}
	
//	for (Lavarropas lav : colLavarropas) {
//
//		Object data[]={lav.getCodElectrodomestico(),lav.getDescripcion(),lav.getPeso(),lav.colores.getDescripcionColor(),lav.ConsumoEnergetico.getDescripcionConsumo(),lav.getPrecio_base(),null,null,lav.getCarga()};
//		modelTable.addRow(data);
//	}
//	for(Television tel:colTelevision)
//	{
//		Object data[]={tel.getCodElectrodomestico(),tel.getDescripcion(),tel.getPeso(),tel.colores.getDescripcionColor(),tel.ConsumoEnergetico.getDescripcionConsumo(),tel.getPrecio_base(),tel.getPulgadas(),tel.getSintonizador(),null};
//		modelTable.addRow(data);
//	}
	
	return modelTable;
	}
	public Electrodomestico getElectrodomestico(int codElec)
	{
		return fachadaPersistencia.getElectrodomestico(codElec);
	}
public void eliminarElectrodomestico(int codElectrodomestico)
{
	fachadaPersistencia.eliminarElectrodomestido(codElectrodomestico);
	}

}
