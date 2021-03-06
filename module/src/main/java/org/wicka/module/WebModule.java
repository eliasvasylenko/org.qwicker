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
package org.wicka.module;

import java.net.URL;
import java.util.stream.Stream;

import org.osgi.framework.Version;

public interface WebModule {
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

  /*
   * 
   * 
   * 
   * TODO generalize this as a scoped & versioned resource registry, not just for
   * ES6 modules? Should we be able to serve other kinds of resources and consume
   * them e.g. through ajax?
   * 
   * 
   * 
   * 
   * Where do we need versioned resources (es6 modules definitely, multiple can
   * exist side-by-side, they are never accessed directly by a user), and when do
   * they not make sense. A landing page or index shouldn't be versioned, there
   * should only be the latest one configured, same with most user-facing web
   * pages.
   * 
   * 
   * 
   * 
   * Other resources? Images, css, etc? Will different user-facing pages use
   * different versions of them? Possibly, this is certianly the case with es6
   * modules, which do need to consume css at the very least.
   * 
   * 
   * 
   * 
   * Makes sense for only the user-facing end-points to be unversioned, as much
   * else as possible should be versioned.
   * 
   * Two ways to approach the divide between versioned resources & unversioned
   * end-points:
   * 
   * - anything that is included as a build-time dependency on another OSGi bundle
   * should be accessed in a properly versioned way at runtime, thus avoiding
   * dependency collisions.
   * 
   * - avoid dependency collisions by wiring together dependencies by
   * configuration. Give the app-deployer the responsibility of management.
   * 
   * Some combination of the two approaches is necessary?
   * 
   *
   * 
   */

  /**
   * @return the entry point of the module
   */
  String entryPoint();

  /**
   * @return the remote, public address of the module root
   */
  URL remoteAddress();

  /**
   * @return the complete set of modules this module depends on to operate
   */
  Stream<WebModule> dependencies();
}
