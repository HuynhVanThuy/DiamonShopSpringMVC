package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategorys implements RowMapper<Categorys>{

	public Categorys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorys categorys = new Categorys();
		categorys.setId(rs.getInt("id"));
		categorys.setName(rs.getString("name"));
		categorys.setDescription(rs.getString("description"));
		return categorys;
	}
}
