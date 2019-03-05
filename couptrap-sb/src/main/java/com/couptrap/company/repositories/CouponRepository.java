package com.couptrap.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couptrap.company.models.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	List<Coupon> findAll();

}
