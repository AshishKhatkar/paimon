/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.flink.utils;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.table.connector.source.LookupTableSource;
import org.apache.flink.table.functions.FunctionContext;

import javax.annotation.Nullable;

/** Utility methods about Flink runtime context to resolve compatibility issues. */
public class RuntimeContextUtils {
    public static int getNumberOfParallelSubtasks(RuntimeContext context) {
        return context.getTaskInfo().getNumberOfParallelSubtasks();
    }

    public static int getIndexOfThisSubtask(RuntimeContext context) {
        return context.getTaskInfo().getIndexOfThisSubtask();
    }

    public static @Nullable Integer getNumberOfParallelSubtasks(FunctionContext context) {
        return context.getTaskInfo().getNumberOfParallelSubtasks();
    }

    public static @Nullable Integer getIndexOfThisSubtask(FunctionContext context) {
        return context.getTaskInfo().getIndexOfThisSubtask();
    }

    public static boolean preferCustomShuffle(LookupTableSource.LookupContext context) {
        return context.preferCustomShuffle();
    }
}
