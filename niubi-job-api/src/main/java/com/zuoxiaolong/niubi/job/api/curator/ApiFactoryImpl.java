/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zuoxiaolong.niubi.job.api.curator;

import com.zuoxiaolong.niubi.job.api.ApiFactory;
import com.zuoxiaolong.niubi.job.api.JobApi;
import com.zuoxiaolong.niubi.job.api.NodeApi;
import com.zuoxiaolong.niubi.job.api.PathApi;
import org.apache.curator.framework.CuratorFramework;

/**
 * @author Xiaolong Zuo
 * @since 16/1/13 01:04
 */
public class ApiFactoryImpl implements ApiFactory {

    private CuratorFramework client;

    public ApiFactoryImpl(CuratorFramework client) {
        this.client = client;
    }

    @Override
    public PathApi pathApi() {
        return PathApiImpl.INSTANCE;
    }

    @Override
    public NodeApi nodeApi() {
        return new NodeApiImpl(client);
    }

    @Override
    public JobApi jobApi() {
        return new JobApiImpl(client);
    }

}
