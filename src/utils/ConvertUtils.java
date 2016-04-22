package utils;

import java.lang.reflect.Field;

import entity.User;
import enums.StuctType;

public class ConvertUtils {
	public static String createSql(Class clz) {
		StringBuffer sb = new StringBuffer("create table "+clz.getName() +"(");
		Field[] fds = clz.getDeclaredFields();
		String tempTypeName = "";
		String tempFieldName = null;
		String tempTypeClz = null;
		if(null != fds && fds.length > 0) {
			Field fd = null;
			for(int i = 0;i< fds.length;i++) {
				fd = fds[i];
				if(fd != null) {
					tempTypeClz = fd.getType().getName();
					tempFieldName = fd.getName();
					if(tempTypeClz.indexOf(".") > 0) {
						tempTypeName = tempTypeClz.substring(tempTypeClz.lastIndexOf(".")+1);
					}else {
						tempTypeName = tempTypeClz;
					}
					sb.append(""+tempFieldName+" "+StuctType.valuesOf(tempTypeName).toDbType()+"(11)");
					if(i < fds.length-1) {
						sb.append(",");
					}else {
						sb.append("}");
					}
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(createSql(User.class));
	}
}
