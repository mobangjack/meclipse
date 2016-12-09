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
package cn.twogen.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * @author Jack Mo
 */
public class IOUtil {

	private IOUtil() {
	}

	public static void closeQuietly(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
					closeable = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void consumeFileLineByLine(File file, Consumer<String> consumer) throws IOException {
		InputStream in = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		try {
			in = new FileInputStream(file);
			ir = new InputStreamReader(in);
			br = new BufferedReader(ir);
			String line = null;
			while ((line = br.readLine()) != null) {
				consumer.accept(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			closeQuietly(br, ir, in);
		}
	}

	public static void consumeFileLineByLine(String pathname, Consumer<String> consumer) throws IOException {
		consumeFileLineByLine(new File(pathname), consumer);
	}
}
