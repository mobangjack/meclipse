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
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeSet;

import cn.twogen.util.IOUtil;

/**
 * @author Jack Mo
 */
public abstract class AbsMixer implements Mixable {

	protected TreeSet<String> set = null;

	public AbsMixer() {
		set = new TreeSet<String>();
	}

	protected abstract void mix(File file) throws Exception;

	@Override
	public void mix(String... filepaths) throws Exception {
		for (String filepath : filepaths) {
			System.out.println("Mixing " + filepath);
			mix(new File(filepath));
			System.out.println("Done.");
		}
	}

	@Override
	public void opt(String filepath) throws Exception {
		System.out.println("Writing mixment result to " + filepath);
		PrintWriter printer = new PrintWriter(filepath);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			printer.println(it.next());
		}
		printer.flush();
		IOUtil.closeQuietly(printer);
		System.out.println("Done.");
	}

}
