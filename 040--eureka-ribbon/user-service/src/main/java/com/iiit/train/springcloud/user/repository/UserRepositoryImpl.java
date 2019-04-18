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
package com.iiit.train.springcloud.user.repository;


import com.iiit.train.springcloud.user.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 用户信息管理扩展repository
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
public class UserRepositoryImpl implements UserRepositoryEx {
    @PersistenceContext
    protected EntityManager entityManager;

    public List<User> findTopUser(int maxResult) {
        Query query = this.entityManager.createQuery("from User");
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
}
