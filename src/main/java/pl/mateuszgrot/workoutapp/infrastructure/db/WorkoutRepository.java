package pl.mateuszgrot.workoutapp.infrastructure.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.mateuszgrot.workoutapp.domain.Workout;

import java.util.UUID;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout, UUID> {
}
