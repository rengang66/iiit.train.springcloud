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

import com.iiit.train.springcloud.product.entity.Product;
import com.iiit.train.springcloud.product.entity.ProductComment;
import com.iiit.train.springcloud.product.repository.ProductCommentRepository;
import com.iiit.train.springcloud.product.repository.ProductRepository;
import com.iiit.train.springcloud.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品管理的Endpoint
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCommentRepository productCommentRepository;
    @Autowired
    private UserService userService;

    /**
     * 获取产品信息列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return this.productRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id){
        return this.productRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<ProductCommentDto> comments(@PathVariable Long id){
        List<ProductComment> commentList = this.productCommentRepository.findByProductIdOrderByCreated(id);
        if (null == commentList || commentList.isEmpty())
            return Collections.emptyList();

        return commentList.stream().map((comment) -> {
            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProduct(this.productRepository.findOne(comment.getProductId()));
            dto.setAuthor(this.userService.load(comment.getAuthorId()));
            return dto;
        }).collect(Collectors.toList());
    }
}
