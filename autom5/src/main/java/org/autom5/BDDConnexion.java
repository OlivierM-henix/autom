package org.autom5;

import java.io.File;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class BDDConnexion {
	private static final String DRIVER = "com.postgresql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";

	
//	Méthode de construction d’un dataset (interface IDataSet) à partir d’un fichier au format xml Dbunit

	private static IDataSet readDataSet (String filename) throws Exception{
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}

	
//	Méthode d’insertion d’un dataset (type IDataSet) à partir d’une connexion à une BDD (interface IDataBaseTester) 

	public void insertData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}


//	Méthode de suppression d’un dataset (type IDataSet) à partir d’une connexion à une BDD (interface IDataBaseTester) 

	public static void deleteAllData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	
	
//	Méthode de comparaison de deux dataset (sous forme ITable) .
//	La première table est créée à partir du fichier xml et la seconde est la table telle quelle est en BDD

	public void compareData(String table, String path_to_file, String... col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable =databaseDataSet.getTable(table);
		IDataSet expectedDataSet=readDataSet(path_to_file);
		ITable expectedTable =expectedDataSet.getTable(table);
		String tab[]= col;
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
		}

}
