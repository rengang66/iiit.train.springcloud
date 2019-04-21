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
package com.iiit.train.springcloud.product.service.impl;

import com.iiit.train.springcloud.bus.MyBusEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 事件监听
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
@Component
public class MyBusEventListener implements ApplicationListener<MyBusEvent> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(MyBusEvent event) {
        this.logger.debug("Recived an remote event... ");
        this.logger.debug("Event type = {}", event.getEventType());
    }
}
