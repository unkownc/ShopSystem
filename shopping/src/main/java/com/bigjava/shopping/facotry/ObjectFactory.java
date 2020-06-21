package com.bigjava.shopping.facotry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 创建对象的工厂类
 * 
 * 根据类路径下的objs.properties属性文件中的配置来创建对象
 * 要求：
 * 1.文件中不能有空行
 * 2.注意编写顺序，由于对象间可能存在依赖关系，被依赖的对象必须放在依赖对象的前面
 */
public class ObjectFactory {

	/*
	 * 定义一个Map集合，用来存储对象
	 */
	private static Map<String, Object> objs = new HashMap<>();

	/*
	 * 类加载时读取属性文件，创建相应对象，对象是单例的
	 */
	static {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				ObjectFactory.class.getClassLoader().getResourceAsStream(
						"objs.properties")));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] entry = line.split("=");
				objs.put(entry[0], Class.forName(entry[1]).newInstance());
			}

			objs.forEach((k,v)->{
				System.out.println(k+":"+v);
			});

		} catch (Exception e) {
			throw new ExceptionInInitializerError("ObjectFactory初始化失败：" + e);
		}
	}

	/*
	 * 工厂方法，用来获取对象
	 */
	public static Object getObject(String key) {
		return objs.get(key);
	}

}
