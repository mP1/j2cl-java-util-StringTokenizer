/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
 *
 */

package walkingkooka.j2cl.java.util.stringtokenizer;

import org.junit.jupiter.api.Test;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringTokenizerTest implements ClassTesting<StringTokenizer> {

    @Test
    public void testCountTokens() {
        final String string = "a,b,c";
        final String delimiters = ",";

        assertEquals(new java.util.StringTokenizer(string, delimiters).countTokens(), new StringTokenizer(string, delimiters).countTokens());
    }

    @Test
    public void testHasMoreTokensNextToken() {
        final String string = "a,b,c";
        final String delimiters = ",";

        final java.util.StringTokenizer jre = new java.util.StringTokenizer(string, delimiters);
        final StringTokenizer emul = new StringTokenizer(string, delimiters);

        for (int i = 0; i < 3; i++) {
            assertEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
            assertEquals(jre.nextToken(), emul.nextToken());
        }

        assertEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
        assertThrows(NoSuchElementException.class, () -> jre.nextToken());
        assertThrows(NoSuchElementException.class, () -> emul.nextToken());
    }

    @Test
    public void testHasMoreElementsNextElement() {
        final String string = "a,b,c";
        final String delimiters = ",";

        final java.util.StringTokenizer jre = new java.util.StringTokenizer(string, delimiters);
        final StringTokenizer emul = new StringTokenizer(string, delimiters);

        for (int i = 0; i < 3; i++) {
            assertEquals(jre.hasMoreTokens(), emul.hasMoreElements());
            assertEquals(jre.nextToken(), emul.nextToken());
        }

        assertEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
        assertThrows(NoSuchElementException.class, () -> jre.nextElement());
        assertThrows(NoSuchElementException.class, () -> emul.nextElement());
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<StringTokenizer> type() {
        return StringTokenizer.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
