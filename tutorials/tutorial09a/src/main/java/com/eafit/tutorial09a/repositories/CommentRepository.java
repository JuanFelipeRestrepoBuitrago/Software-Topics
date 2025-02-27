package com.eafit.tutorial09a.repositories;

import com.eafit.tutorial09a.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CommentRepository extends JpaRepository<Comment, Long> {}
