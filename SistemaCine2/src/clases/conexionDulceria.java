package clases;

import java.io.IOException;
import java.sql.*;

 

public class conexionDulceria 
{
private Connection con=null;
	
	public void conectDatabase() 
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "cine";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try
		{
			Class.forName(driver).newInstance();
			con= DriverManager.getConnection(url+dbName,userName,password);
		}
		catch(Exception e) 
		{
			System.err.println("Exception: "+e);
		}
	}//conectDatabase
	public void insertarMercancia(String nombre, float precio, String descripcion, int cantidad)
	{
		
		
		String sql = "INSERT INTO mercancia(nombre, precio, descripcion,cantidad)"
				+ " VALUES (?,?,?,?)";
		 
		 
			conectDatabase();
			
			try {
				PreparedStatement preparedStmt;
				preparedStmt = con.prepareStatement(sql);
				preparedStmt.setString (1, nombre);
				preparedStmt.setFloat (2, precio);
				preparedStmt.setString   (3, descripcion);
				preparedStmt.setInt(4, cantidad);
				
				preparedStmt.executeUpdate();
			      
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    
	}//insertarMercancia
	public Object[] mostrarMercancia(int id)
	{
		conectDatabase();
		
		try
		{
			String sql = "SELECT * from mercancia WHERE id="+id+"";
			Statement st;
			st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			Object a[]=new Object[5];
			
			if(rs.next())
			{
				a[0]=rs.getString(1);
				a[1]=rs.getString(2);
				a[2]=rs.getString(3);
				a[3]=rs.getString(4);
				a[4]=rs.getString(5);
			}
			if(a!=null)
			{	
				con.close();
				return a;
			}
				
				
			
		}
		catch(SQLException e)
		{	
			
			e.printStackTrace();
		}
		
		return null;
	}//mostrarMercancia
	public Object[][] mostrarMercancias()
	{
		conectDatabase();
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) from mercancia";
		Statement stmt;
		try
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			Object a[][]= new Object [cont][5];
			sql = "SELECT * from mercancia";
			rs = stmt.executeQuery(sql); 
			
			//System.out.println("The records are :"+rs);
			while(rs.next()) {
				a[i][0]=rs.getString(1);
				a[i][1]=rs.getString(2);
				a[i][2]=rs.getString(3);
				a[i][3]=rs.getString(4);
				a[i][4]=rs.getString(5);
				
				i++;
			}
			if(a!=null) {
				con.close();
				return a;
			}
			
		}
		catch(SQLException e)
		{


		}
		return null;
	}//mostrarMercancias
	public void actualizarMercancia(int id,String nombre, float precio, String descripcion, int cantidad)
	{
		String sql = "UPDATE mercancia SET nombre=?, precio=?, descripcion=?, cantidad=? WHERE id =?";
		 
		 
			conectDatabase();
			
			try {
				PreparedStatement preparedStmt;
				preparedStmt = con.prepareStatement(sql);
				preparedStmt.setString (1, nombre);
				preparedStmt.setFloat (2, precio);
				preparedStmt.setString   (3, descripcion);
				preparedStmt.setInt(4, cantidad);
				preparedStmt.setInt(5, id);
				
				preparedStmt.executeUpdate();
			      
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}//actualizarMercancia
	
}//conexionDulceria
