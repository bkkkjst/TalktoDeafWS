package TalktoDeaf;

import java.io.StringWriter;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TalktoDeafWS implements TalktoDeafInterface {
	
	// ใช้ในการทำ json
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public String getCategory() throws Exception {
		
		StringBuilder sb = new StringBuilder();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/t2d_db", "root", "");

			if (conn != null) {
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// our SQL SELECT query.
				// if you only need a few columns, specify them by name instead of using
				// "*"
				String query = "SELECT "
						+ "vocabulary.name_voc, "
						+ "vocabulary.des_voc, "
						+ "type.name_type, "
						+ "example.exam "
						+ "FROM "
						+ "vocabulary ,"
						+ "type ,"
						+ "example "
						+ "WHERE "
						+ "type.id_type = vocabulary.type_id_type "
						+ "AND "
						+ "example.id_exam = vocabulary.example_id_exam";

				// create the java statement
				Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next()) {
					Map<String, String> map = new HashMap();
					String name_voc = rs.getString("name_voc");
					String des_voc = rs.getString("des_voc");
					String name_type = rs.getString("name_type");
					String exam = rs.getString("exam");
					
					

					map.put("name_voc", name_voc);
					map.put("des_voc", des_voc);
					map.put("name_type", name_type);
					map.put("exam", exam);

					list.add(map);

				}
				rs.close();
				st.close();
				conn.close();

				Writer strWriter = new StringWriter();
				mapper.writeValue(strWriter, list);
				sb.append(strWriter.toString());
				return sb.toString();
	}

	@Override
	public String getCategoryName() throws Exception {
		
		StringBuilder sb = new StringBuilder();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/t2d_db", "root", "");

			if (conn != null) {
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "SELECT category.name_cat FROM category";
				
				// create the java statement
				Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);
		
				// iterate through the java resultset
				while (rs.next()) {
					Map<String, String> map = new HashMap();
					String name_cat = rs.getString("name_cat");
					
					
					

					map.put("name_cat", name_cat);
					

					list.add(map);

				}
				rs.close();
				st.close();
				conn.close();

				Writer strWriter = new StringWriter();
				mapper.writeValue(strWriter, list);
				sb.append(strWriter.toString());
				return sb.toString();
	}

}
