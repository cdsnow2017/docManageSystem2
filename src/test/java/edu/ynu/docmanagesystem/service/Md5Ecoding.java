package edu.ynu.docmanagesystem.service;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Ecoding {

	public static void main(String[] args) {
		String str = "2016";
		String salt = "789";
		System.out.println(new Md5Hash(str, salt, 2).toString());// 还可以转换为toBase64()/toHex()

	}

}
