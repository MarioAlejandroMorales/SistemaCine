package clases;

import java.io.IOException;
import java.sql.*;

public class conexionPeliculas {
	private Connection con=null;
	
	public void conectDatabase() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "cine";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try{
			Class.forName(driver).newInstance();
			con= DriverManager.getConnection(url+dbName,userName,password);
			
			/*if(!con.isClosed())
				System.out.println("Successfully conected to MySQL server...");*/
		}catch(Exception e) {
			System.err.println("Exception: "+e);
		}
	}
	
	public void insertEmpleado(String nombre, String apellido, String telefono, String domicilio, String fecha_nac, String nss, String correo, String sexo, 
		String sueldo,String horario, String h_entrada, String h_salida, String codigo, String nip) throws SQLException, IOException {
		conectDatabase();
		PreparedStatement ps=con.prepareStatement("INSERT INTO empleado VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1,nombre);
		ps.setString(2,apellido);
		ps.setString(3,telefono);
		ps.setString(4,domicilio);
		ps.setString(5,fecha_nac);
		ps.setString(6,nss);
		ps.setString(7,correo);
		ps.setString(8,sexo);
		ps.setString(9,sueldo);
		ps.setString(10,horario);
		ps.setString(11,h_entrada);
		ps.setString(12,h_salida);
		ps.setInt(13, contadorRegistros()+1);
		ps.setString(14,nip);
		ps.setString(15,codigo);
		//System.out.println(ps);
		
		@SuppressWarnings("unused")
		int i=ps.executeUpdate();
		//System.out.println(i+" records added");

		
		con.close();
	}
	
	/*String sql = "SELECT * from stud";
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("The records are :");
	while (rs.next()){
		myusn = rs.getString(1);
		myname=rs.getString(2);
		System.out.println(rs.getRow()+"-"+myusn+"  "+myname);
	} //end while*/
	
	public String consultarLogin(String user, String pass) {
		conectDatabase();
		String sql = "SELECT * from empleado WHERE usuario='"+user+"' AND nip="+pass+"";
		Statement stmt;
		//System.out.println(sql);
		String cuenta="";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println("The records are :"+rs);
			if(rs.next())
				cuenta=rs.getString("codigo");
			if(!cuenta.equals("")) {
				return cuenta;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String consultarCodigo(String user, String pass) {
		conectDatabase();
		String sql = "SELECT * from empleado WHERE codigo='"+user+"' AND nip="+pass+"";
		Statement stmt;
		//System.out.println(sql);
		String cuenta="";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println("The records are :"+rs);
			if(rs.next())
				cuenta=rs.getString("codigo");
			if(!cuenta.equals("")) {
				return cuenta;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public Object[][] consultarEmpleados() {
		conectDatabase();
		
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) from empleado";
		Statement stmt;
		
		
		
		//System.out.println(sql);
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			Object a[][]= new Object [cont][13];
			sql = "SELECT * from empleado";
			rs = stmt.executeQuery(sql);
			
			//System.out.println("The records are :"+rs);
			while(rs.next()) {
				a[i][0]=rs.getString(1);
				a[i][1]=rs.getString(2);
				a[i][2]=rs.getString(3);
				a[i][3]=rs.getString(4);
				a[i][4]=rs.getString(5);
				a[i][5]=rs.getString(6);
				a[i][6]=rs.getString(7);
				a[i][7]=rs.getString(8);
				a[i][8]=rs.getString(9);
				a[i][9]=rs.getString(10);
				a[i][10]=rs.getString(11);
				a[i][11]=rs.getString(12);
				a[i][12]=rs.getString(13);
				i++;
			}
			if(a!=null) {
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/////////////////// Alexis Centeno
	public String[][] consultarPeliculas() {
		conectDatabase();
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) FROM pelicula";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			String a[][]= new String [cont][7];
			sql = "SELECT * from pelicula";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				a[i][0]=rs.getString(2);
				a[i][1]=rs.getString(3);
				a[i][2]=rs.getString(4);
				a[i][3]=rs.getString(5);
				a[i][4]=rs.getString(6);
				a[i][5]=rs.getString(7);
				a[i][6]=rs.getString(8);
				i++;
			}
			if(a!=null) {
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int contadorRegistros() {
		int cont=0;
		String sql = "SELECT COUNT(*) from pelicula";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			return cont;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void insertarPelicula(String nombre, String protagonista, String director, String genero, String duracion, String clasificacion, String dirimg ) throws SQLException, IOException {
			conectDatabase();
			PreparedStatement ps=con.prepareStatement("INSERT INTO pelicula VALUES (?, ?, ?, ?, ?, ?, ?,?)");
			ps.setInt(1, contadorRegistros()+1);
			ps.setString(2,nombre);
			ps.setString(3,protagonista);
			ps.setString(4,director);
			ps.setString(5,genero);
			ps.setString(6,duracion);
			ps.setString(7,clasificacion);
			ps.setString(8,dirimg);
			@SuppressWarnings("unused")
			int i=ps.executeUpdate();
			con.close();
		}
	
	public String[] buscaCodigo(String id) {
		conectDatabase();
		String sql = "SELECT * from pelicula WHERE Id ='"+id+"'";
		Statement stmt;
		String cod="";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cod=rs.getString("id");
			if(!cod.equals("")) {
				String a[] = new String[7];
				a[0]=rs.getString(2);
				a[1]=rs.getString(3);
				a[2]=rs.getString(4);
				a[3]=rs.getString(5);
				a[4]=rs.getString(6);
				a[5]=rs.getString(7);
				a[6]=rs.getString(8);
				return a;
			}
			return null;
			//System.out.println("The records are :"+rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//////////////////////////////////////////

	public void actualizaPelicula(String nombre, String protagonista, String director, String genero, String duracion,
			String clasificacion, String dirImg, String id) {
		conectDatabase();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE INTO pelicula WHERE Id ='"+id+"' VALUES (?, ?, ?, ?, ?, ?, ?,?)");
			ps.setString(1, id);
			ps.setString(2,nombre);
			ps.setString(3,protagonista);
			ps.setString(4,director);
			ps.setString(5,genero);
			ps.setString(6,duracion);
			ps.setString(7,clasificacion);
			ps.setString(8,dirImg);
			//System.out.println("The records are :"+rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
