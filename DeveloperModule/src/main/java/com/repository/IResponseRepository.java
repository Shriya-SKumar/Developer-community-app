package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Feeds;
import com.model.Response;
@Repository
public interface IResponseRepository extends JpaRepository<Response,Integer>{

}
