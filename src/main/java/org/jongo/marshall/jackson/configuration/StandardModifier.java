/*
 * Copyright (C) 2011 Benoit GUEROUT <bguerout at gmail dot com> and Yves AMSELLEM <amsellem dot yves at gmail dot com>
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

package org.jongo.marshall.jackson.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS;
import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_SETTERS;

public class StandardModifier implements MapperModifier {

    public void modify(ObjectMapper mapper) {
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(AUTO_DETECT_SETTERS);
        mapper.disable(AUTO_DETECT_GETTERS);
        mapper.setSerializationInclusion(NON_NULL);
        VisibilityChecker<?> checker = mapper.getSerializationConfig().getDefaultVisibilityChecker();
        mapper.setVisibilityChecker(checker.withFieldVisibility(ANY));
    }
}
