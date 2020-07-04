/*
 * Copyright © 2020 Miroslav Pokorny
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test;


import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.StringTokenizer;

@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testConsumeTokens() {
        final StringTokenizer tokenizer = new StringTokenizer("abc,d,ef", ",");

        Assert.assertEquals(true, tokenizer.hasMoreTokens());
        Assert.assertEquals("abc", tokenizer.nextToken());
        Assert.assertEquals("d", tokenizer.nextToken());
        Assert.assertEquals("ef", tokenizer.nextElement());
        Assert.assertEquals(false, tokenizer.hasMoreElements());
    }
}
