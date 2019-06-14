/*
 * Wicka Module - The module API
 * Copyright © 2019 Strange Skies (elias@vasylenko.uk)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.wicka.module.local;

import java.io.IOException;
import java.util.stream.Stream;

import org.osgi.framework.Version;
import org.wicka.module.ModuleFormat;
import org.wicka.module.PackageId;
import org.wicka.module.WebModule;

public interface LocalWebModule {
  /**
   * @return the id of the module
   */
  PackageId id();

  /**
   * @return the version of the module
   */
  Version version();

  /**
   * The module format refers to the module format specification to which the
   * entry point adheres, and how it specifies its imports and exports. Some
   * default format identifier constants corresponding to well-known
   * specifications can be found under {@link WebModuleConstants}.
   * 
   * @return the format identifier
   */
  ModuleFormat format();

  /**
   * @return the entry point of the module
   */
  String entryPoint();

  /**
   * @param name the name of the resource
   * @return an input stream over the named resource
   * @throws IOException if the resource does not exist or cannot be read
   */
  String openResource(String name) throws IOException;

  /**
   * @return the complete set of modules this module depends on to operate
   */
  Stream<WebModule> dependencies();
}
