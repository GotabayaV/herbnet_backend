package com.gotabaya.herbnet.service.serviceImpl;

import com.gotabaya.herbnet.mapper.ProductMapper;
import com.gotabaya.herbnet.model.dto.ProductDto_long;
import com.gotabaya.herbnet.model.dto.ProductDto_short;
import com.gotabaya.herbnet.repository.ProductRepository;
import com.gotabaya.herbnet.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	final ProductRepository productRepository;
	final ProductMapper productMapper;
	@Override
	public List<ProductDto_short> list_short() {
		return productRepository.findAll().stream().map(productMapper::toDto_short).toList();
	}

	@Override
	public ProductDto_long getProduct_long(Long productId) {
		return productRepository.findById(productId).map(productMapper::toDto_long).orElseThrow(() -> new EntityNotFoundException("Product not found by Id: "+productId));
	}
}