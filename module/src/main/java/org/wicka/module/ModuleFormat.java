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

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public final class ModuleFormat {
  private final String id;

  public ModuleFormat(String id) {
    if (requireNonNull(id).isEmpty()) {
      throw new IllegalArgumentException("Empty format ID");
    }
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return getId();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (!(obj instanceof ModuleFormat))
      return false;

    ModuleFormat that = (ModuleFormat) obj;

    return Objects.equals(this.id, that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
