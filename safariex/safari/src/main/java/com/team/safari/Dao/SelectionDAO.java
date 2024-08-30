package com.team.safari.Dao;

import com.team.safari.Vo.InformationVO;
import com.team.safari.Vo.UserSelectionVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SelectionDAO {

    private final JdbcTemplate jdbcTemplate;

    public SelectionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(UserSelectionVO selection) {
        String sql = "INSERT INTO UserSelections (UserID, TypeID, LocationID, SelectionDateTime) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, selection.getUserId(), selection.getTypeId(),
                selection.getLocationId());
    }

    public List<InformationVO> findInformationByUserId(String userId) {
        String sql = "SELECT i.InfoID, s.TypeName, l.LocationName, i.InfoDetails " +
                "FROM Information i " +
                "JOIN UserSelections us ON i.TypeID = us.TypeID AND i.LocationID = us.LocationID " +
                "JOIN SelectionTypes s ON i.TypeID = s.TypeID " +
                "JOIN Locations l ON i.LocationID = l.LocationID " +
                "WHERE us.UserID = ?";
        return jdbcTemplate.query(sql, new InformationRowMapper(), userId);
    }

    private static class InformationRowMapper implements RowMapper<InformationVO> {
        @Override
        public InformationVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            int infoId = rs.getInt("InfoID");
            String typeName = rs.getString("TypeName");
            String locationName = rs.getString("LocationName");
            String infoDetails = rs.getString("InfoDetails");
            return new InformationVO(infoId, typeName, locationName, infoDetails);
        }
    }
}