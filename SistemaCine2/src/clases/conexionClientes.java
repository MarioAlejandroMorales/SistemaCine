package clases;

import java.io.IOException;
import java.sql.*;

public class conexionClientes {
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
	
	public void insertClientes(String nombre, String apellido, String telefono, String correo, String membresia) throws SQLException, IOException {
		conectDatabase();
		PreparedStatement ps=con.prepareStatement("INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ? )");
		ps.setString(1,nombre);
		ps.setString(2,apellido);
		ps.setString(3,telefono);
		ps.setString(4,correo);
		ps.setString(5,membresia);
		ps.setString(6,null);
		System.out.println(ps);
		
		@SuppressWarnings("unused")
		int i=ps.executeUpdate();
		//System.out.println(i+" records added");

		
		con.close();
	}
	
	public Object[][] consultarClientes() {
		conectDatabase();
		
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) from clientes";
		Statement stmt;
		
		
		
		//System.out.println(sql);
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			Object a[][]= new Object [cont][6];
			sql = "SELECT * FROM clientes";
			rs = stmt.executeQuery(sql);
			
			//System.out.println("The records are :"+rs);
			while(rs.next()) {
				a[i][0]=rs.getString(1);
				a[i][1]=rs.getString(2);
				a[i][2]=rs.getString(3);
				a[i][3]=rs.getString(4);
				a[i][4]=rs.getString(5);
				a[i][5]=rs.getString(6);
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

	public void modificarClientes(String nombre, String apellido, String telefono, String correo, String membresia, String id) throws SQLException, IOException {

		conectDatabase();
		String sql="UPDATE clientes SET nombre='"+nombre+"', apellido='"+apellido+"', telefono="+telefono+", correo='"+correo
				+"', membresia='"+membresia+"' WHERE id='"+id+"'";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println(ps);

		@SuppressWarnings("unused")
		int i=ps.executeUpdate();
		//System.out.println(i+" records added");

		con.close();
	}
	
	public String[] consultarId(String id) {
		conectDatabase();
		String sql = "SELECT * from clientes WHERE id='"+id+"'";
		Statement stmt;
		//System.out.println(sql);
		String arra[]= new String [6];
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println("The records are :"+rs);
			if(rs.next()) {
				arra[0]=rs.getString("nombre");
				arra[1]=rs.getString("apellido");
				arra[2]=rs.getString("telefono");
				arra[3]=rs.getString("correo");
				arra[4]=rs.getString("membresia");
				arra[5]=rs.getString("id");
				con.close();
			}
			if(!arra[0].equals("")) {
				return arra;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arra;
	}
	
	public String consultarUltimo() {
		conectDatabase();
		String sql = "SELECT * from clientes ORDER BY id DESC";
		Statement stmt;
		//System.out.println(sql);
		String arra[]= new String [6];
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println("The records are :"+rs);
			if(rs.next()) {
				arra[0]=rs.getString("nombre");
				arra[1]=rs.getString("apellido");
				arra[2]=rs.getString("telefono");
				arra[3]=rs.getString("correo");
				arra[4]=rs.getString("membresia");
				arra[5]=rs.getString("id");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arra[5];
	}
	
}
	