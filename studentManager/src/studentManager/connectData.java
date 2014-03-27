package studentManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class connectData {
	String ip;
	private Statement statement;
	private Connection connect;
	public connectData(String ip, int port, String login, String pass,
			String database) {
		setIp(ip);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + getIp()
					+ ":" + port + "/" + database, login, pass);
			statement = connect.createStatement();

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		final String PATTERN_ = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		Pattern pattern = Pattern.compile(PATTERN_);
		Matcher matcher = pattern.matcher(ip);
		if (matcher.matches()) {
			this.ip = ip;
		} else {
			this.ip = null;
			System.err.println("IP has a wrong format");
		}
	}
	public ArrayList<String> getTables() {
		ArrayList<String> data = new ArrayList<String>();
		DatabaseMetaData md;
		try {
			md = connect.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);

			while (rs.next()) {
				String tmp = rs.getString(3);
				// System.out.println(""+tmp);
				data.add(tmp);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<ColsInfo> getIn(String tableName) {
		List<ColsInfo> listOfLists = new ArrayList<ColsInfo>();
		try {
			ResultSet rsColumns = null;
			DatabaseMetaData meta = connect.getMetaData();
			rsColumns = meta.getColumns(null, "%", tableName, "%");
			Statement st;
			st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int i = 0;
			while (rsColumns.next()) {
				ColsInfo tmp = new ColsInfo();
				tmp.setColTitle(rsColumns.getString("COLUMN_NAME"));
				tmp.setColType(rsColumns.getString("TYPE_NAME"));
				tmp.setColSize(rsColumns.getInt("COLUMN_SIZE"));
				tmp.setColPosition(rsColumns.getInt("ORDINAL_POSITION"));
				tmp.setIsNullable(rsColumns.getInt("NULLABLE"));
//				tmp.setAutoIncrement(autoIncrement);
//				System.out.println("column name=" + tmp.getColTitle());
//				System.out.println("type=" + tmp.getColType());
//				System.out.println("size=" + tmp.getColSize());
//				if (nullable == DatabaseMetaData.columnNullable) {
//					System.out.println("nullable is true");
//				} else {
//					System.out.println("nullable is false");
//				}
//				System.out.println("position " + position);
				listOfLists.add(tmp);
				i++;
			}
			return listOfLists;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean isAutoIncresse(String tableName) {
		boolean itis = false;
		Statement st;
		try {
			st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM survey");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			System.out.println("resultSet MetaData column Count="
					+ numberOfColumns);
			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.println("column MetaData ");
				System.out.println("column number " + i);
				// indicates whether the designated column is
				// automatically numbered, thus read-only.
				System.out.println(rsMetaData.isAutoIncrement(i));
			}
			return itis;
		} catch (SQLException e) {
			e.printStackTrace();
			return itis;
		}
	}
	public String prepareStat(ArrayList<String> x){
		String y = null;
		for(int i = 0; i<x.size();i++){
			y= x.get(i) + ",";
		}
		y = y.substring(0, y.length()-1);
		System.out.println(y);
		return y;
	}
	public void addVal(String what, String where/*use prepareStat function */){
		Statement stmt;
		try {
			
			stmt = connect.createStatement();
		    String sql = "INSERT INTO users (where) VALUES (what)";
		    stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}

