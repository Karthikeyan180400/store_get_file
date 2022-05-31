package com.ty.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.ty.file.dao.FileDao;

public class FileSaveController {

	public static void main(String[] args) {

		/*File f = new File("avinya.jpg");
		try {
			FileInputStream fileInputStream = new FileInputStream(f);
			FileDao fileDao = new FileDao();
			fileDao.saveFile(2, "AVINYA", "avinya.jpg", fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		
		File f = new File("avinya.jpg");
		FileDao fileDao = new FileDao();
		fileDao.saveFile(4, "AVINYA", f);
		System.out.println("Done"); 


	}

}
