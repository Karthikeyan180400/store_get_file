package com.ty.file.dao;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.file.util.ConnectionObject;

public class FileDao {

	public void saveFile(int id, String userName, String fileName, FileInputStream fileInputStream) {
		String query = "insert into document values(?,?,?,?)";

		Connection connection = ConnectionObject.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fileName);
			preparedStatement.setBlob(4, fileInputStream);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void saveFile(int id, String userName, File file) {
		String query = "insert into document values(?,?,?,?)";

		Connection connection = ConnectionObject.getConnection();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String fileName = file.getName();
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fileName);
			preparedStatement.setBlob(4, fileInputStream);

			preparedStatement.executeUpdate();
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getFile(String path, int id) {
		FileOutputStream fileOutputStream;
		Connection connection = ConnectionObject.getConnection();
		String query = "select * from document where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(2));
				Blob blob = resultSet.getBlob(4);

				byte[] array = blob.getBytes(1, (int) blob.length());

				fileOutputStream = new FileOutputStream(path);
				fileOutputStream.write(array);
				
				System.out.println("done");

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
