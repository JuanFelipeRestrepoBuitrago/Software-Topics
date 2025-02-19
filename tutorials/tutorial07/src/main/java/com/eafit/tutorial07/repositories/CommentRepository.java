package com.eafit.tutorial07.repositories;

import com.eafit.tutorial07.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CommentRepository extends JpaRepository<Comment, Long> {}
