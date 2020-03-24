package com.acc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acc.bean.Skill;
import com.acc.util.ConnectorDerby;

public class SkillDao {
    public List<Skill> getSkills() {
        List<Skill> res;

        ConnectorDerby connectorDerby = ConnectorDerby.getConnector();
        Connection conn = connectorDerby.getConn();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM skill");

            res = new ArrayList<Skill>();

            while (rs.next()) {
                res.add(createSkill(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal al hacer ejecutar la query", e);
        }

        return res;
    }

    public List<Skill> getSkillsByEmployeeId(int sysId) {
        List<Skill> res;

        ConnectorDerby connectorDerby = ConnectorDerby.getConnector();
        Connection conn = connectorDerby.getConn();

        try {
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT S.* FROM employee_skill ES JOIN skill S ON S.id = ES.skill_id WHERE ES.employee_id = ?");
            statement.setInt(1, sysId);

            ResultSet rs = statement.executeQuery();

            res = new ArrayList<Skill>();

            while (rs.next()) {
                res.add(createSkill(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal al hacer ejecutar la query", e);
        }

        return res;
    }

    public static Skill createSkill(ResultSet rs) throws SQLException {
        Skill s = new Skill();

        s.setDescription(rs.getString("description"));
        s.setId(rs.getInt("id"));

        return s;
    }
}