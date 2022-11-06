package dev.hyein.jpamultidatasource.repository.member;

import dev.hyein.jpamultidatasource.entity.member.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
}
