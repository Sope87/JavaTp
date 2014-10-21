package Datos;
import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Electrodomestico;
import Clases.Lavarropas;
import Clases.Television;

public class fachadaPersistencia {

	public static void nuevoLavarropa(Lavarropas ele) {
		try {

			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			sql.executeUpdate("INSERT INTO electrodomestico(preciobase,color,peso,consumo,"+
					 "descripcion,carga,tipo) VALUES ("+ele.getPrecio_base() +",'"+ele.colores.getDescripcionColor()+ "',"
					+ " "+ ele.getPeso() +",'" +ele.ConsumoEnergetico.getDescripcionConsumo()+ "','" +ele.getDescripcion() +"', "
					+ " " +ele.getCarga() +",'"+ ele.getTipo() +"');");
			JOptionPane.showMessageDialog(null, "Electrodomestido registrado");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}

	}

	public static void nuevoTelevisor(Television ele) {
		try {
			int sinto=0;
			if(ele.getSintonizador())
			{sinto=1;}

			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			sql.executeUpdate("INSERT INTO electrodomestico(preciobase,color,peso,consumo,"
					+ "descripcion,pulgadas,tdt,tipo) values('"
					+ ele.getPrecio_base()
					+ "','"
					+ ele.colores.getDescripcionColor()
					+ "',"
					+ " '"
					+ ele.getPeso()
					+ "','"
					+ ele.ConsumoEnergetico.getDescripcionConsumo()
					+ "','"
					+ ele.getDescripcion()
					+ "', "
					+ " '"
					+ ele.getPulgadas()
					+ "','" + sinto + "','"+ele.getTipo()+"');");
			JOptionPane.showMessageDialog(null, "Electrodomestido registrado");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}

	}
	

	public static void modificarLavarropa(Lavarropas lav) {
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			sql.executeUpdate("UPDATE electrodomestico set preciobase="+lav.getPrecio_base()+",color='"+lav.colores.getDescripcionColor()+"',"+
					" peso="+ lav.getPeso()+",consumo='"+lav.ConsumoEnergetico.getDescripcionConsumo()+"',"+
					" descripcion='"+lav.getDescripcion()+"',carga="+lav.getCarga()+"  where idelectrodomestico="+lav.getCodElectrodomestico()+"");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}

	}

	public static void modificarTelevision(Television Tel) {
		try {
			int sinto=0;
			if(Tel.getSintonizador())
			{sinto=1;}

			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			sql.executeUpdate("UPDATE electrodomestico set preciobase="+Tel.getPrecio_base()+",color='"+Tel.colores.getDescripcionColor()+"',"+
							" peso="+Tel.getPeso()+",consumo='"+Tel.ConsumoEnergetico.getDescripcionConsumo()+"',"+
							" descripcion='"+Tel.getDescripcion()+"',pulgadas="+Tel.getPulgadas()+",tdt= '"+sinto+"' where idelectrodomestico="+Tel.getCodElectrodomestico()+"");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}

	}

	public static void eliminarElectrodomestido(int cod_electrodomestico) {
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			sql.executeUpdate("DELETE FROM electrodomestico where idelectrodomestico="+ cod_electrodomestico + "; ");
			JOptionPane.showMessageDialog(null,"Electrodomestico eliminado");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}
	}
	
	public static Electrodomestico getElectrodomestico(int codElectrodomestico)
	{
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			ResultSet cmd=sql.executeQuery("Select * from electrodomestico where idelectrodomestico="+codElectrodomestico+";");
			while(cmd.next())
			{
				if(cmd.getString("Tipo").equals("Lavarropas"))
				{
					Lavarropas lav=new Lavarropas(cmd.getInt("carga"), cmd.getInt("preciobase"), cmd.getString("color"),cmd.getString("consumo").charAt(0), cmd.getInt("peso"));
					lav.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
					lav.setDescripcion(cmd.getString("descripcion"));
					lav.setTipo(cmd.getString("Tipo"));
					return lav;
				}
				else
				{
					Boolean sin=false;
					if(cmd.getInt("tdt")>0)
						sin=true;
					Television tel = new Television(cmd.getInt("pulgadas"), sin, cmd.getInt("preciobase"), cmd.getString("color"), cmd.getString("consumo").charAt(0),  cmd.getInt("peso"));
					tel.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
					tel.setDescripcion(cmd.getString("descripcion"));
					tel.setTipo(cmd.getString("Tipo"));
					return tel;
				}
				
				
			}
		
		}  catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		return null;
	}
	public static ArrayList<Lavarropas> getAllLavarropas(int montoMin,int montoMax,char consumo)
	{
		ArrayList<Lavarropas> colElectrodomestico=new ArrayList<Lavarropas>();
		String sqlFiltros="";
		if(montoMin>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase>"+montoMin+" ");
		if(montoMax>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase<"+montoMax+" ");
		if(consumo!=' ')
		{
			sqlFiltros=sqlFiltros.concat(" and consumo='"+consumo+"' ");
		}
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			ResultSet cmd=sql.executeQuery("Select * from electrodomestico where tipo='Lavarropas' "+sqlFiltros+"  ;");
			while(cmd.next())
			{
				
					Lavarropas lav=new Lavarropas(cmd.getInt("carga"), cmd.getInt("preciobase"), cmd.getString("color"),cmd.getString("consumo").charAt(0), cmd.getInt("peso"));
					lav.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
					lav.setDescripcion(cmd.getString("descripcion"));
					lav.setTipo(cmd.getString("Tipo"));
					colElectrodomestico.add(lav);
	
			}
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		return colElectrodomestico;
	}
	
	
	public static ArrayList<Television> getAllTelevision(int montoMin,int montoMax,char consumo)
	{
		ArrayList<Television> colElectrodomestico=new ArrayList<Television>();
		String sqlFiltros="";
		if(montoMin>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase>"+montoMin+" ");
		if(montoMax>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase<"+montoMax+" ");
		if(consumo!=' ')
		{
			sqlFiltros=sqlFiltros.concat(" and consumo='"+consumo+"' ");
		}
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			ResultSet cmd=sql.executeQuery("Select * from electrodomestico where tipo='Television' "+sqlFiltros+";");
			while(cmd.next())
			{
				
					Boolean sin=false;
					if(cmd.getInt("tdt")>0)
						sin=true;
					Television tel = new Television(cmd.getInt("pulgadas"), sin, cmd.getInt("preciobase"), cmd.getString("color"), cmd.getString("consumo").charAt(0),  cmd.getInt("peso"));
					tel.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
					tel.setDescripcion(cmd.getString("descripcion"));
					tel.setTipo(cmd.getString("Tipo"));
					colElectrodomestico.add(tel);
				
				
				
			}
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		return colElectrodomestico;
	}
	public static ArrayList<Electrodomestico> getAllElectrodomestico(int montoMin,int montoMax,char consumo)
	{
		ArrayList<Electrodomestico> colElectrodomestico=new ArrayList<Electrodomestico>();
		String sqlFiltros="";
		if(montoMin>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase>"+montoMin+" ");
		if(montoMax>0)
			sqlFiltros=sqlFiltros.concat(" and preciobase<"+montoMax+" ");
		if(consumo!=' ')
		{
			sqlFiltros=sqlFiltros.concat(" and consumo='"+consumo+"' ");
		}
		try {
			Connection con = conexion.conectarDB();

			Statement sql = con.createStatement();
			ResultSet cmd=sql.executeQuery("Select * from electrodomestico where tipo is not null  "+sqlFiltros+" order by descripcion;");
			while(cmd.next())
			{
				if(cmd.getString("Tipo").equals("Lavarropas"))
						{
					Lavarropas lav = new Lavarropas(cmd.getInt("carga"),  cmd.getInt("preciobase"), cmd.getString("color"), cmd.getString("consumo").charAt(0),  cmd.getInt("peso"));
					lav.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
					lav.setDescripcion(cmd.getString("descripcion"));
					lav.setTipo(cmd.getString("Tipo"));
					colElectrodomestico.add(lav);
						}
					else
						{
						Boolean sin=false;
						if(cmd.getInt("tdt")>0)
						sin=true;
						Television tel = new Television(cmd.getInt("pulgadas"), sin, cmd.getInt("preciobase"), cmd.getString("color"), cmd.getString("consumo").charAt(0),  cmd.getInt("peso"));
						tel.setCodElectrodomestico(cmd.getInt("idelectrodomestico"));
						tel.setDescripcion(cmd.getString("descripcion"));
						tel.setTipo(cmd.getString("Tipo"));
						colElectrodomestico.add(tel);
						}
					
					
				
				
				
			}
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		return colElectrodomestico;
	}
	}


