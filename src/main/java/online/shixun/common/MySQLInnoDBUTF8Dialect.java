package online.shixun.common;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQLInnoDBUTF8Dialect extends MySQL5Dialect{
	@Override
	public String getTableTypeString() {
		return "ENGINE=InnoDB CHARSET=utf8";
	}
}
