/*
 * Copyright (C) 2016 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.karumi.maxibonkata;

class Developer {

  private final String name;
  private final int numberOfMaxibonsToGrab;

  Developer(String name, int numberOfMaxibonsToGrab) {
    if (numberOfMaxibonsToGrab < 0) {
      numberOfMaxibonsToGrab = 0;
    }
    this.name = name;
    this.numberOfMaxibonsToGrab = numberOfMaxibonsToGrab;
  }

  public String getName() {
    return name;
  }

  int getNumberOfMaxibonsToGrab() {
    return numberOfMaxibonsToGrab;
  }

  @Override public String toString() {
    return "Developer{"
        + "name='" + name + '\''
        + ", numberOfMaxibonsToGrab=" + numberOfMaxibonsToGrab
        + '}';
  }
}
