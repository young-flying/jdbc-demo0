package main;

import utils.ConvertUtils;
import entity.User;

public class Test {

	public static void main(String[] args) {
		System.out.println(ConvertUtils.createSql(User.class));
	}

}
