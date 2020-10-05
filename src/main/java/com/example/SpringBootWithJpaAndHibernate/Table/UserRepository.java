package com.example.SpringBootWithJpaAndHibernate.Table;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringBootWithJpaAndHibernate.Entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	@org.springframework.cache.annotation.Cacheable
	List<UserEntity> findByUserName(String userName);
	/**
	 * For native query means sql query,It same as sql query
	 */
	@Query(value ="Select * from user",nativeQuery=true)
	List<UserEntity> findUserNamebynative();

	@Query(value ="from UserEntity")
	List<UserEntity> findUserNameByQuery();

	//	@Query(value ="from UserEntity where userName = ?1")
	//	List<UserEntity> findUserNameByQueryByParam(String userName);

	/**
	 * Its case sensitive so we should use entity name as table name and variable name as column name
	 */
	@Query(value ="from UserEntity where userName = :username")
	List<UserEntity> findUserNameByQueryByParam(@Param("username")String username);


}
