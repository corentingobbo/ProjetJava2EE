/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;
import static org.jscience.physics.amount.Constants.e;

/**
 *
 * @author bfranco
 */
public class DataSourceFactory {
    
	public enum DriverType {
		embedded, server
	};
	
	// Choic du type de driver : embedded ou serveur
	private static final DriverType TYPE = DriverType.server;
	/**
	 * Renvoie la source de données (server ou embbeded)
	 * @return  la source de données
	 */
	public static DataSource getDataSource() {
		DataSource result;
		org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
		es.setCreateDatabase("create");
		es.setDatabaseName("mohammedaliexpress");
		result = es;
		return result;
	}
}
