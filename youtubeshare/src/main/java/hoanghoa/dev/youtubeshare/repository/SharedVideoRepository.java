package hoanghoa.dev.youtubeshare.repository;

import hoanghoa.dev.youtubeshare.model.dao.SharedVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedVideoRepository extends JpaRepository<SharedVideo, Long> {
}
