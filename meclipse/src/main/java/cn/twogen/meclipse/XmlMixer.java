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
package cn.twogen.meclipse;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Jack Mo
 */
public class XmlMixer extends AbsMixer {

	public XmlMixer() {
		super();
	}

	@Override
	protected void mix(File file) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element site = document.getRootElement().element("site");
		@SuppressWarnings("rawtypes")
		List features = site.elements();
		for (Object feature : features) {
			if (feature instanceof Element) {
				Element e = (Element) feature;
				set.add(e.asXML());
			}
		}
	}
}
