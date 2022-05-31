package com.ty.file.controller;

import com.ty.file.dao.FileDao;

public class FileGetController {

	public static void main(String[] args) {
		FileDao fileDao = new FileDao();
		fileDao.getFile("E:/TY/MySQL/avinya.jpg", 1);

	}

}
 