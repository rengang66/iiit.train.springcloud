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
package com.iiit.train.springcloud.product.service;

import com.iiit.train.springcloud.product.api.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 用户远程服务
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
@FeignClient("USERSERVICE")
public interface UserRemoteClient {
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    UserDto load(@PathVariable("id") Long id);
}
