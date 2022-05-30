package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juice.Juice;
import servlet.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<Juice> {
	
	Connection connection;
	
	public SqlCRUD() {
		this.connection = new Connect().getCon();
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Juice t) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = 
				connection.prepareStatement("INSERT INTO juice (title, descr, img) "
						+ "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setString(2, t.getDescr());
			st.setString(3, t.getImg());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Juice> read() {
		// TODO Auto-generated method stub
		List<Juice> list = new ArrayList<>();
		
		try(
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM juice;");
				)
		{
			while(rs.next()) {
				list.add(new Juice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return list;
	}

	@Override
	public void update(int id, Juice t) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = 
				connection.prepareStatement("UPDATE juice "
						+ "SET \"title\"=?, \"descr\"=?, \"img\"=? WHERE id=?;")) {
			st.setString(1, t.getTitle());
			st.setString(2, t.getDescr());
			st.setString(3, t.getImg());
			st.setInt(4, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = 
				connection.prepareStatement("DELETE FROM juice WHERE id=?;")) {
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
