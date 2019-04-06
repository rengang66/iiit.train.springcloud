/*
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
package com.iiit.train.springcloud.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 配置测试的Endpoint
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
@RestController
@RequestMapping("/config")
public class ConfigTestEndpoint {
	
	
    @Value("${foo}")
    private String foo;

   
    @RequestMapping(value = "/foo")
    public String foo(){
        return  "Hi, " + foo + "!";
    }
   
}