package com.sample.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.sample.demo.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	
//	select * from tutorials where title like '% title %'
	public List<Tutorial> findByTitleContaining(String title);
	
	public List<Tutorial> findByPublished(boolean published);
	
//	update tutorials set published=true where tutorial_id=1
//	@Modifying
//	@Query("UPDATE TUTORIALS SET PUBLISHED = :published WHERE TUTORIAL_ID = :id")
//	public int updatePublishedByTutorialId(@Param("published") boolean published, @Param("id") long id);
}
