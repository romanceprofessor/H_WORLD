package city.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import city.dao.CityMapper;

public class CityModel {

	public static List<HashMap> selectCity(SqlSessionFactory sqlSessionFactory, HashMap map) {
		List<HashMap> cityNames = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			CityMapper mapper = session.getMapper(CityMapper.class);
			cityNames = mapper.selectCity(map);
		}
		return cityNames;
	}
}
