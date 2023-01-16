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
import walkingkooka.javashader.ShadedClassTesting;
import walkingkooka.predicate.Predicates;
import walkingkooka.reflect.PackageName;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringTokenizerTest implements ShadedClassTesting<StringTokenizer> {

    @Test
    public void testCountTokens() {
        final String string = "a,b,c";
        final String delimiters = ",";

        this.checkEquals(new java.util.StringTokenizer(string, delimiters).countTokens(), new StringTokenizer(string, delimiters).countTokens());
    }

    @Test
    public void testHasMoreTokensNextToken() {
        final String string = "a,b,c";
        final String delimiters = ",";

        final java.util.StringTokenizer jre = new java.util.StringTokenizer(string, delimiters);
        final StringTokenizer emul = new StringTokenizer(string, delimiters);

        for (int i = 0; i < 3; i++) {
            this.checkEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
            this.checkEquals(jre.nextToken(), emul.nextToken());
        }

        this.checkEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
        assertThrows(NoSuchElementException.class, jre::nextToken);
        assertThrows(NoSuchElementException.class, emul::nextToken);
    }

    @Test
    public void testHasMoreElementsNextElement() {
        final String string = "a,b,c";
        final String delimiters = ",";

        final java.util.StringTokenizer jre = new java.util.StringTokenizer(string, delimiters);
        final StringTokenizer emul = new StringTokenizer(string, delimiters);

        for (int i = 0; i < 3; i++) {
            this.checkEquals(jre.hasMoreTokens(), emul.hasMoreElements());
            this.checkEquals(jre.nextToken(), emul.nextToken());
        }

        this.checkEquals(jre.hasMoreTokens(), emul.hasMoreTokens());
        assertThrows(NoSuchElementException.class, jre::nextElement);
        assertThrows(NoSuchElementException.class, emul::nextElement);
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<StringTokenizer> type() {
        return StringTokenizer.class;
    }

    // ShadedClassTesting................................................................................................

    @Override
    public Predicate<Constructor<?>> requiredConstructors() {
        return Predicates.always();
    }

    @Override
    public Predicate<Method> requiredMethods() {
        return Predicates.always();
    }

    @Override
    public Predicate<Field> requiredFields() {
        return Predicates.always();
    }

    @Override
    public UnaryOperator<Class<?>> typeMapper() {
        return ShadedClassTesting.typeMapper(PackageName.from(this.getClass().getPackage()),
                PackageName.from(java.util.StringTokenizer.class.getPackage()));
    }
}
