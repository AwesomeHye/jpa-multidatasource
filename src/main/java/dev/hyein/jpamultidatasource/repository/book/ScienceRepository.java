package dev.hyein.jpamultidatasource.repository.book;

import dev.hyein.jpamultidatasource.entity.book.Science;
import dev.hyein.jpamultidatasource.entity.member.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScienceRepository extends JpaRepository<Science, Integer> {
}
