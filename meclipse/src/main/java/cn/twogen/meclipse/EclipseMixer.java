/**
 * Copyright (c) 2011-2016, Jack Mo 莫帮杰 (mobangjack@foxmail.com).
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

import java.util.Arrays;

/**
 * A tool to merge different eclipse configurations into one.
 * 
 * @author Jack Mo
 */
public class EclipseMixer {

	public static void mix(Mixable mixable, String[] args) throws Exception {
		if (args.length < 3) {
			System.out.println("Too few args. Aborted.");
			return;
		}
		System.out.println("Start merging...");
		mixable.mix(Arrays.copyOfRange(args, 0, args.length - 1));
		mixable.opt(args[args.length - 1]);
		System.out.println("All done.");
	}

	public static void main(String[] args) throws Exception {
		String[] buldles = {
				"/home/bj/eclipse/jee-neon/eclipse/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info",
				"/home/bj/eclipse/cpp-neon/eclipse/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info",
				"/home/bj/eclipse/mix-neon/eclipse/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info" };
		/*String[] sources = { "/home/bj/eclipse/jee-neon/eclipse/configuration/org.eclipse.equinox.source/source.info",
				"/home/bj/eclipse/cpp-neon/eclipse/configuration/org.eclipse.equinox.source/source.info",
				"/home/bj/eclipse/mix-neon/eclipse/configuration/org.eclipse.equinox.source/source_.info" };*/
		String[] xmls = { "/home/bj/eclipse/jee-neon/eclipse/configuration/org.eclipse.update/platform.xml",
				"/home/bj/eclipse/cpp-neon/eclipse/configuration/org.eclipse.update/platform.xml",
				"/home/bj/eclipse/mix-neon/eclipse/configuration/org.eclipse.update/platform.xml" };
		System.out.println("Merging bundles...");
		mix(new InfoMixer(), buldles);
		System.out.println("Bundles mergement done.");
		/*System.out.println("Merging sources...");
		mixer.mix(0, sources);
		System.out.println("Sources mergement done.");*/
		System.out.println("Merging xmls...");
		mix(new XmlMixer(), xmls);
		System.out.println("Xmls mergement done.");

	}
}
