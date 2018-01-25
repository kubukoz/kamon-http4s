/*
 * =========================================================================================
 * Copyright © 2013-2018 the kamon project <http://kamon.io/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * =========================================================================================
 */

package kamon.http4s.instrumentation.advisor;

import kamon.agent.libs.net.bytebuddy.asm.Advice;
import kamon.agent.libs.net.bytebuddy.implementation.bytecode.assign.Assigner.Typing;
import kamon.http4s.instrumentation.HttpServiceWrapper;

/**
 * Advisor for org.http4s.client.Client::<init>
 */
public class Http4sClientAdvisor {
    @Advice.OnMethodEnter
    public static void enter(@Advice.Argument(value = 0, readOnly = false, typing = Typing.DYNAMIC) Object httpService) {
        httpService = HttpServiceWrapper.wrap(httpService);
    }
}