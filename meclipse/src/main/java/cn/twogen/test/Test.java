/**
 * Copyright (c) 2016, Jack Mo 莫帮杰 (mobangjack@foxmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.twogen.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jack Mo
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		String[] qs = { "arr", "arr[]", "arr[:]", "arr[1]", "arr[0:5]", "arr[1,2,5,6]" };
		for (int i = 0; i < qs.length; i++) {
			System.out.println("Test " + i);
			Matcher matcher = Pattern.compile("(\\w+)\\[((\\d+))\\]").matcher(qs[i]);
			if (matcher.matches()) {
				int c = matcher.groupCount();
				System.out.println("group count: " + c);
				for (int j = 0; j < c; j++) {
					System.out.println("group[" + j + "]: " + matcher.group(j));
				}
			}
			System.out.println();
		}

	}

	public static void test(String[] args) throws Exception {
		/*
		 * String pathname =
		 * "/home/bj/eclipse/mix-neon/eclipse/configuration/org.eclipse.update/platform.xml";
		 * File file = new File(pathname); SAXReader reader = new SAXReader();
		 * Document document = reader.read(file); Element site =
		 * document.getRootElement().element("site");
		 * 
		 * @SuppressWarnings("rawtypes") List features = site.elements(); for
		 * (Object feature : features) { if (feature instanceof Element) {
		 * Element e = (Element) feature; System.out.println(e.asXML()); } }
		 */
	}

}
