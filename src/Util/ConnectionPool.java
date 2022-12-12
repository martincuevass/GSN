/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author polil
 */
public class ConnectionPool {
    private final String PATH = "src/gsn/DataBaseConfig.json";
    private String db = "";
    private String url = "";
    private String user = "";
    private String pass = "";
    private LoggerManager logger = LoggerManager.getTheLogger();
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource = null;

    private ConnectionPool() throws IOException {
        setPoolData();
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(this.user);
        basicDataSource.setPassword(this.pass);
        basicDataSource.setUrl(this.url);
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);

    }

    public static ConnectionPool getInstance() throws IOException {
        if (dataSource == null) {
            dataSource = new ConnectionPool();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.basicDataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void setPoolData() throws IOException {
        JSONObject obj = new JSONObject();
        try {
            String content = Files.readString(Paths.get(PATH));
            obj = new JSONObject(content);
            this.db = obj.getString("DBName");
            this.url = obj.getString("url");
            this.user = obj.getString("usuario");
            this.pass = obj.getString("contrasenia");
            
        } catch (Exception ex) {
            logger.addNewLog("No se encontro el archivo de configuración seleccionado" + ex);
        }
    }
}
