/*
 * Copyright 2012 Martin Winandy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.pmw.benchmark.tinylog;

import java.io.File;

import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.writers.FileWriter;

public class TinylogWithWritingThread extends Tinylog {

	@Override
	public String getName() {
		return "tinylog with writing thread";
	}

	@Override
	public void init(final File file) throws Exception {
		super.init(file);
		Configurator.currentConfig().writingThread(true).activate();
	}

	@Override
	public void dispose() throws Exception {
		Configurator.shutdownWritingThread(true);
		super.dispose();
	}

	@Override
	protected FileWriter createWriter(final File file) {
		return new FileWriter(file.getAbsolutePath(), true);
	}

}
