package com.ohgiraffers.pikka_backserver.auth.config;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
